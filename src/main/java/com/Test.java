package com;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		int[] vals = { 2, 2, 1, 1, 1, 4, 1 };
		Integer numberWithMaxCant = Test.repetirse(vals);
	}

	public static int repetirse(int a[]) {
		Map<Integer, Integer> map = new HashMap<>();
		// Guardo todos los elementos en el mapa con su correspondiente cantidad de repeticiones
		for (int i = 0; i < a.length; i++) {
			Integer cant = 0;
			if (map.containsKey(a[i])) {
				cant = map.get(a[i]);
			}
			map.put(a[i], cant + 1);
		}
		// Busco el elemento que más se repite
		Integer maxCant = 0;
		Integer numberWithMaxCant = 0;
		for (Integer elemnt : map.keySet()) {
			Integer cant = map.get(elemnt);
			if (maxCant < cant) {
				maxCant = cant;
				numberWithMaxCant = elemnt;
			}
		}
		System.out.println("Number with max cant is : " + numberWithMaxCant);
		System.out.println("Number of repeats: " + maxCant);
		return numberWithMaxCant;
	}
}
