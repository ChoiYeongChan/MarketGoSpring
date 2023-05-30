package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "json")
public class Json {
    @Id
    private Integer id;

    @Column
    private String imageName;

    @Column
    private String text1;

    @Column
    private String text2;

    @Column
    private String text3;
}
