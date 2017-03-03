/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author mario
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            response.sendRedirect("./login.jsp");
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

        String accion = request.getParameter("accion");
        if (accion != null) {
            GestorUsuarios gu = new GestorUsuarios();
            Usuario u;
            switch (accion) {
                case "existe_apodo":
                    String apodo = request.getParameter("apodo").trim();                    
                    u = gu.getUsuarioPorApodo(apodo);
                    if (u != null) {
                        System.out.println(u.getId() + " " + u.getApodo() + " " + u.getNombre() + " " + u.getApellidos() + " " + u.getContraseña() + " " + u.getTipo());
                    }
                    if (u != null && u.getApodo().equals(apodo)) {
                        String r = "yes";
                        response.setContentType("text/plain");
                        response.getWriter().write(r);
                    } else {
                        String r = "no";
                        response.setContentType("text/plain");
                        response.getWriter().write(r);
                    }
                    break;
                case "login_submit":                   
                    String l_apodo = request.getParameter("apodo").trim();
                    String l_pass = request.getParameter("pass").trim();
                    u = gu.getUsuarioPorApodo(l_apodo);                    
                    //Si no esta en la base de datos o las contraseñas no son iguales
                    if(u==null || !u.getContraseña().equals(l_pass)){ 
                       String r = "no";
                       response.setContentType("text/plain");
                       response.getWriter().write(r); 
                    }else{
                        System.out.println("redirige");
                        String r = "yes";
                        response.setContentType("text/plain");
                        response.getWriter().write(r);                         
                    }
                    break;
                default:
                    response.sendRedirect("./login.jsp");
            }
        } else {
            response.sendRedirect("./login.jsp");
        }
        /*
        if(request.getParameter("apodo")!= null){
            String apodo = request.getParameter("apodo").trim();
            GestorUsuarios gu = new GestorUsuarios();
            Usuario u = gu.getUsuarioPorApodo(apodo);
            if (u!=null) {
                System.out.println(u.getId()+" "+u.getApodo()+" "+u.getNombre()+" "+u.getApellidos()+" "+u.getContraseña()+" "+u.getTipo());
            }
            if (u!=null && u.getApodo().equals(apodo)){
                String r = "yes";
                response.setContentType("text/plain");
                response.getWriter().write(r);
            }else{
                String r = "no";
                response.setContentType("text/plain");
                response.getWriter().write(r);
            }            
        }else{
             response.sendRedirect("./login.jsp");
        }
        */
        
        //processRequest(request, response);
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
        // Set response content type
        
        String accion = request.getParameter("accion").trim();
        switch(accion){
            case "login":
                HttpSession session = request.getSession();
                //session.setAttribute("id", id);
               
                System.out.println(accion);
                break;
            case "registro":
                System.out.println(accion);
                String apodo = request.getParameter("apodo").trim();
                String pass = request.getParameter("password").trim();
                String nombre = request.getParameter("nombre").trim();
                String apellidos = request.getParameter("apellidos").trim();
                
                break;
            default: 
                response.sendRedirect("./login.jsp");
        }
        
        
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//        String title = "Using GET Method to Read Form Data";
//
//        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
//                + "transitional//en\">\n";
//        Usuario u = new Usuario(-1,"mate","Mario","Matesanz","marmate",0);
//        GestorUsuarios gu = new GestorUsuarios();
//        gu.guardaUsuario(u);
//        out.println(docType + "<html>\n"
//                + "<head><title>" + title + "</title></head>\n"
//                + "<body bgcolor=\"#f0f0f0\">\n"
//                + "<h1 align=\"center\">" + title + "</h1>\n"
//                + "<ul>\n"
//                + "  <li><b>Email</b>: "
//                + request.getParameter("email") + "\n"
//                + "  <li><b>Password</b>: "
//                + request.getParameter("password") + "\n"
//                + "  <li><b>Objeto</b>: "
//                + u.getApodo() + "\n"
//                + "</ul>\n"
//                + "</body></html>");
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
