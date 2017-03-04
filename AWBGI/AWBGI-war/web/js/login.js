$(document).ready(function () {    
    /*
     * Funcion para mostrar la vista de inicio de sesion
     */
    $('#einiciosesion').click(function () {
        $('#registro').hide();
        $('#iniciosesion').show();
        $('#einiciosesion_cont').hide();
        $('#eregistrarse_cont').show();
    });

    /*
     * Funcion para mostrar la vista de registro
     */
    $('#eregistrarse').click(function () {
        $('#registro').show();
        $('#iniciosesion').hide();
        $('#einiciosesion_cont').show();
        $('#eregistrarse_cont').hide();
    });

    /*
     * Funcion que comprueba si el apodo ya existe durante el regitro
     */
    $('#r_apodo').keyup(function () {
        $.ajax({
            url: 'login',
            data: {
                apodo: $('#r_apodo').val(),
                accion: "existe_apodo"
            },
            success: function (responseText) {
                if (responseText === "yes") {
                    $('#apodo_enuso').show();                                                   
                } else {
                    $('#apodo_enuso').hide();                    
                }
            }
        });
    });
    
    /*
     * Funciones que comprueban si las contraseñas son iguales 
     * durante el regitro
     */
    $('#r_password1').keyup(function () {
        var pass1 = $('#r_password1').val();
        var pass2 = $('#r_password2').val();
        if (pass1 !== pass2) {
            $('#l_password1').show();
            $('#l_password2').show();
        } else {
            $('#l_password1').hide();
            $('#l_password2').hide();
        }
    });
    $('#r_password2').keyup(function () {
        var pass1 = $('#r_password1').val();
        var pass2 = $('#r_password2').val();
        if (pass1 !== pass2) {
            $('#l_password1').show();
            $('#l_password2').show();
        } else {
            $('#l_password1').hide();
            $('#l_password2').hide(); 
        }
    });
    
    /*
     * Funcion que extrae los datos del formulario de login y los manda al 
     * serlvet contolador para que compruebe la validez de los datos y en caso
     * de estar bien iniciar sesion
     */
    $('#entrar_form').submit(function (event) {
        $('#error_entrar').hide();
        $.ajax({
            url: 'login',
            data: {
                apodo: $('#e_apodo').val(),
                pass: $('#e_pass').val(),
                accion: "login_submit"
            }, success: function (responseText) {
                if (responseText === "yes") {
                    window.location = "index";
                }
                if (responseText === "no") {
                    $('#error_entrar').show();
                }
            }
        });
        event.preventDefault();
    });
    
    /*
     * Funcion que extrae los datos del formulario de registro y los manda al 
     * servlet controlador para que compruebe la validez de los datos y en caso
     * de poder registrar esos datos, los registra e inicia sesión
     */
    $('#registro_form').submit(function (event) {
        $('#l_password1').hide();
        $('#l_password2').hide();
        $('#apodo_enuso').hide();
        $.ajax({
            url: 'login',
            data: {
                apodo: $('#r_apodo').val(),
                pass1: $('#r_password1').val(),
                pass2: $('#r_password2').val(),
                nombre: $('#r_nombre').val(),
                apellidos: $('#r_apellidos').val(),
                accion: "registro_submit"
            }, success: function (responseText) {
                //Todo esta bien
                if (responseText === "0") {
                    window.location = "index";
                }
                //Las contraseñas no son iguales
                if (responseText === "1") {
                    $('#l_password1').show();
                    $('#l_password2').show();
                }
                //El apodo ya existe
                if (responseText === "2") {
                    $('#apodo_enuso').show();
                }
                //Las contraseñas no coinciden y ademas el apodo ya esta
                if (responseText === "3") {
                    $('#l_password1').show();
                    $('#l_password2').show();
                    $('#apodo_enuso').show();
                }
            }
        });
        event.preventDefault();
    });

});