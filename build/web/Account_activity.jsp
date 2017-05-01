
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
    1. Create a Account_activity.html
    2. Add a Header for the page

    Page Assignment for Assignment 2
    1. Using JSTL If Stmt
    2. if user obj is in the session and not null display the welcome message
        containing first and last name on page
    3. if it does not exist display not logged in message on page
-->

<!-- Add the tag library to the page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Add the header to the page -->
<c:import url="/includes/header.html" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>


    <div>
        <!-- Create a header for the Transaction page  -->
        <header>
            <h1>Current Account Activity</h1>
        </header>
    </div>
    <!-- Create an if else condition to determine if the user is logged in  -->
    <c:choose>
    <c:when test="${user.password != ''}">
        <p>Welcome ${user.firstName} ${user.lastName} to your account activity page</p> 
    </c:when>
    <c:otherwise>
        <p>You are not logged into the system</p>
    </c:otherwise>
</c:choose>
        <form action="index.jsp" method="post">
            <label>First Name:</label>
            <span>${user.firstName}</span><br>
            <label>Last Name:</label>
            <span>${user.lastName}</span><br>
            <label>Current Checking Balance:</label>
            <span>${account.Checking}</span><br>
            <label>Current Savings Balance:</label>
            <span>${account.Savings}</span><br>
            
            <input type="submit" value ="return to main menu">
        </form>
<!-- Add the footer to the page -->        
<c:import url="/includes/footer.jsp" />