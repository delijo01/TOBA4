/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Data;

import toba.Beans.Account;
import toba.Data.AccountDB;
import java.io.Serializable; //adding the Serializable libraries
import java.text.NumberFormat; //adding the Number format libraries
import java.util.Date; //adding the date format libraries
import java.text.SimpleDateFormat; //adding the simple data format libraries
import javax.persistence.CascadeType; //adding the persistence libraries
import javax.persistence.Entity; //adding the persistence libraries
import javax.persistence.FetchType; //adding the persistence libraries
import javax.persistence.GeneratedValue; //adding the persistence libraries
import javax.persistence.GenerationType; //adding the persistence libraries
import javax.persistence.Id; //adding the persistence libraries
import javax.persistence.ManyToOne; //adding the persistence libraries
import javax.persistence.OneToMany; //adding the persistence libraries
import javax.persistence.Temporal; //adding the persistence libraries

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */
//adding the entity
@Entity
public class Transaction implements Serializable{
    //declaring the enum variables
    public enum TransTypes {
        CREDIT,
        DEBIT,
        TRANSFER
    }
    
   //setting the entity ID and auto generate
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //setting the variables
    private long transID;
    private double transAmt;  
    private boolean isProcessed;
    //set the Many to one entity
    @ManyToOne
    //setting the variable
    private Account account;
    //set the one to many entity
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    //private List<LineItem> lineItems;
    //setiing the temporal entity
    @Temporal(javax.persistence.TemporalType.DATE)
    //setting the variables
    private Date transferDate;
    private TransTypes type;
    
    //adding the constructors
    public Transaction(){
        
    }
    
    public Transaction(double transAmt, TransTypes type){
        this.transAmt = transAmt;
        this.transferDate = new Date();
        this.type = type;
    }
            
    
    //adding the getters and Setters
    //Transaction ID getter
    public Long getTransId() {
        return transID;
    }
    //Transaction ID setter
    public void setTransId(Long transID) {
        this.transID = transID;
    }
    //Transaction Amount getter
    public Double getTransAmt() {
        return transAmt;
    }
    //Transaction Amount setter
    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    } 
    //Pulling the current date getter
    public String getDate() {
        String date = new SimpleDateFormat("MM-dd-yyyy").format(this.transferDate);
        return date; 
    }
    //setting the current date setter
    public void setDate(Date transferDate) {
        this.transferDate = transferDate;
    } 
    //Pulling the transaction types
    public TransTypes getType() {
        return type;
    }
    //setting the transaction types
    public void setType(TransTypes type) {
        this.type = type;
    }
    
}
