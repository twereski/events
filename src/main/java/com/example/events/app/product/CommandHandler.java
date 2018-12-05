package com.example.events.app.product;

import com.example.events.app.product.assembler.ProductAssembler;
import com.example.events.app.product.command.Command;
import com.example.events.app.product.command.Create;
import com.example.events.app.product.container.ProductContainerService;
import com.example.events.app.es.EventStoreService;
import com.example.events.domain.model.Money;
import com.example.events.domain.model.product.Product;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service
public class CommandHandler {

    private EventStoreService eventStoreService;

    private ProductContainerService productContainerService;

    private Map<String, ProductAssembler<Command>> assemblers;

    @Autowired
    public CommandHandler(EventStoreService eventStoreService, ProductContainerService productContainerService,
                           Map<String, ProductAssembler<Command>> assemblers) {
        this.eventStoreService = eventStoreService;
        this.productContainerService = productContainerService;
        this.assemblers = assemblers;
    }

    @Transactional
    public void handle(@NonNull Command command) {
        Product product = apply(command);

        eventStoreService.saveEvents(product);
        productContainerService.save(product);
    }

    private Product apply(Command command) {
        if(command.getClass().equals(Create.class)) {
            Create create = (Create) command;
            return new Product(create.getProductId(), create.getName(), new Money(create.getBasicPrice()));
        }

        Product product = productContainerService.retrieveFrom(command.getProductId());
        return assemblers.get(command.getClass().getName())
                .applyCommand(command, product);
    }
}
