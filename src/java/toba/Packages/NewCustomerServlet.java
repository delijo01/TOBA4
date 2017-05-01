package toba.Packages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

import toba.Beans.User; //import the Java beans Class library
import toba.Data.UserDB; //import the Java Data Class library
import toba.Beans.Account; //import the Java Data Class library
import toba.Data.AccountDB; //import the Java Data Class library
import toba.Data.PasswordUtil; //import the Java Data Class library
/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */

/**
 * 
 *1. Add the User Bean instance from the New Customer Form to the New Customer Servlet
 * 2. Add the Username variable with username and zipcode combined
 * 3. Add the password variable with a temporary password that is egual to Welcome1
 */
public class NewCustomerServlet extends HttpServlet {

    /**
     * 1. Code the servlet to retrieve tghe new customer form data and just
     * redirect to the success.html page
     *
     * 2. Code the NewCustomerServlet to validate the user has entered in values
     * for all the form fields, if not assign a message variable such as
     *  "Please fill out all the form fields" and display a message on the 
     *  new_customer.html page
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    //Create the doPost method
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        //set the Content Type -- removed for new process
        //response.setContentType("text/html;charset=UTF-8");
        
        //set printwriter to pull message -- removed for new process
        //PrintWriter htmlnote = response.getWriter();
        
        //Set the string url
        //String url = "/New_customer.html";
        String url = "/New_customer.jsp";
        
        // get parameters from the request
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String email = request.getParameter("Email");
        String username = lastname + zipcode;
        String password = "welcome1"; 
        
        // store data in User object
        User user = new User(firstname, lastname, phone, address, city, state, zipcode, email, username, password);
        //create variables for beginning bal for Checking and Savings
        Account checking = new Account(user, Account.AcctType.CHECKING, 0.00);
        Account savings = new Account(user, Account.AcctType.SAVINGS, 25.00);

        //set variable for the message
        String message;
        // check strength requirements
        try {
            PasswordUtil.checkPasswordStrength(password);
            message = "";
        } catch (Exception e) {
            message = e.getMessage();
        }
        request.setAttribute("message", message); 
            
        //use a condition to validate the parameters
        if (firstname == null || lastname == null || phone == null || address == null || 
                city == null || state == null || zipcode == null || email == null ||
                firstname.isEmpty() || lastname.isEmpty() || phone.isEmpty() || 
                address.isEmpty() || city.isEmpty() || state.isEmpty() || 
                zipcode.isEmpty() || email.isEmpty()) {
            //set the variable message
            message = "Please fill out all eight text boxes.  To return to New Customer form, please press the back button";
            //set the url
            //url = "/New_customer.html";
            url = "/New_customer.jsp";
            //set the message attributes
            request.setAttribute("message", message);
        } 
        else {
            //set the variable message
            message = "";
            String hashPw;
            String salt = "";
            String saltHashPw;
            try {
                salt = PasswordUtil.getSalt();
                saltHashPw = PasswordUtil
                    .hashPassword(user.getPassword() + salt);
                user.setSalt(salt);

            } catch(NoSuchAlgorithmException ex){
                hashPw = ex.getMessage();
                saltHashPw = ex.getMessage();
            }

            user.setPassword(saltHashPw);

            //inserting the user info the User DB
            UserDB.insert(user);
            //insertng the account info in the account DB
            AccountDB.insert(checking);
            AccountDB.insert(savings);
            //set the url
            url = "/Success.jsp";
           
        }
            
        //create the session scope
        HttpSession session = request.getSession();
        //set the user Attributes to sesson scope
        session.setAttribute("user", user);
        //set the message attributes
        request.setAttribute("message", message);
            
        //get the information from the form
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
                
    }

    //Create the doGet Method
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Call the doPost method
        doPost(request, response);
    }

}
