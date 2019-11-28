/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.contactsbd.ws.dao;

import com.test.contactsbd.ws.model.LL_Contact;
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
public class LL_ContactDAO implements Dao<LL_Contact> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public boolean save(LL_Contact t) {

        try {
            String sql = "insert into LL_Contact (ID,FIRSTNAME,LASTNAME,EMAIL,PHONENUMBER,ESTADO) values (SQ_LL_CONTACT.nextval, ?, ?, ?,?,?)";
            jdbcTemplate.update(sql, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNumber(),t.getEstado());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public LL_Contact load(long id) {
        List<LL_Contact> contact = jdbcTemplate.query("select * from LL_CONTACT where id= " + id, new ContactMapper());

        if (contact.size() == 1) {
            return contact.get(0);
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        try {
            String sql = "delete from LL_Contact where id = ?";
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(LL_Contact t) {
        try {
            String sql = "UPDATE LL_CONTACT set FIRSTNAME=?, LASTNAME =?,EMAIL=?,PHONENUMBER=? ,ESTADO=? where id=?";
            jdbcTemplate.update(sql, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNumber(),t.getEstado(), t.getId());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<LL_Contact> loadAll() {
        return jdbcTemplate.query("select * from LL_CONTACT", new ContactMapper());
    }

    class ContactMapper implements RowMapper<LL_Contact> {

        @Override
        public LL_Contact mapRow(ResultSet resultSet, int i) throws SQLException {

            LL_Contact ll_Contact = new LL_Contact();
            ll_Contact.setId(resultSet.getLong("ID"));
            ll_Contact.setFirstName(resultSet.getString("FIRSTNAME"));
            ll_Contact.setLastName(resultSet.getString("LASTNAME"));
            ll_Contact.setEmail(resultSet.getString("EMAIL"));
            ll_Contact.setPhoneNumber(resultSet.getString("PHONENUMBER"));
            ll_Contact.setEstado(resultSet.getLong("ESTADO"));
            return ll_Contact;
        }
    }

}
