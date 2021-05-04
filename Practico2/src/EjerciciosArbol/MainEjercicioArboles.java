package EjerciciosArbol;

import java.util.ArrayList;

public class MainEjercicioArboles {

	public static void main(String[] args) {
	Tree Arbol= new Tree(15);
	ArrayList<Integer>aux= new ArrayList<Integer>();
	Arbol.add(6);
	Arbol.add(3);
	Arbol.add(2);
	Arbol.add(4);
	Arbol.add(7);
	Arbol.add(13);
	Arbol.add(9);
	Arbol.add(18);
	Arbol.add(17);
	Arbol.add(20);
	Arbol.printPreorder();
	System.out.println(Arbol.hasElement(18));
	System.out.println(Arbol.isEmpty());
	System.out.println(Arbol.size());
	Arbol.printInorder();
	System.out.println(Arbol.getHeight());
	System.out.println(Arbol.getFrontera());
	System.out.println(Arbol.getMaxELement());
	System.out.println("los elementos del nivel 2 son:" + Arbol.getElemAtLevel(1));
	System.out.println(Arbol.getLongestBranch());
	System.out.println(Arbol.delete(18));
	Arbol.printPreorder();
	}

}
