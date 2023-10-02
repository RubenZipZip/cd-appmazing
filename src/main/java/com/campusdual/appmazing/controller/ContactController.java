package com.campusdual.appmazing.controller;
import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.dto.ContactDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contacts") //nombreHost/products la respuesta solo seria a partir de /products

public class ContactController {
    @Autowired //devuelve una instancia de una interfaz IproductService (
    private IContactService contactService;

    @GetMapping // respondera con una peticion GET cuando le llegue un peticion testController
    public String testContacts() {
        return "Contact controller works!"; // para que responda a una peticion GET, dará una 200 en la web

    }

    @PostMapping
    public String testController(@RequestBody String name) { //
        return "Product controller works, " + name + "!!";
    }

    @GetMapping(value = "/testMethod")
    public String TestControllerMethod() {
        return "Product controller method work!";
    }

    @GetMapping(value ="/get")
    public ContactDTO queryContact(@RequestBody ContactDTO contact) { // metodo queryContact
// que pasa un objeto ContactDTO como parametro () (@ResquestBody(json) pasa el contact a la queryContact
        return this.contactService.queryContact(contact); //  lo devuelve la bbdd y muestra la response de Postman
    }

    @GetMapping(value = "/getAll") //
    public List<ContactDTO> queryAllContacts(){
        return this.contactService.queryAllContacts();
    }

    @PostMapping(value = "/add")
    public int insertContact(@RequestBody ContactDTO contact) {


        return this.contactService.insertContact(contact);
    }

    @PutMapping(value = "/update")
    public int updateContact(@RequestBody ContactDTO contact){
        return this.contactService.updateContact(contact);
    }
    @DeleteMapping(value = "/delete")
    public int deleteContact(@RequestBody ContactDTO contact){
        return this.contactService.deleteContact(contact);
    }
/*
@PutMapping(value= "/buy")
public int buyProduct(@RequestBody ProductDTO productDTO){
        return contactctService.buyProduct(productDTO, 5);

}

 */
}


