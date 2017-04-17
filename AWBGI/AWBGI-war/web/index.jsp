<%-- 
    Document   : index
    Created on : 09-feb-2017, 17:16:22
    Author     : mario
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title id="titulopestana">MuchaPeli</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" style="background-color: #31708f">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Desplegar navegación</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" id="iconmuchapeli" style="color: white; float: none; position: absolute; left: 50%; margin-left: -50px !important; display: block"> 
                        MuchaPeli 
                    </a>
                </div>  

                <div class="navbar-collapse collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav ">
                        <li>
                            <a><span class="glyphicon glyphicon-search"></span></a>                            
                        </li>
                        <li>
                            <form class="navbar-form navbar-nav" role="search" >
                                <input id="cuadrobusqueda" type="text" class="form-control" placeholder="Buscar..." >
                            </form>
                            <div class="resultadoBusqueda">
                                <div id="contenidoBusqueda" style="height: 302px"></div>
                            </div>
                        </li>
                    </ul>  
                    <!--
                    <ul class="nav navbar-nav navbar-right" style="margin-right: 10px">                        
                        <li>
                            <a href="#" id="explorar">
                                <span class="fa fa-wpexplorer" aria-hidden="true" style="margin-right: 5px" ></span> Explorar 
                            </a>
                        </li>
                    </ul>
                    -->
                </div>

            </div>
        </nav>


        <div class="container-fluid" style="margin-top: 51px">

            <div class="row">
                <div class="col-sm-2 sidebar menu-lateral"  > <!--media query para quitarlo -->
                    <ul class="nav nav-sidebar">
                        <li class="item-menu-lateral"> 
                            <i class="fa fa-user-circle-o fa-2x"></i>
                            <span id="nombre" style="padding-left: 5px"></span>                        
                        </li>
                        
                    </ul>
                    <hr style="color: red"/>
                    <ul class="nav nav-sidebar">
                        <li>
                            <a class="a-menu-lateral" href="#" id="explorar">
                                <span class="fa fa-wpexplorer" aria-hidden="true" style="margin-right: 5px" ></span> Explorar 
                            </a>
                        </li>
                        <li>
                            <a class="a-menu-lateral" href="#" id="banadir"><span class="glyphicon glyphicon-plus-sign"></span> Añadir </a> 
                        </li>
                        <li>
                            <a class="a-menu-lateral" href="#" id="bperfil"><span class="glyphicon glyphicon-user"></span> Perfil </a>
                        </li>
                        <li>
                            <a class="a-menu-lateral" href="#" ><span class="glyphicon glyphicon-transfer"></span> Actividad </a>
                        </li>
                        <li>
                            <a class="a-menu-lateral" href="#" id="bporver"><span class="glyphicon glyphicon-eye-close"></span> Por Ver </a> 
                        </li>
                        <li>
                            <a class="a-menu-lateral" href="#" id="bamigos"> 
                                <span class="fa fa-users" aria-hidden="true"></span> Amigos 
                            </a> 

                        </li>
                    </ul>

                    <hr style="color: red"/>

                    <ul class="nav nav-sidebar">
                        
                        <li>
                            <a class="a-menu-lateral" href="#"><span class="glyphicon glyphicon-cog"></span> Ajustes </a> 
                        </li>
                        <li>
                            <a class="a-menu-lateral" href="#"><span class="glyphicon glyphicon-question-sign"></span> Ayuda </a> 
                        </li>
                    </ul>
                    <hr style="color: red" />
                    <ul class="nav nav-sidebar">
                        <li>
                            <a class="a-menu-lateral"  href="index?accion=cierra_sesion"><span class="glyphicon glyphicon-log-out"></span> Salir </a> 
                        </li>
                    </ul>
                </div>

                <div class="col-sm-10 contenido" style="float:right" ><!--media query para quitarlo -->

                    <div class="row" id="contenido"></div>


                <div class="row " id="formcomentario" style="display:none" style="margin: 4%">
                    <div class="container-fluid" style="margin: 4%">
                        <h2 style="text-align: center"> Añadir Comentario </h2>
                        <form role="form" id="formpeliadd">
                            <div class="form-group">
                                <label for="titulo">Título</label>
                                <input type="text" class="form-control" id="titulocf" name="titulocf"
                                       placeholder="Introduce el Título" required="">
                            </div>
                            <div class="form-group">
                                <label for="texto">Text</label>
                                <input type="text" class="form-control" id="anocf" name="anocf"
                                       placeholder="Introduce el Comentario" required="">
                            </div>
                            <input hidden name="accion" value="enviacomentario"/>
                            <button id="enviacomentario" type="submit" class="btn btn-primary" >Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>-->
    <script src="recursos/bootstrap/js/bootstrap.min.js" ></script> 

    <!-- Funciones javascript que contolan la vista de la pagina -->
    <script type="text/javascript" src="js/index.js"></script>

</body>
</html>
