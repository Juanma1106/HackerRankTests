package com;

public class Cosas implements IPersona, IAuto {

	private IAuto auto;
	private IPersona persona;

	public Cosas(IAuto auto, IPersona persona) {
		super();
		this.auto = auto;
		this.persona = persona;
	}

	@Override
	public String getColor() {
		return auto.getColor();
	}

	@Override
	public void setColor(String color) {
		auto.setColor(color);
	}

	@Override
	public String getMarca() {
		return auto.getMarca();
	}

	@Override
	public void setMarca(String marca) {
		auto.setMarca(marca);
	}

	@Override
	public Integer getAltura() {
		return persona.getAltura();
	}

	@Override
	public void setAltura(Integer altura) {
		persona.setAltura(altura);
	}

	@Override
	public Integer getEdad() {
		return persona.getEdad();
	}

	@Override
	public void setEdad(Integer edad) {
		persona.setEdad(edad);
	}

	@Override
	public String getNombre() {
		return persona.getNombre();
	}

	@Override
	public void setNombre(String nombre) {
		persona.setNombre(nombre);
	}
}
