/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validar(){
    
    var nome=formEstudante.nome.value;
            
    var apelido=formEstudante.apelido.value;
            
    var endereco=formEstudante.endereco.value;
            
    var codigoEstudante=formEstudante.codigoEstudante.value;
            
    var contacto=formEstudante.contacto.value;
            
    if(nome === ""){
        alert("Preencha o campo nome");
        //formEstudante.nome.focus();
        return false;
    }else if(apelido ===""){
        alert("Preencha o campo apelido");
        //formEstudante.apelido.focus();
        return false;
    }else if(endereco ===""){
        alert("Preencha o campo endereco");
        //formEstudante.endereco.focus();
        return false;
    }else if(codigoEstudante ===""){
        alert("Preencha o campo codigoEstudante");
        //formEstudante.codigoEstudante.focus();
        return false;
    }else if(contacto ===""){
        alert("Preencha o campo contacto");
        // formEstudante.contacto.focus();
        return false;
    }else{
        document.forms["formEstudante"].submit();
    }       
}

function salvo(){
    
    alert("Adicionado com Sucesso!!");
}
function updade(){
    alert("Atualizado com Sucesso!! ");
}
function remove(){
    alert("Removido com Sucesso!! ");
}

//confirmar delete

function confirmar(codigoEstudante){
    
    var resposta = confirm("Confirma a exclusão ?");
    
    if(resposta === true){
       
        //alert(codigoEstudante);
        window.location.href = "delete?codigoEstudante="+codigoEstudante;
    }
}

function confirmarR(codigoEstudante){
    
    var resposta = confirm("Confirma a exclusão ?");
    
    if(resposta === true){
       
        //alert(codigoEstudante);
        window.location.href = "deleteR?codigoEstudante="+codigoEstudante;
    }
}

function confirmarD(codigo){
    
    var resposta = confirm("Confirma a exclusão ?");
    
    if(resposta === true){
       
        //alert(codigoEstudante);
        window.location.href = "apagar?codigo="+codigo;
    }
}

function data(){
    
    var now = new Date();
    //alert( now );
}