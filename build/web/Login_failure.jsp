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
    1. Create a Login_failure.html
    2. Add a message that will display the login was incorrect.
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Add the tag library to the page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<!-- Add the header to the page -->
<c:import url="/includes/header.html" />
        <div>
            <!-- Create a header for the Login Failure page  -->
            <header>
                <h1>Login Failure Message</h1>
            </header>
            <!--Add a message that will display the login was incorrect. -->
            <br/><br/><label id="lblloginmessfail" title="Login Failed">Either your id or password is incorrect</label><br/><br/>
        </div>
<!-- Add the footer to the page -->        
<c:import url="/includes/footer.jsp" />
