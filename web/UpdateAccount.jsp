<%-- 
    Document   : UpdateAccount
    Created on : Feb 25, 2024, 11:06:18 PM
    Author     : Michael Dang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="bootstrap.jsp" %>
    <%@include file="Header.jspf" %>
     <div id="login">
            <br>
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div id="login-column" class="col-md-6">
                        <div id="login-box" class="col-md-12">
                            <form id="login-form" class="form" action="MainController" method="post">
                                <h3 class="text-center text-info">Update your Account</h3>
                                <div class="form-group">
                                    <label  class="text-info">Password:</label><br>
                                    <input type="password" name="passwordUpdate" placeholder="Enter password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Last Name: </label><br>
                                    <input type="text" name="lNameUpdate" placeholder="Enter Last Name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">First Name:</label><br>
                                    <input type="text" name="fNameUpdate" placeholder="Enter First Name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Date of birth:</label><br>
                                    <input type="text" name="dobUpdate" placeholder="yyyy-MM-dd" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Gender:</label><br>
                                    <input type="text" name="genderUpdate" placeholder="True = Man | False = Woman" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Phone:</label><br>
                                    <input type="text" name="phoneUpdate" placeholder="Enter phone number" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Is use:</label><br>
                                    <input type="text" name="inuseUpdate" placeholder="True = in use | False = not in use" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Role in system:</label><br>
                                    <input type="text" name="roleUpdate" placeholder="Number" class="form-control" required>
                                </div>

                                <input type="submit" name="action" value="Update Account" />
                            </form>
                            <br>
                            <h4 style="color: red">${Notification}</h4>
                            <a class="btn btn-primary" href="MainController" role="button">Home</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <%@include file="Footer.jspf" %>
</html>
