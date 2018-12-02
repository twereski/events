package com.example.events.app.product;

import com.example.events.app.product.command.Buy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    final private CommandHandler commandHandler;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/{customerId}/command-one", method = RequestMethod.POST)
    public void applyCommandOne(@PathVariable("customerId") int customerId, @RequestBody Buy buy) {
        commandHandler.handle(buy, customerId);
    }
}
