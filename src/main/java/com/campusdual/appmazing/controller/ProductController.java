package com.campusdual.appmazing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/products") //nombreHost/products la respuesta solo seria a partir de /products

    public class ProductController {
        @GetMapping // respoindera con una peticion GET cuando le llegue un peticion testController
        public String testController(){
            return "Product controller works!"; // para que responda a una peticion GET

        }

}

