/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Beans;


import java.io.Serializable; //adding the Serializable libraries
import java.util.ArrayList;
import javax.persistence.CascadeType; //adding the persistence libraries
import javax.persistence.Entity; //adding the persistence libraries
import javax.persistence.FetchType; //adding the persistence libraries
import javax.persistence.GeneratedValue; //adding the persistence libraries
import javax.persistence.GenerationType; //adding the persistence libraries
import javax.persistence.Id; //adding the persistence libraries
import javax.persistence.ManyToOne; //adding the persistence libraries
import javax.persistence.OneToMany; //adding the persistence libraries
import javax.persistence.Temporal; //adding the persistence libraries
import javax.persistence.EnumType; //adding the persistence libraries
import javax.persistence.Enumerated; //adding the persistence libraries
import javax.persistence.*; //adding the persistence libraries

import toba.Beans.User; //adding the User Class java bean
import toba.Data.Transaction; //adding the Transaction class

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */

@Entity
public class Account implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long acctId;
    
    public enum AcctType{
        CHECKING,
        SAVINGS
    }
    
    @Enumerated(EnumType.STRING)
    private AcctType acctType;
    private double balance;

    @ManyToOne
    private User user;

    
//    public User getUser(){
//        return user;
//    }
//    public void setUser(User user){
//        this.user = user;
//    }
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private ArrayList<Transaction> transaction;
    
    public Account(){

    }
    
    public Account(User user, AcctType type, double sBalance){
        this.user = user;
        this.balance = sBalance;
        this.acctType = type;
        this.transaction = new ArrayList<Transaction>();
    }
    
    public void credit(double creditBal){
        this.balance -= creditBal;
        //this.transaction.add(new Transaction(amt, Transaction.TransactionTypes.CREDIT));

    }
    
    public void debit(double debitBal){
        this.balance -= debitBal;
        //this.transaction.add(new Transaction(amt, Transaction.TransactionTypes.DEBIT));
    }
    
    public long getAcctID(){
        return acctId;
    }
    
    public void setAcctID(Long acctId){
        this.acctId = acctId;
    }
    
    public AcctType getAcctType(){
        return acctType;
    }
    
    public void setAcctType(AcctType type){
        this.acctType = type;
    }
    
    public double getBal(){
        return balance;
    }

    //public String getBalCurrFrmt(){
        //Numberformat currency = Numberformat.getCurrencyInstance();
        //return currency.format(this.getBal());
    //}

    public void setBal(Double bal) {
        this.balance = bal;
    }
    
    public ArrayList<Transaction> getList(){
        return transaction;
    }

}
