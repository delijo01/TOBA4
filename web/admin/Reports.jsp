<%-- 
    Document   : TransferFunds
    Created on : Apr 20, 2017, 11:53:38 PM
    Author     : delijo01
<!-- 
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
-->
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<!-- Add the tag library to the page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<!-- Add the header to the page -->
<c:import url="/includes/header.html" />

<%@page import="java.util.Locale"%>
<!--Pulling in the Gregorian Calendar to get current date-->
<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
        <!--Creating the Calendar instance and then pulling the current Year-->
        <%
            GregorianCalendar currentDate = new GregorianCalendar();
            String currentMonth = currentDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
            int currentDay = currentDate.get(Calendar.DATE);
            int currentYear = currentDate.get(Calendar.YEAR);

        %> 

        <div>
            <div>
                <h1>Reports Page</h1>
                <h2>Registered Users for <%=currentMonth %> <%=currentYear %></h2>
                <p><%=currentMonth %> <%=currentDay %>, <%=currentYear %></p>
            </div>
            <table>
                <tr>
                    <th>Date Added</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>

                <c:forEach var="user" items="${account.user}">
                    <tr>
                        <td>${user.user.username}</td>
                        <td>${user.user.firstName}</td>
                        <td>${user.user.lastName}</td>
                    </tr>
                </c:forEach>
            </table>

            <h2>User Table</h2>
            <p><a href="../reportsServlet">Return as an XLS file</a></p>

        </div>    

<!-- Add the footer to the page -->        
<c:import url="/includes/footer.jsp" />

