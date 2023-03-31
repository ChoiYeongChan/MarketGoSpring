package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Category")
public class Category {
    @Id
    private Long category_id;

    @Column
    private String category_name;


}
