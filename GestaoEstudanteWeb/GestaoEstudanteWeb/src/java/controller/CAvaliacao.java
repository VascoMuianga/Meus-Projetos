 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AvaliacaoDao;
import Model.Avaliacao;
import Model.Disciplina;

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

@WebServlet(urlPatterns = {"/controllerA", "/mainA", "/insertA","/cadastroA","/BuscarA","/editarA","/deleteA"})
public class CAvaliacao extends HttpServlet {
    
    static Avaliacao avaliacao=new Avaliacao();
    static AvaliacaoDao avaliacaoDao=new AvaliacaoDao();
    
    
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
                if(action.equals("/mainA")){
                
                    FormAvaliacao(request, response);
                }else if(action.equals("/insertA")){
                
                    inserirEstudante(request,response);
                }else if(action.equals("/cadastroA")){
                
                    FormC(request,response);
                }else if(action.equals("/BuscarA")){
                
                    buscar(request, response);
                }else if(action.equals("/editarA")){
                
                    Editar(request, response);
                }else if(action.equals("/deleteA")){
                
                    remover(request, response);
                }else{
                    
                    response.sendRedirect("index.html");
                }
  
    }
    
    ///pagina de FormEstudanteLista
    protected void FormAvaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.sendRedirect("FormListarAvaliacao.jsp"); 
 
    }
    
    //pagina cadastro
    protected void FormC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("Cadastro") !=null){
            response.sendRedirect("FormCadastroAvaliacao.jsp");
        }
     
    }
    //Listar dados
   
    protected void ListarDado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        List<Avaliacao> resultado= avaliacaoDao.listar();
        //Encaminhar a lista ao documento FormLista.jsp
        request.setAttribute("ListarDado", resultado);
        RequestDispatcher rd=request.getRequestDispatcher("FormListarAvaliacao.jsp");
        rd.forward(request, response);
    }
    
    ///CadastroEstudante
    protected void inserirEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperar dados
        if(request.getParameter("guardar") != null){
            
            avaliacao.setNome(request.getParameter("nome"));
            avaliacao.setCodigoAvaliacao(request.getParameter("codigo"));
                       
            avaliacaoDao.salvar(avaliacao);
            
            RequestDispatcher rd = request.getRequestDispatcher("FormListarAvaliacao.jsp");
            rd.forward(request, response);       
        
        }else if(request.getParameter("voltar") != null){
            
            FormAvaliacao(request, response);
        } 
    }
    
    //Buscar estudante
    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //receber id 
        //if(request.getParameter("Editar") != null){
        String id=request.getParameter("codigo");
        out.print(id);
        out.print("Buscar/editar/avaliacao");
        List<Avaliacao> resultado=(List<Avaliacao>) avaliacaoDao.buscarOutroA(id);
        for(int i=0;i<resultado.size();i++){
            /*    out.println(resultado.get(i).getNumeroMatricula());
                out.println(resultado.get(i).getNome());
                out.println(resultado.get(i).getApelido());
                out.println(resultado.get(i).getEndereco());
                out.println(resultado.get(i).getContacto());
            }*/
           
            //setar os dados do estudante no formulario
            request.setAttribute("codigo", resultado.get(i).getCodigoAvaliacao());
            request.setAttribute("nome", resultado.get(i).getNome());
            
            
        }
        //encaminhar ao doc editar jsp
        RequestDispatcher rd = request.getRequestDispatcher("FormEditaAvaliacao.jsp");
        rd.forward(request, response);
    }
    
    //Editar
    protected void Editar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        if(request.getParameter("Editar") != null){
            
            avaliacao.setNome(request.getParameter("nome"));
            avaliacao.setCodigoAvaliacao(request.getParameter("codigo"));
            
            
            avaliacaoDao.editar(avaliacao);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
            
            RequestDispatcher rd = request.getRequestDispatcher("FormListarAvaliacao.jsp");
            rd.forward(request, response);
        }else if(request.getParameter("voltar") != null){
            
            FormAvaliacao(request, response);
        } 
    
    }
    
    //Apaga
    protected void remover(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //recebimento de id
        String id=request.getParameter("codigo");
        List<Avaliacao> resultado=(List<Avaliacao>) avaliacaoDao.buscarOutroA(id);
        
        for(int i=0;i<resultado.size();i++){
            
        
            avaliacao.setNome(resultado.get(i).getNome());
            avaliacao.setCodigoAvaliacao(resultado.get(i).getCodigoAvaliacao());
                        
            avaliacaoDao.apagar(avaliacao);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
        }  
            RequestDispatcher rd = request.getRequestDispatcher("FormListarAvaliacao.jsp");
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
        String action = request.getServletPath();
                if(action.equals("/mainA")){
                
                    FormAvaliacao(request, response);
                }else if(action.equals("/insertA")){
                
                    inserirEstudante(request,response);
                }else if(action.equals("/cadastroA")){
                
                    FormC(request,response);
                }else if(action.equals("/BuscarA")){
                
                    buscar(request, response);
                }else if(action.equals("/editarA")){
                
                    Editar(request, response);
                }else if(action.equals("/deleteA")){
                
                    remover(request, response);
                }else{
                    
                    response.sendRedirect("index.html");
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
