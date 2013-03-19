package Servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gebruiker
 */
public class Products extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Products</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Products at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sql;
        Dataconnection.ConnectionManager manager = new Dataconnection.ConnectionManager();
        manager.createConnection();
        if (request.getParameter("id") != null) {
            try {
                sql = "SELECT productnaam, productmerk, beschrijving FROM product WHERE idproduct = " + request.getParameter("id");
                ResultSet products = manager.insertRawSQL(sql);

                String html = "<p>" + products.getString("productnaam") + "</p>";
                html += "<p>" + products.getString("productmerk") + "</p>";
                html += "<p>" + products.getString("beschrijving") + "</p>";
                html += "<c:if test='${sessionScope.currentUser != null}'>";
                html += "<form action=\"products\" method=\"POST\">";
                html += "<input type=\"hidden\" value=\"<%= request.getAttribute(\"id\")\" name=\"id\" />";
                html += "<input type=\"submit\" value=\"In winkelwagen\" />";
                html += "</form>";
                html += "</c:if>";

                request.setAttribute("products", html);
                request.setAttribute("id", request.getParameter("id"));
                response.sendRedirect("products.jsp");
            } catch (Exception e) {
            }
        } else {
            sql = "SELECT * FROM product";

            ResultSet products = manager.insertRawSQL(sql);
            String html = "<table>";
            html += "<tr><th>Naam</th><th>Merk</th><th>Prijs</th></tr>";
            try {
                while (products.next()) {
                    html += "<tr><a href='products?id=" + products.getInt("idProduct") + "'>";
                    html += "<td>" + products.getString("productnaam") + "</td>";
                    html += "<td>" + products.getString("productmerk") + "</td>";
                    html += "<td>" + products.getDouble("prijs") + "</td>";
                    html += "</a></tr>";
                }
                html += "</table>";
                request.setAttribute("products", html);
                response.sendRedirect("products.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
