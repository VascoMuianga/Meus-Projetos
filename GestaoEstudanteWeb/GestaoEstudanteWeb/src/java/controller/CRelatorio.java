 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.RealizaDao;

import Model.Realiza;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author V_Muianga
 */

@WebServlet(urlPatterns = {"/controllerRe","/relatorio" , "/dispensado","/aprovado","/excluido","/melhor","/pior"})
public class CRelatorio extends HttpServlet {
    
    static Realiza realiza = new Realiza ();
    static RealizaDao realizaDao=new RealizaDao();
    
    
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
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String action = request.getServletPath();
                
                if(action.equals("/dispensado")){
                
                    Formdispensa(request,response);
                }else if(action.equals("/aprovado")){
                
                    Formaprovado(request,response);
                }else if(action.equals("/excluir")){
                
                    formexcluido(request, response);
                }else if(action.equals("/melhor")){
                
                    formelhor(request, response);
                }else if(action.equals("/pior")){
                
                    formpior(request, response);
                }else{
                    
                    response.sendRedirect("index.html");
                }
  
    }
    
    ///pagina de FormEstudanteLista
    protected void Formdispensa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.sendRedirect("FormListarRealiza.jsp"); 
 
    }
    
    //pagina cadastro
    protected void Formaprovado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("Cadastro") !=null){
            response.sendRedirect("FormCadastroRealiza.jsp");
        }
     
    }
    //Listar dados
   
    protected void formexcluido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        
    }
    
    ///CadastroEstudante
    protected void formelhor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }
    
    //Buscar estudante
    protected void formpior(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
