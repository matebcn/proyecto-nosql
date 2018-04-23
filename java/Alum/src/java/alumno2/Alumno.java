package alumno2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import alumno2.Alumnado;
import java.util.ArrayList;

public class Alumno {

    public String nombre;
    public String apellido;
    public String email;
    public int id = 0;
    private Map<String, String> atributos = new HashMap<String, String>();

    //private String[] aCampos = {"nombre","apellido","email","atributos"};
    public Alumno() {
    }

    public Alumno(int id) {
        this.id = id;
        cargar();
    }

    /*
	public Alumno(String nombre, String apellido, String email, String atributos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.atributos = atributos;
		this.id = 0;
	}
     */
    public Alumno(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public void guardar() {
        String campos = "nombre,apellido,mail,caracteristicas";
        String caracteristicas = map2JsonString();
        String valores = "'" + this.nombre + "','" + this.apellido + "','" + this.email + "','" + caracteristicas + "'";
        String actualizar = "nombre='" + this.nombre + "',apellido='" + this.apellido + "',mail='" + this.email
                + "',caracteristicas='" + caracteristicas + "'";
        Alumnado alumnoDB = new Alumnado();
        alumnoDB.conecta();
        if (this.id != 0) {
            alumnoDB.actualizar(actualizar, this.id);
        } else {
            alumnoDB.insertar(campos, valores);
        }

        alumnoDB.desconecta();
    }

    public void setAtributo(String clave, String valor) {
        this.atributos.put(clave, valor);
    }

    public Map<String, String> getAtributos() {
        return this.atributos;
    }

    private String map2string() {
        String retorno = "";
        return retorno;
    }

    private String map2JsonString() {
        String retorno = "{";
        // atributos.forEach( (k,v) -> retorno+="\""+k+"\":\""+v+"\"" );
        for (Map.Entry<String, String> tupla : this.atributos.entrySet()) {
            retorno += "\"" + tupla.getKey() + "\":\"" + tupla.getValue() + "\",";
        }
        retorno = retorno.replaceAll(",$", "");
        retorno += "}";

        return retorno;
    }

    private Map<String, String> jsonString2map(String cadenaAtributos) {
        Map<String, String> retorno = new HashMap<String, String>();

        //String cadenaAtributos = "{ \"ojos\": \"azules\",\"pelo\": \"rubio\"}";
        JSONParser parser = new JSONParser();
        JSONObject jSonObj = new JSONObject();

        try {
            jSonObj = (JSONObject) parser.parse(cadenaAtributos);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Object obj : jSonObj.keySet()) {
            String clave = (String) obj;
            String valor = (String) jSonObj.get(clave);
            //	System.out.println(clave + " - " + valor);
            retorno.put(clave, valor);
        }

        return retorno;
    }

    public void cargar() {
        Alumnado alumnoDB = new Alumnado();
        alumnoDB.conecta();
        Map<String, String> sAlumno = alumnoDB.recuperar(this.id);
        //Map<String, String> map = new HashMap<String, String>();

        // mejor MAP ?
        this.nombre = sAlumno.get("nombre");
        this.apellido = sAlumno.get("apellido");
        this.email = sAlumno.get("email");
        String caracteristicas = sAlumno.get("caracteristicas");
        //caracteristicas = caracteristicas.replaceAll("\"", "\\\\\"");
        //caracteristicas = caracteristicas.replaceAll("\"", "\\\"");
        //caracteristicas = caracteristicas.replaceAll("\"", Matcher.quoteReplacement("\\\""));

        if (caracteristicas == null || caracteristicas.isEmpty()) {
            caracteristicas = "{}";
        } else {
            caracteristicas = caracteristicas.replaceAll("\"", "\\\"");
        }
        this.atributos = jsonString2map(caracteristicas);

        alumnoDB.desconecta();
    }

    @Override
    public String toString() {
        String retorno = "";

        retorno += this.nombre + " ";
        retorno += this.apellido + " ";
        retorno += this.email + " ";
        retorno += map2JsonString();

        return retorno;
    }

    public void cargar(int id) {
        this.id = id;
        cargar();
    }

    public void borrar() {
        Alumnado alumnoDB = new Alumnado();
        alumnoDB.conecta();
        alumnoDB.borrar(this.id);
        alumnoDB.desconecta();
    }

    public void borrar(int id) {
        this.id = id;
        borrar();
    }

}
