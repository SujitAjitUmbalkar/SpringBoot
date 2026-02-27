package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class PostEnity extends AuditableEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

//    @NotAudited
    private String description;         // except this field , all fields wil be audited

    @PrePersist
    public void beforeSave()
    {

    }

    @PreUpdate
    public void beforeUpdate()
    {

    }

    @PreRemove
    public void beforeDelete()
    {

    }

}
