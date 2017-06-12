
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Casos de teste da Questão <jsp:getProperty name="q" property="titulo" /></h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<c:if test="${status=='1'}">
    <div id="sucesso" class="alert alert-success">Questão cadastrada.</div>
</c:if>


<c:if test="${status=='0'}">
    <div class="panel panel-red">
        <div class="panel-heading">
            Erros encontrados
        </div>
        <div class="panel-body">
            <c:forEach var="erro" items="${msgErro}">
                <div class="alert alert-danger">${erro}</div>
            </c:forEach>
        </div>

    </div>
</c:if>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Entradas
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">

                        <div id="BoxAmmit" class="form-group">
                            <input type="radio" name="tipo_entradas">
                            <label>Utilize a sintaxe Ammit para gerar entradas</label>
                            <input class="form-control" name="ammit" placeholder="ammit" id="ammit">
                            <label>Quantidade de linhas:</label>
                            <select id="qtde" name="qtde">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                            <button id="gerar">Gerar</button>
                        </div>

                        <div id="BoxEntradasManual" class="form-group">
                            <input type="radio" name="tipo_entradas">
                            <label>Digite ou ajuste a lista de entradas conforme suas necessidades</label>
                            <textarea style="width:100%" name="EntradasManual" placeholder="EntradasManual" id="EntradasManual" class="form-control" style="width: 100%"></textarea>
                        </div>

                    </div>
                    <!-- /.col-lg-6 (nested) -->
                </div>
                <!-- /.row (nested) -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Saídas
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">

                        <div id="BoxAmmit" class="form-group">
                            <input type="radio" name="tipo_saidas">
                            <label>Utilize seu próprio código fonte para validar as entradas</label>
                            <input type="file" class="form-control" name="sourcecoide" placeholder="sourcecode" id="sourcecode">
                            <label>Linguagem do código fonte:</label>
                            <select id="qtde" name="qtde">
                                <option value="C">C</option>
                                
                            </select>
                        </div>

                        <div id="BoxEntradasManual" class="form-group">
                            <input type="radio" name="tipo_saidas">
                            <label>Digite ou ajuste a lista de saídas conforme suas necessidades</label>
                            <textarea style="width:100%" name="EntradasManual" placeholder="EntradasManual" id="EntradasManual" class="form-control" style="width: 100%"></textarea>
                        </div>

                    </div>
                    <!-- /.col-lg-6 (nested) -->
                </div>
                <!-- /.row (nested) -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

<script>


    $("#gerar").click(function () {
        $.get("Controle?logica=Casoteste.Ammit", {seed: $("#ammit").val(), qtde: $("#qtde").val()}, function () {})
                .done(function (data) {
                    $("#EntradasManual").val(data);
                })
                .fail(function () {
                    alert("Ocorreu um erro ao tentar alterar a situação");
                });
    });

</script>

<%@include file="/footer.jsp" %>