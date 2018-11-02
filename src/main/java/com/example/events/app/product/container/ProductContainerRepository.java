package com.example.events.app.product.container;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ProductContainerRepository extends JpaRepository<ProductContainer, UUID> {

    Optional<ProductContainer> findByCustomerId(int customerId);

    @Modifying
    @Query("UPDATE ProductContainer set payLoad = :payLoad where id = :productId")
    void updateProduct(@Param("productId") UUID productId,
                       @Param("payLoad") String payLoad);

}


