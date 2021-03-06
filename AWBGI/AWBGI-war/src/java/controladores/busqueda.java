/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorPeliculas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pelicula;

/**
 *
 * @author mario
 */
@WebServlet(name = "busqueda", urlPatterns = {"/busqueda"})
public class busqueda extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet busqueda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet busqueda at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        String accion = request.getParameter("accion");
        GestorPeliculas gp = new GestorPeliculas();
        if (accion != null) {
            switch (accion) {
                case "busqueda":
                    String palabra = request.getParameter("palabra");
                    ArrayList<Pelicula> arrayPeliculas = gp.extraePeliculasLike(palabra);
                    
                    response.setContentType("text/html; charset=iso-8859-1");
                    PrintWriter out = response.getWriter();
                    
                    out.println("<ul class=\"list-group\" style=\"margin-bottom : 0\">\n");
                    if(arrayPeliculas.isEmpty()){
                        out.println("<li class=\"list-group-item\">No hay peliculas relacionadas...</li>\n");
                    }
                    for (int j = 0; j < arrayPeliculas.size(); j++) {                        
                         out.println("<a id='" + arrayPeliculas.get(j).getId() + "' class='accesopeli list-group-item'>"+arrayPeliculas.get(j).getTitulo()+"</a>\n");
                    }
                    out.println("</ul>");
                    
                    break;
                default:
                    response.sendRedirect("./index.jsp");
            }
        }else{
            response.sendRedirect("./index.jsp");
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
