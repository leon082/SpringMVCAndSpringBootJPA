/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contactsbd.ws.client;

import com.test.contactsbd.ws.dao.Dao;
import com.test.contactsbd.ws.model.LL_Contact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis.leon
 */
@Component
public class ContactClient {

    @Autowired
    Dao<LL_Contact> contactDao;

    public List<LL_Contact> loadAll() {
        return contactDao.loadAll();
    }

    public String save(LL_Contact t) {
        if (contactDao.save(t)) {
            return "Se guardo el contacto";
        } else {
            return "No se pudo guardar el contacto";
        }

    }

    public LL_Contact load(long id) {
        return contactDao.load(id);

    }

    public String delete(long t) {
        if (contactDao.delete(t)) {
            return "Se Elimino el Contacto";
        } else {
            return "No se pudo eliminar el contacto";
        }

    }

    public LL_Contact update(LL_Contact t) {
        if (contactDao.update(t)) {
            return contactDao.load(t.getId());
        } else {
            return null;
        }

    }

}
