package com.example.events.app.product.command;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Create implements Command {

    private UUID productId;
    private BigDecimal basicPrice;
    private String name;
}
