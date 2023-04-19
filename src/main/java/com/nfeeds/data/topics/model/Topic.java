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

    /** Chosen identifier for the topic. */
    @Id
    private String id;

    /** Identifier of the user that created the topic. */
    @Column(nullable = false)
    private String owner;

    /** Tells if the topic is open or closed. */
    @Column(nullable = false)
    private String status;
}
