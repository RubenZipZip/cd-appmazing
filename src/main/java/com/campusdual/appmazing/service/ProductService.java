package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ProductDTO;
import com.campusdual.appmazing.model.dto.dtopmapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service("ProductService")
@Lazy //no se creará cuando se inicie la aplicacion por primera
public class ProductService implements IProductService{ //Indicamos como los servicios tienen que implementar una interfaz
    @Autowired
    private ProductDao productDao; // le pasamos un dao para saber como comunicarse
    @Override
    public ProductDTO queryProduct(ProductDTO productDTO) { //PASA DTO
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);// lo convierte a producto para buscarlo
        Product productFinal = this.productDao.getReferenceById(product.getId()); //paso el ID pq es una consulta y llamo al DAO ->clase product id
        return ProductMapper.INSTANCE.toDTO(productFinal);
    }


    @Override
    public List<ProductDTO> queryAllProducts() {

        return ProductMapper.INSTANCE.toDTOList( this.productDao.findAll());// le pasa findAll todos los datos para que pueda leerlos el DTO
    }

    @Override
    public int insertProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);// paso DTO menos el identificador
        this.productDao.saveAndFlush(product);
        return product.getId();
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {
        return this.insertProduct(productDTO);
    }

    @Override
    public int deleteProduct(ProductDTO productDTO) {
        int id = productDTO.getId();
        Product product = ProductMapper.INSTANCE.toEntity((productDTO));
        this.productDao.delete(product);
        return id;
    }
     @Override
    public int buyProduct(ProductDTO product, int quantity) { //le pasamos a nuestro servicio el producto y una cantidad
        //y vamos a controllerService a decirlle cuanto es quantity 5
        ProductDTO productToBuy = this.queryProduct(product);
        if (productToBuy.isActive() && quantity <= productToBuy.getStock()){
            productToBuy.setStock(productToBuy.getStock()-quantity);
            this.updateProduct(productToBuy);
        }
        return productToBuy.getStock();
    }
public BigDecimal calculateTotalPrice(ProductDTO product, int quantity) {
        ProductDTO productToBuy = this.queryProduct(product);
        return productToBuy.getPrice().multiply(BigDecimal.valueOf(quantity));

}
}

