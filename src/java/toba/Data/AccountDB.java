/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Data;
//Adding the needed libraries
import toba.Beans.Account;
import java.util.List;
import javax.persistence.EntityManager; //adding the persistence libraries
import javax.persistence.EntityManagerFactory; //adding the persistence libraries
import javax.persistence.EntityTransaction; //adding the persistence libraries
import javax.persistence.Persistence; //adding the persistence libraries
import javax.persistence.NoResultException; //adding the persistence libraries
import javax.persistence.TypedQuery; //adding the persistence libraries
import toba.Beans.User;

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */
public class AccountDB {

    public static void insert(Account account) {
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Account account) {
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static List<Account> findByUserId(Long userId, String accountType){
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                         "WHERE a.user.userId = :userId ";
        
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("userId", userId);
        List<Account> results = null;
        try { 
            results = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return results;
    }
}
