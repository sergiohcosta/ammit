
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/header.jsp" %>

<jsp:useBean id="p" class="beans.Casoteste" scope="request">
    <jsp:setProperty name="p" property="*"/>
</jsp:useBean>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Casos de teste</h1>
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

        <div class="form-group">
            <label>Questão:</label> "${q.titulo}"<br>
            <label>Enunciado:</label> "${q.enunciado}"
        </div>

        <div id="BoxTítulo" class="form-group">
            <label>Título</label>
            <input class="form-control" name="titulo" placeholder="titulo" id="titulo" value="<jsp:getProperty name="p" property="titulo" />">
            <p class="help-block">Digite o titulo do caso de teste</p>
        </div>

        <div id="BoxConteudo" class="form-group">
            <label>Conteúdo</label>
            <textarea name="conteudo" placeholder="conteudo" id="conteudo" class="form-control"><jsp:getProperty name="p" property="conteudo" /></textarea>
            <p class="help-block">Digite o enunciado da questão</p>
        </div>

    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Entradas
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <input type="radio" name="tipo_entradas" class="tipo_entradas" id="tipo_entradas_ammit">
                    <label>Utilize o Ammit para gerar entradas</label>
                </div>
                <div id="BoxEntradasAmmit" class="row">
                    <div class="col-lg-6">
                        <label>Sintaxe Ammit</label>
                        <input class="form-control" name="ammit_seed" placeholder="Sintaxe Ammit" id="ammit_seed">
                        <label>Quantidade de linhas:</label>
                        <select id="ammit_qtde" name="ammit_qtde">
                            <c:forEach begin="1" end="100" varStatus="loop">
                                <option value="<c:out value="${loop.current}"/>"><c:out value="${loop.current}"/></option>
                            </c:forEach>
                        </select>
                        <button id="gerar">Gerar</button>
                    </div>
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               Exemplos de Entradas Geradas pelo Ammit
                            </div>
                            <div class="panel-body" id="AmmitGeracao">
                            </div>
                        </div>

                    </div>
                </div>
                <div class="form-group">
                    <input type="radio" name="tipo_entradas" id="tipo_entradas_manual" class="tipo_entradas">
                    <label>Digitar entradas manualmente</label>
                </div>
                <div id="BoxEntradasManual" class="row">
                    <div class="col-lg-6">
                        <textarea style="width:100%; height: 200px;" name="entrada" placeholder="entrada" id="entrada" class="form-control"></textarea>
                    </div>

                </div>
            </div>
        </div>
    </div>
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
                            <input type="file" class="form-control" name="codigofonte" placeholder="codigofonte" id="codigofonte">
                            <label>Linguagem do código fonte:</label>
                            <select id="codigofonte_linguagem" name="codigofonte_linguagem">
                                <option value="C">C</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <input type="radio" name="tipo_saidas">
                            <label>Digitar saídas manualmente</label>
                        </div>

                        <div id="BoxSaidasManual" class="form-group">
                            <textarea style="width:100%; height: 200px;" name="saida" placeholder="saida" id="saida" class="form-control"></textarea>
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

    $("#tipo_entradas_ammit").attr("checked", true);
    desativarEntradaManual();

    $("#gerar").click(function () {
        $.get("Controle?logica=Casoteste.Ammit", {seed: $("#ammit_seed").val(), qtde: $("#ammit_qtde").val()}, function () {})
                .done(function (data) {
                    if($("#entrada").val().length==0)
                        $("#entrada").val(data);
            
                    $("#AmmitGeracao").html(data.replace(/\n/g, "<br>"));
                })
                .fail(function () {
                    alert("Ocorreu um erro ao tentar gerar entradas");
                });
    });

    $(".tipo_entradas").click(function () {
        if ($("#tipo_entradas_ammit").is(':checked')) {
            desativarEntradaManual();
        } else {
            desativarEntradaAmmit();
        }
    });

    function desativarEntradaAmmit() {
        //alert("desativar ammit");
        $("#BoxEntradasAmmit").hide();
        $("#BoxEntradasManual").show();
    }
    function desativarEntradaManual() {
        //alert("desativar manual");
        $("#BoxEntradasAmmit").show();
        $("#BoxEntradasManual").hide();
    }

</script>

<%@include file="/footer.jsp" %>