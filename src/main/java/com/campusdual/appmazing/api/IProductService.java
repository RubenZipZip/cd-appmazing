package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {

//paso los metodos CRUD
    ProductDTO queryProduct (ProductDTO product); //devuel un porduct y pasa un trozo de productDTO
    List<ProductDTO> queryAllProducts(); //pide todos los productos
    int insertProduct (ProductDTO product);//añadir
    int updateProduct (ProductDTO product);
    int deleteProduct (ProductDTO product);



}


