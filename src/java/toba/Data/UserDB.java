/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import toba.Beans.User; //importing the java bean class
//import toba.Data.ConnectionPool; //importing the connection pool class
import javax.persistence.EntityManager; //adding the persistence libraries
import javax.persistence.EntityTransaction; //adding the persistence libraries
import javax.persistence.NoResultException; //adding the persistence libraries
import javax.persistence.TypedQuery; //adding the persistence libraries

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */

public class UserDB {
    
    public static void insert(User user) {
        //ConnectionPool pool = ConnectionPool.getInstance();
        //Connection connection = pool.getConnection();
        //PreparedStatement ps = null;
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    } 
    
    public static void update(User user) {
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        } 
    } 
    
        public static void delete(User user) {
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static User selectUser(String username) {
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.userName = :username";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("username", username);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static boolean usernameExists(String username) {
        User u = selectUser(username);   
        return u != null;
    }
}
