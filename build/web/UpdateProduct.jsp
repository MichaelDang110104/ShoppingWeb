<%-- 
    Document   : UpdateProduct
    Created on : Feb 28, 2024, 5:36:41 PM
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
                                <h3 class="text-center text-info">Update product</h3>
                                <div class="form-group">
                                    <label  class="text-info">Name: </label><br>
                                    <input type="text" name="pNameUpdate" placeholder="Enter product name" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Image </label><br>
                                    <input type="text" name="pImageUpdate" placeholder="Enter image link" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Brief:  </label><br>
                                    <input type="text" name="pBriefUpdate" placeholder="Enter brief" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Posted Date:</label><br>
                                    <input type="text" name="pDateUpdate" placeholder="yyyy-MM-dd" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Type ID:</label><br>
                                    <input type="text" name="pTypeUpdate" placeholder="Enter a number" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Account:</label><br>
                                    <input type="text" name="pAccUpdate" placeholder="Enter your position" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Unit:</label><br>
                                    <input type="text" name="pUnitUpdate" placeholder="" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Price:</label><br>
                                    <input type="text" name="pPriceUpdate" placeholder="Enter price of product" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label  class="text-info">Discount:</label><br>
                                    <input type="text" name="pDiscountUpdate" placeholder="Enter number" class="form-control" required>
                                </div>
                                <input type="hidden" name="action" value="SubmitUpdateProduct">
                                <input type="submit" value="Submit" />
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
