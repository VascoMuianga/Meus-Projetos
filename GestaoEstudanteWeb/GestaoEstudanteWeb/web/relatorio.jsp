<%-- 
    Document   : FormCadastro
    Created on : Jun 14, 2022, 10:39:45 PM
    Author     : V_Muianga
--%>


<%@page import="Dao.Relatorio"%>
<%@page import="java.util.List"%>
<%@page import="Dao.RelatorioDao"%>

<%/**
     * +258 para contactos (tentar aplicar)
     */
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Date" %>

<%  
    List<Relatorio> teste=RelatorioDao.calcularMedia();
    
%>
<!DOCTYPE html>
<html>
    <head>
        <<title>Gestão de Estudantes web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="img/favicon2.png" type="image/x-icon" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body class="p-3 text-light bg-dark">

        <div class="container">
            <form action="" class="container">
                <div class="btn-group p-4">
                   
                    <div class="col-4">
                        <a class="btn btn-primary btn-lg" href="index.html">Home</a>
                    </div>
                </div>
            </form>
            <h1 class="">Relatorio</h1> 
            
            <h2>Dispensados</h2>
            <table class="table p-3 text-light table-bordered ">

                <thead>
                    <tr class="">
                        <th>Codigo do Estudante</th>

                        <th scope="col">Media</th>

                        <th scope="col">Situação</th>
                    </tr>
                </thead>

                <tbody>

                    <% for (int i = 0; i <teste.size() ; i++) {%>
                    <% String situacao="Dispensado"; if(situacao.equals(teste.get(i).getSituacao())){%>
                    
                    <tr>
                        <td><%=teste.get(i).getId()%></td>

                        <td><%=teste.get(i).getMedia()%></td>

                        <td><%=teste.get(i).getSituacao()%></td>
                        
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table>
                
                
            <br>
            <br>
            
            
            <h2>Aprovados</h2>
            <table class="table p-3 text-light table-bordered ">

                <thead>
                    <tr class="">
                        <th>Codigo do Estudante</th>

                        <th scope="col">Media</th>

                        <th scope="col">Situação</th>
                    </tr>
                </thead>

                <tbody>

                    <% for (int i = 0; i <teste.size() ; i++) {%>
                    <% String situacao="Aprovado"; if(situacao.equals(teste.get(i).getSituacao())){%>
                    
                    <tr>
                        <td><%=teste.get(i).getId()%></td>

                        <td><%=teste.get(i).getMedia()%></td>

                        <td><%=teste.get(i).getSituacao()%></td>
                        
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table>
                
                <br>
                <br>
                
            <h2>Admitidos</h2>
            <table class="table p-3 text-light table-bordered ">

                <thead>
                    <tr class="">
                        <th>Codigo do Estudante</th>

                        <th scope="col">Media</th>

                        <th scope="col">Situação</th>
                    </tr>
                </thead>

                <tbody>

                    <% for (int i = 0; i <teste.size() ; i++) {%>
                    <% String situacao="Admitido"; if(situacao.equals(teste.get(i).getSituacao())){%>
                    
                    <tr>
                        <td><%=teste.get(i).getId()%></td>

                        <td><%=teste.get(i).getMedia()%></td>

                        <td><%=teste.get(i).getSituacao()%></td>
                        
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table>
                
                
                <br>
                <br>
                
            <h2>Excluidos</h2>
            <table class="table p-3 text-light table-bordered ">

                <thead>
                    <tr class="">
                        <th>Codigo do Estudante</th>

                        <th scope="col">Media</th>

                        <th scope="col">Situação</th>
                    </tr>
                </thead>

                <tbody>

                    <% for (int i = 0; i <teste.size() ; i++) {%>
                    <% String situacao="Excluido"; if(situacao.equals(teste.get(i).getSituacao())){%>
                    
                    <tr>
                        <td><%=teste.get(i).getId()%></td>

                        <td><%=teste.get(i).getMedia()%></td>

                        <td><%=teste.get(i).getSituacao()%></td>
                        
                    </tr>
                    <%}%>
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


                <script src="validaEstudante.js"></script> 
    </body>
</html>
