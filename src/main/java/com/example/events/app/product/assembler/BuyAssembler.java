package com.example.events.app.product.assembler;

import com.example.events.app.product.command.Buy;
import com.example.events.domain.model.product.Product;
import org.springframework.stereotype.Service;

@Service("BuyAssembler")
public class BuyAssembler extends ProductAssembler<Buy> {

    public Product applyCommand(Buy command, Product product){
        product.buy();
        return product;
    }
}
