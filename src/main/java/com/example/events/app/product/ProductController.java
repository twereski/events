package com.example.events.app.product;

import com.example.events.app.product.command.Buy;
import com.example.events.app.product.command.Create;
import com.example.events.app.product.command.Pay;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createProduct(@RequestBody Create create) {
        commandHandler.handle(create);
    }
    @RequestMapping(value = "/bay", method = RequestMethod.POST)
    public void bayProduct(@RequestBody Buy buy) {
        commandHandler.handle(buy);
    }
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public void bayProduct(@RequestBody Pay pay) {
        commandHandler.handle(pay);
    }
}
