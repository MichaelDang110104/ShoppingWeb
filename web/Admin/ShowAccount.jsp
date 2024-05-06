<%-- 
    Document   : ShowAccount
    Created on : Feb 25, 2024, 10:20:14 AM
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
                        <th>Account</th>
                        <th>Full Name</th>
                        <th>Date of birth</th>
                        <th>Gender</th>
                        <th>Phone Number</th>
                        <th>Is Use</th>
                        <th>Role in system</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listAcc}" var="o">
                        <tr>
                            <td>${o.account}</td>
                            <td>${o.lastName} ${o.firstName}</td>
                            <td>${o.birthday}</td>
                            <td>${o.gender}</td>
                            <td>${o.phone}</td>
                            <td>${o.isUse}</td>
                            <td>${o.roleInSystem}</td>
                            <td style="display: flex;justify-content: center">
                                <form action="MainController" style="margin: 5px">
                                    <input type="hidden" name="action" value="AccountManagement">
                                    <input type="hidden" name="lenh" value="Update">
                                    <input type="hidden" name="id" value="${o.account}">
                                    <input type="submit" value="Update" class="btn btn-warning">
                                </form>
                                <form action="MainController" style="margin: 5px">                         
                                    <input type="hidden" name="action" value="AccountManagement">
                                    <input type="hidden" name="lenh" value="Delete">
                                    <input type="hidden" name="id" value="${o.account}">
                                    <input type="submit" value="Delete" class="btn btn-danger">
                                </form>
                                <form action="MainController" style="margin: 5px">
                                    <input type="hidden" name="action" value="AccountManagement">
                                    <input type="hidden" name="lenh" value="Condition">
                                    <input type="hidden" name="id" value="${o.account}">
                                    <input type="submit" value="${o.isUse?"Active":"Inactive"}" class="btn btn-success">
                                </form> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="MainController" role="button">Home</a>
        </div>

    </body><%@include file="Footer.jspf" %>
</html>
