<%-- 
    Document   : UpdateCategory
    Created on : May 4, 2024, 9:07:13 PM
    Author     : MichaelDang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="bootstrap.jsp" %>
    </head>
    <body>
        <%@include file="Header.jspf" %>
        <div id="login">
            <h3>${CatID}</h3>
            <br>
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div id="login-column" class="col-md-6">
                        <div id="login-box" class="col-md-12">
                            <form id="login-form" class="form" action="MainController" method="post">
                                <h3 class="text-center text-info">Update category</h3>
                                <div class="form-group">
                                    <label  class="text-info">Category Name:</label><br>
                                    <input type="text" name="catNameUpdate" placeholder="Enter Product Name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Description</label><br>
                                    <input type="text" name="catMemoUpdate" placeholder="Enter Description" class="form-control" required>
                                </div>
                                <input type="hidden" name="action" value="SubmitUpdateCategory">
                                <input type="submit" value="Submit" />
                            </form>
                            <br>
                            <a class="btn btn-primary" href="UserControl" role="button">Home</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="Footer.jspf" %>
    </body>
</html>
