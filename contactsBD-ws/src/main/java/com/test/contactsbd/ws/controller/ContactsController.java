/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contactsbd.ws.controller;

import com.test.contactsbd.ws.client.ContactClient;
import com.test.contactsbd.ws.client.EstadoClient;
import com.test.contactsbd.ws.model.LL_Contact;
import com.test.contactsbd.ws.model.LL_Estadoscontact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis.leon
 */
@RequestMapping("/contacts")
@RestController
public class ContactsController {

    @Autowired
    ContactClient contactClient;
    
    @Autowired
    EstadoClient estadoCient;

    @RequestMapping(value = "/")
    public ResponseEntity<List<LL_Contact>> getAllContacts() {
        
        List<LL_Contact> list = contactClient.loadAll();
        ResponseEntity<List<LL_Contact>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/getContactByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<LL_Contact> getContact(@PathVariable String id) {
        
        ResponseEntity<LL_Contact> response = new ResponseEntity<>(contactClient.load(Long.parseLong(id)), HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/getAllEstates", method = RequestMethod.GET)
    public ResponseEntity<List<LL_Estadoscontact>> getContact() {
        List<LL_Estadoscontact> list = estadoCient.loadAll();
        ResponseEntity<List<LL_Estadoscontact>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public String addContact(@RequestBody LL_Contact contact) {
        return contactClient.save(contact);

    }

    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable String id) {

        return contactClient.delete(Long.parseLong(id));

    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
    public ResponseEntity<LL_Contact> updateContact(@RequestBody LL_Contact contact) {

        ResponseEntity<LL_Contact> response = new ResponseEntity<>(contactClient.update(contact), HttpStatus.OK);
        return response;
    }
}
