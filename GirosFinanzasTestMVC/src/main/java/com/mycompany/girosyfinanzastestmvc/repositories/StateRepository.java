/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.girosyfinanzastestmvc.repositories;


import com.mycompany.girosfinanzastestmvc.model.State;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luis.leon
 */
public interface StateRepository extends CrudRepository<State, Integer>{
    
}
