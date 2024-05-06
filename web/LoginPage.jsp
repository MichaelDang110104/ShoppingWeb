<%-- 
    Document   : LoginPage
    Created on : Apr 27, 2024, 12:37:20 PM
    Author     : MichaelDang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="bootstrap.jsp" %>
    </head>
    <body>
        <section class="vh-100" style="background-color: #9A616D;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-xl-10">
                        <div class="card" style="border-radius: 1rem;">
                            <div class="row g-0">
                                <div class="col-md-6 col-lg-5 d-none d-md-block">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                         alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                                </div>
                                <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                    <div class="card-body p-4 p-lg-5 text-black">

                                        <form action="MainController" method="post">

                                            <div class="d-flex align-items-center mb-3 pb-1">
                                                <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                                <span class="h1 fw-bold mb-0">Michael Dang's Store</span>
                                            </div>

                                            <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>

                                            <div data-mdb-input-init class="form-outline mb-4">
                                                <input type="text" name="account" class="form-control form-control-lg" />
                                                <label class="form-label" >Account</label>
                                            </div>

                                            <div data-mdb-input-init class="form-outline mb-4">
                                                <input type="password" name="password" class="form-control form-control-lg" />
                                                <label class="form-label" >Password</label>
                                            </div>

                                            <div class="pt-1 mb-4">
                                                <input type="hidden" name="action" value="Login">
                                                <input data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-lg btn-block" type="submit" value="Login">
                                            </div>
                                        </form>
                                        <h5 style="color: red">${Notification}</h5>
                                        <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? 
                                        <a href="Signup.jsp" style="color: #393f81;">Register here</a>
                                        </p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>