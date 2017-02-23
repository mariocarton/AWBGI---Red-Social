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

            <div class="col-sm-2 col-md-2 sidebar panel panel-primary" style="height: 100%">
                <ul class="nav nav-sidebar">
                    <li class="active">
                        <a href="#"> Perfil </a>
                    </li>
                    <li>
                        <a href="#"> Actividad </a>
                    </li>
                </ul>
            </div>

            <div class="col-sm-8">
                <h4  > Usuario 1 </h4>
                <hr style="color: red" />

                <div class="row">
                    <div class="col-sm-4 col-md-4">
                        <div class="thumbnail">
                            <img src="..." alt="...">
                            <div class="caption">
                                <h3>Peli 1</h3>
                                <p>Muy bonita</p>
                                <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4">
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

            <div class="col-sm-2 panel panel-primary">
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
