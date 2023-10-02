package com.campusdual.appmazing.model.dto.dtopmapper;

import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
        ProductDTO toDTO(Product product);
        List<ProductDTO> toDTOList(List<Product> products); //lista productos
        Product toEntity(ProductDTO productDTO); //le paso un dto y me da un modelo

}
