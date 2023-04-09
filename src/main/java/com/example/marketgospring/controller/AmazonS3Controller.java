package com.example.marketgospring.controller;

import java.util.List;

import com.example.marketgospring.service.AmazonS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class AmazonS3Controller {

    private final AmazonS3Service amazonS3Service;


    @PostMapping("/uploads")
    public ResponseEntity<Object> uploadFiles(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "id") String id,
            @RequestPart(value = "files") List<MultipartFile> multipartFiles) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(amazonS3Service.uploadFiles(category, id, multipartFiles));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteFile(
            @RequestParam(value = "uploadFilePath") String uploadFilePath,
            @RequestParam(value = "uploadFileName") String uploadFileName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(amazonS3Service.deleteFile(uploadFilePath, uploadFileName));
    }
}
