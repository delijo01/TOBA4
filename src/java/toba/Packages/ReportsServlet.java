/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Packages;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import toba.Data.ConnectionPool; //importing the connection pool class
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import toba.Beans.User;
import toba.Data.UserUtil;
/**
 *
 * @author delijo01
 */

@WebServlet(name = "ReportsServlet", urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {

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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // create the workbook, its worksheet, and its title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User table");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("The User table");
        
        // create the header row
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("userId");
        row.createCell(1).setCellValue("lastName");
        row.createCell(2).setCellValue("firstName");
        row.createCell(3).setCellValue("email");
        
        
        // read database rows
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            String qString = "SELECT username, firstName, lastName, email FROM USER;";    
            ResultSet results = statement.executeQuery(qString);
            
            // create the spreadsheet rows
            int i = 3;
            while (results.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(results.getString("username"));
                row.createCell(1).setCellValue(results.getString("lastName"));
                row.createCell(2).setCellValue(results.getString("firstName"));
                row.createCell(3).setCellValue(results.getString("email"));
                i++;
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.log(e.toString());
        }
        // set the response headers
        response.setHeader("content-disposition", 
                "attachment; filename=users.xls");
        response.setHeader("cache-control", "no-cache");

        // get the output stream and send the workbook to the browser
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Call the doGet method
        doGet(request, response);
    }
}
