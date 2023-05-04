package com.example.marketgospring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/json")
public class JsonController {

    @GetMapping(value = "/{json}")
    public Map getJson(@PathVariable("json") String jsonData) {

        String openApiURL = "http://aiopen.etri.re.kr:8000/WiseNLU_spoken";
        String accessKey = "94a79136-75ad-4b96-bb41-10d6a8702ac6";   // 발급받은 API Key
        String analysisCode = "ner";        // 언어 분석 코드
        String text = jsonData;           // 분석할 텍스트 데이터
        Gson gson = new Gson();
        Map<String, Object> request = new HashMap<>();
        Map<String, String> argument = new HashMap<>();
        Map<Integer, String> resultMap = new HashMap<>();
        argument.put("analysis_code", analysisCode);
        argument.put("text", text);

        request.put("argument", argument);

        URL url;
        Integer responseCode;
        String responseBodyJson;
        Map<String, Object> responseBody;

        try {
            url = new URL(openApiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("Authorization", accessKey);


            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(gson.toJson(request).getBytes("UTF-8"));
            wr.flush();
            wr.close();

            responseCode = con.getResponseCode();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();

            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            responseBodyJson = sb.toString();

            // http 요청 오류 시 처리
            if ( responseCode != 200 ) {
                // 오류 내용 출력
                System.out.println("[error] " + responseBodyJson);
                return null;
            }

            responseBody = gson.fromJson(responseBodyJson, Map.class);
            Integer result = ((Double) responseBody.get("result")).intValue();
            Map<String, Object> returnObject;
            List<Map> sentences;

            // 분석 요청 오류 시 처리
            if ( result != 0 ) {

                // 오류 내용 출력
                System.out.println("[error] " + responseBody.get("result"));
                return null;
            }
            returnObject = (Map<String, Object>) responseBody.get("return_object");
            sentences = (List<Map>) returnObject.get("sentence");




            for( Map<String, Object> sentence : sentences ) {

                // 개체명 분석 결과 수집 및 정렬
                List<Map<String, Object>> nameEntityRecognitionResult = (List<Map<String, Object>>) sentence.get("NE");
                for( Map<String, Object> nameEntityInfo : nameEntityRecognitionResult ) {
                    String name = (String) nameEntityInfo.get("text");
                    String type = (String) nameEntityInfo.get("type");
                    if (type.contains("PT")==true) {
                        resultMap.put(0, name);
                    }
                    if (type.equals("QT_COUNT")==true || type.equals("QT_WEIGHT")==true) {
                        resultMap.put(1, name);
                    }
                    if (type.equals("QT_PRICE")==true) {
                        resultMap.put(2, name);
                    }
                    if (type.equals("QT_OTHERS")) {
                        try {
                            int x=Integer.parseInt(name);
                            if (x>100) {
                                resultMap.put(1, name);
                            }
                            else {
                                resultMap.put(2, name);
                            }
                        } catch (NumberFormatException e) {
                            resultMap.put(2, name);
                            //throw new RuntimeException(e);
                        }
                    }
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

}
