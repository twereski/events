package com.example.events.app.product;


import com.example.events.app.product.assembler.CommandOneAssembler;
import com.example.events.app.product.assembler.ProductAssembler;
import com.example.events.app.product.command.CommandOne;
import com.example.events.app.product.command.CommandTwo;
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

        assemblerMap.put(CommandOne.class.getName(), new CommandOneAssembler());
        assemblerMap.put(CommandTwo.class.getName(), new CommandOneAssembler());

        return assemblerMap;
    }
}
