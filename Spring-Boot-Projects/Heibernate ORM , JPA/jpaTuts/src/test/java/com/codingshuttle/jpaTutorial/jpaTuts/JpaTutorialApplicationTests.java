package com.codingshuttle.jpaTutorial.jpaTuts;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests
{
    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

//    @Test
//    void testRepository()
//    {
//        ProductEntity productEntity = ProductEntity.builder()
//                .sku("nestle234")
//                .title("Nestle Chocolate")
//                .price(BigDecimal.valueOf(23.45))
//                .quantity(4)
//                .build();
//
//        ProductEntity savedProductEntity = productRepository.save(productEntity);
//        System.out.println(savedProductEntity);
//    }
//
//    @Test
//    void getRepository()
//    {
//        List<ProductEntity> productEntityList = productRepository.findByTitle("pepsii");
//        System.out.println(productEntityList);
//    }
}
