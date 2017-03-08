package controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import datos.GestorPeliculas;
import datos.GestorVistas;
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
import modelo.Pelicula;
import modelo.Visto;

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
                        case "visto":
                            GestorVistas gv = new GestorVistas();
                            ArrayList<Visto> arrayVistas = gv.extraeVistas(1);
                            GestorPeliculas gp3 = new GestorPeliculas();
                            response.setContentType( "text/html; charset=iso-8859-1" );
                            PrintWriter out2 = response.getWriter();
                            out2.println("<h2 style='text-align: center; margin-bottom: 3%'> Películas Vistas </h2>");
                            for (int i = 0; i < arrayVistas.size(); i++) {
                                Visto vista = arrayVistas.get(i);
                                Pelicula peli = gp3.getPeliculaPorId(vista.getIdpelicula());
                                out2.println("<div class='col-xs-4'>");
                                out2.println("<div class='thumbnail'>");
                                out2.println("<img src='...' alt='...'>");
                                out2.println("<div class='caption'>");
                                out2.println("<h3>"+peli.getTitulo()+"</h3>");
                                out2.println("<p>"+peli.getGenero()+"</p>");
                                out2.println("<p><a class='btn btn-primary' role='button'>Button</a></p>");
                                out2.println("</div>");
                                out2.println("</div>");
                                out2.println("</div>");
                                
                            }
                            break;
                        case "explorar":
                             GestorPeliculas gp2 = new GestorPeliculas();
                             ArrayList<Pelicula> arrayPeliculas = gp2.extraePeliculas();
                             response.setContentType( "text/html; charset=iso-8859-1" );
                             PrintWriter out = response.getWriter();
                             out.println("<h2 style='text-align: center; margin-bottom: 3%'> Películas de la Página </h2>");
                             for (int j = 0; j < arrayPeliculas.size(); j++) {
                                Pelicula peli = arrayPeliculas.get(j);
                                out.println("<div class='col-xs-4'>");
                                out.println("<div class='thumbnail'>");
                                out.println("<img src='...' alt='...'>");
                                out.println("<div class='caption'>");
                                out.println("<h3>"+peli.getTitulo()+"</h3>");
                                out.println("<p>"+peli.getGenero()+"</p>");
                                out.println("<p><a class='btn btn-primary' role='button'>Button</a></p>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</div>");
                            }
                            
                            System.out.println("extraepelis");
                            break;
                        case "savepeli":
                            String titulo = request.getParameter("titulopf").trim();
                            String anoaux = request.getParameter("anopf").trim();
                            int ano = Integer.parseInt(anoaux);
                            String duracionaux = request.getParameter("duracionpf").trim();
                            int duracion = Integer.parseInt(duracionaux);
                            String director = request.getParameter("directorpf").trim();
                            String pais = request.getParameter("paispf").trim();
                            String genero = request.getParameter("generopf").trim();
                            String sinopsis = request.getParameter("sinopsispf").trim();
                            GestorPeliculas gp = new GestorPeliculas();
                            //HttpSession session = request.getSession();
                            //session.getAttribute("id");
                            Pelicula pe = new Pelicula(1,titulo,ano,duracion,pais,director,genero,sinopsis);
                            String mensaje = gp.guardaPeliculas(pe);
                            System.out.println(titulo + " " + ano + " " + duracion +" " + director + " " + pais + " " + genero + " " + sinopsis);
                            if ("yes".equals(mensaje)){
                                String r = "yes";
                                response.setContentType("text/plain");
                                response.getWriter().write(r);
                            //response.sendRedirect("./index.jsp");
                            }else{
                                response.setContentType("text/plain");
                                response.getWriter().write(mensaje);
                            }
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
        /*
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
        }*/
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
