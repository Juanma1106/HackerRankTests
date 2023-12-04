package com;

public class Auto implements IAuto {

	private String color;
	private String marca;

	public Auto(String color, String marca) {
		super();
		this.color = color;
		this.marca = marca;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getMarca() {
		return marca;
	}

	@Override
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
