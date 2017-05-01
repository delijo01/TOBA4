package toba.Packages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//adding the need libraries
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.Beans.Account; 
import toba.Data.AccountDB;
import toba.Beans.User;

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */
public class TransactionServlet extends HttpServlet {

    /**
     * 1. This page will allow the user to post a transaction. 
     * 2. Just add a header for now
     * 
     * Sample doPost method
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //set the Content Type
        response.setContentType("text/html;charset=UTF-8");
        //set url variable
        String url = "/Transaction.jsp";
        
        //set variable to current action
        String action = request.getParameter("action");
        //set up condition to act if blank submit is used
        if(action == null) {
            action = "submit";
        }
        
        //set up condition to set the URL to appropriate page
        if(action.equals("submit")){
            url = "/Transaction.jsp";
        } else if (action.equals("transferFunds")){
            //get the parameters for the transactions
            String transAmt = request.getParameter("transferAmount");
            //format the variable to double
            Double amt = Double.parseDouble(transAmt);
            //create the session scope
            HttpSession session = request.getSession();
            //set the session attributes
            User user = (User) session.getAttribute("user");
            //set the variables
            String transferFrom = request.getParameter("transferFrom");
            String transferTo = request.getParameter("transferTo");
            String message = "";
            //set the condtion for the transfer
            if (transferFrom.equals("checking")) {
                //setting the variable for accout types                
                Account from = user.getAcct(Account.AcctType.CHECKING);
                Account to = user.getAcct(Account.AcctType.SAVINGS);
                //calling the methods and applying the amount
                from.debit(amt);
                to.credit(amt);
                //updating the account info in the account DB
                AccountDB.update(to);
                AccountDB.update(from);
                //apply page to url string
                url = "/Account_activity.jsp";
            } else if (transferFrom.equals("savings")) {
                //setting the variable for accout types
                Account from = user.getAcct(Account.AcctType.SAVINGS);
                Account to = user.getAcct(Account.AcctType.CHECKING);
                //calling the methods and applying the amount
                from.debit(amt);
                to.credit(amt);
                //updating the account info in the account DB
                AccountDB.update(to);
                AccountDB.update(from);
                //apply page to url string
                url = "/Account_activity.jsp";
            } else if (transferFrom.isEmpty() || transferTo.isEmpty()) {
                //create the error message
                message = "Please select which accounts you would like to transfer from and to in order to proceed.";
                //apply page to url string
                url = "/Transaction.jsp";
            } else {
                //create the error message
                message = "Transfer ammount was left empty, please enter a dollar amount.";
                //apply page to url string
                url = "/Transaction.jsp";
            }

        //set the Attributes to sesson scope 
        session.setAttribute("user", user);
        request.setAttribute("message", message);
        
        }       
        //get the information from the form
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        

    }


    /**
     * Sample doGet method
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Call the doPost method
        doPost(request, response);
    }

}
