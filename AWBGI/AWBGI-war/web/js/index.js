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
        return false;
    });
    
   /*
   $('#bvisto').click(function () {
        $('#anadir').hide();
        $('#visto').show();
        $('#pexplorar').hide();
        $('#porver').hide();
        $('#titulopestana').html("Perfil");
        $.ajax({
            url: 'index',
            data: {
                accion: "visto"
            }, success: function (responseText) {
                $('#visto').html(responseText);
                $(".accesopeli").click(function () {
                    var ID = $(this).attr("id");
                    $.ajax({
                        url: 'index',
                        data: {
                            id: ID,
                            accion: "verpeli"
                        }, success: function (responseText) {
                            $('#navperfil').hide();
                            $('#titulopestana').html("VerPelícula");
                            $('#visto').html(responseText);

                        }
                    });
                });
            }
        });
    });
    */
   
    $('#banadir').click(function () {
        $('#titulopestana').html("Añadir Película");
        $('#contenido').load('html/anadirpelicula.html');
        return false;
    });
    $('#bamigos').click(function () {
        $('#titulopestana').html("Amigos");
        $('#contenido').load('html/amigos.html');
        return false;
    });

    $('#bperfil').click(function () {
        $('#titulopestana').html("Perfil");
        $('#contenido').load('html/perfil.html');
        return false;
    });

    $('#bporver').click(function () {
        $('#titulopestana').html("PorVer");
        $('#contenido').load('html/porver.html');        
        return false;
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
        $('.resultadoBusqueda').css("display", "none");
    });

    $.ajax({
        url: 'api/user',
        data: {
            accion: 'nombre'
        }
    }).done(function (responseText) {
        $('#nombre').html(responseText);
    });

    $('#explorar').click();



});