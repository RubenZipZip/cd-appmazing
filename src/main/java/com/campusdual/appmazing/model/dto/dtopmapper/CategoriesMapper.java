package com.campusdual.appmazing.model.dto.dtopmapper;

import com.campusdual.appmazing.model.Categories;
import com.campusdual.appmazing.model.dto.CategoriesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    CategoriesMapper INSTANCE = Mappers.getMapper(CategoriesMapper.class);
    CategoriesDTO toDTO(Categories categories);
    List<CategoriesDTO> toDoList(List<Categories> categories);
    Categories toEntity(CategoriesDTO categoriesDTO);
}