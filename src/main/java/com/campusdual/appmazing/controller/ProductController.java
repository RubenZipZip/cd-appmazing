package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/products") //nombreHost/products la respuesta solo seria a partir de /products

    public class ProductController {
    @Autowired //devuelve una instancia de una interfaz IproductService (
    IProductService productService;

    @GetMapping // respoindera con una peticion GET cuando le llegue un peticion testController
    public String testController() {
        return "Product controller works!"; // para que responda a una peticion GET, dará una 200 en la web

    }

    @PostMapping
    public String testController(@RequestBody String name) { //
        return "Product controller works, " + name + "!!";
    }

    @GetMapping(value = "/testMethod")
    public String TestControllerMethod() {
        return "Product controller method work!";
    }

    @PostMapping(value ="/get")
    public ProductDTO queryProduct(@RequestBody ProductDTO product) {
       return this.productService.queryProduct(product);
    }

    @GetMapping(value = "/getAll") //
    public List<ProductDTO> queryAllProducts(){
        return this.productService.queryAllProducts();
}
}

