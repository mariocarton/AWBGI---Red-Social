package controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import datos.GestorComentarios;
import datos.GestorPeliculas;
import datos.GestorPorVer;
import datos.GestorVistas;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Comentario;
import modelo.Pelicula;
import modelo.PorVer;
import modelo.Usuario;
import modelo.Visto;

/**
 *
 * @author mario
 */
@MultipartConfig
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

        HttpSession session = request.getSession();
        Boolean sesion = (Boolean) session.getAttribute("auth");

        if (sesion != null) {
            System.out.println("Sesion: " + sesion);
            if (sesion) {
                
                String accion = request.getParameter("accion");
                if (accion != null) {
                Usuario us = (Usuario) session.getAttribute("usuario");  
                System.out.println("Id: "+us.getId());
                    switch (accion) {

                        case "cierra_sesion":
                            System.out.println("cierra sesion");
                            session.setAttribute("auth", false);
                            System.out.println("Sesion cerrada: " + session.getAttribute("auth"));
                            response.sendRedirect("./login");
                            break;

                        case "verpeli":
                            System.out.println("verpeli");
                            response.setContentType("text/html; charset=iso-8859-1");
                            PrintWriter out3 = response.getWriter();
                            String idaux = request.getParameter("id").trim();
                            int id = Integer.parseInt(idaux);
                            GestorPeliculas gp4 = new GestorPeliculas();
                            Pelicula peli2 = gp4.getPeliculaPorId(id);
                            
                            //Descomentar para verpeli antigua aqui y en idex.jsp segundo ajax
                            
                            out3.println("<h3>" + peli2.getTitulo() + "</h3>");

                            //BOTONES
                            out3.println("<hr style='color: red' />");
                            out3.println("<div class='btn-group' role='group' aria-label='...'>");
                            out3.println("<button type='button' class='btn btn-default'>Visto</button>");
                            out3.println("<button type='button' class='btn btn-default'>PorVer</button>");
                            out3.println("<button type='button' class='btn btn-default'>NoVisto</button>");
                            out3.println("</div>");
                            out3.println("<div class='btn-group' style='margin-left: 20px' role='group' aria-label='...'>");
                            out3.println("<a class='btn btn-primary ' id='bformcomentario' >Añadir Comentario</a>");
                            out3.println("</div>");

                            //INFOPELI
                            out3.println("<hr style='color: red' />");
                            out3.println("<p>Título: " + peli2.getTitulo() + "</p>");
                            out3.println("<p>Año: " + peli2.getAno() + "</p>");
                            out3.println("<p>Duración: " + peli2.getDuracion() + " Minutos</p>");
                            out3.println("<p>País: " + peli2.getPais() + "</p>");
                            out3.println("<p>Director: " + peli2.getDirector() + "</p>");
                            out3.println("<p>Género " + peli2.getGenero() + "</p>");
                            out3.println("<p>Sinopsis: " + peli2.getSinopsis()+ "</p>");
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
                            
                            
                            ///Guardar info peli en sessión
                            
                            //session.setAttribute("infopeli", peli2);
                            
                            //response.sendRedirect("./index.jsp");
                            
                            break;
                        
                        case "visto":
                            System.out.println("visto");
                            GestorVistas gv = new GestorVistas();
                            Usuario u2 = (Usuario) session.getAttribute("usuario");
                            ArrayList<Visto> arrayVistas = gv.extraeVistas(u2.getId());
                            GestorPeliculas gp3 = new GestorPeliculas();
                            response.setContentType("text/html; charset=iso-8859-1");
                            PrintWriter out2 = response.getWriter();
                            out2.println("<h2 style='text-align: center; margin-bottom: 3%'> Películas Vistas </h2>");
                            for (int i = 0; i < arrayVistas.size(); i++) {
                                Visto vista = arrayVistas.get(i);
                                Pelicula peli = gp3.getPeliculaPorId(vista.getIdpelicula());
                                out2.println("<div class='col-xs-4'>");
                                out2.println("<div class='thumbnail'>");
                                out2.println("<img src='imagenes/" + peli.getRuta() + "' height='600' width='200'>");
                                out2.println("<div class='caption'>");
                                out2.println("<h3>" + peli.getTitulo() + "</h3>");
                                out2.println("<p>" + peli.getGenero() + "</p>");
                                out2.println("<input type='hidden' name=idpeli value=" + peli.getId() + ">");
                                out2.println("<a  id=" + peli.getId() + " class='accesopeli btn btn-primary'>Ver Detalles</a>");
                                out2.println("</div>");
                                out2.println("</div>");
                                out2.println("</div>");

                            }
                            break;
                        case "explorar":
                            System.out.println("explorar");
                            GestorPeliculas gp2 = new GestorPeliculas();
                            ArrayList<Pelicula> arrayPeliculas = gp2.extraePeliculas();
                            response.setContentType("text/html; charset=iso-8859-1");
                            PrintWriter out = response.getWriter();
                            out.println("<h2 style='text-align: center; margin-bottom: 3%'> Películas de la Página </h2>");
                            out.println("<div class='container-fluid'>");
                            for (int j = 0; j < arrayPeliculas.size(); j++) {
                                Pelicula peli = arrayPeliculas.get(j);
                                if(j%4==0) out.println("<div class='row'>");
                                out.println("<div class='col-sm-3'>");
                                out.println("<div class='thumbnail'>");
                                out.println("<img src='" + peli.getRuta() + "'  class='img-responsive'>");
                                out.println("<div class='caption'>");
                                out.println("<h3>" + peli.getTitulo() + "</h3>");
                                out.println("<p>" + peli.getGenero()+ "</p>");
                                out.println("<input type='hidden' name=idpeli value=" + peli.getId() + " class='accesopeli'>");
                                out.println("<a  id=" + peli.getId() + " class='accesopeli btn btn-primary'>Ver Detalles</a>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</div>");
                                if(j%4==3) out.println("</div>");
                            }
                            out.println("</div>");   
                            break;
                            
                        case "savepeli":
                            System.out.println("savepeli");
                            Usuario u3 = (Usuario) session.getAttribute("usuario");
                            String titulo = request.getParameter("titulopf");
                            String anoaux = request.getParameter("anopf");
                            int ano = Integer.parseInt(anoaux);
                            String duracionaux = request.getParameter("duracionpf");
                            int duracion = Integer.parseInt(duracionaux);
                            String director = request.getParameter("directorpf");
                            String pais = request.getParameter("paispf");
                            String genero = request.getParameter("generopf");
                            String sinopsis = request.getParameter("sinopsispf");
                            String imagenUrl = request.getParameter("imagenpelipf");                            
                            
                            GestorPeliculas gp = new GestorPeliculas();
                            
                            Pelicula pe = new Pelicula(u3.getId(), titulo, ano, duracion, pais, director, genero, sinopsis, imagenUrl);
                            String mensaje = gp.guardaPeliculas(pe);
                            System.out.println(u3.getId()+ " "+titulo + " " + ano + " " + duracion + " " + director + " " + pais + " " + genero + " " + sinopsis+" "+imagenUrl);
                            if ("yes".equals(mensaje)) {
                                //String r = "yes";
                                response.setContentType("text/plain");
                                response.getWriter().write(mensaje);
                                //response.sendRedirect("./index.jsp");
                            } else {
                                response.setContentType("text/plain");
                                response.getWriter().write(mensaje);
                            }

                            break;
                        default:
                            System.out.println("default");
                            response.sendRedirect("./index.jsp");
                    }
                } else {
                    System.out.println("No action");                   
                    response.sendRedirect("./index.jsp");
                }
            } else {
                System.out.println("Sesion: " + sesion);
                response.sendRedirect("./login");
            }
        } else {
            System.out.println("Sesion: " + sesion);
            response.sendRedirect("./login");
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

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
