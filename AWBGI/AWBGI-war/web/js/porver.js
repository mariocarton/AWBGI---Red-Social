$.ajax({
    url: 'pelicula',
    data: {
        accion: "getporver"
    }
}).done(function (response) {
    $('#contenido-porver').html(response);
       
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
        return false;
    });
});

