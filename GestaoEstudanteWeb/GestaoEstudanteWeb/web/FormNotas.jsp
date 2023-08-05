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
        <div class="col-4">
            <a class="btn btn-primary btn-lg" href="index.html">Home</a>
        </div>
        <br>
        <h1 class="">Notas</h1> 
        <table class="table p-3 text-light table-bordered ">

            <thead>
                <tr class="">
                    <th>Codigo de Estudante</th>

                    <th scope="col">Codigo da Disciplina</th>

                    <th scope="col">Codigo da Avaliação</th>

                    <th scope="col">Nota</th>

                </tr>
            </thead>

            <tbody>

                <% for (int i = 0; i < resultado.size(); i++) {%>

                <tr>
                    <td><%=resultado.get(i).getNumeroMatricula()%></td>

                    <td><%=resultado.get(i).getCodigoDisciplina()%></td>

                    <td><%=resultado.get(i).getCodigoAvalicao()%></td>

                    <td><%=resultado.get(i).getNota()%></td>

                </tr>
                <%}%>
            </tbody>
        </table>
        <br>
        <br>
        <footer style="padding-top:15em;"class="text-ligth ">
            <h6><script>var data = new Date();
                    document.write(data);</script></h3>
        </footer>
    </div>


    <script src="validaRealiza.js"></script> 
</body>
</html>
