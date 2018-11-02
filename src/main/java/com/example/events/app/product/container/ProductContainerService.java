package com.example.events.app.product.container;

import com.example.events.domain.ProductException;
import com.example.events.domain.model.product.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;


@Service
public class ProductContainerService {

    private final ProductContainerRepository productContainerRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProductContainerService(ProductContainerRepository productContainerRepository,
                                   ObjectMapper objectMapper) {
        this.productContainerRepository = productContainerRepository;
        this.objectMapper = objectMapper;
        this.objectMapper.registerModule(new GuavaModule());
    }

    public Product retrieveFrom(UUID productId) {
        ProductContainer productContainer = productContainerRepository.getOne(productId);

        try {
            return objectMapper.readValue(productContainer.getPayLoad(), Product.class);
        } catch (IOException e) {
//            log.error(e.getMessage());
//            throw new ProductException(ExceptionMessage.SERIALIZATION_READ, e);
            throw new ProductException();
        }
    }

    public void save(Product product) {
        try {
            String serializedProduct = objectMapper.writeValueAsString(product);
            productContainerRepository.updateProduct(product.getId(),
                    serializedProduct);
        } catch (JsonProcessingException e) {
//            log.error(e.getMessage());
            throw new ProductException();
//            throw new ProductException(ExceptionMessage.SERIALIZATION_WRITE, e);
        }
    }

}
