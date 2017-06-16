<%-- PAGES/QUESTAO/GERENCIAR.JSP --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="area" value="administrador"/>

<%@include file="/header.jsp" %>

<!-- DataTables CSS -->
<link href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Questões - Gerenciar</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-10">

        <c:if test="${status=='0'}">
            <div class="alert alert-danger">
                ${msg}
            </div>
        </c:if>
        
        <c:if test="${status=='1'}">
            <div class="alert alert-success">
                ${msg}
            </div>
        </c:if>

        <div id="BoxSucesso" class="alert alert-success" style="display: none">
            Questão removida com sucesso
        </div>
        <div id="BoxErro" class="alert alert-danger" style="display: none">
            Questão não pôde ser removida
        </div>

        <div class="dataTable_wrapper">
            <table class="table table-striped table-bordered table-hover" id="tableQuestoes">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Professor</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>


                    <c:forEach var="questao" items="${questoes}">
                        <tr class="odd gradeA">
                            <td>${questao.titulo}</td>
                            <td>${questao.professor}</td>
                            <td class="CelOpcoes" align="center">
                                <a href="Controle?logica=Questao.Cadastrar&op=editar&pId=${questao.id}">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </a>
                                <a href="Controle?logica=Casoteste.Gerenciar&op=editar&qId=${questao.id}">
                                    <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
                                </a>
                                <a href="#">
                                    <span class="glyphicon glyphicon-remove icon-delete" id="${questao.id}" aria-hidden="true"></span>
                                </a>
                            </td>
                        </tr>

                    </c:forEach>


                </tbody>
            </table>
        </div>

    </div>
</div>

<style>
    #BoxSucesso, #BoxErro {
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

        var boxsucesso = $('#BoxSucesso');
        var boxerro = $('#BoxErro');

        var table = $('#tableQuestoes');
        table.DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.10/i18n/Portuguese-Brasil.json"
            },
            responsive: true,
            columnDefs: [{orderable: false, targets: [2]}]
        });

        $('#tableQuestoes tbody').on('click', 'span.icon-delete', function () {
            var botao = $(this);
            var row = $(this).closest("tr").get(0);

            if (botao.hasClass("glyphicon-remove")) {
                if (confirm("REMOVER a questão?")) {
                    var id = botao.attr("id");
                    $.ajax({
                        method: 'POST',
                        dataType: "json",
                        url: "Controle",
                        data: {
                            logica: "Questao.Gerenciar",
                            op: "remover",
                            pId: id
                        },
                        success: function (data) {
                            if (data.status) {
                                table.DataTable().row(row).remove().draw(false);
                                boxsucesso.show().fadeOut(7500);
                            } else {
                                boxerro.show().fadeOut(7500);
                            }
                        }
                    });
                }
            }
        });
    });
</script>   

<%@include file="/footer.jsp" %> 