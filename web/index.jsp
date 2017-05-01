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
    1. This is the home page of the application. This should have the name of
    banking application
    2. And a navigation
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Add the tag library to the page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<!-- Add the header to the page -->
<c:import url="/includes/header.html" />
        <div>
            <!-- Create a header for the Index page  -->
            <header>
                <h1>Titan Online Banking Application</h1>
            </header>
            <section><br>
                <!--Create a form for the Index Process-->
                <form action="New_customer.jsp" method="post">
                    <!-- Setup navigation menu for the other pages-->
                    <input type="submit" value ="New Customer">
                    <input type="hidden" name="action" value="New Customer" >
                </form><br>
                <form action="Login.jsp" method="post">
                    <input type="submit" value ="Account Activity">
                    <input type="hidden" name="action" value="Account Activity" >
                </form><br>
                <form action="Login.jsp" method="post">
                    <input type="submit" value ="Transaction">
                    <input type="hidden" name="action" value="Transaction" >
                </form><br>
                 <form action="admin\Login.html" method="post">
                    <input type="submit" value ="Administration">
                    <input type="hidden" name="action" value="Administration" >
                </form><br>
            </section>
        </div>
        <!-- Add the footer to the page -->        
<c:import url="/includes/footer.jsp" ></c:import>

