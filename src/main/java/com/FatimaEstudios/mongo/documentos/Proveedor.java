package com.FatimaEstudios.mongo.documentos;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Proveedor")
public class Proveedor {

	@Id
	private int id;
	
	private String nombre;
	private String apellidos;
	private String dni;


	   
	   /*CONSTRUCTOR*/
	   
	   /*Representa un data de la bd mongo*/
	   
		public Proveedor(int id, String nombre, String apellidos, String dni) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.dni = dni;
		}
	   
	   
	   
	   
	   
	   /*GUETTER AND SETTER*/

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	   
	
}
