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
                    <ul class="nav navbar-nav navbar-right" style="margin-right: 10px">                        
                        <li>
                            <a id="explorar">
                                <span class="fa fa-wpexplorer" aria-hidden="true" style="margin-right: 5px" ></span> Explorar 
                            </a>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>


        <div class="container-fluid" style="margin-top: 55px">

            <div class="row">
                <div class="col-sm-2 sidebar menu-lateral"  > <!--media query para quitarlo -->

                    <ul class="nav nav-sidebar">
                        <li>
                            <a id="banadir"><span class="glyphicon glyphicon-plus-sign"></span> Añadir </a> 
                        </li>
                        <li class="active">
                            <a id="bperfil"><span class="glyphicon glyphicon-user"></span> Perfil </a>
                        </li>
                        <li>
                            <a href="#" ><span class="glyphicon glyphicon-transfer"></span> Actividad </a>
                        </li>
                        <li>
                            <a id="bporver"><span class="glyphicon glyphicon-eye-close"></span> Por Ver </a> 
                        </li>
                        <li>
                            <a id="bamigos"> 
                                <span class="fa fa-users" aria-hidden="true"></span> Amigos 
                            </a> 

                        </li>
                    </ul>

                    <hr style="color: red"/>

                    <ul class="nav nav-sidebar">
                        <li> 
                        <h7 style="text-align: center"> 
                            <p id="nombre"></p>
                        </h7>
                        </li>
                        <li>
                            <a href="#"><span class="glyphicon glyphicon-cog"></span> Ajustes </a> 
                        </li>
                        <li>
                            <a><span class="glyphicon glyphicon-question-sign" href="#"></span> Ayuda </a> 
                        </li>
                    </ul>
                    <hr style="color: red" />
                    <ul class="nav nav-sidebar">
                        <li>
                            <a class="glyphicon glyphicon-log-out" href="index?accion=cierra_sesion"> Salir </a> 
                        </li>
                    </ul>
                </div>

                <div class="col-sm-10 contenido" style="float:right" ><!--media query para quitarlo -->

                    <div class="row" id="contenido"></div>

                    <div class="row" id="visto" style="display:none">
                    </div>

                    <div class="row" id="porver" style="display:none">

                    </div>

                    <div class="row" id="visto" style="display:none">
                    </div>

                    <div class="row" id="pexplorar" style="display:none">

                    </div>

                    <div class="row" id="infopeli" style="display:none">

                    </div>
                </div>

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

    <script type="text/javascript">

        $.ajax({
            url: 'api/user',
            data: {
                accion: 'nombre'
            }
        }).done(function (responseText) {
            $('#nombre').html(responseText);
        });

        function mostarDetallesPelicula() {
            //Controladores de la vista explorar
            $(".accesopeli").click(function () {
                //ID de la pelicula qu ese ha seleccionado
                var ID = $(this).attr("id");
                //Se pasa a la vista de detalles de pelicula
                $.ajax({
                    url: 'pelicula',
                    data: {
                        id: ID,
                        accion: "verpeli"
                    }
                }).done(function (responseText) {
                    //Titulo de la pestaña
                    $('#titulopestana').html("VerPelícula");
                    //Controlador del boton añadir comentario
                    $('#bformcomentario').click(function () {
                        $('#formcomentario').slideDown('slow');
                    });
                    $('#contenido').html(responseText);
                });

            });
        }

        $(document).ready(function () {


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
                $('#contenido').html("");

                $.ajax({
                    url: 'index',
                    data: {accion: "explorar"}
                }).done(function (responseText) {
                    //Redibuja la pantalla de explorar
                    $('#contenido').html(responseText).ready(function () {
                        //Pone a todas las imagenes el mismo tamaño
                        var alto = $('.img-responsive').val();
                        $('.img-responsive').each(function () {
                            if ($(this).height() > alto)
                                alto = $(this).height();
                        });
                        $('.img-responsive').each(function () {
                            $(this).height(alto);
                        });
                        //Si cambia el tamaño de la pantalla las reescala
                        $(window).resize(function () {
                            alto = $('.img-responsive').val();
                            $('.img-responsive').each(function () {
                                $(this).height('auto');
                            });
                            $('.img-responsive').each(function () {
                                if ($(this).height() > alto)
                                    alto = $(this).height();
                            });
                            $('.img-responsive').each(function () {
                                $(this).height(alto);
                            });
                        });
                    });
                    mostarDetallesPelicula();
                });
            });

            $('#cuadrobusqueda').keyup(function () {
                var contenido = $('#cuadrobusqueda').val();
                if (contenido.length > 1) {
                    $.ajax({
                        url: 'busqueda',
                        data: {accion: "busqueda",
                            palabra: contenido}
                    }).done(function (responseText) {
                        $('#contenidoBusqueda').html(responseText);
                        $('.resultadoBusqueda').css("display", "block");
                        mostarDetallesPelicula();

                    });
                } else {
                    $('.resultadoBusqueda').css("display", "none");
                }
            });
            $(window).click(function (e) {
                //if(e.target.id==='cuadrobusqueda'){
                //    $('.resultadoBusqueda').css("display","block");
                //}else{
                $('.resultadoBusqueda').css("display", "none");
                //}
            });


        });



    </script>

</body>
</html>
