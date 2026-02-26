package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@AllArgsConstructor         // conversion of DTO <-> Entity
@NoArgsConstructor      // conversion of DTO <-> Entity
@Getter     // conversion of DTO <-> Entity
@Setter     // conversion of DTO <-> Entity
public class PostEnity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

}
