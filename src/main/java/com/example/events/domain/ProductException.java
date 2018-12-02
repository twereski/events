package com.example.events.domain;

import java.io.IOException;

public class ProductException extends RuntimeException {
    public ProductException(String message, IOException e) {
        super(message, e);
    }
    public ProductException(String message) {
        super(message);
    }
}
