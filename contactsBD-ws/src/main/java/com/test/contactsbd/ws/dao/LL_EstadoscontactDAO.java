/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contactsbd.ws.dao;

import com.test.contactsbd.ws.model.LL_Contact;
import com.test.contactsbd.ws.model.LL_Estadoscontact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author luis.leon
 */
@Repository
public class LL_EstadoscontactDAO implements Dao<LL_Estadoscontact> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    
    @Override
    public List<LL_Estadoscontact> loadAll() {
       return jdbcTemplate.query("select * from LL_ESTADOSCONTACT", new EstadoMapper());
    }

    @Override
    public boolean save(LL_Estadoscontact t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LL_Estadoscontact load(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(LL_Estadoscontact t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class EstadoMapper implements RowMapper<LL_Estadoscontact> {

        @Override
        public LL_Estadoscontact mapRow(ResultSet resultSet, int i) throws SQLException {

            LL_Estadoscontact estado = new LL_Estadoscontact();
            estado.setLlave(resultSet.getInt("LLAVE"));
            estado.setValor(resultSet.getString("VALOR"));

            return estado;
        }
    }

}
