<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>




    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Início</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            
            <c:if test="${status=='0'}"><div class="alert alert-warning">Ops! Página não encontrada!</div></c:if>

            Bem-vindo, ${sessionScope.usuario.nome}
        <br>
        Seu perfil é de ${sessionScope.usuario.perfil}
        <br><br>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<c:if test="${sessionScope.usuario.perfil == 'Professor'}">
    <div class="row" style="">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-question-circle fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${qtdQuestao}</div>
                            <div>Questões</div>
                        </div>
                    </div>
                </div>
                <a href="Controle?logica=Questao.Gerenciar">
                    <div class="panel-footer">
                        <span class="pull-left">Gerenciar</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>


        <div class="col-lg-3 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-check-circle-o fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${qtdRespostas}</div>
                            <div>Respostas</div>
                        </div>
                    </div>
                </div>
                <a href="Controle?logica=Questao.Gerenciar">
                    <div class="panel-footer">
                        <span class="pull-left">Gerenciar</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
    </c:if>






</div>
<!-- /.row -->

<%@include file="footer.jsp" %>

