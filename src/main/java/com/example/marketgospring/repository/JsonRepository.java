package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Json;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonRepository extends JpaRepository<Json, Integer> {
    @Query(value = "select s.originalFileName from S3File s where s.fileId=:fileId")
    String getFilePath(@Param("fileId") Integer fileId);
}
