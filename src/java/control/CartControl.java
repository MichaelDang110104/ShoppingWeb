/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ProductDAO;
import entity.CartItems;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MichaelDang
 */
public class CartControl extends HttpServlet implements Serializable {

    private static final String CART_PAGE = "Cart.jsp";

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
        ArrayList<CartItems> cartList = null;
        try (PrintWriter out = response.getWriter()) {
            String pid = request.getParameter("pid");
            ProductDAO pdao = new ProductDAO();
            Products x = pdao.getObjectById(pid);
            int tf = 20000;
            int total = 0;
            int vat = 0;
            int it = 0;
            final int quantity = 1;
            HttpSession session = request.getSession();
            cartList = (ArrayList<CartItems>) session.getAttribute("listCart");
            if (cartList == null || cartList.isEmpty()) {
                CartItems cart = new CartItems();
                cartList = new ArrayList<>();
                cart.setProduct(x);
                cart.setQuantity(quantity);
                cartList.add(cart);
            } else if (cartList != null) {
                for (CartItems d : cartList) {
                    if (d.getProduct().getProductID().equals(pid)) {
                        d.setQuantity(d.getQuantity() + 1);
                        break;
                    } else {
                        CartItems cart = new CartItems();
                        cart.setProduct(x);
                        cart.setQuantity(quantity);
                        cartList.add(cart);
                        break;
                    }
                }

            }
            for (CartItems d : cartList) {
                it += d.getProduct().getPrice()* d.getQuantity();
                if (d.getProduct().getDiscount() != 0) {
                    request.setAttribute("Notification", "Sale has been added already !");
                    it = it - ((it * d.getProduct().getDiscount() / 100)*d.getQuantity());
                }
            }
            session.setAttribute("listCart", cartList);
            vat = it * 10 / 100;
            total = it + vat + tf;
            session.setAttribute("tf", tf);
            session.setAttribute("total", total);
            session.setAttribute("vat", vat);
            session.setAttribute("it", it);
            response.sendRedirect(CART_PAGE);
        } catch (ClassNotFoundException ex) {
            log(ex.getMessage());
        } catch (SQLException ex) {
            log(ex.getMessage());
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
