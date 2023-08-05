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
import javax.swing.JOptionPane;

/**
 *
 * @author V_Muianga
 */

@WebServlet(urlPatterns = {"/controllerR", "/mainR", "/insertR","/cadastroR","/BuscarR","/editarR","/deleteR"})
public class CRealiza extends HttpServlet {
    
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
    /***
     * Instanciar as classes HibernateUtil
     * Estudante
     */
    
        
   
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
                String action = request.getServletPath();
                if(action.equals("/mainR")){
                
                    FormEstudante(request, response);
                }else if(action.equals("/insertR")){
                
                    inserirEstudante(request,response);
                }else if(action.equals("/cadastroR")){
                
                    FormC(request,response);
                }else if(action.equals("/BuscarR")){
                
                    buscar(request, response);
                }else if(action.equals("/editarR")){
                
                    Editar(request, response);
                }else if(action.equals("/deleteR")){
                
                    remover(request, response);
                }else{
                    
                    response.sendRedirect("index.html");
                }
  
    }
    
    ///pagina de FormEstudanteLista
    protected void FormEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.sendRedirect("FormListarRealiza.jsp"); 
 
    }
    
    //pagina cadastro
    protected void FormC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("Cadastro") !=null){
            response.sendRedirect("FormCadastroRealiza.jsp");
        }
     
    }
    //Listar dados
   
    protected void ListarDado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        List<Realiza> resultado= realizaDao.listar();
        //Encaminhar a lista ao documento FormLista.jsp
        request.setAttribute("ListarDado", resultado);
        RequestDispatcher rd=request.getRequestDispatcher("FormListarRealiza.jsp");
        rd.forward(request, response);
    }
    
    ///CadastroEstudante
    protected void inserirEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperar dados
        if(request.getParameter("guardar") != null){
            
            
            /*out.println(request.getParameter("codigoEstudante"));
            out.println(request.getParameter("codigoDisciplina"));
            out.println(request.getParameter("codigoAvaliacao"));
            out.println(Double.parseDouble(request.getParameter("nota")));
            */
            realiza.setNumeroMatricula(Integer.parseInt(request.getParameter("codigoEstudante")));
            realiza.setCodigoDisciplina(request.getParameter("codigoDisciplina"));
            realiza.setCodigoAvalicao(request.getParameter("codigoAvaliacao"));
            realiza.setNota(Double.parseDouble(request.getParameter("nota")));
            
            realizaDao.salvar(realiza);
            //FormEstudante(request, response);
            
            RequestDispatcher rd = request.getRequestDispatcher("FormListarRealiza.jsp");
            rd.forward(request, response);       
        
        }else if(request.getParameter("voltar") != null){
            
            FormEstudante(request, response);
        } 
    }
    
    //Buscar estudante
    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //receber id 
        //if(request.getParameter("Editar") != null){
        String id=request.getParameter("codigoEstudante");
        String cod=request.getParameter("codigoAvaliacao");
        int code=Integer.parseInt(id);
        out.print(code);
        out.print(cod);
        out.print("Buscar/editar/realiza");
        List<Realiza> resultado=(List<Realiza>) realizaDao.buscarRealiza(code,cod);
        
        for(int i=0;i<resultado.size();i++){
            
            out.print(resultado.get(i).getNumeroMatricula());
            out.print(resultado.get(i).getCodigoDisciplina());
            out.print(resultado.get(i).getCodigoAvalicao());
            out.print(resultado.get(i).getNota());
                
                
            
           
           //setar os dados do estudante no formulario
          /*  request.setAttribute("codigoEstudante", resultado.get(i).getNumeroMatricula());
            request.setAttribute("codigoDisciplina", resultado.get(i).getCodigoDisciplina());
            request.setAttribute("codigoAvaliacao", resultado.get(i).getCodigoAvalicao());
            request.setAttribute("nota", resultado.get(i).getNota());
           */
           
       }
        //encaminhar ao doc editar jsp
        //RequestDispatcher rd = request.getRequestDispatcher("FormEditaRealiza.jsp");
        //rd.forward(request, response);
    }
    
    //Editar
    protected void Editar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        if(request.getParameter("Editar") != null){
            
            realiza.setNumeroMatricula(Integer.parseInt(request.getParameter("codigoEstudante")));
            realiza.setCodigoDisciplina(request.getParameter("codigoDisciplina"));
            realiza.setCodigoAvalicao(request.getParameter("codigoAvaliacao"));
            realiza.setNota(Double.parseDouble(request.getParameter("nota")));
            
            realizaDao.editar(realiza);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
            
            RequestDispatcher rd = request.getRequestDispatcher("FormListarRealiza.jsp");
            rd.forward(request, response);
        }else if(request.getParameter("voltar") != null){
            
            FormEstudante(request, response);
        } 
    
    }
    
    //Apaga
    protected void remover(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //recebimento de id
        String id=request.getParameter("codigoEstudante");
        out.println(" id realiza apagar "+ id);
        
        List<Realiza> resultado=(List<Realiza>) realizaDao.buscarRealizar(Integer.parseInt(id));
        
        for(int i=0;i<resultado.size();i++){
            
            realiza.setNumeroMatricula(resultado.get(i).getNumeroMatricula());
            realiza.setCodigoDisciplina(resultado.get(i).getCodigoDisciplina());
            realiza.setCodigoAvalicao(resultado.get(i).getCodigoAvalicao());
            realiza.setNota(resultado.get(i).getNota());
        
            realiza.setNumeroMatricula(Integer.parseInt(request.getParameter("codigoEstudante")));
            realiza.setCodigoDisciplina(request.getParameter("codigoDisciplina"));
            realiza.setCodigoAvalicao(request.getParameter("codigoAvaliacao"));
            realiza.setNota(Double.parseDouble(request.getParameter("nota"))); 
            
            realizaDao.apagar(realiza);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
        }  
            RequestDispatcher rd = request.getRequestDispatcher("FormListarRealiza.jsp");
            rd.forward(request, response);
        
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
