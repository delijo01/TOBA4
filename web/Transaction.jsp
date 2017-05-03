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
    1. Create a Transaction.html
    2. Add a Header for the page
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Add the tag library to the page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<!-- Add the header to the page -->
<c:import url="/includes/header.html" />
        <form action="TransactionServlet" method="post">
        <!-- Create a header for the Transaction page  -->
            <header>
                <h1>Transactions</h1>
                <p>Transfer Funds Page</p>
            </header>
            <c:if test="${message != null}">
                <p><i>${message}</i></p>
            </c:if>
                <input type="hidden" name="action" value="transferfunds" >
                <label>First Name:</label>
                <span>${user.firstName}</span><br>
                <label>Last Name:</label>
                <span>${user.lastName}</span><br>
                ${request.getSession("user").getCheckingBalance()}
                <label>Current Checking Balance:</label>
                <span>${user.checkingBalance}</span><br>
                <label>Current Savings Balance:</label>
                <span>${user.savingsBalance}</span><br>
                <label>Transfer From:</label>
                <select name="transferfrom">
                    <option value="Checking">Checking</option>
                    <option value="Savings">Savings</option>
                </select></br>
                <label>Transfer To:</label>
                <select name="transferto">
                    <option value="Checking">Checking</option>
                    <option value="Savings">Savings</option>
                </select></br></br>
                <label for="transferamount">Amount to Transfer ($)</label>
                <input type="text" name="transferamount">
                </br></br>
                <input type="submit" value ="Transfer">
            </br>
        </form>
<!-- Add the footer to the page -->        
<c:import url="/includes/footer.jsp" />
