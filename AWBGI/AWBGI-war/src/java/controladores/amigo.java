/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorAmigos;
import datos.GestorUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Amigo;
import modelo.Usuario;

/**
 *
 * @author mariomatesanz
 */
public class amigo extends HttpServlet {

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
            response.sendRedirect("./index.jsp");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
        //   response.sendRedirect("./index.jsp");
        //}
        //System.out.println("doget");
        // Mira en la session si esta autenticado el usuario
        /*
        HttpSession session = request.getSession();
        Boolean sesion = (Boolean) session.getAttribute("auth");
        
        if (sesion != null) {
            if (sesion) {
         */
        String accion = request.getParameter("accion");
        if (accion != null) {

            switch (accion) {

                case "guardaamigo":
                    response.setContentType("text/html; charset=iso-8859-1");
                    PrintWriter out = response.getWriter();
                    String idaux = request.getParameter("id").trim();
                    int id = Integer.parseInt(idaux);
                    //int id = Integer.parseInt(idaux);
                    GestorAmigos ga = new GestorAmigos();
                    ga.guardaAmistad(id, id);
                    break;

                case "extraeamigos":
                    response.setContentType("text/html; charset=iso-8859-1");
                    PrintWriter out2 = response.getWriter();
                    //String idaux2 = request.getParameter("id").trim();
                    //int id2 = Integer.parseInt(idaux2);
                    GestorAmigos ga2 = new GestorAmigos();
                    ArrayList<Amigo> arrayAmigos = ga2.extraeAmigos(1);
                    GestorUsuarios gu = new GestorUsuarios();
                    out2.println("<h2 style='text-align: center; margin-bottom: 3%'> Películas de la Página </h2>");
                    out2.println("<div class='container-fluid'>");
                    for (int j = 0; j < arrayAmigos.size(); j++) {
                        Amigo amigo = arrayAmigos.get(j);
                        Usuario u = gu.getUsuarioPorId(amigo.getId());
                        out2.println("<div class='jumbotron col-xs-4' style='margin: 1%'>");
                        out2.println("<h3 style=\"text-height: auto'>" + u.getNombre() + " " + u.getApellidos());
                        //out2.println("<p>Vistas 17</p>");
                        //out2.println("<p>Por Ver 17</p>");
                        out2.println("<p><a class=\"btn btn-primary btn-lg\" href=\"#\" role='button'>Añadir</a></p>");
                        out2.println("</div>");

                    }
                    out2.println("</div>");
                    break;

                default:
                    System.out.println("default");
                    response.sendRedirect("./index.jsp");
            }

        } else {
            System.out.println("aqui");
            response.sendRedirect("./index.jsp");
        }
        /*
            } else {
                response.sendRedirect("./login");
            }
        } else {
            response.sendRedirect("./login");
        }
         */
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        System.out.println("dopost");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
