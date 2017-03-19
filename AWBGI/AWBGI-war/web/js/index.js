$(document).ready(function () {



    $('#bvisto').click(function () {
        $('#anadir').hide();
        $('#visto').show();
        $('#amigos').hide();
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
    $('#banadir').click(function () {
        $('#titulopestana').html("Añadir Película");
        $('#contenido').load('html/anadirpelicula.html', function () {
            $('#formpeliadd').submit(function (event) {
                $.ajax({
                    url: 'index',
                    data: {
                        titulopf: $('#titulopf').val(),
                        anopf: $('#anopf').val(),
                        directorpf: $('#directorpf').val(),
                        paispf: $('#paispf').val(),
                        duracionpf: $('#duracionpf').val(),
                        generopf: $('#generopf').val(),
                        sinopsispf: $('#sinopsispf').val(),
                        imagenpelipf: $('#imagenpelicula').val(),
                        accion: "savepeli"

                    }
                }).done(function (responseText) {
                    if (responseText === "yes") {
                        $('#titulopestana').html("Pelicula Añadida");
                        $('#mensajepeli').html("La pelicula fue añadida con éxito");
                        //window.location = "index",
                        $('#anadir').hide();
                        $('#pelianadida').show();
                    } else {
                        $('#mensajepeli').html(responseText);
                    }
                });
                //alert( "Handler for .submit() called." );
                event.preventDefault();
            });
        });
    });
    $('#bamigos').click(function () {
        $('#titulopestana').html("Amigos");
        $('#contenido').load('html/amigos.html');
    });
    $('#bperfil').click(function () {
        $('#titulopestana').html("Perfil");
        $('#contenido').load('html/perfil.html');

    });

    $('#bporver').click(function () {
        $('#titulopestana').html("PorVer");
        $.ajax({
            url: 'index',
            data: {
                accion: "porver"
            }, success: function (responseText) {
                $('#contenido').html(responseText);
                
                $(".accesopeli").click(function () {
                    var ID = $(this).attr("id");
                    $.ajax({
                        url: 'index',
                        data: {
                            id: ID,
                            accion: "verpeli"
                        }, success: function (responseText) {
                            $('#titulopestana').html("VerPelícula");
                            $('#contenido').html(responseText);
                        }
                    });
                });
            }
        });
    });


    $('#btnpelianadida').click(function () {
        $('#pelianadida').hide();
        $('#anadir').hide();
        $('#visto').hide();
        $('#amigos').hide();
        $('#pexplorar').hide();
        $('#navperfil').show();
        $('#visto').show();
        $('#porver').hide();
        $('#titulopestana').html("Perfil");

    });
    $('#btnpelianadida2').click(function () {
        $('#pelianadida').hide();
        $('#anadir').hide();
        $('#visto').hide();
        $('#amigos').hide();
        $('#navperfil').show();
        $('#visto').show();
        $('#pexplorar').hide();
        $('#porver').hide();
        $('#titulopestana').html("Perfil");

    });   

   
});