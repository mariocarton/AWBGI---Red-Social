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

$('#bvisto').click(function () {
    $('#libvisto').attr('class', 'active');
    $('#libmiactividad').attr('class', '');
    $('#libalertas').attr('class', '');
    $.ajax({
        url: 'pelicula',
        data: {
            accion: 'getvisto'
        }
    }).done(function (response) {
        $('#contenido-perfil').html(response);
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
        mostarDetallesPelicula();
    });
    return false;
});

$('#bmiactividad').click(function () {
    $('#libvisto').attr('class', '');
    $('#libmiactividad').attr('class', 'active');
    $('#libalertas').attr('class', '');
    $('#contenido-perfil').html('... Mi actividad ...');
    return false;
});

$('#balertas').click(function () {
    $('#libvisto').attr('class', '');
    $('#libmiactividad').attr('class', '');
    $('#libalertas').attr('class', 'active');
    $('#contenido-perfil').html('... Alertas ...');
    return false;
}); 



$('#bvisto').click();
