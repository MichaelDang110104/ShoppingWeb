<%-- 
    Document   : Cart
    Created on : Feb 28, 2024, 6:13:34 PM
    Author     : Michael Dang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%@include file="bootstrap.jsp" %>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="MainController">Products Page</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Accounts
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="Signup.jsp">Add Accounts</a>
                            <a class="dropdown-item" href="ShowAccountControl">Accounts Management</a>
                        </div>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Categories
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="AddCategories.jsp">Add Categories</a>
                            <a class="dropdown-item" href="ShowCategoriesControl">Categories Management</a>
                        </div>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Products
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="AddProducts.jsp">Add Products</a>
                            <a class="dropdown-item" href="ShowProductsControl">Products Management</a>
                        </div>
                </ul>

                <form action="SearchControl" method="post" class="form-inline my-2 my-lg-0">
                    <div class="input-group input-group-sm">
                        <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-secondary btn-number">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                    <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">
                        <i class="fa fa-shopping-cart"></i> Cart
                        <span class="badge badge-light">3</span>
                    </a>
                </form>
                <a class="btn btn-success btn-sm ml-3" href="LogoutControl">
                    <i class="fa fa-sign-out"></i> Logout
                </a>

                <a class="btn btn-success btn-sm ml-3" href="Signup.jsp">
                    <i class="fa fa-upload"></i> Sign up

                </a>

            </div>

        </nav>  
        <div class="shopping-cart" style="margin-top: 80px">
            <div class="px-4 px-lg-0">

                <div class="pb-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                <!-- Shopping cart table -->
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Đơn Giá</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Số lượng</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Xóa</div>
                                                </th>
                                            </tr>   
                                        </thead>
                                        <tbody>

                                            <c:forEach items="${listCart}" var="items">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="${items.product.productImage}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${items.product.productName}</a>
                                                                </h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>

                                                    </th>
                                                    <td class="align-middle"><strong>${items.product.price}</strong></td>
                                                    <td class="align-middle"><strong>${items.quantity}</strong></td>  
                                                    <td class="align-middle">
                                                        <form>
                                                            <c:url var="mainController" value="MainController">
                                                                <c:param name="action" value="DeleteItem"></c:param>
                                                                <c:param name="ItemID" value="${items.product.productID}"></c:param>
                                                            </c:url>
                                                            <a href="${mainController}">Delete Item</a>
                                                        </form> 
                                                    </td>
                                            
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                        <h3 style="color: red">${Notification}</h3>

                        <div class="col-lg-6">
                            <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                            <div class="p-4">
                                <ul class="list-unstyled mb-4">
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${it}</strong></li>
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>${tf}</strong></li>
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>${vat}</strong></li>
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                        <h5 class="font-weight-bold">${total}</h5>
                                    </li>
                                </ul><a href="BuyControl" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <%@include file="Footer.jspf" %>
</body>
</html>
