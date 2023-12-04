package com;

public class Triangulo {

	/**
	 * Todos los lados iguales
	 * 
	 * @param lado1
	 * @param lado2
	 * @param lado3
	 * @return
	 */
	public static boolean isEquilatero(Float lado1, Float lado2, Float lado3) {
		boolean isEquilatero = lado1.equals(lado2) && lado1.equals(lado3);
		System.out.println("El triangulo con lados " + lado1 + " " + lado2 + " " + lado3 + (isEquilatero ? " " : " NO ")
				+ "es equilatero");
		return isEquilatero;
	}

	/**
	 * 2 lados iguales y 1 distinto
	 * 
	 * @param lado1
	 * @param lado2
	 * @param lado3
	 * @return
	 */
	public static boolean isIsosceles(Float lado1, Float lado2, Float lado3) {
		boolean isIsosceles = (lado1.equals(lado2) && !lado1.equals(lado3))
				|| (lado1.equals(lado3) && !lado1.equals(lado2)) || (lado2.equals(lado3) && !lado1.equals(lado2));
		System.out.println("El triangulo con lados " + lado1 + " " + lado2 + " " + lado3 + (isIsosceles ? " " : " NO ")
				+ "es isosceles");
		return isIsosceles;
	}

	/**
	 * Todos los lados son distintos
	 * 
	 * @param lado1
	 * @param lado2
	 * @param lado3
	 * @return
	 */
	static boolean isEscaleno(Float lado1, Float lado2, Float lado3) {
		boolean isEscaleno = !lado1.equals(lado2) && !lado1.equals(lado3) && !lado2.equals(lado3);
		System.out.println("El triangulo con lados " + lado1 + " " + lado2 + " " + lado3 + (isEscaleno ? " " : " NO ")
				+ "es escaleno");
		return isEscaleno;
	}

	public static TypeTriangle getType(Float lado1, Float lado2, Float lado3) {
		if (lado1.equals(lado2) && lado1.equals(lado3)) {
			return TypeTriangle.EQUILATERO;
		} else if (!lado1.equals(lado2) && !lado1.equals(lado3) && !lado2.equals(lado3)) {
			return TypeTriangle.ESCALENO;
		} else {
			return TypeTriangle.ISOSCELES;
		}
	}

	public static void main(String[] args) {
		Triangulo.isEquilatero(3f, 3f, 3f);
		Triangulo.isIsosceles(3f, 3f, 3f);
		Triangulo.isEscaleno(3f, 3f, 3f);
		System.out.println("");
		Triangulo.isEquilatero(3f, 4f, 4f);
		Triangulo.isIsosceles(3f, 4f, 4f);
		Triangulo.isEscaleno(3f, 4f, 4f);
		System.out.println("");
		Triangulo.isEquilatero(3f, 4f, 5f);
		Triangulo.isIsosceles(3f, 4f, 5f);
		Triangulo.isEscaleno(3f, 4f, 5f);
	}
}
