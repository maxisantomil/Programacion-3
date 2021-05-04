package Ejercicio1;

import java.util.Iterator;

public class main {
	
	
	
	public static boolean buscar(int valor, MySimpleLinkedList lista2) {
		for (int valor2:lista2) {
			if (valor==valor2) {
				return true;
			}
		}
		return false;
	}
	
	public static MySimpleLinkedList listaEnComun(MySimpleLinkedList lista1,MySimpleLinkedList lista2) {
		MySimpleLinkedList comun= new MySimpleLinkedList();
		MyIterator iteratorLista1=lista1.iterator();
		MyIterator iteratorLista2=lista2.iterator();
		
		while (iteratorLista1.hasNext()) {    // es lo mismo que hacerlo con un FOR??
			int valor1=iteratorLista1.next();   
			if (buscar(valor1,lista2)) {
				if (comun.indexOf(valor1)==-1) {
					comun.insertAlFinal(valor1);
				}
			}
		}
		
		comun.ordenar();
		return comun;
	}

	

	public static void main(String[] args) {
		MySimpleLinkedList e1= new MySimpleLinkedList();
		MySimpleLinkedList e2= new MySimpleLinkedList();
		Node aux = new Node(9,null);
		e1.insertAlFinal(9);
		e1.insertAlFinal(7);
		e1.insertAlFinal(3);
		e1.insertAlFinal(2);
		e1.insertAlFinal(11);
		
		e2.insertAlFinal(5);
		e2.insertAlFinal(3);
		e2.insertAlFinal(12);
		e2.insertAlFinal(15);
		e2.insertAlFinal(9);
		
		//probando iterador y mostrando lista completa
		Iterator<Integer> iterator=e1.iterator();
		
		for(Integer valor:e1) {  //O(n) n =e1.size();
			System.out.println(valor); //O(1)
		}
		
	
		//System.out.println(e1.extractFront().);
		System.out.println("esta vacio? " + e1.isEmpty());
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println("elemento de la primer posicion: "+ e1.get(1));
		System.out.println(e1.get(2));
		System.out.println(e1.get(3));
		//System.out.println(e1.extractBack());
		//System.out.println(e1.toString());
		System.out.println(e1.indexOf(10));
		System.out.println(listaEnComun(e1, e2));
		System.out.println(listaEnComun(e1,e2));
	}

}
