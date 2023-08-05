<%-- 
    Document   : FormCadastro
    Created on : Jun 14, 2022, 10:39:45 PM
    Author     : V_Muianga
--%>
<%@page import="Model.Realiza"%>
<%@page import="Dao.RealizaDao"%>
<%/**
     * +258 para contactos (tentar apicar)
     */
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>

<%
    RealizaDao realizaDao = new RealizaDao();
    List<Realiza> resultado = realizaDao.listar();
    /*for(int i=0;i<resultado.size();i++){
     
     out.println(resultado.get(i).getNumeroMatricula());
     out.println(resultado.get(i).getNome());
     out.println(resultado.get(i).getApelido());
     out.println(resultado.get(i).getEndereco());
     out.println(resultado.get(i).getContacto());
     
     
     }*/
%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Gestão de Estudantes web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="img/favicon2.png" type="image/x-icon" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
   
    </head>

    <body class="p-3 text-light bg-dark">

        <div class="container">
            <form action="cadastroR " class="container">
                <div class="btn-group p-4">

                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-lg" name="Cadastro" style="margin-right: 20em;">Cadastrar</button>
                    </div>

                    <div class="col-4">
                        <a class="btn btn-primary btn-lg" href="index.html">Home</a>
                    </div>
                </div>
            </form>
            <h1 class="">Notas</h1> 
            <table class="table p-3 text-light table-bordered ">

                <thead>
                    <tr class="">
                        <th>Codigo de Estudante</th>

                        <th scope="col">Codigo da Disciplina</th>

                        <th scope="col">Codigo da Avaliação</th>

                        <th scope="col">Nota</th>

                        <th scope="col">Operações</th>
                    </tr>
                </thead>

                <tbody>

                    <% for (int i = 0; i < resultado.size(); i++) {%>

                    <tr>
                        <td><%=resultado.get(i).getNumeroMatricula()%></td>

                        <td><%=resultado.get(i).getCodigoDisciplina()%></td>

                        <td><%=resultado.get(i).getCodigoAvalicao()%></td>

                        <td><%=resultado.get(i).getNota()%></td>

                        <td><!--<form action="editar">-->
                            <div style="margin: 0 15px;" class="center" >
                                <a style="margin-right: 5px;" href="BuscarR?codigoEstudante=<%=resultado.get(i).getNumeroMatricula()%> codigoAvaliacao=<%=resultado.get(i).getCodigoAvalicao()%>" class="btn btn-primary">Editar</a>
                                <!--btn para apagar-->
                                <a href="javascript: confirmarR(<%=resultado.get(i).getNumeroMatricula()%>)" class="btn btn-danger" >Apagar</a>
                                <!-- </form>-->
                            </div>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <br>
            <br>
            <footer style="padding-top:15em;" class="text-ligth ">
                <h6><script>var data = new Date();
                    document.write(data);</script></h3>
            </footer>
        </div>


        <script src="validaEstudante.js"></script> 
    </body>
</html>
