package Ejercicio3Ordenamientos;

public class Main {

	public static void ordenarSeleccion(int[]arr) {
		
		for (int i=0;i < arr.length-1;i++) {
			int menor=i;
			for (int j=i+1;j< arr.length;j++) {
				if (arr[j]< arr[menor]) {
					menor=j;
				}
			}
			if (i!=menor) {
				int aux=arr[i];
				arr[i]=arr[menor];
				arr[menor]=aux;
			}
		}
	}
	
	public static void ordenarBurbujeo(int[]arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i=0; i<arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}
	
	public static void imprimir(int[]arr) {
		for (int i=0;i< arr.length;i++) {
			System.out.print("["+arr[i]+"]");
		}
	}
	
	public static void main(String[] args) {
	int[]arrEnteros = {7,3,9,8,10,5,1};
	imprimir(arrEnteros);
	ordenarBurbujeo(arrEnteros);
	System.out.println("");
	imprimir(arrEnteros);
	System.out.println("");
	//ordenarSeleccion(arrEnteros);
	//System.out.println("-----------------");
	//imprimir(arrEnteros);
	}

}
