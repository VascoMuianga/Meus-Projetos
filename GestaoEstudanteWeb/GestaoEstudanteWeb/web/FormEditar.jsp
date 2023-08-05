<%-- 
    Document   : FormCadastro
    Created on : Jun 14, 2022, 10:39:45 PM
    Author     : V_Muianga
--%>

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
            
            <form action="editar"  class="row g-3">
                <div class="col-md-6">
                    <label  class="form-label">Nome</label>
                    <input type="text" class="form-control"  name="nome" value="<%out.print(request.getAttribute("nome"));%>">
                </div>

                <div class="col-md-6">
                    <label  class="form-label">Apelido</label>
                    <input type="text" class="form-control"  name="apelido" value="<%out.print(request.getAttribute("apelido"));%>">
                </div>

                <div class="col-md-6">
                    <label  class="form-label">Endereço</label>
                    <input type="text" class="form-control"  name="endereco" value="<%out.print(request.getAttribute("endereco"));%>" >
                </div>

                <div class="col-md-6">
                    <label  class="form-label">Codigo de Estudante</label>
                    <input type="text" class="form-control"  name="codigoEstudante" readonly value="<%out.print(request.getAttribute("codigoEstudante"));%>">
                </div>

                <div class="col-md-6">
                    <label for="inputCity" class="form-label">Contacto</label>
                    <input type="tel" class="form-control" name="contacto" value="<%out.print(request.getAttribute("contacto"));%>">
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
