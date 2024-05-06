<%-- 
    Document   : ShowProducts
    Created on : Feb 25, 2024, 2:48:17 PM
    Author     : Michael Dang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%@include file="bootstrap.jsp" %>
        <%@include file="Header.jspf" %>
        <h3 style="color: red">${Notification}</h3>
        <div class="container">
            <br>
            <h3>List of Accounts</h3>
            <br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Brief</th>
                        <th>Type ID</th>
                        <th>Account</th>
                        <th>Unit</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listPRO}" var="o">
                        <tr>
                            <td>${o.productID}</td>
                            <td>${o.productName}</td>
                            <td>${o.brief}</td>
                            <td>${o.typeID}</td>
                            <td>${o.account}</td>
                            <td>${unit}</td>
                            <td>${o.price}</td>
                            <td>${o.discount}</td>
                            <td style="display: flex;justify-content: center;">
                                <form action="MainController" style="margin: 5px">
                                    <input type="hidden" name="lenh" value="Update">
                                    <input type="hidden" name="id" value="${o.productID}">
                                    <input type="hidden" name="action" value="UpdateProduct"/>
                                    <input type="submit" class="btn btn-warning" value="Update" />
                                </form>
                                <form action="MainController" style="margin: 5px">
                                    <input type="hidden" name="lenh" value="Delete">
                                    <input type="hidden" name="id" value="${o.productID}">
                                    <input type="hidden" name="action" value="DeleteProduct"/>
                                    <input type="submit" class="btn btn-danger" value="Delete" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="MainController" role="button">Home</a>
        </div>

        <%@include file="Footer.jspf" %>
    </body>
</html>
