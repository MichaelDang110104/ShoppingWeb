<%-- 
    Document   : AddProducts
    Created on : Feb 24, 2024, 4:31:45 PM
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
                                <h3 class="text-center text-info">Add new product</h3>
                                <div class="form-group">
                                    <label  class="text-info">ID: </label><br>
                                    <input type="text" name="pIDAdd" placeholder="Enter 10 letters and numbers" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Name: </label><br>
                                    <input type="text" name="pNameAdd" placeholder="Enter product name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Image </label><br>
                                    <input type="text" name="pImageAdd" placeholder="Enter image link" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Brief:  </label><br>
                                    <input type="text" name="pBriefAdd" placeholder="Enter brief" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Posted Date:</label><br>
                                    <input type="text" name="pDateAdd" placeholder="yyyy-MM-dd" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Type ID:</label><br>
                                    <input type="text" name="pTypeAdd" placeholder="Enter a number" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Account:</label><br>
                                    <input type="text" name="pAccAdd" placeholder="Enter your position" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Unit:</label><br>
                                    <input type="text" name="pUnitAdd" placeholder="" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Price:</label><br>
                                    <input type="text" name="pPriceAdd" placeholder="Enter price of product" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Discount:</label><br>
                                    <input type="text" name="pDiscountAdd" placeholder="Enter number" class="form-control" required>
                                </div>

                                <input type="submit" value="AddNewProduct" name="action" />
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
