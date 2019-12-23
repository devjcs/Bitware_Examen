package com.devjocs.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {


	private String id;
	private String nombre;
	private String apellidos;
	private String nombre_usuario;
	private String correo_electronico;
	private String contrasena;
	private String edad;
	private String estatura;
	private String peso;
	private String geb;
	
	public Client() {
		
	}

	public Client(String nombre, String apellidos, String nombre_usuario, String correo_electronico, String contrasena) {
		this.id = "C"+nombre.charAt(1)+apellidos.charAt(0)+contrasena.charAt(2);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_usuario = nombre_usuario;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
	}
	
	public Client(String id,String nombre, String apellidos, String nombre_usuario, String correo_electronico, String contrasena,
			String edad, String estatura, String peso, String geb) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_usuario = nombre_usuario;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
		this.edad = edad;
		this.estatura = estatura;
		this.peso = peso;
		this.geb = geb;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getGeb() {
		return geb;
	}

	public void setGeb(String geb) {
		this.geb = geb;
	}
	
}
