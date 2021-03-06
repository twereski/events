package com.example.events.app.product.container;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "PRODUCT_CONTAINER")
public class ProductContainer {

    @Id
    @Column(name = "ID")
    private UUID productId;

    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @Lob
    @Column(name = "PAY_LOAD")
    private String payLoad;

    public ProductContainer(UUID productId) {
        this.productId = productId;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }
}
