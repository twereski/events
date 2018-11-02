package com.example.events.app.product.assembler;

import com.example.events.app.product.command.CommandOne;
import com.example.events.domain.model.product.Product;
import org.springframework.stereotype.Service;

@Service("CommandOneAssembler")
public class CommandOneAssembler extends ProductAssembler<CommandOne> {

    public Product toEntity(CommandOne command, Product product){
        return product;
    };
}
