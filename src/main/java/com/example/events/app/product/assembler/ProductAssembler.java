package com.example.events.app.product.assembler;

import com.example.events.app.product.command.Command;
import com.example.events.domain.model.product.Product;

public abstract class ProductAssembler<X extends Command> {

    public abstract Product toEntity(X command, Product product);
}
