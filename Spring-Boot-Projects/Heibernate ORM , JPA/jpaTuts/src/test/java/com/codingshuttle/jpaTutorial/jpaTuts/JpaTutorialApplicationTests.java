package com.codingshuttle.jpaTutorial.jpaTuts;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class JpaTutorialApplicationTests
{
    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository()
    {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(23.45))
                .quantity(5)
                .build();

        ProductEntity savedProductEntity = productRepository.save(productEntity);
        System.out.println(savedProductEntity);
    }

    @Test
    void getRepository()
    {
        List<ProductEntity> productEntityList = productRepository.findByTitle("pepsii");
        System.out.println("Finding by Title pepsii " + productEntityList);

        List<ProductEntity> entities = productRepository.findByCreatedAtAfter( LocalDateTime.of(2025, 1, 1, 0, 0, 0 ));
        System.out.println("Finding by findByCreatedAtAfter " + entities);

        List<ProductEntity> quantities = productRepository.findByQuantityGreaterThanOrPriceLessThan(4, BigDecimal.valueOf(23.45));
        System.out.println("Finding by findByQuantityGreaterThanOrPriceLessThan " + quantities);

        List<ProductEntity> like = productRepository.findByTitleLike("%Choco%");
        System.out.println("Finding by findByTitleLike(%....%)  " + like);

        List<ProductEntity> containing = productRepository.findByTitleContaining("Choco");      // no need for %(wildcard)
        System.out.println("Finding by findByTitleContaining(....)  " + containing);

        List<ProductEntity> containingIgnoreCases = productRepository.findByTitleContainingIgnoreCase("ChOco");
        System.out.println("Finding by findByTitleContainingIgnoreCase(....)  " + containingIgnoreCases);

    }

    @Test
    void getSingleFromRepository()
    {
        Optional<ProductEntity> titleAndPrice = productRepository.findByTitleAndPrice("ParleBuiscuits" , BigDecimal.valueOf(200.66));
        titleAndPrice.ifPresent(System.out::println);
    }
}
