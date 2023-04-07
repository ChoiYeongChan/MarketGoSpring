package com.example.marketgospring.repository;

import com.example.marketgospring.entity.S3File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface S3FileRepository extends JpaRepository<S3File, Long> {
}
