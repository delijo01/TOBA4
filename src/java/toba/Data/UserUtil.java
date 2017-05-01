/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */

public class UserUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("TOBAPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
