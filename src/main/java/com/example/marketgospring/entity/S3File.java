package com.example.marketgospring.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "s3file")
public class S3File {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    @Column
    private String originalFileName;
    @Column
    private String uploadFileName;
    @Column
    private String uploadFilePath;
    @Column
    private String uploadFileUrl;
}
