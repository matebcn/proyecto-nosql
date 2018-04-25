<%@page import="java.util.ArrayList"%>
<%@page language="java" %>
<%@page import = "alumno2.Alumnos" %> 
<%@page import = "alumno2.Alumno" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Alumnos alumnos = new Alumnos();
    ArrayList<Alumno> alum = alumnos.listado();
%>
<!DOCTYPE html>
<html lang="en">
    <head>                                                                                                 
        <meta charset="UTF-8">                                                                             
        <title>Proyecto NoSQL</title>                                                                      
        <link rel="stylesheet" href="css/normalize.css">        
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/estilos.css">                                                     
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">                      
    </head>
    <body>
        <div class="contenedor">                                                                       
            <div class="cabecera">                                                                         
                <h1>Proyecto NoSQL</h1>                                                                        
                <h2>Presentado por: Miguel Angel, Daniel, Luis y Ricard.</h2>                                   
            </div> <!-- Fin de cabecera -->                                                                
            <div class="lista">
                <div class="dentrolista">                                                      
                    <fieldset>
                        <legend>Lista de usuarios registrados.</legend>                                  
                        <p>Si usted ya es usuario, puede consultar o modificar sus datos.</p>                      
                        <table>
                            <tr class="celdas">
                                <!--td>id</td-->
                                <td>Nombre</td>
                                <td>Apellidos</td>
                                <!--td>mail</td-->
                                <!--td>caracteristcas</td-->
                                <th>
                                    <div class="iconos">
                                        <img src="images/shuffle.png" alt="Modificar datos">
                                    </div>
                                </th>
                                <th>
                                    <div class="iconos">
                                        <img src="images/delete.png" alt="Eliminar datos">
                                    </div>
                                </th>
                            </tr>
<%

                                for (Alumno alumno : alum) {
                                    if (alumno != null && alumno.id != 0) {
                                        out.println("<tr>");
                                        out.println("<td>" + alumno.nombre + "</td>");
                                        out.println("<td>" + alumno.apellido + "</td>");
                                        out.println("<td><a href='editar.jsp?id=" + alumno.id + "'> Modificar </a></td>");
                                        out.println("<td><a href='baja?id=" + alumno.id + "'> Eliminar </a></td>");
                                        out.println("</tr>");
                                    }
                                }
%>

                        </table>
                    </fieldset>
                </div> <!-- div final dentrolista -->
            </div> <!-- Fin de lista -->                           
            <div class="nuevo">
                <div class="dentronuevo">           
                    <fieldset><legend>Crear nuevo usuario</legend>     
                        <p>Pulse para crear un nuevo usuario.</p>      
                        <div class="botoncrear">                       
                            <a href="alta.html">alta</a>
                            <!--button name="hola" >Crear nuevo usuario</button></div-->
                        </div>
                    </fieldset>                                               
                </div>
            </div> <!--Final de nuevo -->                       
        </div> <!-- Fin de contenedor -->                             
    </body>                                                           
</html>                                                           
