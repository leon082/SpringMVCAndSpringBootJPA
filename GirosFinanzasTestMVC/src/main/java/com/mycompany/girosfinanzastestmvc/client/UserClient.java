/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.girosfinanzastestmvc.client;


import com.mycompany.girosfinanzastestmvc.dto.UserDTO;
import com.mycompany.girosfinanzastestmvc.model.User;
import com.mycompany.girosyfinanzastestmvc.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis.leon
 */
@Component
public class UserClient {

    @Autowired
    UserRepository repository;

    public List<User> loadAll() {
        return (List<User>) repository.findAll();
    }

    public String save(User t) {
        try{
            repository.save(t);
        return "Se guardo el contacto";
        }catch(Exception e){
            return "No se pudo guardar el contacto "+e.getMessage();
        }
        

    }

    public User load(int id) {
        return repository.findById(id).get();

    }

    public String delete(int id) {
        try{
            repository.deleteById(id);
            return "Se Elimino el Contacto";
        } catch(Exception e) {
            return "No se pudo eliminar el contacto "+e.getMessage();
        }

    }

    public User update(User t) {
      this.save(t);
      return t;

    }
    
    public List<UserDTO> getContactReport(){
        List<UserDTO> list = new ArrayList<>();
        repository.findAll().forEach(i-> list.add(userToDTO(i)));
        return list;
    }
    
    private UserDTO userToDTO(User u){
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setFirstName(u.getFirstName());
        dto.setLastName(u.getLastName());
        dto.setEstado(u.getEstado() == 1 ? "Activo" : "Inactivo");
        
        return dto;
    }
    
    
    public List<User> getContactByState(int estado){
        
        return (List<User>) repository.findContactByState(estado);
    }
}
