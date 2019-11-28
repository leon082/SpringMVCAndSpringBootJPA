/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.girosfinanzastestmvc.controller;

import com.mycompany.girosfinanzastestmvc.client.UserClient;
import com.mycompany.girosfinanzastestmvc.client.EstadoClient;
import com.mycompany.girosfinanzastestmvc.dto.UserDTO;
import com.mycompany.girosfinanzastestmvc.model.User;
import com.mycompany.girosfinanzastestmvc.model.State;
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
    UserClient contactClient;
    
    @Autowired
    EstadoClient estadoCient;

    @RequestMapping(value = "/")
    public ResponseEntity<List<User>> getAllContacts() {
        
        List<User> list = contactClient.loadAll();
        ResponseEntity<List<User>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/getContactByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getContact(@PathVariable String id) {
        
        ResponseEntity<User> response = new ResponseEntity<>(contactClient.load(Integer.parseInt(id)), HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/getAllEstates", method = RequestMethod.GET)
    public ResponseEntity<List<State>> getContact() {
        List<State> list = estadoCient.loadAll();
        ResponseEntity<List<State>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/getContactReport", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getActiveContact() {
        List<UserDTO> list = contactClient.getContactReport();
        ResponseEntity<List<UserDTO>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }
    
     @RequestMapping(value = "/getContactByState/{estado}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getInactiveContact(@PathVariable String estado) {
        List<User> list = contactClient.getContactByState(Integer.parseInt(estado));
        ResponseEntity<List<User>> response = new ResponseEntity<>(list, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public String addContact(@RequestBody User contact) {
        return contactClient.save(contact);

    }

    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable String id) {

        return contactClient.delete(Integer.parseInt(id));

    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
    public ResponseEntity<User> updateContact(@RequestBody User contact) {

        ResponseEntity<User> response = new ResponseEntity<>(contactClient.update(contact), HttpStatus.OK);
        return response;
    }
}
