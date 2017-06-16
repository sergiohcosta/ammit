<%-- 
    Document   : menu_upper_right
    Created on : Oct 19, 2015, 8:53:47 PM
    Author     : sergio
--%>

<ul class="nav navbar-top-links navbar-right">  
    Bem-vindo, ${sessionScope.usuario.nome}. Seu perfil é de ${sessionScope.usuario.perfil}
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li class="divider"></li>
            <li><a href="Controle?logica=Acesso.Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
</ul>