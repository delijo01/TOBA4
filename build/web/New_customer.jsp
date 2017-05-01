<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
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
    1. Create a New_customer.html
    2. Add a form to the page
    3. Add 8 input eliminates (FirstName, LastName, Phone, Address, City, State, Zipcode, Email)
    4. Add a Submit Button
    5. Add a link to the "New Customer Sign Up Page"
-->
<!-- Add the tag library to the page -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Add the header to the page -->
<c:import url="/includes/header.html" />


                <!--Create a form for the New Customer Entry Process-->
                <form action="NewCustomerServlet" method="post" >
                    <!-- Create a header for the New Customer page  -->
                    <header>
                        <h1>New Customer</h1>
                    </header>
                    <!--Adding the code to place the message on the page-->
                    <c:if test="${message != null}">
                        <p><i>${message}</i></p>
                    </c:if>
                    <!--<p style="align-content: center">-->
                    <!--Created a label for the First Name input-->
                    <label class="pad_top" id="lblfirstName" title="First Name">First Name: </label>
                    <!--Created the input for the First Name type = text-->
                    <input type="text" id="txtFName" name="firstname"><br>
                    <!--Created a label for the Last Name input-->
                    <label class="pad_top" id="lbllastName" title="Last Name" >Last Name: </label>
                    <!--Created the input for the Last Name type = text-->
                    <input type="text" id="txtLName" name="lastname"><br>
                    <!--Created a label for the Phone input-->
                    <label class="pad_top" id="lblPhone" title="Phone">Phone: </label>
                    <!--Created the input for the Phone type = text-->
                    <input type="text" id="txtPhone" name="phone"><br>
                    <!--Created a label for the Address input-->
                    <label class="pad_top" id="lblAddress" title="Address" >Address: </label>
                    <!--Created the input for the Address type = text-->
                    <input type="text" id="txtAdd" name="address"><br>
                    <!--Created a label for the City input-->
                    <label class="pad_top" id="lblCity" title="City">City: </label>
                    <!--Created a label for the City"city"-->
                    <input type="text" id="txtCity" name="city"><br>
                    <!--Created a label for the State input-->
                    <label class="pad_top" id="lblState" title="State" >State: </label>
                    <!--Created the input for the State type = text-->
                    <input type="text" id="txtState" name="state"><br>
                    <!--Created a label for the Zip Code input-->
                    <label class="pad_top" id="lblZip" title="Zip Code">Zip Code: </label>
                    <!--Created the input for the Zip Code type = text-->
                    <input type="text" id="txtZip" name="zipcode"><br>
                    <!--Created a label for the Email input-->
                    <label class="pad_top" id="lblEmail" title="Email" >Email: </label>
                    <!--Created the input for the Email type = text-->
                    <input type="text" id="txtEmail" name="Email"><br>
                    <!--Created a Submit button for the page-->
                    <input type="submit" value ="Add Now">
                    <!--Created a cancel button to allow the user to cancel the entry-->
                    <input type="reset" name="cancel" value ="Reset">
                    <!--</p>-->
                </form>

<!-- Add the footer to the page -->        
<c:import url="/includes/footer.jsp" />