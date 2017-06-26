<%-- PAGES/CASOTESTE/GERENCIAR.JSP --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="area" value="administrador"/>

<%@include file="/header.jsp" %>

<!-- DataTables CSS -->
<link href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Casos de teste - Gerenciar</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-8">

        <div class="form-group">
            <label>Questão:</label> "${q.titulo}"<br>
            <label>Enunciado:</label> "${q.enunciado}"
        </div>

        <c:if test="${status=='0'}"><div class="alert alert-danger">${msg}</div></c:if>
        <c:if test="${status=='1'}"><div class="alert alert-success">${msg}</div></c:if>
        <c:if test="${status=='3'}"><div class="alert alert-info">Agora, gerencie os casos de teste para sua questão</div></c:if>

        <div id="BoxSucesso" class="alert alert-success" style="display: none">
            Caso de teste removido com sucesso
        </div>
        <div id="BoxErro" class="alert alert-danger" style="display: none">
            Caso de teste não pôde ser removido
        </div>

            <a href="Controle?logica=Casoteste.Cadastrar&qId=${q.id}"><i class="icon-plus-sign">Criar novo caso de teste </i></a><br>
        
        <div class="dataTable_wrapper">
            <table class="table table-striped table-bordered table-hover" id="tableCasosteste">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tbody>


                    <c:forEach var="casoteste" items="${casosteste}">
                        <tr class="odd gradeA">
                            <td>${casoteste.titulo}</td>
                            <td class="CelOpcoes" align="center">
                                <a href="Controle?logica=Casoteste.Cadastrar&op=editar&qId=${q.id}&id=${casoteste.id}">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </a>

                                <a href="#">
                                    <span class="glyphicon glyphicon-remove icon-delete" id="${casoteste.id}" aria-hidden="true"></span>
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

        var table = $('#tableCasosteste');
        table.DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.10/i18n/Portuguese-Brasil.json"
            },
            responsive: true,
            columnDefs: [{orderable: false, targets: [1]}]
        });

        $('#tableCasosteste tbody').on('click', 'span.icon-delete', function () {
            var botao = $(this);
            var row = $(this).closest("tr").get(0);

            if (botao.hasClass("glyphicon-remove")) {
                if (confirm("REMOVER o caso de teste?")) {
                    var id = botao.attr("id");
                    $.ajax({
                        method: 'POST',
                        dataType: "json",
                        url: "Controle",
                        data: {
                            logica: "Casoteste.Gerenciar",
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