package controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import datos.GestorPeliculas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Pelicula;

/**
 *
 * @author mario
 */
public class index extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
        //   response.sendRedirect("./index.jsp");
        //}

        String accion = request.getParameter("accion");
        if (accion != null) {
            System.out.println("aqui2");
            switch (accion) {
                case "savepeli":
                    
                    break;

                default:
                    response.sendRedirect("./index.jsp");
            }
        } else {
            System.out.println("aqui");
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
        //processRequest(request, response);
        String accion = request.getParameter("accion").trim();
        switch (accion) {
            case "anadirpeli":
                String titulo = request.getParameter("titulopf").trim();
                String ano = request.getParameter("anopf").trim();
                String director = request.getParameter("directorpf").trim();
                String pais = request.getParameter("paispf").trim();
                String genero = request.getParameter("generopf").trim();
                String sinopsis = request.getParameter("sinopsispf").trim();
                GestorPeliculas gp = new GestorPeliculas();
                HttpSession session = request.getSession();
                //session.getAttribute("id");
                //Pelicula pe = new Pelicula();
                System.out.println(titulo+" "+ano+" "+director+" "+pais+" "+genero+" "+sinopsis);
                String r = "yes";
                response.setContentType("text/plain");
                response.getWriter().write(r); 
                //response.sendRedirect("./index.jsp");
                break;
                
            default:
                 System.out.println("aqui4");
                response.sendRedirect("./index.jsp");
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
