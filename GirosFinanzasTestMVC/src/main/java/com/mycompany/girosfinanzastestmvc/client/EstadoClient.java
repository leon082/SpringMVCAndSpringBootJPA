/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.girosfinanzastestmvc.client;



import com.mycompany.girosfinanzastestmvc.model.State;
import com.mycompany.girosyfinanzastestmvc.repositories.StateRepository;
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
    StateRepository repository;

    public List<State> loadAll() {
        return (List<State>) repository.findAll();
    }
    
}
