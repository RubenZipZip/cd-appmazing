package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
 //vengo de Product y aqui indica que necesito una logica de acceso a datos
//tu modelo va a ser un Product y tu clave primaria un entero
    //paso a hacer el DTO
}
