package com.example.marketgospring.controller;

import com.example.marketgospring.entity.S3File;
import com.example.marketgospring.repository.S3FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/file")
public class S3FileController {
    private S3FileRepository s3FileRepository;

    @Autowired
    public S3FileController(S3FileRepository s3FileRepository) {
        this.s3FileRepository=s3FileRepository;
    }
    @GetMapping(value = "/all")
    public Iterable<S3File> list() {
        return s3FileRepository.findAll();
    }
    @GetMapping(value = "/{fileId}")
    public Optional<S3File> findOne(@PathVariable("fileId")Integer fileId) {
        return s3FileRepository.findById(fileId);
    }

}
