package com.example.events.domain.model;

import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class Money {

    public static final Currency DEFAULT_CURRENCY = Currency.PLN;
    BigDecimal amount;
    Currency currency;

    public Money(@NonNull BigDecimal amount, @NonNull Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money(@NonNull BigDecimal amount) {
        this.amount = amount;
        this.currency = DEFAULT_CURRENCY;
    }
}
