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
                            $('#titulopestana').html("VerPelícula");
                            $('#visto').html(responseText);
                        }
                    });
                });
            }
        });

    });
    $('#banadir').click(function () {
        $('#anadir').show();
        $('#visto').hide();
        $('#amigos').hide();
        $('#navperfil').hide();
        $('#pexplorar').hide();
        $('#porver').hide();
        $('#titulopestana').html("Añadir Película");
    });
    $('#bamigos').click(function () {
        $('#anadir').hide();
        $('#visto').hide();
        $('#amigos').show();
        $('#navperfil').hide();
        $('#pexplorar').hide();
        $('#porver').hide();
        $('#titulopestana').html("Amigos");
    });
    $('#bperfil').click(function () {
        $('#anadir').hide();
        $('#visto').hide();
        $('#amigos').hide();
        $('#pexplorar').hide();
        $('#navperfil').show();
        $('#visto').show();
        $('#porver').hide();
        $('#titulopestana').html("Perfil");

    });

    $('#bporver').click(function () {
        $('#anadir').hide();
        $('#visto').hide();
        $('#amigos').hide();
        $('#pexplorar').hide();
        $('#navperfil').hide();
        $('#visto').hide();
        $('#porver').show();
        $('#titulopestana').html("PorVer");
        $.ajax({
            url: 'index',
            data: {
                accion: "porver"
            }, success: function (responseText) {
                $('#porver').html(responseText);
                
                $(".accesopeli").click(function () {
                    var ID = $(this).attr("id");
                    $.ajax({
                        url: 'index',
                        data: {
                            id: ID,
                            accion: "verpeli"
                        }, success: function (responseText) {
                            $('#titulopestana').html("VerPelícula");
                            $('#porver').html(responseText);
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

            }, success: function (responseText) {
                if (responseText === "yes") {
                    $('#titulopestana').html("Pelicula Añadida");
                    $('#mensajepeli').html("La pelicula fue añadida con éxito");
                    //window.location = "index",
                    $('#anadir').hide();
                    $('#pelianadida').show();
                } else {
                    $('#mensajepeli').html(responseText);
                }
            }
        });
        //alert( "Handler for .submit() called." );
        event.preventDefault();
    });
});