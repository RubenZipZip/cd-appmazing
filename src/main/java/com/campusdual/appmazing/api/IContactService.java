package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ContactDTO;


import java.util.List;

public interface IContactService {

    ContactDTO queryContact(ContactDTO contactDTO);

    List<ContactDTO> queryAllContacts();

    // operaciones crud contra la bbdd
    int insertContact (ContactDTO contact);
     int updateContact (ContactDTO contact);
     int deleteContact (ContactDTO contact);
}
