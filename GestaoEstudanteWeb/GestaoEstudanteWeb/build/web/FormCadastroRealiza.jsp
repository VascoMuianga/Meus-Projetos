<%-- 
    Document   : FormCadastro
    Created on : Jun 14, 2022, 10:39:45 PM
    Author     : V_Muianga
--%>
<%@page import="Model.Avaliacao"%>
<%@page import="Dao.AvaliacaoDao"%>
<%@page import="Model.Disciplina"%>
<%@page import="Dao.DisciplinaDao"%>
<%@page import="Dao.EstudanteDao"%>
<%@page import="Model.Estudante"%>
<%@page import="Model.Realiza"%>
<%@page import="Dao.RealizaDao"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>

<%
    RealizaDao realizaDao = new RealizaDao();
    EstudanteDao estudanteDao = new EstudanteDao();
    List<Estudante> resultado = estudanteDao.listar();
    ///////////////
    DisciplinaDao disciplinaDao = new DisciplinaDao();
    List<Disciplina> resultadoD = disciplinaDao.listar();
    ///////////////////////////////
    AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
    List<Avaliacao> resultadoA = avaliacaoDao.listar();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="FormCadastroRealiza.jsp"></a>
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
        <legend>Atribuir nota</legend>

        <form name="formRealiza" action="insertR" method="GET" class="row g-3">

            <div class="col-md-6">
                <label  class="form-label">Codigo do Estudante</label>
                <select class="form-select form-select" aria-label=".form-select-sm example" name="codigoEstudante">
                    <option selected>codigo dos estudantes cadastrados</option>
                    <% for (int i = 0; i < resultado.size(); i++) {%>

                    <option value="<%=resultado.get(i).getNumeroMatricula()%>"><%=resultado.get(i).getNumeroMatricula()%></option>

                    <%}%>
                </select>
            </div>



            <div class="col-md-6">
                <label  class="form-label">Codigo da Disciplina</label>
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="codigoDisciplina">
                    <option selected>codigo das disciplinas cadastradas</option>
                    <% for (int j = 0; j < resultadoD.size(); j++) {%>

                    <option value="<%=resultadoD.get(j).getCodigoDisciplina()%>"><%=resultadoD.get(j).getCodigoDisciplina()%></option>
                    <%}%>
                </select>
            </div>



            <div class="col-md-6">
                <label  class="form-label">Codigo da Avaliação</label>
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="codigoAvaliacao">
                    <option selected>codigo das avaliações cadastradas</option>
                    <% for (int a = 0; a < resultadoA.size(); a++) {%>
                    <option value="<%=resultadoA.get(a).getCodigoAvaliacao()%>"><%=resultadoA.get(a).getCodigoAvaliacao()%></option>
                    <%}%>
                </select>
            </div>

            <div class="col-md-6">
                <label  class="form-label">Nota</label>
                <input type="text" class="form-control"  placeholder="codigo de estudante" name="nota" >
            </div>
            <div class="btn-group p-4">

                <div class="col-4">
                    <button type="submit" class="btn btn-primary" onclick="validar()" name="guardar">Cadastrar</button>
                </div>

                <div class="">
                    <button type="submit" class="btn btn-primary"  name="voltar">Votar</button>
                </div>
            </div>
        </form>
    </fildeset>

    <script src="validaEstudante.js"></script> 
</body>
</html>
