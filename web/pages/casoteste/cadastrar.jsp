<%-- PAGES/CASOTESTE/CADASTRAR.JSP --%>

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
    <div id="sucesso" class="alert alert-success">Caso de Teste cadastrada.</div>
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
<form method="post" action="Controle" enctype="multipart/form-data" name='form-casoteste' id='casoteste'>
    <input type="hidden" name="logica" value="Casoteste.Cadastrar">
    <input type="hidden" name="id" value="<jsp:getProperty name="p" property="id" />">
    <input type="hidden" name="qId" value="${q.id}">

    <div class="row">
        <div class="col-lg-12">

            <div class="form-group">
                <label>Questão:</label> "${q.titulo}"<br>
                <label>Enunciado:</label> "${q.enunciado}"
            </div>

            <div id="BoxTitulo" class="form-group">
                <label id="LabelTitulo">Título</label>
                <input class="form-control" name="titulo" placeholder="titulo" id="titulo" value="<jsp:getProperty name="p" property="titulo" />">
                <p class="help-block">Digite o titulo do caso de teste</p>
            </div>

            <div id="BoxConteudo" class="form-group">
                <label id="LabelConteudo">Conteúdo</label>
                <textarea name="conteudo" placeholder="conteudo" id="conteudo" class="form-control"><jsp:getProperty name="p" property="conteudo" /></textarea>
                <p class="help-block">Digite o conteúdo do caso de teste</p>
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
                        <input type="radio" name="tipo_entradas" class="tipo_entradas" id="tipo_entradas_ammit" value="entradaammit">
                        <label>Utilize o Ammit para gerar entradas</label>
                    </div>
                    <div id="BoxEntradasAmmit" class="row">
                        <div class="col-lg-6">
                            <div id="BoxAmmit_seed" class="form-group">
                                <label id="LabelAmmit_seed">Sintaxe Ammit</label>
                                <input class="form-control" name="ammit_seed" placeholder="Sintaxe Ammit" id="ammit_seed" value='<jsp:getProperty name="p" property="ammit_seed" />'>
                            </div>
                            <div id="BoxAmmit_qtde" class="form-group">
                                <label>Quantidade de linhas:</label>
                                <select id="ammit_qtde" name="ammit_qtde">
                                    <c:forEach begin="1" end="100" varStatus="loop">
                                        <option value="<c:out value="${loop.current}"/>"><c:out value="${loop.current}"/></option>
                                    </c:forEach>
                                </select>
                                <input type='button' id="gerar" value='Gerar'>
                                <input type='button' id="ajuda" value='Aprenda mais sobre o AMMIT' class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">



                            </div>

                        </div>
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Exemplos de Entradas Geradas pelo Ammit
                                </div>
                                <div class="panel-body" id="AmmitGeracao">
                                    <div class="alert alert-warning" id="ErroAmmit" style="display: none;">
                                        O Ammit não conseguiu interpretar sua sintaxe.<br>
                                        Por favor, tente novamente
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <input type="radio" name="tipo_entradas" id="tipo_entradas_manual" class="tipo_entradas" value="entradamanual">
                        <label>Digitar entradas manualmente</label>
                    </div>
                    <div id="BoxEntradasManual" class="row">
                        <div class="col-lg-6">
                            <div id="BoxEntrada" class="form-group">
                                <label id="LabelEntrada">Entrada</label>
                                <textarea style="width:100%; height: 200px;" name="entrada" placeholder="entrada" id="entrada" class="form-control"><jsp:getProperty name="p" property="entrada" /></textarea>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="modal-body">
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Sobre o AMMIT</h4>
                    </div>
                    <div class="modal-body">
                        Ammit é uma notação desenvolvida para simplificar a escrita de casos de teste. Por exemplo, para um programa que deva ler 10 inteiros de 1 a 100 e fazer alguma ação, em vez de escrever vários casos de teste como:
                        <br><br>
                        15 49 35 84 26 45 80 54 100 19
                        <br><br>
                        Com Ammit você pode escrever simplesmente escrever o seguinte:
                        <br><br>
                        i[1:100, 10]
                        <br><br>
                        E pronto!
                        <br><br>
                        A cada execução, Ammit gerará um ou mais novos casos de teste aleatórios com base na sua especificação. Isso ajuda a garantir que o aluno resolveu o exercício, e não apenas contornou os casos de teste.
                        <br><br>
                        Sintaxe:
                        <br><br>
                        Inteiros:
                        i (gera um inteiro entre -32768 e 32767)
                        i[x:y] (gera um número entre x e y, inclusive, ou entre y e x se y<x)
                            i[x:y, z] (gera z inteiros entre x e y)
                            Você pode omitir os índices x e  y, por exemplo:
                            i[x:] (gera um inteiro entre x e 32767)
                            i[:,z] (gera z inteiros entre -32768 e 32767)
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Entendi!</button>

                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</div>



