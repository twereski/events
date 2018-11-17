package com.example.events.app.product;

import com.example.events.app.product.command.CommandOne;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    final private CommandHandler commandHandler;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Xd xd dupa";
    }

    @RequestMapping(value = "/{customerId}/command-one", method = RequestMethod.POST)
    public void applyCommandOne(@PathVariable("customerId") int customerId, @RequestBody CommandOne commandOne) {
        commandHandler.handle(commandOne, customerId);
    }
}
