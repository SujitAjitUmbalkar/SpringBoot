package com.codingshuttle.SecurityApp.SecurityApplication.repositories;

import com.codingshuttle.SecurityApp.SecurityApplication.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> findByEmail(String username);


}
