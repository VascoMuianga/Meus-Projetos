<%-- 
    Document   : FormCadastro
    Created on : Jun 14, 2022, 10:39:45 PM
    Author     : V_Muianga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="FormCadastroAvaliacao.jsp"></a>
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
        <legend>Dados da Avaliação</legend>

        <form name="formAvaliacao" action="insertA" method="GET" class="row g-3">
            <div class="col-md-6">
                <label  class="form-label">Codigo da Avaliação</label>
                <input type="text" class="form-control" placeholder="insira o codigo da avaliação" name="codigo" >
            </div>

            <div class="col-md-6">
                <label  class="form-label">Nome da Avaliação</label>
                <input type="text" class="form-control"  placeholder="insira o nome da avaliação" name="nome" >
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

    <script src="validaAvaliacao.js"></script> 

    
</body>
</html>