<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Saídas
            </div>
            <div class="panel-body">
                <div class="form-group" id="tipo_saidas_seletor_codigo">
                    <c:if test="${sourceUpado}"><div class="alert alert-warning">Você já tem um código fonte armazenado para esse caso de teste<br>Se você selecionar um novo arquivo, o antigo será perdido</div></c:if>
                        <input type="radio" name="tipo_saidas" class="tipo_saidas" id="tipo_saidas_codigo" value="saidacodigo">
                        <label>Utilize seu próprio código fonte para validar as entradas</label>
                    </div>
                    <div id="BoxSaidasCodigo" class="row">
                        <div class="col-lg-6">
                            <div id="BoxCodigofonte" class="form-group">
                                <label id="LabelCodigofonte">Forneca um arquivo com o código fonte</label>
                                <input type="file" class="form-control" name="codigofonte" placeholder="codigofonte" id="codigofonte">
                            </div>
                            <label>Linguagem do código fonte:</label>
                            <select id="codigofonte_linguagem" name="codigofonte_linguagem">
                                <option value="C">C</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" id="tipo_saidas_seletor_manual">
                        <input type="radio" name="tipo_saidas" class="tipo_saidas" id="tipo_saidas_manual" value="saidamanual">
                        <label>Insira manualmente suas saídas</label>
                    </div>
                    <div id="BoxSaidasManual" class="row">
                        <div class="col-lg-6">
                            <div id="BoxSaida" class="form-group">
                                <label id="LabelSaida">Saída</label>
                                <textarea style="width:100%; height: 200px;" name="saida" placeholder="saida" id="saida" class="form-control"><jsp:getProperty name="p" property="saida" /></textarea>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<button type="submit" class="btn btn-default">Salvar</button>
<button type="reset" class="btn btn-default">Limpar</button>

