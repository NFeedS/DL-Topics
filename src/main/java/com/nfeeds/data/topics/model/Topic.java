package com.nfeeds.data.topics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {

    @Id
    private String id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String status;
}
