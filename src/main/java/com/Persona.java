package com;

public class Persona implements IPersona {

	private Integer altura;
	private Integer edad;
	private String nombre;

	public Persona(Integer altura, Integer edad, String nombre) {
		super();
		this.altura = altura;
		this.edad = edad;
		this.nombre = nombre;
	}

	@Override
	public Integer getAltura() {
		return altura;
	}

	@Override
	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	@Override
	public Integer getEdad() {
		return edad;
	}

	@Override
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
