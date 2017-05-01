<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!-- 
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
-->
<!--
    Page Assignment for Assignment 1
    1. Create a Login.html
    2. Add a form to the page
    3. Add two input eliminates (Username and Password)
    4. Add a login Button
    5. Add a link to the "New Customer Sign Up Page"

    Page Assignment for Assignment 2
    1. Add a reset password link

-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Add the tag library to the page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<!-- Add the header to the page -->
<c:import url="/includes/header.html" />
        <div>
            <!-- Create a header for the Transaction page  -->
            <header>
                <h1>Please Enter Login Information</h1>
            </header>
            <!--Create a form for the Login Process (New_customer.jsp)-->
            <form action="LoginServlet" method="post" style="align-content: center">
                <!--Created a label for the Username input-->
                <label id="lblUsername1" title="Username">Username: </label>
                <!--Created the input for the Username type = text-->
                <input type="text" id="txtUsername1" name="username"><br>
                <!--Created a label for the password input-->
                <label id="lblPW1" title="password" >Password: </label>
                <!--Created the input for the Username type = text-->
                <input type="password" id="txtPW1" name="password"><br><br>
                <!--Created a login button for the page-->
                <c:if test="New Customer">
                        <input type="hidden" name="action" value="New Customer" >
                </c:if>
                <c:if test="Account Activity">
                        <input type="hidden" name="action" value="Account Activity" >
                    </c:if>
                <c:if test="Transaction">
                        <input type="hidden" name="action" value="Transaction" >
                </c:if>
                <input type="submit" value ="Login">
                <!--Created a reset button to allow the user to cancel the entry-->
                <input type="reset" name="cancel" value ="Cancel Entry"><br><br>
                <!--Created a link to allow the user to reset their password-->
                <a href="password_reset.jsp?action=LoginServlet">Password Reset</a><br><br>
                <!--Created a New Customer link to allow the user to be added to the list-->
                <a href="New_customer.jsp?action=LoginServlet">New Customer Sign Up</a>
            </form>
        </div>
<!-- Add the footer to the page -->        
<c:import url="/includes/footer.jsp" />
