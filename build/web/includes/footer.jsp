<!-- 
    Name: John M Delia Jr
    SPC Student ID: 434299
    Course COP 2806 - Java Web Applications
-->

<!-- 
    Page Assignment for Assignment 2
    1. Create a footer.jsb file
    2. using jsp tags add a current date in the copywright information dynamically
    3. include on all pages
-->
<!--Created the footer page-->
<%@page import="java.util.Locale"%>
<!--Pulling in the Gregorian Calendar to get current date-->
<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!--Creating the Calendar instance and then pulling the current Year-->
        <%
            GregorianCalendar currentDate = new GregorianCalendar();
            String currentMonth = currentDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
            int currentDay = currentDate.get(Calendar.DATE);
            int currentYear = currentDate.get(Calendar.YEAR);

        %> 
        <!--displaying the results to the page-->
        <p>&copy; Copyright <%=currentMonth %> <%=currentDay %>, <%=currentYear %> TOBA Titan &amp; Corporation</p>
    </body>
</html>
