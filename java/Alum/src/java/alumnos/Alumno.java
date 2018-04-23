/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

/**
 *
 * @author devweb
 */
public class Alumno {
	private int id;
	private String nombre;
	private String apellido;
	private String mail;
        private int active = 1;
        private String caracteristicas;
        
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
        public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
        public int getActive() {
		return active;
	}
	public void setActive(int activo) {
		this.active = activo;
	}
        public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String texto) {
		this.caracteristicas = texto;
	}
        
}