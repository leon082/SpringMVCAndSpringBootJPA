/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contactsbd.ws.client;

import com.test.contactsbd.ws.dao.Dao;
import com.test.contactsbd.ws.model.LL_Contact;
import com.test.contactsbd.ws.model.LL_Estadoscontact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis.leon
 */
@Component
public class EstadoClient {
     @Autowired
    Dao<LL_Estadoscontact> contactDao;

    public List<LL_Estadoscontact> loadAll() {
        return contactDao.loadAll();
    }
    
}
