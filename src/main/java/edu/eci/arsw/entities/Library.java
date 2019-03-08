package edu.eci.arsw.entities;

import java.util.ArrayList;
import java.util.List;

public class Library {

	Integer id;
	String nombre;
	String direccion;
	String telefono;
	List<Book> books;
	
	public Library(Integer id, String nombre, String direccion, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.books = new ArrayList<Book>();
	}
	
	public Library(Integer id, String nombre, String direccion, String telefono, List<Book> books) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.books = books;
	}
	
	public int getId() {
		return this.id;
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
	
	public void setBooks(List<Book> books){
		this.books = books;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
