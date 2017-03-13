/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import datos.GestorComentarios;
import datos.GestorPeliculas;
import datos.GestorPorVer;
import datos.GestorVistas;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import static javax.management.Query.div;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.Pelicula;
import modelo.PorVer;
import modelo.Visto;

/**
 *
 * @author mario
 */
public class pelicula extends HttpServlet {

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
                /*case "savepeli":
                            System.out.println("savepeli");
                            break;*/
 /*
                        case "cierra_sesion":
                            System.out.println("cierra sesion");
                            session.setAttribute("auth", false);
                            response.sendRedirect("./login");
                            break;
                 */
                case "verpeli":
                    response.setContentType("text/html; charset=iso-8859-1");
                    PrintWriter out3 = response.getWriter();
                    String idaux = request.getParameter("id").trim();
                    int id = Integer.parseInt(idaux);
                    GestorPeliculas gp4 = new GestorPeliculas();
                    Pelicula peli2 = gp4.getPeliculaPorId(id);
                    out3.println("<h3>" + peli2.getTitulo() + "</h3>");

                    //BOTONES
                    out3.println("<hr style='color: red' />");
                    out3.println("<div class='btn-group' role='group' aria-label='...'>");
                    out3.println("<button type='button' class='btn btn-default'>Visto</button>");
                    out3.println("<button type='button' class='btn btn-default'>PorVer</button>");
                    out3.println("<button type='button' class='btn btn-default'>NoVisto</button>");
                    out3.println("</div>");
                    out3.println("<div class='btn-group' style='margin-left: 20px' role='group' aria-label='...'>");
                    out3.println("<a class='btn btn-primary ' id='formcomentario' >Añadir Comentario</a>");
                    out3.println("</div>");

                    //INFOPELI
                    out3.println("<hr style='color: red' />");
                    out3.println("<p>Título: " + peli2.getTitulo() + "</p>");
                    out3.println("<p>Año: " + peli2.getAno() + "</p>");
                    out3.println("<p>Duración: " + peli2.getDuracion() + " Minutos</p>");
                    out3.println("<p>País: " + peli2.getPais() + "</p>");
                    out3.println("<p>Director: " + peli2.getDirector() + "</p>");
                    out3.println("<p>Género " + peli2.getGenero() + "</p>");
                    out3.println("<p>Sinopsis: " + peli2.getGenero() + "</p>");
                    out3.println("<hr style='color: red' />");

                    //COMENTARIOS
                    GestorComentarios gc = new GestorComentarios();
                    ArrayList<Comentario> arrayComentarios = gc.extraeComentarios(id);
                    out3.println("<div class='list-group'>");
                    //list-group-item active
                    for (int i = 0; i < arrayComentarios.size(); i++) {
                        Comentario comentario = arrayComentarios.get(i);
                        out3.println("<a class='list-group-item'>");
                        out3.println("<h4 class='list-group-item-heading'>" + comentario.getTitulo() + "</h4>");
                        out3.println("<p class='list-group-item-text'>" + comentario.getTexto() + "</p>");
                        out3.println("</a>");
                    }
                    out3.println("</div>");
                    out3.println("<hr style='color: red' />");
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
    @Override
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
