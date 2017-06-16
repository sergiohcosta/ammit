
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/auth.jsp" %>
<%@include file="/header.jsp" %>

<jsp:useBean id="p" class="beans.Questao" scope="request">
    <jsp:setProperty name="p" property="*"/>
</jsp:useBean>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Responder Questão - <jsp:getProperty name="p" property="titulo" /></h1>
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
                Dados da questão
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">

      
                        <form role="form" id="questao_cadastrar_form" method="post" action="Controle" >
                            <input type="hidden" name="logica" value="Resposta.Responder">
                            <input type="hidden" name="id" value="<jsp:getProperty name="p" property="id" />">
                            

                            <div id="BoxEnunciado" class="form-group">
                                <label>Enunciado:</label><br>
                                <jsp:getProperty name="p" property="enunciado" />
                            </div>
                            
                            <div id="BoxSaidasCodigo" class="row">
                                <div class="col-lg-12">
                                    <label>Sua resposta:</label><br>
                                    <input type="file" class="form-control" name="codigofonte" placeholder="codigofonte" id="codigofonte">
                                    <label>Linguagem do código fonte:</label>
                                    <select id="codigofonte_linguagem" name="codigofonte_linguagem">
                                        <option value="C">C</option>
                                    </select>
                                </div>
                            </div>
                            
                            
                            <button type="submit" class="btn btn-default">Salvar</button>
                            <button type="reset" class="btn btn-default">Limpar</button>


                        </form>

                        <script src="bower_components/jquery.maskedinput/src/jquery.maskedinput.js" type="text/javascript"></script>

                        <script>

                            <c:if test="${errProfessor =='1'}">
                            $("#BoxProfessor").toggleClass("has-error");
                            $("#LabelProfessor").toggleClass("text-danger");
                            </c:if>

                            <c:if test="${errTítulo =='1'}">
                            $("#BoxTítulo").toggleClass("has-error");
                            $("#LabelTitulo").toggleClass("text-danger");
                            </c:if>

                            <c:if test="${errEnunciado =='1'}">
                            $("#BoxEnunciado").toggleClass("has-error");
                            $("#LabelEnunciado").toggleClass("text-danger");
                            </c:if>


                            $("#questao_cadastrar_form").validate(
                                    {
                                        rules: {
                                            professor: {
                                                required: true
                                            },
                                            titulo: {
                                                required: true,
                                                minlength: 3
                                            },
                                            enunciado: {
                                                required: true,
                                                minlength: 3
                                            }
                                        }
                                    });</script>
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

<%@include file="/footer.jsp" %>