<br><br>
</form>
<script>

    <c:if test="${errTitulo =='1'}">
    $("#BoxTitulo").toggleClass("has-error");
    $("#LabelTitulo").toggleClass("text-danger");
    </c:if>

    <c:if test="${errConteudo =='1'}">
    $("#BoxConteudo").toggleClass("has-error");
    $("#LabelConteudo").toggleClass("text-danger");
    </c:if>

    <c:if test="${errAmmit_seed =='1'}">
    $("#BoxAmmit_seed").toggleClass("has-error");
    $("#LabelAmmit_seed").toggleClass("text-danger");
    </c:if>
    <c:if test="${errAmmit_qtde =='1'}">
    $("#BoxAmmit_qtde").toggleClass("has-error");
    $("#LabelAmmit_qtde").toggleClass("text-danger");
    </c:if>
    <c:if test="${errEntrada =='1'}">
    $("#BoxEntrada").toggleClass("has-error");
    $("#LabelEntrada").toggleClass("text-danger");
    </c:if>
    <c:if test="${errCodigofonte =='1'}">
    $("#BoxCodigofonte").toggleClass("has-error");
    $("#LabelCodigofonte").toggleClass("text-danger");
    </c:if>
    <c:if test="${errCodigofonte_linguagem =='1'}">
    $("#BoxCodigofonte_linguagem").toggleClass("has-error");
    $("#LabelCodigofonte_linguagem").toggleClass("text-danger");
    </c:if>
    <c:if test="${errSaida =='1'}">
    $("#BoxSaida").toggleClass("has-error");
    $("#LabelSaida").toggleClass("text-danger");
    </c:if>

    <c:if test="${not empty p.ammit_seed}">
    $("#tipo_entradas_ammit").attr("checked", true);
    $("#tipo_saidas_seletor_manual").hide();
    $("#BoxSaidasManual").hide();
    $("#BoxEntradasManual").hide();
    </c:if>

    <c:if test="${not empty p.ammit_seed}">
    $("#tipo_entradas_ammit").attr("checked", true);
    $("#tipo_saidas_codigo").attr("checked", true);
    $("#tipo_saidas_seletor_manual").hide();
    $("#BoxEntradasManual").hide();
    $("#BoxSaidasManual").hide();
    </c:if>

    <c:if test="${not empty p.entrada}">
    $("#tipo_entradas_manual").attr("checked", true);
    $("#BoxEntradasManual").show();
    $("#tipo_entradas_ammit").show();
    $("#BoxEntradasAmmit").hide();

    </c:if>

    <c:if test="${not empty p.saida}">
    $("#tipo_saidas_manual").attr("checked", true);
    $("#tipo_saidas_seletor_codigo").show();
    $("#tipo_saidas_seletor_manual").show();
    $("#BoxSaidasManual").show();
    $("#BoxSaidasCodigo").hide();
    </c:if>

    <c:if test="${empty p.saida}">

    $("#tipo_saidas_seletor_codigo").show();
    $("#BoxSaidasCodigo").show();
    $("#tipo_saidas_seletor_manual").show();
    $("#BoxSaidasManual").hide();
    $("#tipo_saidas_codigo").attr("checked", true);
    </c:if>

    $("#gerar").click(function () {
        $("#ErroAmmit").hide();
        $.get("Controle?logica=Casoteste.Ammit", {seed: $("#ammit_seed").val(), qtde: $("#ammit_qtde").val()}, function () {})
                .done(function (data) {
                    if ($("#entrada").val().length == 0)
                        $("#entrada").val(data);

                    $("#AmmitGeracao").html(data.replace(/\n/g, "<br>"));
                })
                .fail(function () {
                    $("#ErroAmmit").show();
                });
    });

    $(".tipo_entradas").click(function () {
        if ($("#tipo_entradas_ammit").is(':checked')) {
            $("#tipo_saidas_seletor_manual").hide();
            $("#BoxEntradasAmmit").show();
            $("#BoxSaidasManual").hide();
            $("#BoxEntradasManual").hide();
        } else {
            $("#tipo_saidas_seletor_manual").show();
            $("#BoxEntradasAmmit").hide();
            $("#BoxEntradasManual").show();
        }
    });

    $(".tipo_saidas").click(function () {
        // se o ammit tiver selecionado
        if ($("#tipo_saidas_codigo").is(':checked')) {
            $("#BoxSaidasManual").hide();
            $("#BoxSaidasCodigo").show();
        } else {
            $("#BoxSaidasCodigo").hide();
            $("#BoxSaidasManual").show();
        }
    });

    function desativarEntradaAmmit() {

        $("#BoxEntradasAmmit").hide();
        $("#BoxEntradasManual").show();
        $("#tipo_saidas_seletor_manual").show();
    }
    function desativarEntradaManual() {

        $("#BoxEntradasAmmit").show();
        $("#BoxEntradasManual").hide();
    }

    function desativarSaidaCodigo() {

        $("#BoxSaidasCodigo").hide();
        $("#BoxSaidasManual").show();
        $("#tipo_saidas_seletor_manual").show();
    }
    function ativarSaidaManual() {

        $("#tipo_saidas_seletor_manual").hide();
        $("#BoxSaidasManual").show();
        $("#BoxSaidasCodigo").show();

    }
    function desativarSaidaManual() {

        $("#BoxSaidasCodigo").show();
        $("#BoxSaidasManual").hide();
        $("#tipo_saidas_seletor_manual").hide();
    }

</script>

<%@include file="/footer.jsp" %>