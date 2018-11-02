package com.example.events.app.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/")
    public String index() {
        return "Xd xd dupa";
    }

    public void applyCommandOne() {

    }
}
