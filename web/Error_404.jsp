<%-- 
    Document   : Error_404
    Created on : Mar 20, 2017, 3:28:02 PM
    Author     : delijo01
--%>
<!-- 
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
-->
<!--
    Page Assignment for Assignment 1
    1. Create a Error Message jsp page
    2. Add a Heading for the page
    3. Add a message for the page
-->
<%-- Add the tag library to the page --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Add the header to the page --%>
<c:import url="/includes/header.html" />

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Add a title for the Error message -->
        <title>Error Code 404</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>--%>
    <body>
        <!-- Create a heading for the Java Error  -->
        <h1>Error message: 404 Error</h1>
        <!-- Create a message to display for the Java Error  -->
        <p>An error has occurred! Unable to locate file.</p>
        <p>To return back to the application, click the Back Button in the left hand corner.</p>

<%-- Add the footer to the page --%>        
<c:import url="/includes/footer.jsp" />