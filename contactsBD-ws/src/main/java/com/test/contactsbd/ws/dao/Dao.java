/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contactsbd.ws.dao;

/**
 *
 * @author luis.leon
 */
import java.util.List;

public interface Dao<T> {

    boolean save(T t);

    T load(long id);

    boolean delete(long id);

    boolean update(T t);

    List<T> loadAll();

}
