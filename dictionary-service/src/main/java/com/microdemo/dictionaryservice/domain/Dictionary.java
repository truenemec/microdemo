package com.microdemo.dictionaryservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dictionary {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column(name = "user_id")
    private Long userId;
}
