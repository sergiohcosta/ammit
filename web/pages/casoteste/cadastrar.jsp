
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
    <div id="sucesso" class="alert alert-success">Quest�o cadastrada.</div>
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
            <label>Quest�o:</label> "${q.titulo}"
        </div>
        <div class="form-group">
            <label>Enunciado:</label> "${q.enunciado}"
        </div>

        <div id="BoxT�tulo" class="form-group">
            <label>T�tulo</label>
            <input class="form-control" name="titulo" placeholder="titulo" id="titulo" value="<jsp:getProperty name="p" property="titulo" />">
            <p class="help-block">Digite o titulo do caso de teste</p>
        </div>

        <div id="BoxConteudo" class="form-group">
            <label>Conte�do</label>
            <textarea name="conteudo" placeholder="conteudo" id="conteudo" class="form-control"><jsp:getProperty name="p" property="conteudo" /></textarea>
            <p class="help-block">Digite o enunciado da quest�o</p>
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
                Sa�das
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">

                        <div id="BoxAmmit" class="form-group">
                            <input type="radio" name="tipo_saidas">
                            <label>Utilize seu pr�prio c�digo fonte para validar as entradas</label>
                            <input type="file" class="form-control" name="sourcecoide" placeholder="sourcecode" id="sourcecode">
                            <label>Linguagem do c�digo fonte:</label>
                            <select id="qtde" name="qtde">
                                <option value="C">C</option>

                            </select>
                        </div>

                        <div id="BoxEntradasManual" class="form-group">
                            <input type="radio" name="tipo_saidas">
                            <label>Digite ou ajuste a lista de sa�das conforme suas necessidades</label>
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
                    alert("Ocorreu um erro ao tentar alterar a situa��o");
                });
    });

</script>

<%@include file="/footer.jsp" %>