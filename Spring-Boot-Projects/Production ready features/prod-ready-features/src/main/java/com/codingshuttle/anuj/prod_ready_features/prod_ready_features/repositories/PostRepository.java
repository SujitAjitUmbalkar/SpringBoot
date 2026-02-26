package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.repositories;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.entities.PostEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEnity,Long>
{

}
