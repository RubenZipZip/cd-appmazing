

package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ContactDao;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ContactDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;
import com.campusdual.appmazing.model.dto.dtopmapper.ContactMapper;
import com.campusdual.appmazing.model.dto.dtopmapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactService")
@Lazy
public class ContactService implements IContactService {
    @Autowired
    private ContactDao contactDao;



    @Autowired
    private IProductService productService;


    @Override // metodos de la interfaz implementados
    public ContactDTO queryContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        Contact contactFinal = this.contactDao.getReferenceById(contact.getId());
        return ContactMapper.INSTANCE.toDTO(contactFinal);
    }


    @Override
    public List<ContactDTO> queryAllContacts() {
        return ContactMapper.INSTANCE.toDTOList(this.contactDao.findAll());
    }

    @Override
    public int insertContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        this.contactDao.saveAndFlush(contact);
        return contact.getId();
    }

    @Override
    public int updateContact(ContactDTO contactDTO) {
        return this.insertContact(contactDTO);
    }

    @Override
    public int deleteContact(ContactDTO contactDTO) {
        int id = contactDTO.getId();
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contactDao.delete(contact);
        return id;
    }

    @Override
    public void buyProduct(ProductDTO product, int quantity) {

    }

    void buyProduct(ContactDTO contact, ProductDTO product, int quantity) {
        Product productEntity = ProductMapper.INSTANCE.toEntity(product);
        ProductDTO productToBuy = productService.queryProduct(product);
        if (productToBuy.isActive() && quantity <= productToBuy.getStock()) {
            productToBuy.setStock(productEntity.getStock() - quantity);
            productService.updateProduct(productToBuy);
        }
        ProductMapper.INSTANCE.toDTO(productEntity).getStock();
        }

    }






