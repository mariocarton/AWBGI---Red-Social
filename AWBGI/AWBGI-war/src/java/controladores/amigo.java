/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorAmigos;
import datos.GestorPeliculas;
import datos.GestorPorVer;
import datos.GestorUsuarios;
import datos.GestorVistas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Amigo;
import modelo.PorVer;
import modelo.Usuario;
import modelo.Visto;

/**
 *
 * @author mariomatesanz
 */
@WebServlet(name = "amigo", urlPatterns = {"/amigo"})
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
        
        HttpSession session = request.getSession();
        String accion = request.getParameter("accion");
        
        GestorAmigos ga = new GestorAmigos();
        GestorUsuarios gu = new GestorUsuarios();
        GestorPorVer gpv = new GestorPorVer();
        GestorVistas gv = new GestorVistas();
        GestorPeliculas gp = new GestorPeliculas();
        Usuario u = (Usuario) session.getAttribute("usuario");

        PrintWriter out = response.getWriter();

        if (accion != null) {

            switch (accion) {

                case "guardaamigo":
                    response.setContentType("text/html; charset=iso-8859-1");
                    String idaux = request.getParameter("id").trim();
                    int id = Integer.parseInt(idaux);
                    ga.guardaAmistad(id, id);
                    break;

                case "extraeamigos":
                    response.setContentType("text/html; charset=iso-8859-1");
                    ArrayList<Amigo> arrayAmigos = ga.extraeAmigos(u.getId());
                    
                    for (int j = 0; j < arrayAmigos.size(); j++) {
                        Amigo amigo = arrayAmigos.get(j);
                        Usuario uamigo = gu.getUsuarioPorId(amigo.getIdamigo());
                        if (j % 4 == 0) {
                            out.println("<div class='row'>");
                        }
                        out.println("<div class='col-sm-3'>");
                        out.println("<div class='thumbnail'>");
                        out.println("<img src='imagenes/user.svg'  class='img-responsive'>");
                        out.println("<div class='caption'>");
                        out.println("<h3>" + uamigo.getNombre() + " " + uamigo.getApellidos() + "</h3>");
                        out.println("<p>Vistas "+gv.extraeVistas(uamigo.getId()).size()+"</p>");
                        out.println("<p>Por Ver "+gpv.extraePorVer(uamigo.getId()).size()+"</p>");
                        out.println("<div style='text-align:center'>");
                        out.println("<a id=" + uamigo.getId() + " class='verdetalles btn btn-success' style='margin: 4px; width: 100%'>Ver detalles</a>");
                        out.println("<a id=" + uamigo.getId() + " class='eliminaamigo btn btn-danger' style='margin: 4px; width: 100%'>Eliminar amigo</a>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        if (j % 4 == 3) {
                            out.println("</div>");
                        }
                    }
                    if(arrayAmigos.isEmpty()){
                        out.println("<div class='row'>");
                        out.println("<p><em>No tienes amigos, explora usuarios para hacer amigos</em></p>");
                        out.println("</div>");
                    }
                    break;

                case "extraenoamigos":
                    response.setContentType("text/html; charset=iso-8859-1");
                    ArrayList<Amigo> amigos = ga.extraeAmigos(u.getId());
                    GestorUsuarios guena = new GestorUsuarios();

                    ArrayList<Usuario> usuarios = guena.getAllUsuarios();
                    ArrayList<Usuario> noamigos = new ArrayList<>();

                    for (Usuario usuario : usuarios) {
                        if (!amigos.isEmpty()) {
                            boolean esta = false;
                            for (Amigo amigo : amigos) {
                                if (usuario.getId() == amigo.getIdamigo()) {
                                    esta=true;
                                }
                            }
                            if(!esta && usuario.getId() != u.getId()){
                                noamigos.add(usuario);
                            }
                        } else if (usuario.getId()!= u.getId()) {
                            noamigos.add(usuario);
                        }
                    }

                    for (int j = 0; j < noamigos.size(); j++) {
                        Usuario noamigo = noamigos.get(j);
                        if (j % 4 == 0) {
                            out.println("<div class='row'>");
                        }
                        out.println("<div class='col-sm-3'>");
                        out.println("<div class='thumbnail'>");
                        out.println("<img src='imagenes/user.svg'  class='img-responsive'>");
                        out.println("<div class='caption'>");
                        out.println("<h3>" + noamigo.getNombre() + " " + noamigo.getApellidos() + "</h3>");
                        out.println("<p>Vistas "+gv.extraeVistas(noamigo.getId()).size()+"</p>");
                        out.println("<p>Por Ver "+gpv.extraePorVer(noamigo.getId()).size()+"</p>");                        
                        out.println("<a id=" + noamigo.getId() + " class='addamigo btn btn-success'>Añadir como amigo</a>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        if (j % 4 == 3) {
                            out.println("</div>");
                        }
                    }
                    if(noamigos.isEmpty()){
                        out.println("<div class='row'>");
                        out.println("<p><em>No hay usuarios de los que ser amigo</em></p>");
                        out.println("</div>");
                    }
                    break;
                 
                case "eliminaamigo":
                    int idamigo = Integer.parseInt(request.getParameter("id"));
                    ga.eliminaAmistad(u.getId(), idamigo);
                    break;
                
                case "addamigo":
                    int idamigo2 = Integer.parseInt(request.getParameter("id"));
                    ga.guardaAmistad(u.getId(), idamigo2);
                    break;
                
                case "detallesamigo":
                    int idamigoda = Integer.parseInt(request.getParameter("id"));
                    Usuario amigo = gu.getUsuarioPorId(idamigoda);
                    ArrayList<Visto> vistasamigo = gv.extraeVistas(idamigoda);
                    ArrayList<PorVer> porveramigo = gpv.extraePorVer(idamigoda);
                    
                    out.println("<h2>Películas de "+amigo.getNombre()+" "+amigo.getApellidos()+"</h2>"+
                            "<div class='row' style='padding: 20px;'>"+
                            "<h4>Películas Vistas</h4>"+
                            "<ul class='list-group'>");
                    for(Visto pelicula: vistasamigo){
                        out.println("<li class='list-group-item'>"+gp.getPeliculaPorId(pelicula.getIdpelicula()).getTitulo()+"<a href='"+pelicula.getIdpelicula()+"' class='accesopeli btn-xs btn-primary' style='float:right'>Ver detalles</a></li>");
                    }                    
                    out.println("</ul>"+
                            "<h4>Películas Vistas</h4>"+
                            "<ul class='list-group'>");
                    
                    for(PorVer pelicula: porveramigo){
                        out.println("<li class='list-group-item'>"+gp.getPeliculaPorId(pelicula.getIdpelicula()).getTitulo()+"<a href='"+pelicula.getIdpelicula()+"' class='accesopeli btn-xs btn-primary' style='float:right'>Ver detalles</a></li>");
                    }                    
                    out.println("</ul></div>");  
                    break;
                    
                default:
                    System.out.println("default");
                    response.sendRedirect("./index.jsp");
            }

        } else {           
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
