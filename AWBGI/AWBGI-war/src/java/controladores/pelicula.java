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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.Pelicula;
import modelo.PorVer;
import modelo.Usuario;
import modelo.Visto;
import sun.nio.cs.ext.GB18030;

/**
 *
 * @author mario
 */
@WebServlet(name = "pelicula", urlPatterns = {"/pelicula"})
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
        HttpSession session = request.getSession();
        String accion = request.getParameter("accion");
        
        GestorPeliculas gp = new GestorPeliculas();
        GestorVistas gv = new GestorVistas();
        GestorPorVer gpv = new GestorPorVer();
        Usuario u = (Usuario) session.getAttribute("usuario");

        if (accion != null) {
            switch (accion) {
                case "verpeli":
                    response.setContentType("text/html; charset=iso-8859-1");
                    PrintWriter out3 = response.getWriter();
                    String idaux = request.getParameter("id").trim();
                    int id = Integer.parseInt(idaux);
                    //GestorPeliculas gp4 = new GestorPeliculas();
                    Pelicula peli2 = gp.getPeliculaPorId(id);
                    out3.println("<h2 style='margin-left:35px'>" + peli2.getTitulo() + "</h2>");

                    //BOTONES
                    //out3.println("<hr style='color: red' />");
                    out3.println("<div class='row' style='margin-top:35px; margin-right: 0px; margin-left:35px'>");
                    out3.println("<div class='btn-group' role='group' aria-label='...'>");
                    out3.println("<a id='btn-visto' href='#' class='btn btn-default btn-estado'>Visto</a>");
                    out3.println("<a id='btn-porver' href='#' class='btn btn-default btn-estado'>Por Ver</a>");
                    out3.println("<a id='btn-novisto' href='#' class='btn btn-default btn-estado'>No Visto</a>");
                    out3.println("</div>");
                    out3.println("<div class='btn-group' style='margin-left: 20px' role='group' aria-label='...'>");
                    out3.println("<a class='btn btn-primary ' id='formcomentario' data-toggle='modal' data-target='#myModal' >Añadir Comentario</a>");
                    out3.println("</div>");
                    out3.println("</div>");

                    out3.println(
                            "<div id='myModal' class='modal fade' role='dialog'>"
                            + "  <div class='modal-dialog'>"
                            + "    <!-- Modal content-->"
                            + "    <div class='modal-content'>"
                            + "      <div class='modal-header'>"
                            + "        <button type='button' class='close' data-dismiss='modal'>&times;</button>"
                            + "        <h4 class='modal-title'>Añadir comentario</h4>"
                            + "      </div>"
                            + "      <form id='enviar-comentario'>"
                            + "      <div class='modal-body'>"
                            + "         <div class='form-group'>"
                            + "             <label>Título:</label>"
                            + "             <input type='text' class='form-control' id='comentario-titulo' required>"
                            + "             <input type='hidden' id='id-pelicula' value='" + peli2.getId() + "'>"
                            + "         </div>"
                            + "         <div class='form-group'>"
                            + "             <label for='comment'>Comentario:</label>"
                            + "                 <textarea class='form-control' rows='5' id='comentario-cuerpo' required></textarea>"
                            + "         </div>"
                            + "      </div>"
                            + "      <div class='modal-footer'>"
                            + "        <button type='submit' class='btn btn-primary'>Aceptar</a>"
                            + "        <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>"
                            + "      </div>"
                            + "      </form>"
                            + "    </div>"
                            + "  </div>"
                            + "</div>"
                    );

                    //INFOPELI3
                    //out3.println("<hr style='color: red' />");
                    out3.println("<div class='row' style='margin-right: 0px; margin-left:35px'>");
                    out3.println("<div id='imagen' class='col-md-2' style='margin-top:35px'>");
                    out3.println("<img src='" + peli2.getRuta() + "'  class='img-responsive' style='float: right'>");
                    out3.println("</div>");
                    out3.println("<div id='descripcion' class='col-md-10' style='margin-top:35px'>");
                    out3.println("<p>Título: " + peli2.getTitulo() + "</p>");
                    out3.println("<p>Año: " + peli2.getAno() + "</p>");
                    out3.println("<p>Duración: " + peli2.getDuracion() + " Minutos</p>");
                    out3.println("<p>País: " + peli2.getPais() + "</p>");
                    out3.println("<p>Director: " + peli2.getDirector() + "</p>");
                    out3.println("<p>Género " + peli2.getGenero() + "</p>");
                    out3.println("<p>Sinopsis: " + peli2.getSinopsis()+ "</p>");
                    out3.println("</div>");
                    out3.println("</div>");
                    //out3.println("<hr style='color: red' />");

                    //COMENTARIOS
                    GestorComentarios gc = new GestorComentarios();
                    ArrayList<Comentario> arrayComentarios = gc.extraeComentarios(id);
                    out3.println("<div class='row' style='margin:35px'>");
                    out3.println("<div id='notificacion' class='alert alert-success alert-dismissable' hidden>"
                            + "     <a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                            + "     <strong>Comentario publicado.</strong> Tu comentario se ha publicado con éxito."
                            + " </div>"
                    );
                    out3.println("<div id='comentarios' class='list-group'>");
                    //list-group-item active
                    for (int i = 0; i < arrayComentarios.size(); i++) {
                        Comentario comentario = arrayComentarios.get(arrayComentarios.size() - 1 - i);
                        out3.println("<a class='list-group-item'>");
                        out3.println("<h4 class='list-group-item-heading'>" + comentario.getTitulo() + "</h4>");
                        out3.println("<p class='list-group-item-text'>" + comentario.getTexto() + "</p>");
                        out3.println("</a>");
                    }                    
                    if(arrayComentarios.isEmpty()){
                        out3.println("<a class='list-group-item'>");
                        out3.println("<h4 class='list-group-item-heading'><em>No hay comentarios para esta película</em></h4>");
                        out3.println("<p class='list-group-item-text'><em>Sé el primero en dejar un comentario</em></p>");
                        out3.println("</a>");
                    }
                    out3.println("</div>");
                    out3.println("</div>");
                    out3.println("<script type=\"text/javascript\" src=\"js/verpeli.js\"></script>");

                    //out3.println("<hr style='color: red' />");
                    break;

                case "getcomentarios":
                    //COMENTARIOS
                    GestorComentarios gc3 = new GestorComentarios();
                    ArrayList<Comentario> arrayComent = gc3.extraeComentarios(Integer.parseInt(request.getParameter("id")));
                    String respuesta = "";
                    //list-group-item active
                    for (int i = 0; i < arrayComent.size(); i++) {
                        Comentario comentario = arrayComent.get(arrayComent.size() - 1 - i);
                        respuesta += "<a class='list-group-item'>";
                        respuesta += "<h4 class='list-group-item-heading'>" + comentario.getTitulo() + "</h4>";
                        respuesta += "<p class='list-group-item-text'>" + comentario.getTexto() + "</p>";
                        respuesta += "</a>";
                    }
                    respuesta += "</div>";
                    respuesta += "</div>";
                    response.setContentType("text/plain");
                    response.getWriter().write(respuesta);
                    break;

                case "guarda-comentario":
                    //Usuario ucoment = (Usuario) session.getAttribute("usuario");
                    int idcoment = Integer.parseInt(request.getParameter("id"));
                    String titulocoment = request.getParameter("titulo");
                    String comentrariocoment = request.getParameter("comentario");
                    Comentario coment = new Comentario(-1, u.getId(), idcoment, titulocoment, comentrariocoment);

                    GestorComentarios gc2 = new GestorComentarios();
                    gc2.guardaComentario(coment);
                    response.setContentType("text/plain");
                    response.getWriter().write("ok");
                    break;

                case "estado-pelicula":
                    //Usuario uep = (Usuario) session.getAttribute("usuario");
                    //GestorVistas gv = new GestorVistas();
                    //GestorPorVer gpv = new GestorPorVer();
                    int idpeli = Integer.parseInt(request.getParameter("id"));
                    String rep = "0";
                    for (Visto visto : (ArrayList<Visto>) gv.extraeVistas(u.getId())) {
                        if (visto.getIdpelicula() == idpeli) {
                            rep = "1";
                        }
                    }
                    for (PorVer porver : (ArrayList<PorVer>) gpv.extraePorVer(u.getId())) {
                        if (porver.getIdpelicula() == idpeli) {
                            rep = "2";
                        }
                    }
                    response.setContentType("text/plain");
                    response.getWriter().write(rep);
                    break;

                case "cambia-estado":
                    //GestorVistas gvce = new GestorVistas();
                    GestorPorVer gpvce = new GestorPorVer();

                    //Usuario uce = (Usuario) session.getAttribute("usuario");
                    int idpeliculace = Integer.parseInt(request.getParameter("idpelicula"));
                    int estadoce = Integer.parseInt(request.getParameter("estado"));
                    int pulsadoce = Integer.parseInt(request.getParameter("pulsado"));

                    if (estadoce == 1) {
                        //Si esta en visto se borra
                        gv.eliminaVisto(u.getId(), idpeliculace);
                    } else if (estadoce == 2) {
                        //Si esta en por ver se borra
                        gpvce.eliminaPorVer(u.getId(), idpeliculace);
                    }

                    if (pulsadoce == 1) {
                        //Si ha marcado visto se guarda
                        gv.guardaVisto(new Visto(u.getId(), idpeliculace));
                    } else if (pulsadoce == 2) {
                        //Si ha marcado por ver se guarda
                        gpvce.guardaPorVer(new PorVer(u.getId(), idpeliculace));
                    }

                    break;
                case "getvisto":                    
                    ArrayList<Visto> vistas = gv.extraeVistas(u.getId());
                    ArrayList<Pelicula> pelisVistas = new ArrayList<>();
                    for (int i=0; i<vistas.size(); i++){
                        pelisVistas.add(gp.getPeliculaPorId(vistas.get(i).getIdpelicula()));
                    }                    
                                       
                    response.setContentType("text/html; charset=iso-8859-1");
                    PrintWriter out = response.getWriter();
                                        
                    for (int j = 0; j < pelisVistas.size(); j++) {
                        Pelicula peli = pelisVistas.get(j);
                        if (j % 4 == 0) {
                            out.println("<div class='row'>");
                        }
                        out.println("<div class='col-sm-3'>");
                        out.println("<div class='thumbnail'>");
                        out.println("<img src='" + peli.getRuta() + "'  class='img-responsive'>");
                        out.println("<div class='caption'>");
                        out.println("<h3>" + peli.getTitulo() + "</h3>");
                        out.println("<p>" + peli.getGenero() + "</p>");
                        out.println("<input type='hidden' name=idpeli value=" + peli.getId() + " class='accesopeli'>");
                        out.println("<a  id=" + peli.getId() + " class='accesopeli btn btn-primary'>Ver Detalles</a>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        if (j % 4 == 3) {
                            out.println("</div>");
                        }
                    }                    
                    break;
                    
                case "getporver":
                            System.out.println("porver");
                            //GestorPorVer gpv = new GestorPorVer();
                            //Usuario u = (Usuario) session.getAttribute("usuario");  
                            ArrayList<PorVer> arrayPorVer = gpv.extraePorVer(u.getId());
                            //GestorPeliculas gp5 = new GestorPeliculas();
                            response.setContentType("text/html; charset=iso-8859-1");
                            PrintWriter out4 = response.getWriter();
                            
                          
                            for (int i = 0; i < arrayPorVer.size(); i++) {
                                PorVer porver = arrayPorVer.get(i);
                                Pelicula peli = gp.getPeliculaPorId(porver.getIdpelicula());
                                if(i%4==0) out4.println("<div class='row'>");
                                out4.println("<div class='col-xs-3'>");
                                out4.println("<div class='thumbnail'>");
                                out4.println("<img src='" + peli.getRuta() + "' style='img-responsive' >");
                                out4.println("<div class='caption'>");
                                out4.println("<h3>" + peli.getTitulo() + "</h3>");
                                out4.println("<p>" + peli.getGenero() + "</p>");
                                out4.println("<input type='hidden' name=idpeli value=" + peli.getId() + ">");
                                out4.println("<a  id=" + peli.getId() + " class='accesopeli btn btn-primary'>Ver Detalles</a>");
                                out4.println("</div>");
                                out4.println("</div>");
                                out4.println("</div>");
                                if(i%4==3) out4.println("</div>");
                            }
                           
                            break;

                default:
                    System.out.println("default");
                    response.sendRedirect("./index.jsp");
            }

        } else {
            //System.out.println("aqui");
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
