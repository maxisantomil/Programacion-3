package Ejercicio2;

import java.util.ArrayList;

public class mainR {

	public static void main(String[] args) {
		int [] arrayEnteros;
		arrayEnteros= new int[7];
		arrayEnteros[0]=10;
		arrayEnteros[1]=11;
		arrayEnteros[2]=12;
		arrayEnteros[3]=13;
		arrayEnteros[4]=14;
		arrayEnteros[5]=15;
		arrayEnteros[6]=16;
		ArrayList<Integer> aux= new ArrayList<>();
		aux.add(1);
		aux.add(2);
		aux.add(3);
		aux.add(4);
		aux.add(5);
		aux.add(6);
		aux.add(7);
		System.out.println(aux.size());
		System.out.println(buscarElementoLista(aux,5,0));
		System.out.println(buscarElementoArreglo(arrayEnteros,15,0,arrayEnteros.length));
	}

	public static int buscarElementoLista(ArrayList<Integer> aux,int valor,int pos) {
		if (pos <=aux.size()){
			if (aux.get(pos)!= valor) {
				return buscarElementoLista(aux,valor,pos+1);
			}
			else return pos;
		}
		
		return -1;
	}
	
	public static int buscarElementoArreglo(int[]A,int x, int inicio, int fin) {
		int medio;
		if (fin < inicio)
			return -1; //sucederá si no se encuentra el elemento
		else {
			medio = (inicio + fin) / 2; //al ser medio un int, se realiza un truncado
		if (x > A[medio])
			return buscarElementoArreglo(A, x, medio+1, fin);
		else
		if (x < A[medio])
			return buscarElementoArreglo(A,x, inicio, medio -1);
		else
			return medio;
		}
	}
}

