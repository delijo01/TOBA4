/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Packages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import toba.Beans.User; //import the Java beans Class library
import toba.Data.UserDB; //import the Java Data Class library
/**
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
 */

/**
 *  Page Assignment for Assignment 2
 *  1. Create servlet page 
 *  2. retrieve the user from the session
 *  3. change the pw to new pw from reset form
 */

@WebServlet(name = "PasswordResetServlet", urlPatterns = {"/PasswordResetServlet"})
public class PasswordResetServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        //set the Content Type -- removed for new process
        //response.setContentType("text/html;charset=UTF-8");

        //set printwriter to pull message  -- removed for new process
        //PrintWriter htmlnote = response.getWriter();
        
        //Set the string url
        String url = "/password_reset.jsp";

        // get parameters from the request        
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    
        //create the session scope
        HttpSession session = request.getSession();
        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname);
        session.setAttribute("username", username);
        //set the session attributes
        User user = (User) session.getAttribute("user");
        //set the variable
        String message;

        //use a condition to validate the parameters
        if (password == null || password.isEmpty()) {
            //set the variable message
            message = "Please add the new password for the password reset.  To return to Password Reset form, please press the back button";
            //set the url
            url = "/password_reset.jsp";
            //set the message attributes
            request.setAttribute("message", message);
            //using a try finally  -- removed for new process
            //try {
                //print the message to inform the user that information is missing from the form
            //    htmlnote.println("<h1>Missing Information: </h1><br><h1>" + request.getAttribute("message") + "</h1>");
            //}
            //finally{
                //close the html connection
            //    htmlnote.close();
            //}
        } else if ( user == null ) {
            //redirect user if not in database
            url = "/new_customer.jsp;";
        }
        else {
            //set the variable message
            message = "";
            //moved data before condition to be accounted for in the if user == null condition
            //session.setAttribute("firstname", firstname);
            //session.setAttribute("lastname", lastname);
            //session.setAttribute("username", username);          
            //User user = (User) session.getAttribute("user");
            
            // store data in User object
            user.setPassword(password);
            //call UserDb for future coding
            UserDB.update(user);
            //set the url
            url = "/Account_activity.jsp";
            //set the message attributes
            request.setAttribute("message", message);
            //set the user Attributes to sesson scope
            session.setAttribute("user", user);
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
