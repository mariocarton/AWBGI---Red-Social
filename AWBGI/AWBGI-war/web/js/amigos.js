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
