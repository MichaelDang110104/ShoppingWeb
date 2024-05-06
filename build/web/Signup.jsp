<%-- 
    Document   : AddCateory
    Created on : Feb 22, 2024, 4:36:28 PM
    Author     : Michael Dang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <%@include file="bootstrap.jsp" %>
        <%@include file="Header.jspf" %>
        <div id="login">
            <br>
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div id="login-column" class="col-md-6">
                        <div id="login-box" class="col-md-12">
                            <form id="login-form" class="form" action="MainController" method="post">
                                <h3 class="text-center text-info">Add new account</h3>
                                <div class="form-group">
                                    <label  class="text-info">Account:</label><br>
                                    <input type="text" name="accountSignup" placeholder="Enter username" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Password:</label><br>
                                    <input type="text" name="passwordSignup" placeholder="Enter password" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Last Name: </label><br>
                                    <input type="text" name="lNameSignup" placeholder="Enter Last Name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">First Name:</label><br>
                                    <input type="text" name="fNameSignup" placeholder="Enter First Name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Date of birth:</label><br>
                                    <input type="text" name="dobSignup" placeholder="yyyy-MM-dd" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Gender:</label><br>
                                    <input type="text" name="genderSignup" placeholder="True = Man | False = Woman" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Phone:</label><br>
                                    <input type="text" name="phoneSignup" placeholder="Enter phone number" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Is use:</label><br>
                                    <input type="text" name="inuseSignup" placeholder="True = in use | False = not in use" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Role in system:</label><br>
                                    <input type="text" name="roleSignup" placeholder="Number" class="form-control" required>
                                </div>
                                <input type="submit" value="Signup" name="action" />
                            </form>
                            <br>
                            <a class="btn btn-primary" href="MainController" role="button">Home</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="Footer.jspf" %>
    </body>
</html>
