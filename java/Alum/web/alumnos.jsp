<%@ page language="java" %>
<%@ page import = "alumnos.Alumno"%> 
<%@ page import = "alumnos.Conexion"%> 
<%@ page import = "java.util.LinkedList"%> 
<html lang="en">
    <head>                                                                                                 
        <meta charset="UTF-8">                                                                             
        <title>Proyecto NoSQL</title>                                                                      
        <link rel="shortcut icon" href="images/favicon.ico" />
        <link rel="stylesheet" href="css/normalize.css">                                                      
        <link rel="stylesheet" href="css/estilos.css">                                                     
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">                      
    </head>
    <body>
        <div class="contenedor">                                                                       
            <div class="cabecera">                                                                         
                <h1>Proyecto NoSQL</h1>                                                                        
                <h2>Presentado por: Miguel Angel, Daniel, Luis y Ricard.</h2>                                   
            </div> <!-- Fin de cabecera -->                                                                
            <div class="lista"><div class="dentrolista">                                                      
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
                                LinkedList<Alumno> alum = Conexion.getAlumnos();
                                int IdBdd = 0;
                                for (int i = 0; i < alum.size(); i++) {
                                    int active = alum.get(i).getActive();
                                    if (active > 0) {
                                        out.println("<tr>");
                                        IdBdd = alum.get(i).getId();
                                        out.println("<td>" + alum.get(i).getNombre() + "</td>");
                                        out.println("<td>" + alum.get(i).getApellido() + "</td>");
                                        //out.println("<td>" + alum.get(i).getMail() + "</td>");
                                        //out.println("<td>" + alum.get(i).getCaracteristicas() + "</td>");
                                        out.println("<td><a href='modifica?id=" + IdBdd + "'> Modificar </a></td>");
                                        out.println("<td><a href='elimina?id=" + IdBdd + "'> Eliminar </a></td>");
                                        out.println("</tr>");
                                    }
                                }
                            %>
                        </table>
                    </fieldset>
                </div> <!-- div final dentrolista -->
            </div> <!-- Fin de lista -->                           
            <div class="nuevo"><div class="dentronuevo">           
                    <fieldset><legend>Crear nuevo usuario</legend>     
                        <p>Pulse para crear un nuevo usuario.</p>      
                        <div class="botoncrear">                       
                            <button name="hola">Crear nuevo usuario</button></div>
                    </fieldset>                                               
                </div></div> <!--Final de nuevo -->                       
        </div> <!-- Fin de contenedor -->                             
    </body>                                                           
</html>                                                           