<%-- 
    Document   : FormDisciplina
    Created on : Jun 21, 2022, 8:24:23 AM
    Author     : V_Muianga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="FormDisciplina.jsp"></a>
<!DOCTYPE html>
<html>
    <head>
        <head
        <title>Gestão de Estudantes web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="img/favicon2.png" type="image/x-icon" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    </head>

    <body class="p-3 text-light bg-dark">
    <fildeset class="container">
        <legend>Dados da Disciplina</legend>

        <form name="formDisciplina" action="insertD" method="GET" class="row g-3">
            <div class="col-md-6">
                <label  class="form-label">Codigo da Disciplina</label>
                <input type="text" class="form-control" placeholder="insira o codigo da disciplina" name="codigo" >
            </div>

            <div class="col-md-6">
                <label  class="form-label">Nome da Disciplina</label>
                <input type="text" class="form-control"  placeholder="insira o nome da disciplina" name="nome" >
            </div>

            <div class="col-md-6">
                <label  class="form-label">Carga Horaria</label>
                <input type="text" class="form-control"  placeholder="insira a carga horaria da disciplina" name="cargaH" >
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

    <script src="validaDisciplina.js"></script> 

</body>
</html>
