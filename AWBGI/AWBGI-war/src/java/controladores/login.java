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
                    String l_pass  = request.getParameter("pass").trim();
                    u = gu.getUsuarioPorApodo(l_apodo);                    
                    
                    //Si no esta en la base de datos o las contraseñas no son iguales
                    if(u==null || !u.getContraseña().equals(l_pass)){ 
                       String r = "no";
                       response.setContentType("text/plain");
                       response.getWriter().write(r); 
                    }else{
                        HttpSession session = request.getSession();
                        session.setAttribute("auth", true);
                        session.setAttribute("usuario", u);
                        String r = "yes";
                        response.setContentType("text/plain");
                        response.getWriter().write(r);                         
                    }
                    break;
                    
                case "registro_submit":  
                    System.out.println("entra aqui");
                    String r_apodo = request.getParameter("apodo").trim();
                    String r_pass1 = request.getParameter("pass1").trim();
                    String r_pass2 = request.getParameter("pass2").trim();
                    String r_nombre = request.getParameter("nombre").trim();
                    String r_apellidos = request.getParameter("apellidos").trim();
                    u = gu.getUsuarioPorApodo(r_apodo);
                    
                    if(!r_pass1.equals(r_pass2) && u!=null){
                        String r = "3";
                        response.setContentType("text/plain");
                        response.getWriter().write(r);
                    }else if(u!=null){
                        String r = "2";
                        response.setContentType("text/plain");
                        response.getWriter().write(r);
                    }else if(!r_pass1.equals(r_pass2)){
                        String r = "1";
                        response.setContentType("text/plain");
                        response.getWriter().write(r);
                    }else{
                        Usuario r_usuario = new Usuario(-1,r_apodo,r_nombre,r_apellidos,r_pass1,0);
                        gu.guardaUsuario(r_usuario);
                        HttpSession session = request.getSession();
                        session.setAttribute("auth", true);
                        session.setAttribute("usuario", r_usuario);
                        String r = "0";
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
