package toba.Data;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import toba.Beans.Account;
import toba.Data.Transaction.TransTypes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-30T23:26:13")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, Long> transID;
    public static volatile SingularAttribute<Transaction, Double> transAmt;
    public static volatile SingularAttribute<Transaction, Boolean> isProcessed;
    public static volatile SingularAttribute<Transaction, Date> transferDate;
    public static volatile SingularAttribute<Transaction, TransTypes> type;
    public static volatile SingularAttribute<Transaction, Account> account;

}