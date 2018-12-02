package com.example.events.app.product;


import com.example.events.app.product.assembler.BuyAssembler;
import com.example.events.app.product.assembler.ProductAssembler;
import com.example.events.app.product.command.Buy;
import com.example.events.app.product.command.Pay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductConfiguration {

//    private Context context;

//    public ProductConfiguration(Context context){
//        this.context = context;
//    }

    @Bean
    public Map<String, ProductAssembler> basicDataAssembler() {

        Map<String, ProductAssembler> assemblerMap = new HashMap<>();

        assemblerMap.put(Buy.class.getName(), new BuyAssembler());
        assemblerMap.put(Pay.class.getName(), new BuyAssembler());

        return assemblerMap;
    }
}
