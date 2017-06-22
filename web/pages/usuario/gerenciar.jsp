<%-- PAGES/USUARIO/GERENCIAR.JSP --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="area" value="Admin"/>

<%@include file="/header.jsp" %>

<!-- DataTables CSS -->
<link href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Usuários - Gerenciar</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-10">
        
        <c:if test="${status=='0'}"><div class="alert alert-danger">${msg}</div></c:if>
        <c:if test="${status=='1'}"><div class="alert alert-success">${msg}</div></c:if>

        <div id="BoxDesativa" class="alert alert-info" style="display: none">Usuário DESATIVADO com sucesso</div>
        <div id="BoxAtiva" class="alert alert-info" style="display: none">Usuário ATIVADO com sucesso</div> 

        <div class="dataTable_wrapper">
            <table class="table table-striped table-bordered table-hover" id="tableUsuarios">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Perfil</th>
                        <th>Email</th>
                        <th>Situação</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>


                    <c:forEach var="usuario" items="${usuarios}">
                        <c:if test="${usuario.situacao}">
                            <c:set var="Situacao" value="Ativo"/>
                            <c:set var="Acao" value="Desativar"/>
                            <c:set var="BotaoClasse" value="glyphicon-ok"/>
                        </c:if>
                        <c:if test="${ not usuario.situacao}">
                            <c:set var="Situacao" value="Inativo"/>
                            <c:set var="Acao" value="Ativar"/>
                            <c:set var="BotaoClasse" value="glyphicon-remove"/>
                        </c:if>  
                        <tr class="odd gradeA">
                            <td>${usuario.nome}</td>
                            <td>${usuario.perfil}</td>
                            <td>${usuario.email}</td>
                            <td align="center">
                                <a href="#"><span title='Este usuário está ${Situacao}. Clique para ${Acao}' class="glyphicon ${BotaoClasse} icon-delete" pessoaId="${usuario.id}" aria-hidden="true"></span></a>
                            </td>
                            <td class="CelOpcoes" align="center">
                                <a href="Controle?logica=Usuario.Cadastrar&op=editar&pId=${usuario.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                            </td>
                        </tr>

                    </c:forEach>


                </tbody>
            </table>
        </div>

    </div>
</div>

<style>
    #BoxAtiva, #BoxDesativa {
        position: fixed;
        top: 45%;
        left: 50%;
        margin-left: -150px;
        width: 300px;
        z-index: 9999;
    }
</style>


<script src="bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script>
    $(document).ready(function () {

        var table = $('#tableUsuarios');
        table.DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.10/i18n/Portuguese-Brasil.json"
            },
            responsive: true,
            columnDefs: [{orderable: false, targets: [4]}]
        });
        var boxativa = $('#BoxAtiva');
        var boxdesativa = $('#BoxDesativa');
        $('#tableUsuarios tbody').on('click', 'span.icon-delete', function () {
            var botao = $(this);
            var pessoaId = botao.attr("pessoaId");

            if (botao.hasClass("glyphicon-remove")) {
                msg = "Alterar situação do usuário para ATIVO?";
                box = boxativa;
            }
            else {
                msg = "Alterar situação do usuário para INATIVO?";
                box = boxdesativa;
            }


            if (confirm(msg)) {

                $.ajaxSetup({
                    cache: false
                });


                $.get("Controle?logica=Usuario.Situacao&pId=" + pessoaId, function () {

                })
                        .done(function () {
                            box.show().fadeOut(3000);
                            botao.toggleClass("glyphicon-remove").toggleClass("glyphicon-ok");
                        })
                        .fail(function () {
                            alert("Ocorreu um erro ao tentar alterar a situação");
                        })

            }
        });
    });
    function alternaSituacao(pId) {
        $.ajax({
            method: 'GET',
            dataType: "json",
            url: "Controle",
            data: {
                logica: "UsuarioSituacao",
                pId: pId
            },
            success: function (data) {
                boxativa.show().fadeOut(3000);
                botao.toggleClass("glyphicon-remove").toggleClass("glyphicon-ok");
            }
        });
    }
</script>   

<%@include file="/footer.jsp" %> 