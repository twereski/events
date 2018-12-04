package com.example.events.app.product.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Create implements Command {

    private UUID productId;
    private BigDecimal basicPrice;
    private String name;
}
