package com.campusdual.appmazing.controller;


import com.campusdual.appmazing.api.ICategoriesService;
import com.campusdual.appmazing.model.dto.CategoriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired //devuelve una instancia de una interfaz IproductService (
    private ICategoriesService categoriesService;

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
        return "Categories controller method work!";
    }
    /*
        @GetMapping(value ="/get")
        public ProductDTO queryProduct(@RequestBody ProductDTO product) {
           return this.productService.queryProduct(product);
        }


     */
    @GetMapping(value ="/get")
    public CategoriesDTO queryCategories(@RequestBody CategoriesDTO categories) {
        return this.categoriesService.queryCategories(categories);
    }


    @GetMapping(value = "/getAll") //
    public List<CategoriesDTO> queryAllCategories(){
        return this.categoriesService.queryAllCategories();
    }

    @PostMapping(value = "/add")
    public int insertCategories(@RequestBody CategoriesDTO categories) {
        return this.categoriesService.insertCategories(categories);
    }

    @PutMapping(value = "/update")
    public int updateCategories(@RequestBody CategoriesDTO categories){
        return this.categoriesService.updateCategories(categories);
    }
    @DeleteMapping(value = "/delete")
    public int deleteCategories(@RequestBody CategoriesDTO categories){
        return this.categoriesService.deleteCategories(categories);
    }
}

