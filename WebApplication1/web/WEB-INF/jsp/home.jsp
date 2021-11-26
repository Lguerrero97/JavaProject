
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8" />
        <title>Ejemplo de jdbc</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>


        <c:forEach items="${personaIngresada}" var="personaI">
            <br>
            <div class="contanier">
                <div class="row">
                    <div class="col-10"></div>
                    <div class="col-2">
                        <a href="index.htm"  class="btn btn-secondary">Salir</a>
                    </div>
                </div>
                <c:if test="${personaI.esexterno == true}">
                    <div class="row">
                        <div class="col-1">
                        </div>
                        <div class="col-10">
                            <form method="POST">
                                <label>Publicacion</label>
                                <textarea type="text" class="form-control" name="notapublicada"></textarea>
                                <br>
                                <input  type="hidden" class="form-control" name="idpersona" value="${personaI.idpersona}"></input>
                                <input type="submit" value="Agregar" class="btn btn-success" align="right">
                            </form>                
                        </div>
                    </div>
                </c:if>

                <c:forEach items="${datos}" var="dato"> 
                    <hr/>
                    <br> 
                    <div class="row"> 
                        <div class="col-1"></div>
                        <div class="media col-10">
                            <div class="media-left">
                                <img class="mr-3" src="https://images.vexels.com/media/users/3/137047/isolated/preview/5831a17a290077c646a48c4db78a81bb-icono-de-perfil-de-usuario-azul.png"  width="60" height="60">
                            </div>
                            <div class="media-body">
                                <h5 class="mt-0"><c:out value="${dato.nombre}"/></h5>
                                <div class="row">
                                    <div class="col-12">
                                        <c:out value="${dato.notapublicada}"/>
                                    </div>

                                    <div class="col-12">
                                        <a href="comentario.htm?id=${dato.idnotapublicada}&idpersonacomenta=${personaI.idpersona}">Comentar</a>
                                    </div>
                                    <c:if test="${comentarB == true && iDP == dato.idnotapublicada}">
                                        <div class="col-1">
                                        </div>  
                                        <div class="col-10"> 
                                            <form method="POST" action="guardarComentario.htm">
                                                <textarea type="text" class="form-control" name="comentario"></textarea>
                                                <br>
                                                <input  type="submit" value="Comentar" class="btn btn-success">
                                                <a href="cancelarComentario.htm" class="btn btn-danger">Cancelar</a>
                                            </form>                
                                        </div>
                                    </c:if>
                                </div>
                                <c:forEach items="${comentarios}" var="comentario">
                                    <c:if test="${dato.idnotapublicada == comentario.idnotapublicada}">
                                        <div class="media mt-3">
                                            <img src="https://es.seaicons.com/wp-content/uploads/2015/06/Comment-edit-icon.png" width="50" height="50">   
                                            <div class="media-body">
                                                <h5 class="mt-0"><c:out value="${comentario.nombre}"/></h5>
                                                <div class="row">
                                                    <div class="col-12">
                                                        <c:out value="${comentario.comentario}"/>
                                                    </div>
                                                    <div class="col-12">
                                                        <a href="responder.htm?id=${comentario.idcomentario}&idPubli=${dato.idnotapublicada}&idpersonaresponde=${personaI.idpersona}"">Responder</a>
                                                    </div>
                                                    <c:if test="${respuestaB == true && idC == comentario.idcomentario}">
                                                        <div class="col-1">
                                                        </div>  
                                                        <div class="col-10"> 
                                                            <form method="POST" action="agregarRespuesta.htm">
                                                                <textarea type="text" class="form-control" name="respuesta"></textarea>
                                                                <br>
                                                                <input  type="submit" value="Responder" class="btn btn-success">
                                                                <a href="responderCancelar.htm" class="btn btn-danger">Cancelar</a>
                                                            </form>                
                                                        </div>
                                                    </c:if>
                                                </div>
                                                <c:forEach items="${respuestas}" var="respuesta">
                                                    <c:if test="${respuesta.idcomentario == comentario.idcomentario}">
                                                        <div class="media mt-3">
                                                            <img src="https://es.seaicons.com/wp-content/uploads/2015/06/Comment-edit-icon.png" width="50" height="50">   
                                                            <div class="media-body">
                                                                <h5 class="mt-0"><c:out value="${respuesta.nombre}"/></h5>
                                                                <c:out value="${respuesta.respuesta}"/>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>  
                                            </div>                  
                                        </div>    
                                    </c:if>                                                        
                                </c:forEach>
                            </div>
                        </div> 
                        <div class="col-1"></div>
                    </div>
                </c:forEach>
            </div>  
        </c:forEach>
    </body>
</html>
