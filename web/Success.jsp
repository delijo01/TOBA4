
<!-- Add the tag library to the page -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Add the header to the page -->
<c:import url="/includes/header.html" />

<%@page contentType="text/html" pageEncoding="utf-8"%>

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
    1. Create a Success.html
    2. Add a message that will display that the account has been successfully updated

    Page Assignment for Assignment 2
    1. bind the customer object using EL
    2. display all the attributes
    3. include username and pw
-->
        <!-- Create a header for the Success page  -->
    
        <!--<header></header>-->
        <h1>Success Message</h1>
        
        <!-- Add a message that will display that the account has been successfully updated -->
        <label id="lblmessSuccess" title="Success Message Box">This action completed successfully</label><br>
        <!--added a form section to the page-->
        <form action="Login.jsp" method="post" >
        <p>Below is your registration information that you entered:</p><br>
        <!-- Create and bind the EL and display all the attributes along with username and pw -->
            <label>First Name:</label>
            <span>${user.firstName}</span><br>
            <label>Last Name:</label>
            <span>${user.lastName}</span><br>
            <label>Phone:</label>
            <span>${user.phone}</span><br>
            <label>Address:</label>
            <span>${user.address}</span><br>
            <label>City:</label>
            <span>${user.city}</span><br>
            <label>State:</label>
            <span>${user.state}</span><br>
            <label>Zip Code:</label>
            <span>${user.zip}</span><br>
            <label>Email:</label>
            <span>${user.email}</span><br>
            <label>User Name:</label>
            <span>${user.userName}</span><br>
            <label>Password:</label>
            <span>${user.password}</span><br>
            <!--Created a login button for the page-->
            <input type="submit" value ="Login">
        </form>

</html>
    
 <!-- add the footer to the page --!>   
 <c:import url="/includes/footer.jsp" />
