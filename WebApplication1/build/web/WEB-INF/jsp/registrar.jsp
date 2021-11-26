<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset=UTF-8" />
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>

    <body>
        <div class="contanier mt-4 col-lg-4">
            <div class="card bordder-info">
                <div class="card-header bg-info">
                    <h4>Agregar Persona</h4>
                </div>    
                <div class="card-body">
                    <form method="POST" action="registrarPersona.htm">
                        <label>Nombre</label>
                        <input type="text" name="nombre" class="form-control" />  
                        <label>Apellido Paterno</label>
                        <input type="text" name="appaterno" class="form-control" />
                        <label>Apellido Materno</label>
                        <input type="text" name="apmaterno" class="form-control" />
                        <label>Dirección</label>
                        <input type="text" name="direccion" class="form-control" />
                        <label>Fecha de Ingreso</label>
                        <input type="date" name="fechaingreso" class="form-control" />
                        <label>Contraseña</label>
                        <input type="password" name="contrasenia" class="form-control" />
                        <br>
                        <div class="form-check">
                            <input type="checkbox" name="esexterno" class="form-check-input" id="esexterno">
                            <label class="form-check-label" for="esexterno">Empleado Interno</label>
                        </div>
                        <br>

                        <br>
                        <input type="submit" value="Registrar" class="btn btn-success"/>
                        <a href="index.htm"  class="btn btn-secondary">Regresar</a>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
