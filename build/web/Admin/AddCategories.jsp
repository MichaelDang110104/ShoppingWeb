z<%-- 
    Document   : AddCategories
    Created on : Feb 24, 2024, 3:47:25 PM
    Author     : Michael Dang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <h3 class="text-center text-info">Add new category</h3>
                                <div class="form-group">
                                    <label  class="text-info">Category Name:</label><br>
                                    <input type="text" name="cateAdd" placeholder="Enter Product Name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Description</label><br>
                                    <input type="text" name="memoAdd" placeholder="Enter Description" class="form-control" required>
                                </div>
                                <input type="submit" value="AddCate" name="action" />
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
