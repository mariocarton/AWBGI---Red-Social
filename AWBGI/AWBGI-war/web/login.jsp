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
        <div class="container" style="text-align: center; padding-top: 2%">
            <div class="page-header" style="text-align: center" >
                <h1>MuchaPeli</h1>
            </div>
        </div>
        <div class="container" style="text-align: center; padding-top: 25px; padding-bottom: 6%; padding-left: 30%; padding-right: 30%">
            <div class="row" id="iniciosesion">
                <div class="col-md-12" >
                    <form role="form" id="entrar_form">
                        <div class="form-group">
                            <h2>Entrar</h2>
                        </div>
                        <div id="error_entrar" class="form-group">
                            <label><span class="glyphicon glyphicon-remove" style="color: red" aria-hidden="true"></span><em style="color:red"> Nombre de usuario o contraseña incorrectos</em></label>
                        </div>
                        <div class="form-group">
                            <label>Apodo</label>
                            <input type="text" class="form-control" id="e_apodo" name="e_apodo"
                                   placeholder="Introduce tu apodo" required="">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" class="form-control" id="e_pass" name="e_pass"
                                   placeholder="Introduce tu contraseña" required="">
                        </div>
                        <input hidden name="accion" value="login"/>
                        <button id="boton_entrar" type="submit" class="btn btn-default">Entrar</button>
                    </form>
                </div>                
            </div>
            <div class="row" id="registro">
                <div class="col-md-12" >
                    <form role="form"  id="registro_form">
                        <div class="form-group">
                            <h2>Registro</h2>
                        </div>
                        <div class="form-group">
                            <label>Apodo <span id="apodo_enuso"> <span class="glyphicon glyphicon-remove" style="color: red" aria-hidden="true"></span><em style="color:red">Apodo en uso</em></span></label>
                            <input type="text" class="form-control" id="r_apodo" name="r_apodo"
                                   placeholder="Introduce un apodo" required="">
                        </div>
                         <div class="form-group">
                            <label>Contraseña <span id="l_password1"> <span class="glyphicon glyphicon-remove" style="color: red" aria-hidden="true"></span><em style="color:red">La contraseña no es igual</em></span></label>
                            <input type="password" class="form-control" id="r_password1" name="r_password1"
                                   placeholder="Introduce una contraseña" required="">
                        </div>  
                        <div class="form-group">
                            <label for="ejemplo_password_1">Repetir Contraseña <span id="l_password2"> <span class="glyphicon glyphicon-remove" style="color: red" aria-hidden="true"></span><em style="color:red">La contraseña no es igual</em></span></label>
                            <input type="password" class="form-control" id="r_password2" name="r_password2"
                                   placeholder="Repite la contraseña" required="">
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_1" >Nombre</label>
                            <input type="text" class="form-control" id="r_nombre" name="r_nombre"
                                   placeholder="Introduce tu nombre" required="">
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_1" >Apellidos</label>
                            <input type="text" class="form-control" id="r_apellidos" name="r_apellidos"
                                   placeholder="Introduce tus apellidos" required="">
                        </div>
                        <input hidden name="accion" value="registro"/>
                        <button id="boton_registro" type="submit" class="btn btn-default">Registrarse</button>
                    </form>
                </div>                
            </div>
            <div class="row" style="margin-top: 35px">
                <div class="col-md-12" id="einiciosesion_cont">
                    Si ya tienes cuenta puedes
                    <a id="einiciosesion" style="cursor: hand; cursor: pointer; text-decoration: none">Iniciar Sesión</a>                    
                </div>
                <div class="col-md-12" id="eregistrarse_cont">
                    Si no tienes cuenta puedes
                    <a id="eregistrarse" style="cursor: hand; cursor: pointer; text-decoration: none">Registrarse</a>
                </div>
            </div>
        </div> 
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> 
        
        <!-- Funciones javascript que contolan la vista de la pagina -->
        <script type="text/javascript" src="js/login.js"></script>
        <script type="text/javascript">
            // Iicializacion de los scripts
            $('#registro').hide();
            $('#einiciosesion_cont').hide();
            $('#apodo_enuso').hide();
            $('#l_password1').hide();
            $('#l_password2').hide();
            $('#error_entrar').hide();
        </script>
        
    </body>
</html>
