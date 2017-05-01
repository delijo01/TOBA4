package toba.Beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import toba.Beans.Account.AcctType;
import toba.Beans.User;
import toba.Data.Transaction;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-30T23:26:13")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Double> balance;
    public static volatile SingularAttribute<Account, AcctType> acctType;
    public static volatile SingularAttribute<Account, Long> acctId;
    public static volatile SingularAttribute<Account, User> user;
    public static volatile ListAttribute<Account, Transaction> transaction;

}