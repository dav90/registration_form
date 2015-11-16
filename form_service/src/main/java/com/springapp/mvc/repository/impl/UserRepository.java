package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IUserRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository
@Transactional
public class UserRepository implements IUserRepository {
    @Autowired
    public SessionFactory sessionFactory;


    @Override
    public void addUser(User user) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new DatabaseException("cant add user to database");
        }
    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public User findUserByEmail(User user) {
        String hql = "FROM User u where u.email= :email";
        Query query;
        try {
            Session session = sessionFactory.openSession();
            query = session.createQuery(hql);
            query.setParameter("email", user.getEmail());
        } catch (Exception e) {
            throw new RuntimeException("Cant find user ", e);
        }
        return (User)query.list().get(0);
    }

    @Override
    public List<User> getAllUser() {
        // Retrieve session from Hibernate
        Session session = this.sessionFactory.openSession();
        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM User");
        // Retrieve all
        return query.list();
    }

    @Override
    public void editUser(User user) {
        Session session = null;
        if (user != null) {
            String hql = "update User u set u.address= :userAddress where u.id= :userId";
//        String hql = "select * from User where id =userId";
            try {
                session = sessionFactory.openSession();
                if (session != null) {
                    Query query = session.createQuery(hql);
                    query.setParameter("userId", user.getId());
                    query.setParameter("userAddress", user.getAddress());
                    query.executeUpdate();
                }
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException("Cant edit user");
            }
        }
    }

    @Override
    public boolean isExistingUser(User user) {
        String hql = "from User u where u.email= :email";
        List results = null;
        try {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery(hql);
            query.setParameter("email", user.getEmail());
            results = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results != null;
    }
}
