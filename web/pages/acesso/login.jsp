<%-- 
    Document   : login
    Created on : 16/10/2015, 18:47:00
    Author     : sergio
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>AMMIT</title>

        <!-- Bootstrap Core CSS -->
        <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="dist/css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- jQuery -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


        <!-- Custom Theme JavaScript -->
        <!-- <script src="dist/js/sb-admin-2.js"></script> -->

    </head>

    <body>

        <div class="container">
            <div class="row">
                <!-- aqui acaba o cabe�alho -->

                <div class="col-md-4 col-md-offset-4">


                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Efetuar Login</h3>
                        </div>
                        <div class="panel-body">
                            <c:if test="${errLogin==1}">
                                <div class="alert alert-warning" role="alert">Usu�rio ou senha incorretos.</div>
                            </c:if>
                            <c:if test="${errLogin==3}">
                                <div class="alert alert-warning" role="alert">Usu�rio desativado.</div>
                            </c:if>
                            <c:if test="${msg=='logout'}">
                                <div class="alert alert-warning" role="alert">Logout efetuado com sucesso.</div>
                            </c:if>
                            <form role="form" action="Controle" method="post">
                                <input type="hidden" name="logica" value="Acesso.Login">
                                <fieldset>
                                    <div class="form-group">
                                        ${msg}<input class="form-control" placeholder="E-mail" name="email" type="login" autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="senha" type="password" value="">
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <button type="submit" class="btn btn-lg btn-success btn-block">Login</button><br>

                                </fieldset>
                            </form>
                        </div>

                    </div>
                    <br><br>
                    Logins para testes
                    <br>
                    TBD
                </div>

            </div>
        </div>


    </body>

</html>