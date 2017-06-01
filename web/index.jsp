
<%@include file="header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Início</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    
                    Bem-vindo, ${sessionScope.usuario.nome}
                    <br>
                    Seu perfil é de ${sessionScope.usuario.perfil}
        
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row" style="display: none">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-institution fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">15</div>
                                    <div>Atendentes</div>
                                </div>
                            </div>
                        </div>
                        <a href="atendentes_gerenciar.jsp">
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
                                    <i class="fa fa-male fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">3</div>
                                    <div>Nutricionistas</div>
                                </div>
                            </div>
                        </div>
                        <a href="Nutricionistas_gerenciar.php">
                            <div class="panel-footer">
                                <span class="pull-left">Gerenciar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-wechat fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">1</div>
                                    <div>Gerente</div>
                                </div>
                            </div>
                        </div>
                        <a href="gerente_gerenciar.php">
                            <div class="panel-footer">
                                <span class="pull-left">Gerenciar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-users fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">5</div>
                                    <div>Clientes</div>
                                </div>
                            </div>
                        </div>
                        <a href="clientes_gerenciar.php">
                            <div class="panel-footer">
                                <span class="pull-left">Gerenciar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-magenta">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-users fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">5</div>
                                    <div>Cardápios</div>
                                </div>
                            </div>
                        </div>
                        <a href="Cardápios_gerenciar.php">
                            <div class="panel-footer">
                                <span class="pull-left">Gerenciar</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                
            </div>
            <!-- /.row -->

<%@include file="footer.jsp" %>

