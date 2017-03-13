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
        <title id="titulopestana">Perfil</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%
            // Si no esta iniciada la sesion se reenvia al formulario de registro
            Boolean sesion = (Boolean) session.getAttribute("auth");
            if (sesion != null) {
                if (!sesion) {
                    response.sendRedirect("./login");
                }
            }
        %>
        <nav class="navbar navbar-inverse navbar-fixed-top" style="background-color: #31708f">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" id="iconmuchapeli" style="color: white"> MuchaPeli </a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="glyphicon" id="explorar"> 
                                <i class="fa fa-wpexplorer" aria-hidden="true"></i>
                                Explorar </a>
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
                <h1>MuchaPeli <small></small></h1>
            </div>

            <div class="col-xs-2 sidebar" style="height: 100%">
                <ul class="nav nav-sidebar">
                    <li>
                        <input type="text" class="form-control" placeholder="Buscar...">
                    </li>
                    <li>
                        <a id="banadir" class="glyphicon glyphicon-plus-sign"> Añadir </a> 
                    </li>
                    <li class="active">
                        <a class="glyphicon glyphicon-user" id="bperfil"> Perfil </a>
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-transfer" href="#" > Actividad </a>
                    </li>
                    <li>
                        <a class="glyphicon glyphicon-eye-close" id="bporver"> Por Ver </a> 
                    </li>
                    <li>
                        <a class="glyphicon" id="bamigos"> 
                            <i class="fa fa-users" aria-hidden="true"></i> Amigos 
                        </a> 

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
                        <a class="glyphicon glyphicon-log-out" href="index?accion=cierra_sesion"> Salir </a> 
                    </li>
                </ul>
            </div>

            <div class="col-xs-8" >

                <div class="nav nav-tabs" id="navperfil" style="display:none">
                    <h4  > Usuario 1 </h4>
                    <li role="presentation" class="active">
                        <a class="active glyphicon glyphicon-eye-open" id="bvisto"> Visto</a>
                    </li>
                    <li role="presentation">
                        <a id="bmiactividad" class="active glyphicon glyphicon-adjust"> Mi Actividad</a>
                    </li>
                    <li role="presentation">
                        <a class="active glyphicon glyphicon-alert"> Alertas</a>
                    </li>
                </div>
                <!--
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
                -->
                <hr style="color: red" />

                <div class="row" id="visto" style="display:none">

                </div>

                <div class="row" id="porver" style="display:none">

                </div>

                <div class="row " id="anadir" style="display:none" style="margin: 4%">
                    <div class="container-fluid" style="margin: 4%">
                        <h2 style="text-align: center"> Añadir película </h2>
                        <form role="form" id="formpeliadd">
                            <div class="form-group">
                                <label for="titulo">Título</label>
                                <input type="text" class="form-control" id="titulopf" name="titulopf"
                                       placeholder="Introduce el Título" required="">
                            </div>
                            <div class="form-group">
                                <label for="ano">Año</label>
                                <input type="text" class="form-control" id="anopf" name="anopf"
                                       placeholder="Introduce el año" required="">
                            </div>
                            <div class="form-group">
                                <label for="director">Director</label>
                                <input type="text" class="form-control" id="directorpf" name="directorpf"
                                       placeholder="Introduce el Director" required="">
                            </div>
                            <div class="form-group">
                                <label for="pais">País</label>
                                <input type="text" class="form-control" id="paispf" name="paispf"
                                       placeholder="Introduce el País de origen" required="">
                            </div>
                            <div class="form-group">
                                <label for="duracion">Duración</label>
                                <input type="text" class="form-control" id="duracionpf" name="duracionpf"
                                       placeholder="Introduce la duración de la película" required="">
                            </div>
                            <div class="form-group">
                                <label for="pais">Género</label>
                                <input type="text" class="form-control" id="generopf" name="generopf"
                                       placeholder="Introduce el genero de la película" required="">
                            </div>
                            <div class="form-group">
                                <label for="sinopsis">Sinopsis</label>
                                <input type="text" class="form-control" id="sinopsispf" name="sinopsispf"
                                       placeholder="Introduce una breve descripción" required="">
                            </div>
                            <div class="form-group">
                                <label for="archivo_foto">Adjuntar un archivo</label>
                                <input type="file" name="file" id="imagenpelicula">
                                <p class="help-block">Adjunta una imagen para su película.</p>
                            </div>
                            <input hidden name="accion" value="anadirpeli"/>
                            <button id="enviapeli" type="submit" class="btn btn-primary" >Enviar</button>
                        </form>
                    </div>

                </div>
                <div class="row" id="amigos" style="display:none">
                    <div class="container-fluid">
                        <div class="jumbotron col-xs-4" style="margin: 1%">
                            <h3 style="text-height: auto">Mario Cartón</h3>
                            <p>Vistas 17</p>
                            <p>Por Ver 17</p>
                            <p><a class="btn btn-primary btn-lg" href="#" role="button">Añadir</a></p>
                        </div>
                        <div class="jumbotron col-xs-4" style="margin: 1%">
                            <h3 style="text-height: auto">Mario</h3>
                            <p>Vistas 17</p>
                            <p>Por Ver 17</p>
                            <p><a class="btn btn-primary btn-lg" href="#" role="button">Añadir</a></p>
                        </div>
                        <div class="jumbotron col-xs-4" style="margin: 1%">
                            <h3 style="text-height: auto">Mario González</h3>
                            <p>Vistas 17</p>
                            <p>Por Ver 17</p>
                            <p><a class="btn btn-primary btn-lg" href="#" role="button">Añadir</a></p>
                        </div>
                    </div>
                </div>

                <div class="row" id="pexplorar" style="display:none">

                </div>

                <div class="row" id="infopeli" style="display:none">

                </div>

                <div class="modal-content" style="display:none" id="pelianadida">
                    <div class="modal-header">
                        <button type="button" class="close" id="btnpelianadida" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Insercción ejecutada</h4>
                    </div>
                    <div class="modal-body" id="mensajepeli">
                        <!--<p>La pelicula fue añadida con éxito</p>-->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="btnpelianadida2">Close</button>
                    </div>
                </div>
            </div>
            <div class="col-xs-2 panel panel-primary">
                <a href="#"> saf </a>
            </div>

        </div>


    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>-->
    <script src="recursos/bootstrap/js/bootstrap.min.js" ></script> 

    <!-- Funciones javascript que contolan la vista de la pagina -->
    <script type="text/javascript" src="js/index.js"></script>


    <script type="text/javascript">
        $('#explorar').click(function () {
            $('#pelianadida').hide();
            $('#anadir').hide();
            $('#visto').hide();
            $('#amigos').hide();
            $('#navperfil').hide();
            $('#visto').hide();
            $('#pexplorar').show();
            $('#porver').hide();
            $('#titulopestana').html("Explorar");
            $.ajax({
                url: 'index',
                data: {
                    accion: "explorar"
                }, success: function (responseText) {
                    $('#pexplorar').html(responseText);
                     
                    $(".accesopeli").click(function () {
                        var ID = $(this).attr("id");
                        
                        $.ajax({
                            url: 'index',
                            data: {
                                id: ID,
                                accion: "verpeli"
                            }, success: function (responseText) {
                                $('#titulopestana').html("VerPelícula");

                                $('#formcomentario').click(function () {
                                    $('#titulopestana').html("Form");
                                });
                                $('#pexplorar').html(responseText);
                            }
                        });
                        
                    });
                }

            });
        });




    </script>

</body>
</html>
