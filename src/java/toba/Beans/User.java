/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Beans;

import java.io.Serializable;
import javax.persistence.Entity; //adding the persistence libraries
import javax.persistence.GeneratedValue; //adding the persistence libraries
import javax.persistence.GenerationType; //adding the persistence libraries
import javax.persistence.Id; //adding the persistence libraries

import toba.Beans.Account; //adding the Account library
import toba.Data.AccountDB; //adding the AccountDB library
import toba.Data.Transaction; //adding the Transaction library

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */
/**
 * 1. Create a User Java Bean
 * 2. Add all Attributes from the New Customer Form
 * 3. create a property for username and password
 * 4. Add the Entity and its properties, including the auto increment
 * 5. Set the variables for User ID
 * 6. Set the get and set for the User ID
 */
//Add the Entity
@Entity
//create class that impletments Serializable
public class User implements Serializable{
    
    //Set the Entity ID
    @Id
    //Set the code to auto generate the ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Set the User ID variable
    private Long userId;
    //set all variables
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String userName;
    private String password;
    private String salt;
    
    
    //create the zero argument constructor
    public User(){
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
        city = "";
        state = "";
        zip = "";
        email = "";
        userName = "";
        password = "";
    }
    //create a constructor for User
    public User(String firstName, String lastName, String phone, String address, 
            String city, String state, String zip, String email, String userName, String password){
        //connect the variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
    
    //create the get for the User ID
    public Long getUserId() {
        return userId;
    }
    //create the set for the User ID
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    //Create the first name get method
    public String getFirstName(){
        return firstName;
    }
    //Create the first name set method
    public void setFirstName(String firstName){
        //connect the variable
        this.firstName = firstName;
    }
    //Create the last name get method
    public String getLastName(){
        return lastName;
    }
    //Create the last name set method
    public void setLastName(String lastName){
        //connect the variable
        this.lastName = lastName;
    }
    //Create the phone get method
    public String getPhone(){
        return phone;
    }
    //Create the phone set method
    public void setPhone(String phone){
        //connect the variable
        this.phone = phone;
    }
    //Create the address get method
    public String getAddress(){
        return address;
    }
    //Create the address set method
    public void setAddress(String address){
        //connect the variable
        this.address = address;
    }
    //Create the city method
    public String getCity(){
        return city;
    }
    //Create the city set method
    public void setCity(String city){
        //connect the variable
        this.city = city;
    }
    //Create the state get method
    public String getState(){
        return state;
    }
    //Create the state set method
    public void setState(String state){
        //connect the variable
        this.state = state;
    }
    //Create the zip get method
    public String getZip(){
        return zip;
    }
    //Create the zip set method
    public void setZip(String zip){
        //connect the variable
        this.zip = zip;
    }
    //Create the email get method
    public String getEmail(){
        return email;
    }
    //Create the email set method
    public void setEmail(String email){
        //connect the variable
        this.email = email;
    }
    //Create the user name get method
    public String getUserName(){
        return userName;
    }
    //Create the user name set method
    public void setUserName(String userName){
        //connect the variable
        this.userName = userName;
    }
    //Create the password get method
    public String getPassword(){
        return password;
    }
   //Create the password set method
    public void setPassword(String password){
        //connect the variable
        this.password = password;
    }
    //Create the get method for the Checking Balance
    public String getCheckingBalance(){
        Account checking = this.getAcct(Account.AcctType.CHECKING);
        return checking.getBalanceCurrencyFormat();
    }
    //Create the get method for the Savings Balance
    public String getSavingsBalance(){
        Account savings = this.getAcct(Account.AcctType.SAVINGS);
        return savings.getBalanceCurrencyFormat();
    }
    
    public String getSalt(){
        return salt;
    }
    
    public void setSalt(String salt){
        this.salt = salt;
    }
    
    //create the method to pull the user acct infor
    public Account getAcct(Account.AcctType type){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //for(Account a: AccountDB.findByUserId(this.getUserId(), null)){
        //    if (a.getAcctType().equals(type))
        //        return a;
        //}
        //return null;
    }
}
