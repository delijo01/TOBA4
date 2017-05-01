/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Packages;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.Beans.User;
import toba.Data.PasswordUtil;
import toba.Data.UserDB;

/**
 *
 * @author delijo01
 */
@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {

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
        
        //set the Content Type
        response.setContentType("text/html;charset=UTF-8");
       
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
//        } else if( username.equals(user.getUserName()) && 
//                password.equals(user.getPassword()) )
            //create the session scope
            HttpSession session = request.getSession();
            //pull the session for the Specified User
            session.setAttribute("user", selUser);
            //set the url
            url = "Admin/Reports.jsp;";
        } else {
            //set the url
            url = "Admin/Login_Error.html";
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
