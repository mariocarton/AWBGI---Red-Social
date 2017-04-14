$(document).ready(function () {
    $('.img-responsive').height($('#descripcion').height());
    $(window).resize(function () {
         $('.img-responsive').height($('#descripcion').height());
    });
    function estadoPelicula() {
        var id_peli = $('#id-pelicula').val();
        $.ajax({
            url: 'pelicula',
            data: {
                accion: 'estado-pelicula',
                id: id_peli
            }
        }).done(function(response){  
            switch (response){
                case '0':
                    $('#btn-novisto').attr('class','btn btn-success');
                    break;
                case '1':
                    $('#btn-visto').attr('class','btn btn-success');
                    break;
                case '2':
                    $('#btn-porver').attr('class','btn btn-success');
                    break;
            }
        });
    }
    estadoPelicula();

    $('#enviar-comentario').submit(function () {
        var id = $('#id-pelicula').val();
        var titulo = $('#comentario-titulo').val();
        var comentario = $('#comentario-cuerpo').val();
        $.ajax({
            url: 'pelicula',
            data: {
                accion: 'guarda-comentario',
                id: id,
                titulo: titulo,
                comentario: comentario
            }
        }).done(function (response) {
            if (response === 'ok') {
                $('#notificacion').show();
            } else {
                $('#notificacion').attr('class', 'alert alert-danger alert-dismissable');
                $('#notificacion').html('<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error.</strong> Ha habido un error al publicar tu comentario.');
                $('#notificacion').show();
            }
        }).fail(function () {
            alert('error');
            $('#notificacion').attr('class', 'alert alert-danger alert-dismissable');
            $('#notificacion').html('<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error.</strong> Ha habido un error al publicar tu comentario.');
            $('#notificacion').show();
        });
        $('#myModal').modal('hide');
        //Recarga los comentarios
        $.ajax({
            url: 'pelicula',
            data: {
                accion: 'getcomentarios',
                id: id
            }
        }).done(function (response) {
            $('#comentarios').html(response);
        })
        return false;
    });
});

