 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.DisciplinaDao;
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

@WebServlet(urlPatterns = {"/controllerD", "/mainD", "/insertD","/cadastroD","/BuscarD","/editarD","/apagar"})
public class CDisciplina extends HttpServlet {
    
    static Disciplina disciplina=new Disciplina();
    static DisciplinaDao disciplinaDao=new DisciplinaDao();
    
    
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
                if(action.equals("/mainD")){
                
                    FormDisciplina(request, response);
                }else if(action.equals("/insertD")){
                
                    inserirEstudante(request,response);
                }else if(action.equals("/cadastroD")){
                
                    FormC(request,response);
                }else if(action.equals("/BuscarD")){
                
                    buscar(request, response);
                }else if(action.equals("/editarD")){
                
                    Editar(request, response);
                }else if(action.equals("/apagar")){
                
                    remover(request, response);
                }else{
                    
                    response.sendRedirect("index.html");
                }
  
    }
    
    ///pagina de FormEstudanteLista
    protected void FormDisciplina(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.sendRedirect("FormListarDisciplina.jsp"); 
 
    }
    
    //pagina cadastro
    protected void FormC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("Cadastro") !=null){
            response.sendRedirect("FormDisciplina.jsp");
        }
     
    }
    //Listar dados
   
    protected void ListarDado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        List<Disciplina> resultado= disciplinaDao.listar();
        //Encaminhar a lista ao documento FormLista.jsp
        request.setAttribute("ListarDado", resultado);
        RequestDispatcher rd=request.getRequestDispatcher("FormListarDisciplina.jsp");
        rd.forward(request, response);
    }
    
    ///CadastroEstudante
    protected void inserirEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperar dados
        if(request.getParameter("guardar") != null){
            
            disciplina.setNome(request.getParameter("nome"));
            disciplina.setCodigoDisciplina(request.getParameter("codigo"));
            disciplina.setCargaHoraria(Integer.parseInt(request.getParameter("cargaH")));
            
            disciplinaDao.salvar(disciplina);
            
            RequestDispatcher rd = request.getRequestDispatcher("FormListarDisciplina.jsp");
            rd.forward(request, response);       
        
        }else if(request.getParameter("voltar") != null){
            
            FormDisciplina(request, response);
        } 
    }
    
    //Buscar estudante
    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //receber id 
        //if(request.getParameter("Editar") != null){
        String id=request.getParameter("codigo");
        out.print(id);
        out.print("Buscar/editar/disicplina");
        List<Disciplina> resultado=(List<Disciplina>) disciplinaDao.buscarOutroD(id);
        for(int i=0;i<resultado.size();i++){
               //out.println(resultado.get(i).getCodigoDisciplina());
               // out.println(resultado.get(i).getNome());
               // out.println(resultado.get(i).getCargaHoraria());
            
            //setar os dados da disciplina no formulario
            request.setAttribute("codigo", resultado.get(i).getCodigoDisciplina());
            request.setAttribute("nome", resultado.get(i).getNome());
            request.setAttribute("cargaH", resultado.get(i).getCargaHoraria());
            
        }
        //encaminhar ao doc editar jsp
        RequestDispatcher rd = request.getRequestDispatcher("FormEditaDisciplina.jsp");
        rd.forward(request, response);
    }
    
    //Editar
    protected void Editar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        if(request.getParameter("Editar") != null){
            
            disciplina.setNome(request.getParameter("nome"));
            disciplina.setCodigoDisciplina(request.getParameter("codigo"));
            disciplina.setCargaHoraria(Integer.parseInt(request.getParameter("cargaH")));
            
            disciplinaDao.editar(disciplina);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
            
            RequestDispatcher rd = request.getRequestDispatcher("FormListarDisciplina.jsp");
            rd.forward(request, response);
        }else if(request.getParameter("voltar") != null){
            
            FormDisciplina(request, response);
        } 
    
    }
    
    //Apaga
    protected void remover(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //recebimento de id
        String id=request.getParameter("codigo");
        out.print(id);
        out.print("Buscar/editar/disicplina");
        List<Disciplina> resultado=(List<Disciplina>) disciplinaDao.buscarOutroD(id);
        
        for(int i=0;i<resultado.size();i++){
            
            out.println(resultado.get(i).getCodigoDisciplina());
            out.println(resultado.get(i).getNome());
            out.println(resultado.get(i).getCargaHoraria());
            
            disciplina.setCodigoDisciplina(resultado.get(i).getCodigoDisciplina());
            disciplina.setNome(resultado.get(i).getNome());
            disciplina.setCargaHoraria(resultado.get(i).getCargaHoraria());
            
            disciplinaDao.apagar(disciplina);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
        }  
            RequestDispatcher rd = request.getRequestDispatcher("FormListarDisciplina.jsp");
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
