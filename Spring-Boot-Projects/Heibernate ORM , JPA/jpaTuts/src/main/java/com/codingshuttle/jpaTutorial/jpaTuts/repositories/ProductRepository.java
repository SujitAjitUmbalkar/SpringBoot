package com.codingshuttle.jpaTutorial.jpaTuts.repositories;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{

    List<ProductEntity> findBy(Sort sort);

    Page<ProductEntity> findAll(Pageable pageable);

//    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);
//    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int quantity,  BigDecimal price);
//
//    List<ProductEntity> findByTitleLike(String s);
//
//    List<ProductEntity> findByTitleContaining(String choco);

    Page<ProductEntity> findByTitleContainingIgnoreCase(String title ,  Pageable pageable);
//
//    Optional<ProductEntity> findByTitleAndPrice(String parleBuiscuits, BigDecimal price);
}

