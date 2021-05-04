package Ejercicio1;

public class ArregloOrdenado {
	int [] arrayEnteros;
	
	
	public ArregloOrdenado() {
		arrayEnteros= new int[5];
		arrayEnteros[0]=1;
		arrayEnteros[1]=2;
		arrayEnteros[2]=10;
		arrayEnteros[3]=4;
		arrayEnteros[4]=5;
	}
	
	public void imprimirArreglo(int i) {
		if (i >=0) {
			imprimirArreglo(i-1);
			System.out.println(arrayEnteros[i]);
			
		}
	}
	
	
	public boolean estaOrdenado(int indice ) { //O(n) en el peor de los casos voy hasta el final 
		if (indice+1 >= arrayEnteros.length) {
			return true;
		}else {
			if (arrayEnteros[indice]> arrayEnteros[indice+1]) {
				return false;
			}
			else return estaOrdenado(indice +1);
		}
	}
}
	
