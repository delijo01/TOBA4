/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Data;


import java.sql.*; //importing the SQL libaries
import javax.sql.DataSource; //importing the datasource libaries
import javax.naming.InitialContext; //importing needed libaries
import javax.naming.NamingException; //importing needed libaries
/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */
/**
 * 
 * 1. Establish a connection pool to call the connection info from the context xml
 */
//Setup the connection pool class to establish the connection
public class ConnectionPool {
    
    //setup variables for the Connection pool and datasource
    private static ConnectionPool pool = null;
    private static DataSource ds = null;
    
    //set the zero argument constructor for the database connection
    private ConnectionPool(){
        //create a try catch
        try{
            //initialize the connection
            InitialContext ic = new InitialContext();
            //set the datasource
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/toba");
        } catch (NamingException e) {
            System.out.println(e);
        
        }
    }
    //setup up the connection pool getInstance constructor
    public static synchronized ConnectionPool getInstance() {
        //set the condition if null
        if(pool == null){
            //create new connection pool
            pool = new ConnectionPool();
        }
        return pool;
    }
    //setup the get Connection constructor
    public Connection getConnection() {
        //create a try catch
        try {
            //return the datasource connection
            return ds.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void freeConnection(Connection c) {
        //create a try catch
        try {
            //close the connection
            c.close();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
