/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Category;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michael Dang
 */
public class UpdateProductControl extends HttpServlet {
    private static final String UPDATE_PRODUCT_PAGE = "UpdateProduct.jsp";
    private static final String SHOW_PRODUCT_CONTROL = "ShowProductControl";
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
            throws ServletException, IOException, ParseException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("UPID");
            String name = request.getParameter("pNameUpdate");
            String image = request.getParameter("pImageUpdate");
            String brief = request.getParameter("pBriefUpdate");
            String pdate = request.getParameter("pDateUpdate");
            String type = request.getParameter("pTypeUpdate");
            String acc = request.getParameter("pAccUpdate");
            String unit = request.getParameter("pUnitUpdate");
            int price = Integer.parseInt(request.getParameter("pPriceUpdate"));
            int discount = Integer.parseInt(request.getParameter("pDiscountUpdate"));
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(pdate);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            CategoryDAO cdao = new CategoryDAO();
            AccountDAO adao = new AccountDAO();
            Account a = adao.getObjectById(acc);
            Category c = cdao.getObjectById(type);
            Products p = new Products(id, name, image, brief, sqlDate, c, a, unit, price, discount);
            ProductDAO pdao = new ProductDAO();
            if(pdao.updateRec(id,p) == true) {
                request.setAttribute("Notification", "Product has been updated successfully !");
                request.getRequestDispatcher(SHOW_PRODUCT_CONTROL).forward(request, response);
            }
            else response.sendRedirect(UPDATE_PRODUCT_PAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddProductControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddProductControl.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
