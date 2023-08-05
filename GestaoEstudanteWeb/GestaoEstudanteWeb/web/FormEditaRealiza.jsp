<%-- 
    Document   : FormCadastro
    Created on : Jun 14, 2022, 10:39:45 PM
    Author     : V_Muianga
--%>
<%@page import="java.lang.System.out"%>
<%@page import="Model.Realiza"%>
<%@page import="Dao.RealizaDao"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>

<%
    RealizaDao realizaDao = new RealizaDao();
    List<Realiza> resultado = realizaDao.listar();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="FormCadastro.jsp"></a>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <title>Gestão de Estudantes web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="img/favicon2.png" type="image/x-icon" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    </head>

    <body class="p-3 text-light bg-dark">
    <fildeset class="container">
        <legend>Editar Estudante</legend>

        <form name="formRealiza" action="editarR"  class="row g-3">
            
            <div class="col-md-6">
                <label  class="form-label">Codigo do Estudante</label>
                <input type="text" class="form-control"  name="codigoEstudante" value="<%out.print(request.getAttribute("codigoEstudante"));%>"readonly>
            </div>

            <div class="col-md-6">
                <label  class="form-label">Codigo da Disciplina</label>
                <input type="text" class="form-control"  name="codigoDisciplina" value="<%out.print(request.getAttribute("codigoDisciplina"));%>"readonly>
            </div>

            <div class="col-md-6">
                <label  class="form-label">Codigo da Avaliação</label>
                <input type="text" class="form-control"  name="codigoAvaliacao" value="<%out.print(request.getAttribute("codigoAvaliacao"));%>"readonly>
            </div>
            <%}%>
            <div class="col-md-6">
                <label  class="form-label">Nota</label>
                <input type="text" class="form-control"  name="nota" >
            </div>
            
            
            
            
            <div class="btn-group p-4">

                <div class="col-4">
                    <button type="submit" class="btn btn-primary" onclick="validar()" name="Editar">Salvar</button>
                </div>

                <div class="">
                    <button type="submit" class="btn btn-primary"  name="voltar">Votar</button>
                </div>
            </div>
        </form>
    </fildeset>
    <!--<br>[
    <br>
    <section class=" pb-4 container bg-white">
        <p>Listar </p>
        
    </section>
    
    -->




    <script src="validaEstudante.js"></script> 

    <!--  
      <script >
          
          function validar(){
      
                 
          }
      </script>-->
</body>
</html>
