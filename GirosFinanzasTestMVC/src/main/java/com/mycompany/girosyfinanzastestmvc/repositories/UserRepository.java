/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.girosyfinanzastestmvc.repositories;
import com.mycompany.girosfinanzastestmvc.model.User;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author luis.leon
 */
public interface UserRepository extends CrudRepository<User, Integer>{
    
    @Query(value = "from User u WHERE u.estado = :estado")
    List<User> findContactByState(@Param("estado") int estado);
    
  
}


