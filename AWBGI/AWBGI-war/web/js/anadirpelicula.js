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
            imagenpelipf: $('#imagenpf').val(),
            accion: "savepeli"
        }
    }).done(function (responseText) {
        
        if (responseText === "yes") {
            $('#titulopestana').html("Pelicula Añadida");
            $('#mensajepeli').html("La pelicula fue añadida con éxito");
            //$('#anadir').hide();
            $('#modal').modal('show');
            //Terminar con esto
            $('#btnpelianadida').click(function () {
                $('#modal').modal('hide');
                return false;
            });
            $('#btnpelianadida2').click(function () {
                $('#modal').modal('hide');
               return false;
            });            
            titulopf: $('#titulopf').val('');
            anopf: $('#anopf').val('');
            directorpf: $('#directorpf').val('');
            paispf: $('#paispf').val('');
            duracionpf: $('#duracionpf').val('');
            generopf: $('#generopf').val('');
            sinopsispf: $('#sinopsispf').val('');
            imagenpelipf: $('#imagenpf').val('');
        } else {
            $('#mensajepeli').html(responseText);
        }
        
        

    });
    //alert( "Handler for .submit() called." );
    event.preventDefault();
});
