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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
