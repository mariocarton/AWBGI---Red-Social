<%-- 
    Document   : login
    Created on : 21-feb-2017, 19:43:07
    Author     : mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
         <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    
    </head>
    <body>
        <div class="container" style="text-align: center; padding-top: 6%; padding-bottom: 6%; padding-left: 30%; padding-right: 30%">
            <div class="row">
                <div class="col-md-6">
                    <a id="einiciosesion">Iniciar Sesión</a>                    
                </div>
                <div class="col-md-6">
                    <a id="eregistrarse">Registrarse</a>
                </div>
            </div>
            <div class="row" id="iniciosesion">
                <div class="col-md-12" >
                    <form role="form" action="login" method="POST">
                        <div class="form-group">
                            <h1>Entrar</h1>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_1" >Apodo</label>
                            <input type="text" class="form-control" id="email" name="email"
                                   placeholder="Introduce tu apodo">
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_password_1">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Introduce tu contraseña">
                        </div>                       
                        <button type="submit" class="btn btn-default">Entrar</button>
                    </form>
                </div>                
            </div>
            <div class="row" id="registro">
                <div class="col-md-12" >
                    <form role="form" action="login" method="POST">
                        <div class="form-group">
                            <h1>Registro</h1>
                        </div>
                        <div class="form-group">
                            <label>Apodo <span id="apodo_enuso"> <span class="glyphicon glyphicon-remove" style="color: red" aria-hidden="true"></span><em style="color:red">Apodo en uso</em></span></label>
                            <input type="text" class="form-control" id="r_apodo" name="r_apodo"
                                   placeholder="Introduce un apodo">
                        </div>
                         <div class="form-group">
                            <label for="ejemplo_password_1">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Introduce una contraseña">
                        </div>  
                        <div class="form-group">
                            <label for="ejemplo_password_1">Repetir Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Repite la contraseña">
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_1" >Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="email"
                                   placeholder="Introduce tu nombre">
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_1" >Apellidos</label>
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="Introduce tus apellidos">
                        </div>
                       
                        <button id="boton_registro" type="submit" class="btn btn-default">Registrarse</button>
                    </form>
                </div>                
            </div>
        </div>        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> 
        
        <script type="text/javascript">
            $('#einiciosesion').click(function() {                
                $('#registro').hide();
                $('#iniciosesion').show();  
            });
            $('#eregistrarse').click(function() {
                $('#registro').show();
                $('#iniciosesion').hide();                
            });
            $('#registro').hide();
           
        </script>
        
        <script type="text/javascript">
            $(function(){
                $('#r_apodo').keyup(function(){
                    $.ajax({
                        url: 'login',
                        data: {
                            apodo : $('#r_apodo').val()
                        },
                        success:function (responseText) {
                            if(responseText === "yes"){
                                $('#apodo_enuso').show();
                                $('#boton_registro').prop('disabled',true);                                
                            }else{
                                $('#apodo_enuso').hide();
                                $('#boton_registro').prop('disabled',false); 
                            }
                        }
                    });           
        
            //        $get('login',{
            //            apodo : $('#r_apodo').val()
            //        }, function (responseText) {
            //            if(responseText == "yes"){
            //                $('#apodo_enuso').show();
            //            }else{
            //                $('#apodo_enuso').hide();
            //            }   
            //      });
              }); 
           });
           $('#apodo_enuso').hide();
        </script>
    </body>
</html>
