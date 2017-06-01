
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/header.jsp" %>

<jsp:useBean id="p" class="beans.Usuario" scope="request">
    <jsp:setProperty name="p" property="*"/>
</jsp:useBean>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Usuário - Cadastrar</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<c:if test="${status=='1'}">
    <div id="sucesso" class="alert alert-success">Usuário cadastrado.</div>
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
                Dados do usuário
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">

                        <p>Todos os campos são de preenchimento obrigatório</p>

                        <form role="form" id="usuario_cadastrar_form" method="post" action="Controle" >
                            <input type="hidden" name="logica" value="Usuario.Cadastrar">
                            <input type="hidden" name="id" value="<jsp:getProperty name="p" property="id" />">
                            <div id="BoxPerfil" class="form-group">
                                <label>Perfil do usuário</label>
                                <select name="perfil" placeholder="perfil" id="perfil" class="form-control">
                                    <option value="">--- Selecione ---</option>
                                    <option value="Professor">Professor</option>
                                    <option value="Aluno">Aluno</option>
                                </select>
                                <p class="help-block">Selecione o perfil do usuário</p>
                            </div>

                            <div id="BoxNome" class="form-group">
                                <label>Nome</label>
                                <input class="form-control" name="nome" placeholder="nome" id="nome" value="<jsp:getProperty name="p" property="nome" />">
                                <p class="help-block">Digite o nome completo do usuário</p>
                            </div>

                            

                            

                            <div id="BoxEmail" class="form-group">
                                <label>Email</label>
                                <input class="form-control" name="email" placeholder="email" id="email" type="email" value="<jsp:getProperty name="p" property="email" />">
                                <p class="help-block">Digite o email do usuário</p>
                            </div>

                            <%--TODO: melhorar as ações de alterar senha --%>

                            <div id="BoxSenha" class="form-group">
                                <label>Senha</label>
                                <input type="password" class="form-control" name="senha" placeholder="senha" id="senha">
                                <p class="help-block">Digite a senha do usuário</p>
                            </div>

                            <div id="BoxConfsenha" class="form-group">
                                <label>Confirme a senha</label>
                                <input type="password" class="form-control" name="confsenha" placeholder="" id="confsenha">
                                <p class="help-block">Repita a senha do usuário</p>
                            </div>


                            <button type="submit" class="btn btn-default">Salvar</button>
                            <button type="reset" class="btn btn-default">Limpar</button>


                        </form>

                        <script src="bower_components/jquery.maskedinput/src/jquery.maskedinput.js" type="text/javascript"></script>

                        <script>
                            $("#perfil").val("<jsp:getProperty name="p" property="perfil" />");
                            
                            <c:if test="${errPerfil =='1'}">
                            $("#BoxPerfil").toggleClass("has-error");
                            $("#LabelPerfil").toggleClass("text-danger");
                            </c:if>

                            <c:if test="${errNome =='1'}">
                            $("#BoxNome").toggleClass("has-error");
                            $("#LabelNome").toggleClass("text-danger");
                            </c:if>
                                
                            </c:if>
                            <c:if test="${errEmail =='1'}">
                            $("#BoxEmail").toggleClass("has-error");
                            $("#LabelEmail").toggleClass("text-danger");
                            </c:if>
                            <c:if test="${errSenha =='1'}">
                            $("#BoxSenha").toggleClass("has-error");
                            $("#LabelSenha").toggleClass("text-danger");
                            </c:if>

                            $("#usuario_cadastrar_form").validate(
                                    {
                                        rules: {
                                            perfil: {
                                                required: true
                                            },
                                            nome: {
                                                required: true,
                                                minlength: 3
                                            },
                                            email: {
                                                required: true
                                            },
                                            senha: {
                                                required: true,
                                                minlength: 3
                                            },
                                            confsenha: {
                                                equalTo: "#senha"
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