package toba.Packages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import toba.Beans.User; //import the Java beans Class library
import toba.Data.UserDB; //import the Java Data Class library
import toba.Data.PasswordUtil; //import the Java Data Class library

/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */
public class LoginServlet extends HttpServlet {

    /**
     * 1. Code the servlet to retrieve the username and password form the form
     * we added to login.html. Have the servlet check that the username is equal
     * to jsmith@toba.com and the password is equal to "letmein". Make sure you
     * use these values. If the username and password match, the servlet to 
     * forward the request to the account_activity.html page. If it is incorrect,
     * it should forward the request to the login_failure.html page.
     * 
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    //Create the doPost method
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //set the Content Type
        response.setContentType("text/html;charset=UTF-8");
        //set variable to current action
        String action = request.getParameter("action");
        
        // get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //set the url
        String url = "/index.jsp";
        //idenifying the user with connection to server
        User selUser = UserDB.selectUser(username);
        
        String saltPw = "";
        try {
            saltPw = PasswordUtil.hashPassword(password + selUser.getSalt());
        } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Create a condition to look for the username and password specified
        //or redirect if the user is null
        if( selUser == null ) {
            url = "/new_customer.jsp;";
        } else if( username.equals(selUser.getUserName()) && 
                saltPw.equals(selUser.getPassword()) ) {
            //create the session scope
            HttpSession session = request.getSession();
            //pull the session for the Specified User
            session.setAttribute("user", selUser);
            //set the url
            url = "/mmindex.jsp";

        } else {
            //set the url
            url = "/Login_failure.jsp";
        }
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
