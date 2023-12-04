package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangulos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		float[] lados = new float[3];
		float lado;
		String orden = null;
		for (int numeroDeLado = 0; numeroDeLado < 3; numeroDeLado++) {
			do {
				try {
					switch (numeroDeLado) {
					case 0:
						orden = "primer";
						break;
					case 1:
						orden = "segundo";
						break;
					case 2:
						orden = "tercer";
						break;
					}
					System.out.println("Ingrese el valor del " + orden + " lado:");
					lado = in.nextFloat();
					if (lado > 0) {
						lados[numeroDeLado] = lado;
					} else {
						System.out.println("Valor no valido\n Debe ingresar un valor mayor a 0");
					}
				} catch (InputMismatchException e) {
					System.out.println("Error! Debe ingresar un numero");
					in.nextLine();
				}
			} while (lados[numeroDeLado] == 0);
		}
		System.out.println(Triangulos.getType(lados));
		in.close();
	}

	public static TypeTriangle getType(float[] lados) {
		float lado1 = lados[0];
		float lado2 = lados[1];
		float lado3 = lados[2];
		if (lado1 == lado2 && lado1 == lado3) {
			return TypeTriangle.EQUILATERO;
		} else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
			return TypeTriangle.ESCALENO;
		} else {
			return TypeTriangle.ISOSCELES;
		}
	}
}
