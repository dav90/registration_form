package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IAddressRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AddressRepository implements IAddressRepository {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public void addAddress(User user) throws DatabaseException {

    }

    @Override
    public void removeAddress(User user) {

    }

    @Override
    public void editAddress(Address address) {

    }
}
