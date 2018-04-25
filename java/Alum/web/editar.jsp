<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page language="java" %>
<%@page import = "alumno2.Alumnos" %> 
<%@page import = "alumno2.Alumno" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String id = request.getParameter("id");
    int idi = Integer.parseInt(id);
    Alumno alum = new Alumno(idi);
    Map<String,String> atributos = alum.getAtributos();
    String[] claves = { "sexo", "nacionalidad", "pelo", "ojos" };
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto NoSQL</title>
        <link rel="shortcut icon" href="images/favicon.ico">
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

            <div class="lista">
                <div class="dentrolista">  
                    <form method="post" action="alta">
                        <input type="hidden" name="id" value="<%=id%>">
                        <h2>Editar usuario</h2>
                        <fieldset>
                            <legend>Introduzca los datos actualizados</legend>
                            <table>
                                <tr>
                                    <th><label for="texto1">Nombre: </label></th>
                                    <th><input id="nombre" type="text" placeholder="Escriba su nombre..." size="20" name="nombre" value="<%=alum.nombre%>"></th>
                                </tr>
                                <th><label for="texto2">Apellidos:</label></th>    
                                <th> <input id="apellidos" type="text" placeholder="Escriba sus apellidos..." size="20" name="apel" value="<%=alum.apellido%>"></th>
                                <tr>
                                    <th><label for="texto3">E-mail:</label></th>
                                    <th><input id="mail" type="email" placeholder="Escriba su mail..." maxlength="20" size="20" name="email" value="<%=alum.email%>"> </th>
                                </tr>
                            </table>                   

                        </fieldset>
                        <fieldset>
                            <legend>Active la casilla para m&aacute;s datos</legend>
                            <table>
<%
                                    int i = 1;
                                    for (Map.Entry<String,String> map:atributos.entrySet() ) {
                                        out.println("<tr>");
                                        out.println("<th><input id='check" + i + "' type='checkbox' name='check" + i + "' value='" + i + "' class='js-check' checked><label for='texto" + i + "'>" + map.getKey() + ": </label></th>");
                                        out.println("<th>");
                                        out.println("<input id='texto" + i + "' type='text' maxlength='20' size='20' name='valor' class='js-input' value='"+ map.getValue() +"'>");
                                        out.println("<input id='hidden" + i + "' type='hidden' name='clave' class='js-input' value='"+ map.getKey() +"'>");
                                        out.println("</th>");
                                        out.println("</tr>");
                                        i++;
                                    }
                                    
                                    for(String clavo : claves){
                                        if (atributos.get(clavo)==null){
                                            out.println("<tr>");
                                            out.println("<th><input id='check" + i + "' type='checkbox' name='check" + i + "' value='" + i + "' class='js-check'><label for='texto" + i + "'>" + clavo + ": </label></th>");
                                            out.println("<th>");
                                            out.println("<input id='texto" + i + "' type='text' maxlength='20' size='20' name='valor' class='js-input'>");
                                            out.println("<input id='hidden" + i + "' type='hidden' class='js-input' name='clave' value='"+clavo+"'>" );
                                            out.println("</th>");
                                            out.println("</tr>");
                                            i++;
                                        }
                                    }
                                    
%>
                            </table>               
                        </fieldset>
                        <div class="nuevo"><div class="dentronuevo">
                                <fieldset><legend>Crear nuevo usuario</legend>
                                    <p>Pulse para guardar sus nuevos datos.</p>
                                    <div class="botonguardar">
                                        <input type="submit" value="Guardar datos">
                                    </div>
                                </fieldset>
                            </div></div> <!--Final de nuevo -->
                    </form>
                </div> <!-- Fin de contenedor -->
            </div> <!-- div final dentrolista -->
        </div> <!-- Fin de lista -->
        <script src="js/myscript.js"></script>
    </body>
</html>