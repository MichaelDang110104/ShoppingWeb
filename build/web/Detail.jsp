<%-- 
    Document   : Detail
    Created on : Feb 26, 2024, 11:14:43 AM
    Author     : Michael Dang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <%@include file="bootstrap.jsp" %>
        <link href="css/DetailStyle.css" rel="stylesheet" type="text/css">

    </head>
</head>
<body>
    <%@include file="Header.jspf" %>
    <div  style="margin-top: 50px; ">
        <%@include file="CategoryBar.jspf" %>

        <div class="col-sm-9">
            <div class="container">
                <div class="card">
                    <div class="row">
                        <aside class="col-sm-5 border-right">
                            <article class="gallery-wrap"> 
                                <div class="img-big-wrap">
                                    <div> <img src="${p.productImage}" style="width: 100%"></div>
                                </div> <!-- slider-product.// -->

                            </article> <!-- gallery-wrap .end// -->
                        </aside>
                        <aside class="col-sm-7">
                            <article class="card-body p-5">
                                <h3 class="title mb-3">${p.productName}</h3>

                                <p class="price-detail-wrap"> 
                                    <span class="price h3 text-warning"> 
                                        <span class="currency">VND</span><span class="num">${p.price}</span>
                                    </span> 

                                </p> 
                                <dl class="item-property">
                                    <dt>Description</dt>
                                    <dd><p>${p.brief} </p></dd>
                                </dl>


                                <!-- row.// -->
                                <hr>
                                <c:url value="MainController" var="main">
                                    <c:param name="action" value="Buy"></c:param>
                                    <c:param name="pid" value="${p.productID}"></c:param>
                                </c:url>
                                <a href="${main}" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
                                <c:url value="MainController" var="main">
                                    <c:param name="action" value="AddToCart"></c:param>
                                    <c:param name="pid" value="${p.productID}"></c:param>
                                </c:url>
                                <a href="${main}" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fa fa-shopping-cart"></i> Add to cart </a>
                            </article> <!-- card-body.// -->
                        </aside> <!-- col.// -->
                    </div> <!-- row.// -->
                </div> <!-- card.// -->
            </div>
        </div>
    </div>
    <%@include file="Footer.jspf" %>
</body>
</html>
