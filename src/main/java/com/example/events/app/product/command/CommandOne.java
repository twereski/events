package com.example.events.app.product.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CommandOne implements Command {
    private UUID productId;
}
