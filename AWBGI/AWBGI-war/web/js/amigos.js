$('#bveramigos').click(function () {
    $('#libveramigos').attr('class', 'active');
    $('#libexploraamigos').attr('class', '');
    $.ajax({
        url: 'amigo',
        data: {
            accion: 'extraeamigos'
        }
    }).done(function (response) {
        $('#contenido-amigos').html(response);
        $('.eliminaamigo').click(function () {
            var id = $(this).attr('id');
            $.ajax({
                url: 'amigo',
                data: {
                    accion: 'eliminaamigo',
                    id: id
                }
            }).fail(function () {
                alert('error');
            });
            $('#bveramigos').click();
        });

        $('.verdetalles').click(function () {
            var id = $(this).attr('id');
            $.ajax({
                url: 'amigo',
                data: {
                    accion: 'detallesamigo',
                    id: id
                }
            }).done(function (response) {
                $('#contenido-detalles').html(response);
                //Controlador de los botones de ver detalles de pelicula
                $('.accesopeli').click(function () {                    
                    //ID de la pelicula qu ese ha seleccionado
                    var ID = $(this).attr("href");
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
                        $('#contenido').html(responseText);                    });
                    return false;
                });
                
            }).fail(function () {
                alert('error');
            });
            return false;
        });
    });
    return false;
});

$('#bexploraamigos').click(function () {
    $('#libexploraamigos').attr('class', 'active');
    $('#libveramigos').attr('class', '');
    $.ajax({
        url: 'amigo',
        data: {
            accion: 'extraenoamigos'
        }
    }).done(function (response) {
        $('#contenido-amigos').html(response);
        $('.addamigo').click(function () {
            var id = $(this).attr('id');
            $.ajax({
                url: 'amigo',
                data: {
                    accion: 'addamigo',
                    id: id
                }
            }).fail(function () {
                alert('error');
            });
            $('#bexploraamigos').click();
        });
    });
    return false;
});

$('#bveramigos').click();
