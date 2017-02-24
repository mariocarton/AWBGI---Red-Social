<%-- 
    Document   : index
    Created on : 09-feb-2017, 17:16:22
    Author     : mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap-theme.min.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" style="background-color: blue">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#" style="color: white"> MUCHAPELI </a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#"> Explorar </a>
                        </li>
                    </ul>

                    <form class="navbar-form navbar-nav" role="search">
                        <input type="text" class="form-control" placeholder="Buscar...">
                    </form>

                </div>
            </div>
        </nav>


        <div class="container-fluid" style="padding-top: 3%">
            <div class="page-header" style="text-align: center" >
                <h1>MUCHAPELI <small></small></h1>
            </div>

            <div class="col-xs-2 sidebar" style="height: 100%">
                <ul class="nav nav-sidebar">
                    <li>
                        <input type="text" class="form-control" placeholder="Buscar...">
                        <i class="glyphicon glyphicon-search form-control-feedback"></i>
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-plus-sign" href="#"> Añadir </a> 
                    </li>
                    <li class="active">
                        <a class="glyphicon glyphicon-user" href="#"> Perfil </a>
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-transfer" href="#" > Actividad </a>
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-eye-close" href="#"> Por Ver </a> 
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-" href="#"> Amigos </a> 
                    </li>
                </ul>
                <hr style="color: red" />
                <ul class="nav nav-sidebar">
                    <li> 
                        <h7 style="text-align: center"> Usuario 1 </h7>
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-cog" href="#"> Ajustes </a> 
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-question-sign" href="#"> Ayuda </a> 
                    </li>
                </ul>
                <hr style="color: red" />
                <ul class="nav nav-sidebar">
                    <li>
                        <a class="glyphicon glyphicon-log-out" href="#"> Salir </a> 
                    </li>
                </ul>
            </div>

            <div class="col-xs-8">
                <h4  > Usuario 1 </h4>
                <div class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a class="active glyphicon glyphicon-eye-open" href="#"> Visto</a>
                    </li>
                     <li role="presentation">
                        <a class="active glyphicon glyphicon-adjust" href="#"> Mi Actividad</a>
                    </li>
                     <li role="presentation">
                        <a class="active glyphicon glyphicon-alert" href="#"> Alertas</a>
                    </li>
                </div>
                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default glyphicon glyphicon-eye-open"> Visto</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default glyphicon glyphicon-adjust"> Mi Actividad</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default glyphicon glyphicon-alert"> Alertas</button>
                    </div>
                </div>
                <hr style="color: red" />

                <div class="row">
                    <div class="col-xs-4">
                        <div class="thumbnail">
                            <img src="..." alt="...">
                            <div class="caption">
                                <h3>Peli 1</h3>
                                <p>Muy bonita</p>
                                <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-4">
                        <div class="thumbnail">
                            <img src="..." alt="...">
                            <div class="caption">
                                <h3>Peli 1</h3>
                                <p>Muy bonita</p>
                                <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xs-2 panel panel-primary">
                <a href="#"> saf </a>
            </div>
        </div>   
    </div>


</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>-->
<script src="recursos/bootstrap/js/bootstrap.min.js" ></script> 


</body>
</html>
