
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="sidebar-nav navbar-collapse">
    <ul class="nav" id="side-menu">

        <li>
            <a href="Controle?logica=Inicio"><i class="fa fa-dashboard fa-fw"></i>In�cio</a>
        </li>

        <c:if test="${sessionScope.usuario.perfil == 'Admin'}">
        <li class="MenuGerente">
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Usu�rios<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
                <li>
                    <a href="Controle?logica=Usuario.Cadastrar">Cadastrar</a>
                </li>
                <li>
                    <a href="Controle?logica=Usuario.Gerenciar">Gerenciar</a>
                </li>
            </ul>
            <!-- /.nav-second-level -->
        </li>
        </c:if>

        <c:if test="${sessionScope.usuario.perfil != 'Aluno'}">
        <li class="MenuGerente">
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Quest�es<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
                <li>
                    <a href="Controle?logica=Questao.Cadastrar">Cadastrar</a>
                </li>
                <li>
                    <a href="Controle?logica=Questao.Gerenciar">Gerenciar</a>
                </li>
            </ul>
            <!-- /.nav-second-level -->
        </li>
        </c:if>
        
        <c:if test="${sessionScope.usuario.perfil == 'Aluno'}">
        <li class="MenuGerente">
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Quest�es para Responder<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
                <li>
                    <a href="Controle?logica=Resposta.Pesquisar">Ver Quest�es</a>
                </li>
            </ul>
            <!-- /.nav-second-level -->
        </li>
        </c:if>

    </ul>
</div>
