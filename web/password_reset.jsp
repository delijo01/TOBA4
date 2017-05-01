<!-- 
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications


    Page Assignment for Assignment 2
    1. Create the password_reset jsp
    2. bind user object password using EL to form field
    3. Allow the user to change the password
-->
<!-- Add the header to the page -->
<%@ include file="/includes/header.html" %>
<!-- Add the tag library to the page -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <!--Add a page heading-->
        <h1>Password Reset Form</h1>
        <br>
        <!--Adding the code to place the message on the page-->
        <c:if test="${message != null}">
            <p><i>${message}</i></p>
        </c:if>
        <!--Create a form-->
        <form action="PasswordResetServlet" method="post">
            <!--Add a label for Current PW-->
            <label class="pad_top">Current Temporary Password:</label>
            <!--Add a display for current pw-->
            <input type="text" name="curTempPassword" value="${user.password}" ><br>
            <!--pass through the user id-->
            <input type="hidden" name="username" value="${user.userName}" ><br>
            <!--pass through the first name-->
            <input type="hidden" name="firstname" value="${user.firstName}"  ><br>
            <!--pass through the last name-->
            <input type="hidden" name="lastname" value="${user.lastName}"  ><br>
            <!--Add a label to new pw-->
            <label class="pad_top">New Password:</label>
            <!--Add an input for new pw-->
            <input type="text" id="pwdChang" name="password"><br>
            <!--Add button to submit new pw-->
            <input type="submit" value ="Change Password">
        </form>

<!-- Add the footer to the page -->
<%@ include file="/includes/footer.jsp" %>
