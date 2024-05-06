/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MichaelDang
 */
public class MainController extends HttpServlet {

    private static final String DASHBOARD = "DashboardControl";
    private static final String CATEGORYBAR = "CategoryBarControl";
    private static final String ADD_ACCOUNT = "Signup.jsp";
    private static final String SHOW_ACCOUNT = "Admin/ShowAccount.jsp";
    private static final String SHOW_ACCOUNT_CONTROL = "ShowAccountControl";
    private static final String UPDATE_ACCOUNT_CONTROL = "UpdateAccountControl";
    private static final String ACCOUNT_MANAGEMENT = "AccountManagement";
    private static final String ADD_CATEGORIES = "Admin/AddCategories.jsp";
    private static final String SHOW_CATEGORIES_CONTROL = "ShowCategoryControl";
    private static final String CATEGORIES_MANAGEMENT_CONTROL = "CategoryManagement";
    private static final String UPDATE_CATEGORY_CONTROL = "UpdateCategory";
    private static final String ADD_PRODUCT = "Admin/AddProducts.jsp";
    private static final String SHOW_PRODUCTS_CONTROL = "ShowProductsControl";
    private static final String SIGNUP_CONTROL = "SignupControl";
    private static final String ADD_CATE_CONTROL = "AddCategoryControl";
    private static final String ADD_PRODUCT_CONTROL = "AddProductControl";
    private static final String PRODUCT_MANAGEMENT = "ProductManagement";
    private static final String UPDATE_PRODUCT_CONTROL = "UpdateProductControl";
    private static final String LOGIN_CONTROL = "LoginControl";
    private static final String LOGOUT_CONTROL = "LogoutControl";
    private static final String SEARCH_CONTROL = "SearchControl";
    private static final String DETAIL_CONTROL = "DetailControl";
    private static final String CART_CONTROL = "CartControl";
    private static final String DELETE_ITEM = "DeleteItem";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = "DashboardControl";
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = DASHBOARD;
            } else if (action.equals("CategorySet")) {
                url = CATEGORYBAR;
            } else if (action.equals("addAccount")) {
                url = ADD_ACCOUNT;
            } else if (action.equals("showAccount")) {
                url = SHOW_ACCOUNT_CONTROL;
            } else if (action.equals("addCategory")) {
                url = ADD_CATEGORIES;
            } else if (action.equals("ShowCategory")) {
                url = SHOW_CATEGORIES_CONTROL;
            } else if (action.equals("addProduct")) {
                url = ADD_PRODUCT;
            } else if (action.equals("showProduct")) {
                url = SHOW_PRODUCTS_CONTROL;
            } else if (action.equals("Signup")) {
                url = SIGNUP_CONTROL;
            } else if (action.equals("AddCate")) {
                url = ADD_CATE_CONTROL;
            } else if (action.equals("AddNewProduct")) {
                url = ADD_PRODUCT_CONTROL;
            } else if (action.equals("Update Account")) {
                url = UPDATE_ACCOUNT_CONTROL;
            }else if(action.equals("AccountManagement")){
                url=ACCOUNT_MANAGEMENT;
            } 
            else if (action.equals("UpdateCategory") || action.equals("DeleteCategory")) {
                url = CATEGORIES_MANAGEMENT_CONTROL;
            } else if (action.equals("SubmitUpdateCategory")) {
                url = UPDATE_CATEGORY_CONTROL;
            } else if (action.equals("UpdateProduct") || action.equals("DeleteProduct")) {
                url = PRODUCT_MANAGEMENT;
            } else if (action.equals("SubmitUpdateProduct")) {
                url = UPDATE_PRODUCT_CONTROL;
            } else if (action.equals("Login")) {
                url = LOGIN_CONTROL;
            } else if (action.equals("Logout")) {
                url = LOGOUT_CONTROL;
            } else if (action.equals("Search")) {
                url = SEARCH_CONTROL;
            } else if (action.equals("ShowDetail")) {
                url = DETAIL_CONTROL;
            }else if (action.equals("AddToCart")|| action.equals("Buy")){
                url = CART_CONTROL;
            }else if (action.equals("DeleteItem")){
                url = DELETE_ITEM;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
