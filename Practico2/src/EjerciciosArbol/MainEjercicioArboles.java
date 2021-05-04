package EjerciciosArbol;

import java.util.ArrayList;

public class MainEjercicioArboles {

	public static void main(String[] args) {
	
	int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
	ArrayList<Integer>aux= new ArrayList<Integer>();
	Tree miArbol= new Tree(valoresIniciales);
	
	System.out.println("////////////parte 1////////////");
	miArbol.printPreOrder();
	System.out.println("");
	System.out.println( "el valor del maximo elemento es de: "+miArbol.getMaxElement() );
	System.out.println( "la altura del arbol es: "+ miArbol.getHeight() );
	System.out.println( miArbol.getLongestBranch() );
	System.out.println( miArbol.getElementAtLevel(2) );
	System.out.println( miArbol.getFrontera() );
	
	System.out.println("////////////parte 2////////////");
	miArbol.add(23);
	miArbol.add(3);
	miArbol.delete(6);
	miArbol.delete(30);
	
	miArbol.printPreOrder();
	System.out.println("");
	System.out.println( miArbol.getMaxElement() );
	System.out.println( miArbol.getHeight() );
	System.out.println( miArbol.getLongestBranch() );
	System.out.println( miArbol.getElementAtLevel(2) );
	System.out.println( miArbol.getFrontera() );
	System.out.println("////////////parte 3////////////");
	miArbol.add(65);
	miArbol.delete(5);
	miArbol.delete(15);
	miArbol.add(55);
	miArbol.printPreOrder();
	System.out.println( miArbol.getMaxElement() );
	System.out.println( miArbol.getHeight() );
	System.out.println( miArbol.getLongestBranch() );
	System.out.println( miArbol.getElementAtLevel(2) );
	System.out.println( miArbol.getFrontera() );
	}

}
