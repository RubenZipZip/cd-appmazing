package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.CategoriesDTO;

import java.util.List;

public interface ICategoriesService {
   CategoriesDTO queryCategories(CategoriesDTO categories);

    CategoriesDTO queryService(CategoriesDTO categoriesDTO);

      List<CategoriesDTO> queryAllCategories();

   //operaciones CRUD
   int insertCategories(CategoriesDTO categories);

   int updateCategories(CategoriesDTO categories);

   int deleteCategories(CategoriesDTO categories);
}


