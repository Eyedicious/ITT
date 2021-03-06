/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bart
 */
public class GebruikerServlet extends HttpServlet {


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
        //Doesnothing.
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
        if(request.getParameter("action").equals("registreren")){
            registreren(request, response);
        }
        if(request.getParameter("action").equals("inloggen")){
            inloggen(request, response);
        }
        if(request.getParameter("action").equals("uitloggen")){
            uitloggen(request, response);
        }
    }

    /*
     * 
     * 
     * 
     */
    private void registreren(HttpServletRequest request, HttpServletResponse response){
        try{
            Dataconnection.ConnectionManager Conn = new Dataconnection.ConnectionManager();
            Conn.createConnection();
            if(!Conn.getFromTable("SELECT * FROM gebruiker WHERE login='"+(String)request.getParameter("loginnaam")+"'").next()){
                boolean succes = Conn.insertIntoTable("INSERT INTO gebruiker(voornaam, tussenvoegsel, achternaam, email, login, wachtwoord) VALUES ('"
                        +(String)request.getParameter("voornaam") +"','"+(String)request.getParameter("tussenvoegsel") +"','"+(String)request.getParameter("achternaam")
                        +"','"+(String)request.getParameter("email") +"','"+(String)request.getParameter("loginnaam") +"','"+(String)request.getParameter("wachtwoord")+"')");
                Conn.closeConnection();
                if(succes){
                    inloggen(request, response);
                } else{
                    System.out.println("Failed to reg user");
                    response.sendRedirect("registreren.jsp");
                }
            } else {
                request.setAttribute("registreerfout", "Deze gebruikernaam is al in gebruik");
                response.sendRedirect("registreren.jsp");
            }
        } catch(Exception e){
            System.out.println("exception thrown during reg user: "+e);
        }
    }
    /*
     * 
     * 
     * 
     * 
     */
    private void inloggen(HttpServletRequest request, HttpServletResponse response){
        try{
            Dataconnection.ConnectionManager Conn = new Dataconnection.ConnectionManager();
            Conn.createConnection();
            ResultSet users = Conn.getFromTable("SELECT * FROM gebruiker WHERE login='"+(String)request.getParameter("loginnaam")+"'");
            while(users.next()){
                if(users.getString("wachtwoord").equals((String)request.getParameter("wachtwoord"))){
                    Entities.Gebruiker currentUser = new Entities.Gebruiker();
                    currentUser.setIdGebruiker(users.getInt("idGebruiker"));
                    currentUser.setVoornaam(users.getString("voornaam"));
                    currentUser.setTussenvoegsel(users.getString("tussenvoegsel"));
                    currentUser.setAchternaam(users.getString("achternaam"));
                    currentUser.setEmail(users.getString("email"));
                    currentUser.setLogin(users.getString("login"));
                    currentUser.setWachtwoord(users.getString("wachtwoord"));
                    HttpSession newSession = request.getSession(true);
                    newSession.setAttribute("currentUser", currentUser);
                    response.sendRedirect("index.jsp");
                }
            }
        } catch(Exception e){
            System.out.println("Error logging in: "+e);
        }
    }
    
    /*
     * 
     * 
     * 
     * 
     */
    private void uitloggen(HttpServletRequest request, HttpServletResponse response){
        try{
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        } catch(Exception e){
            System.out.println("Unable to destroy the session: "+e);
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet om in te loggen, registreren en uit te loggen";
    }// </editor-fold>
}
