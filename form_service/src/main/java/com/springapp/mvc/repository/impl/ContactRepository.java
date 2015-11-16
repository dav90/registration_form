package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IContactRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ContactRepository implements IContactRepository{

    @Autowired
    public SessionFactory sessionFactory;


    @Override
    public void addContact(User user) throws DatabaseException {

    }

    @Override
    public void removeContact(User user) {

    }

    @Override
    public List<User> getAllContact() {
        return null;
    }

    @Override
    public void editContact(User user) {

    }
}
