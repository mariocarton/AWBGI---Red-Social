<%-- 
    Document   : nuevapeli
    Created on : 23-feb-2017, 11:20:17
    Author     : mariomatesanz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap-theme.min.css">
    </head>
    <body>
    <div class="container-fluid">
      <form role="form">
        <div class="form-group">
             <label for="titulo">Título</label>
                <input type="text" class="form-control" id="titulo"
                                       placeholder="Introduce el Título">
        </div>
        <div class="form-group">
              <label for="ano">Año</label>
                  <input type="text" class="form-control" id="ano" 
                        placeholder="Introduce el año">
        </div
        <div class="form-group">
              <label for="director">Director</label>
                  <input type="text" class="form-control" id="director" 
                        placeholder="Introduce el Director">
        </div>
        <div class="form-group">
              <label for="pais">País</label>
                  <input type="text" class="form-control" id="pais" 
                        placeholder="Introduce el País de origen">
        </div>
        <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
                  <input type="text" class="form-control" id="sinopsis" 
                        placeholder="Introduce una breve descripción">
        </div>
        <div class="form-group">
             <label for="ejemplo_archivo_1">Adjuntar un archivo</label>
                  <input type="file" id="imagenpelicula">
                      <p class="help-block">Adjunta una imagen para su película.</p>
        </div>
        
        <button type="submit" class="btn btn-primary">Enviar</button>
      </form>
    </div>
        
    <!-- Latest compiled and minified JavaScript -->
           <script src="recursos/bootstrap/js/bootstrap.min.js" ></script> 
    </body>
</html>
