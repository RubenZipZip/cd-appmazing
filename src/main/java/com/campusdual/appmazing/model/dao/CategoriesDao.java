package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesDao extends JpaRepository <Categories, Integer> {
}
//el modelo será Categories y recibirá un int (la clave primaria)