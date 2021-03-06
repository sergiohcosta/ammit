<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="area" value="administrador"/>

<%@include file="/header.jsp" %>

<!-- DataTables CSS -->
<link href="bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Corre��o</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-12">

        <c:if test="${status=='0'}"><div class="alert alert-success">Resposta Correta!</div></c:if>
        <c:if test="${status=='1'}"><div class="alert alert-danger">Erro de compila��o!</div></c:if>
        <c:if test="${status=='2'}"><div class="alert alert-danger">Resposta Incorreta!</div></c:if>
        <c:if test="${status=='-2'}"><div class="alert alert-danger">o c�digo de teste do seu professor n�o compila</div></c:if>
        <c:if test="${status=='-3'}"><div class="alert alert-danger">Erro no servidor</div></c:if>
        <c:if test="${status=='-4'}"><div class="alert alert-danger">Nenhum caso de teste executado. Informe seu professor</div></c:if>



            <div class="col-lg-6">
                <div class="dataTable_wrapper">
                    <table class="table table-striped table-bordered table-hover" id="tableCasosteste">
                        <thead>
                            <tr>
                                <th>Output</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="output" items="${outputs}">
                            <tr class="odd gradeA">
                                <td>${output}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="col-lg-6">
            <div class="dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="tableErros">
                    <thead>
                        <tr>
                            <th>Erros</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="erro" items="${erros}">
                            <tr class="odd gradeA">
                                <td>${erro}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
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

        var table = $('#tableCasosteste,#tableErros');
        table.DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.10/i18n/Portuguese-Brasil.json"
            },
            paging: true,
            responsive: true,
            bSort: false,
            orderable: false,
            searching: false
        });

    });
</script>   

<%@include file="/footer.jsp" %> 