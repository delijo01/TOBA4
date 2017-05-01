<%-- 
    Document   : Error_java
    Created on : Mar 20, 2017, 3:29:44 PM
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
    4. XML tags that provide error handling for all java exceptions
-->
<%-- Add the tag library to the page --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Add the header to the page --%>
<c:import url="/includes/header.html" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Add a title for the Error message -->
        <title>Error Code - Exception</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>--%>
    <body>
        <!-- Create a heading for the Java Error  -->
        <h1>Java Error</h1>
        <!-- Create a message to display for the Java Error  -->
        <p>An exception error has occurred</p>
        <p>To return back to the application, click the Back Button in the left hand corner.</p>
        
        <h2>Exception Details:</h2>
        <p>Type: ${pageContext.exception["class"]}</p>
        <p>Message: ${pageContext.exception.message}</p>


<%-- Add the footer to the page --%>        
<c:import url="/includes/footer.jsp" />
