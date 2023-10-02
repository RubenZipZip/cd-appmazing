package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.dto.ProductDTO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RestController
    @RequestMapping("/products") //nombreHost/products la respuesta solo seria a partir de /products

    public class ProductController {
    @Autowired //devuelve una instancia de una interfaz IproductService (
    private IProductService productService;

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

    /*
        @GetMapping(value ="/get")
        public ProductDTO queryProduct(@RequestBody ProductDTO product) {
           return this.productService.queryProduct(product);
        }


     */
    @GetMapping(value = "/get")
    public ProductDTO queryProduct(@RequestBody ProductDTO product) {
        return this.productService.queryProduct(product);
    }


    @GetMapping(value = "/getAll") //
    public List<ProductDTO> queryAllProducts() {
        return this.productService.queryAllProducts();
    }

    @PostMapping(value = "/add")
    public int insertProduct(@RequestBody ProductDTO product) {
        return this.productService.insertProduct(product);
    }

    @PutMapping(value = "/update")
    public int updateProduct(@RequestBody ProductDTO product) {
        return this.productService.updateProduct(product);
    }

    @DeleteMapping(value = "/delete")
    public int deleteProduct(@RequestBody ProductDTO product) {
        return this.productService.deleteProduct(product);
    }


    //@PutMapping(value = "/buy5")
    //public int buyProduct(@RequestBody ProductDTO productDTO) {
    //    return this.productService.buyProduct(productDTO, 5); // indicamos que vamos a comprar 5


    @PostMapping(value = "/buy")
    public int buyProduct(@RequestBody Map<String, Integer> body) { //le pasamos un mapa de String y enteros ("id": 15)
        int quantity = body.get("quantity"); //como es un mapa le podemos pedir el valor de la clave quantity
        ProductDTO productDTO = new ProductDTO(); //creamos un productdto vacio
        productDTO.setId(body.get("id")); // y le establecemos un set con el id del body
        return this.productService.buyProduct(productDTO,quantity);
        // "quantity" :
        // "id":
    }
/*
    @PostMapping(value= /buy5")
    public int buyProduct5(@RequestBody ProductDTO productDTO){
    int quantity = 5;
    return this.productService.buyProduct(productDTO, quantity);
    }

 */
    @PostMapping(value = "/buyandshowprice")
    public BigDecimal buyProductAndShowPrice(@RequestBody ProductDTO productDTO) {
        int quantity = 5;
        this.productService.calculateTotalPrice(productDTO, quantity);
        return this.productService.calculateTotalPrice(productDTO,quantity);
    }
}
