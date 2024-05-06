<%-- 
    Document   : ShowCategories
    Created on : Feb 25, 2024, 2:33:07 PM
    Author     : Michael Dang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        <%@include file="bootstrap.jsp" %>
        <%@include file="Header.jspf" %>
        <div class="container">
            <br>
            <h3>List of Categories</h3>
            <br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Type ID</th>
                        <th>Category Name</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCAT}" var="o">
                        <tr>
                            <td>${o.typeID}</td>
                            <td>${o.categoryName}</td>
                            <td>${o.memo}</td>
                            <td style="display: flex; justify-content: center;">
                                <form action="MainController" style="margin: 5px">
                                    <input type="hidden" name="lenh" value="Update">
                                    <input type="hidden" name="id" value="${o.typeID}">
                                    <input type="hidden" name="action" value="UpdateCategory">
                                    <input type="submit" value="Update" class="btn btn-warning" />
                                </form>
                                <form action="MainController" style="margin: 5px">
                                    <input type="hidden" name="lenh" value="Delete">
                                    <input type="hidden" name="id" value="${o.typeID}">
                                    <input type="hidden" name="action" value="DeleteCategory">
                                    <input type="submit" class="btn btn-danger" value="Delete" />
                                </form>
                            </td> 
                        </tr>

                    </c:forEach>
                <h3 style="color: red">${Notification}</h3>
                </tbody>
            </table>
            <a class="btn btn-primary" href="MainController" role="button">Home</a>
        </div>

        <%@include file="Footer.jspf" %>
    </body>
</html>
