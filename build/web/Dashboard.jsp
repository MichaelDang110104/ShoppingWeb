<%-- 
    Document   : User
    Created on : Feb 14, 2024, 5:29:10 PM
    Author     : Michael Dang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Category"%>
<%@page import="entity.Products"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping site</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="Scripts/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="Scripts/bootstrap.min.js"></script>
    </head>
    <body>
        
        <%@include file="Header.jspf" %>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Best Products Seller</h1>
                <p class="lead text-muted mb-0">Over 10 years of selling products</p>
            </div>
        </section>
        <!--end of menu-->
        <h3 style="color: red">${Notification}</h3>
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="MainController">Home</a></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        
        <%@include file="CategoryBar.jspf" %>
        <div class="col-sm-9" style="margin-bottom: 30px">
                    <div class="row">
                        <c:forEach items="${listP}" var="p">
                            <c:url value="MainController" var="main">
                                <c:param name="action" value="ShowDetail"></c:param>
                                <c:param name="pid" value="${p.productID}"></c:param>
                              
                            </c:url>
                            
                            <div class="col-12 col-md-6 col-lg-4" style="width: 600px;height: 500px">
                                <div class="card">
                                    <img class="card-img-top" style="width: 250px;height: 250px" src="${p.productImage}" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title show_txt"><a href="${main}" title="View Product">${p.productName}</a></h5>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block" >${p.price} VND</p><br>
                                            </div>
                                            <div class="col">
                                                <a href="${main}" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>


        <!-- Footer -->
        <%@include file="Footer.jspf" %>
    </body>
</html>
