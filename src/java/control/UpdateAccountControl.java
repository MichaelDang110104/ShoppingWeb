/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AccountDAO;
import entity.Account;
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
 * @author MichaelDang
 */
public class UpdateAccountControl extends HttpServlet {

    private static final String SHOW_ACCOUNT_CONTROL = "ShowAccountControl";
    private static final String UPDATE_PAGE = "Admin/UpdateAccount.jsp";

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
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            HttpSession session = request.getSession();
            AccountDAO adao = new AccountDAO();
            String account = (String) session.getAttribute("UACC");
            String pass = request.getParameter("passwordUpdate");
            String lastName = request.getParameter("lNameUpdate");
            String firstName = request.getParameter("fNameUpdate");
            String dob = request.getParameter("dobUpdate");
            boolean gender = Boolean.parseBoolean(request.getParameter("genderUpdate"));
            String phone = request.getParameter("phoneUpdate");
            boolean inUse = Boolean.parseBoolean(request.getParameter("inuseUpdate"));
            int role = Integer.parseInt(request.getParameter("roleUpdate"));
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(dob);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            Account acc = new Account(account, pass, lastName, firstName, sqlDate, gender, phone, inUse, role);
            adao = new AccountDAO();
            if (adao.updateRec(account, acc) == true) {
                request.setAttribute("Notification", "Update complete !");
                request.getRequestDispatcher(SHOW_ACCOUNT_CONTROL).forward(request, response);
            } else {
                response.sendRedirect(UPDATE_PAGE);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
            Logger.getLogger(UpdateAccountControl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateAccountControl.class.getName()).log(Level.SEVERE, null, ex);
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
