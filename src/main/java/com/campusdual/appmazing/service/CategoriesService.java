package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.ICategoriesService;
import com.campusdual.appmazing.model.Categories;
import com.campusdual.appmazing.model.dao.CategoriesDao;
import com.campusdual.appmazing.model.dto.CategoriesDTO;
import com.campusdual.appmazing.model.dto.dtopmapper.CategoriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoriesService")
@Lazy
public class CategoriesService implements ICategoriesService {
    @Autowired
    private CategoriesDao categoriesDao;

    public CategoriesDTO queryCategories(CategoriesDTO categoriesDTO) {
        Categories categories = CategoriesMapper.INSTANCE.toEntity(categoriesDTO);
        Categories categoriesFinal = this.categoriesDao.getReferenceById(categories.getId());
        return CategoriesMapper.INSTANCE.toDTO(categoriesFinal);
    }

    @Override
    public CategoriesDTO queryService(CategoriesDTO categoriesDTO) {
        return null;
    }

    @Override
    public List<CategoriesDTO> queryAllCategories() {
        return CategoriesMapper.INSTANCE.toDoList(this.categoriesDao.findAll());
    }

    @Override
    public int insertCategories(CategoriesDTO categoriesDTO) {
        Categories categories = CategoriesMapper.INSTANCE.toEntity(categoriesDTO);
        this.categoriesDao.saveAndFlush(categories);
        return categories.getId();


    }

    @Override
    public int updateCategories(CategoriesDTO categoriesDTO) {
        return this.insertCategories((categoriesDTO));
    }

    @Override
    public int deleteCategories(CategoriesDTO categoriesDTO) {

        int id = categoriesDTO.getId();
        Categories categories = CategoriesMapper.INSTANCE.toEntity(categoriesDTO);
        categoriesDao.delete(categories);
        return id;
    }

}
