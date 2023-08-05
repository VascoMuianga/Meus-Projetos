 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.EstudanteDao;
import Model.Estudante;
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

@WebServlet(urlPatterns = {"/controller", "/main", "/insert","/cadastro","/Buscar","/editar","/delete","/nota"})
public class CEstudante extends HttpServlet {
    
    static Estudante estudante = new Estudante ();
    static EstudanteDao estudanteDao=new EstudanteDao();
    
    
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
                if(action.equals("/main")){
                
                    FormEstudante(request, response);
                }else if(action.equals("/insert")){
                
                    inserirEstudante(request,response);
                }else if(action.equals("/cadastro")){
                
                    FormC(request,response);
                }else if(action.equals("/Buscar")){
                
                    buscar(request, response);
                }else if(action.equals("/editar")){
                
                    Editar(request, response);
                }else if(action.equals("/delete")){
                
                    remover(request, response);
                }else if(action.equals("/nota")){
                
                    Formnota(request, response);
                }else{
                    
                    response.sendRedirect("index.html");
                }
  
    }
    
    ///pagina de FormEstudanteLista
    protected void FormEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.sendRedirect("FormListar.jsp"); 
 
    }
    //listar notas
    protected void Formnota(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.sendRedirect("FormNotas.jsp"); 
 
    }
    
    //pagina cadastro
    protected void FormC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("Cadastro") !=null){
            response.sendRedirect("FormCadastro.jsp");
        }
     
    }
    //Listar dados
   
    protected void ListarDado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        List<Estudante> resultado= estudanteDao.listar();
        //Encaminhar a lista ao documento FormLista.jsp
        request.setAttribute("ListarDado", resultado);
        RequestDispatcher rd=request.getRequestDispatcher("FormListar.jsp");
        rd.forward(request, response);
    }
    
    ///CadastroEstudante
    protected void inserirEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperar dados
        if(request.getParameter("guardar") != null){
            
            estudante.setNome(request.getParameter("nome"));
            estudante.setApelido(request.getParameter("apelido"));
            estudante.setEndereco(request.getParameter("endereco"));
            estudante.setNumeroMatricula(Integer.parseInt(request.getParameter("codigoEstudante")));
            estudante.setContacto(request.getParameter("contacto"));
            estudanteDao.salvar(estudante);
            //FormEstudante(request, response);
           
            RequestDispatcher rd = request.getRequestDispatcher("FormListar.jsp");
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
        out.print(id);
        out.print("Buscar/editar/vasco");
        List<Estudante> resultado=(List<Estudante>) estudanteDao.buscar(Integer.parseInt(id));
        for(int i=0;i<resultado.size();i++){
            /*    out.println(resultado.get(i).getNumeroMatricula());
                out.println(resultado.get(i).getNome());
                out.println(resultado.get(i).getApelido());
                out.println(resultado.get(i).getEndereco());
                out.println(resultado.get(i).getContacto());
            }*/
           
            //setar os dados do estudante no formulario
            request.setAttribute("codigoEstudante", resultado.get(i).getNumeroMatricula());
            request.setAttribute("nome", resultado.get(i).getNome());
            request.setAttribute("apelido", resultado.get(i).getApelido());
            request.setAttribute("endereco", resultado.get(i).getEndereco());
            request.setAttribute("contacto", resultado.get(i).getContacto());
        }
        //encaminhar ao doc editar jsp
        RequestDispatcher rd = request.getRequestDispatcher("FormEditar.jsp");
        rd.forward(request, response);
    }
    
    //Editar
    protected void Editar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        if(request.getParameter("Editar") != null){
            
            estudante.setNome(request.getParameter("nome"));
            estudante.setApelido(request.getParameter("apelido"));
            estudante.setEndereco(request.getParameter("endereco"));
            estudante.setNumeroMatricula(Integer.parseInt(request.getParameter("codigoEstudante")));
            estudante.setContacto(request.getParameter("contacto"));
            estudanteDao.editar(estudante);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
            
            RequestDispatcher rd = request.getRequestDispatcher("FormListar.jsp");
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
        List<Estudante> resultado=(List<Estudante>) estudanteDao.buscar(Integer.parseInt(id));
        
        for(int i=0;i<resultado.size();i++){
            
        
            estudante.setNome(request.getParameter("nome"));
            estudante.setApelido(request.getParameter("apelido"));
            estudante.setEndereco(request.getParameter("endereco"));
            estudante.setNumeroMatricula(Integer.parseInt(request.getParameter("codigoEstudante")));
            estudante.setContacto(request.getParameter("contacto"));
            estudanteDao.apagar(estudante);
            //FormEstudante(request, response);
            //PrintWriter imprimir=response.getWriter();
            //imprimir.println("Pessoa guardada com sucesso");  
        }  
            RequestDispatcher rd = request.getRequestDispatcher("FormListar.jsp");
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
