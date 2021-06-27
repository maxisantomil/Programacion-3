package EntregableTP4y5;

import java.util.ArrayList;

public class MainGreedy {

	public static void main(String[] args) {
		Empleado e1 = new Empleado("e1", "Juan", "Perez", 34, 48);
		Empleado e2 = new Empleado("e2", "Roberto", "Hernandez", 34, 57);
		Empleado e3 = new Empleado("e3", "Camila", "Gutierrez", 34, 51);
		Empleado e4 = new Empleado("e4", "Francisco", "Martinez", 34, 73);
		Empleado e5 = new Empleado("e5", "Benjamin", "Nuñez", 34, 15);
		Empleado e6 = new Empleado("e6", "Mateo", "Morales", 34, 33);
		Empleado e7 = new Empleado("e7", "Delfina", "Lopez", 36, 92);
		Empleado e8 = new Empleado("e8", "Catalina", "Cruz", 51, 71);
		Empleado e9 = new Empleado("e9", "Benicio", "Montero", 48, 19);
		Empleado e10 = new Empleado("e10", "Valentino", "Gonzalez", 58, 22);
		Empleado e11 = new Empleado("e11", "Olivia", "Gomez", 33, 41);
		Empleado e12 = new Empleado("e12", "Martina", "Diaz", 21, 49);
		Empleado e13 = new Empleado("e13", "Joaquin", "Cabrera", 22, 14);
		Empleado e14 = new Empleado("e14", "Bautista", "Dominguez", 36, 33);
		Empleado e15 = new Empleado("e15", "Emilia", "Paz", 40, 16);
		Empleado e16 = new Empleado("e16", "Francesca", "Figueroa", 43, 21);
		Empleado e17 = new Empleado("e17", "Santino", "Blanco", 25, 79);
		Empleado e18 = new Empleado("e18", "Ignacio", "Ibarra", 61, 32);
		Empleado e19 = new Empleado("e19", "Andrea", "Chavez", 27, 78);
		Empleado e20 = new Empleado("e20", "Elena", "Mengochea", 52, 67);

		ArrayList<Empleado> empleadosEntrada1 = new ArrayList<>();
		empleadosEntrada1.add(e1);
		empleadosEntrada1.add(e2);
		empleadosEntrada1.add(e3);
		empleadosEntrada1.add(e4);
		empleadosEntrada1.add(e5);
		empleadosEntrada1.add(e6);

		Greedy greedy = new Greedy();

		System.out.println(greedy.Soluciongreedy(empleadosEntrada1));
		ArrayList<Empleado> empleadosEntrada2 = new ArrayList<>();
		empleadosEntrada2.add(e7);
		empleadosEntrada2.add(e4);
		empleadosEntrada2.add(e8);
		empleadosEntrada2.add(e15);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada2));

		ArrayList<Empleado> empleadosEntrada3 = new ArrayList<>();
		empleadosEntrada3.add(e19);
		empleadosEntrada3.add(e12);
		empleadosEntrada3.add(e11);
		empleadosEntrada3.add(e13);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada3));

		ArrayList<Empleado> empleadosEntrada4 = new ArrayList<>();
		empleadosEntrada4.add(e19);
		empleadosEntrada4.add(e18);
		empleadosEntrada4.add(e14);
		empleadosEntrada4.add(e16);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada4));

		ArrayList<Empleado> empleadosEntrada5 = new ArrayList<>();
		empleadosEntrada5.add(e7);
		empleadosEntrada5.add(e8);
		empleadosEntrada5.add(e20);
		empleadosEntrada5.add(e3);
		empleadosEntrada5.add(e16);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada5));

		ArrayList<Empleado> empleadosEntrada6 = new ArrayList<>();
		empleadosEntrada6.add(e6);
		empleadosEntrada6.add(e15);
		empleadosEntrada6.add(e17);
		empleadosEntrada6.add(e13);
		empleadosEntrada6.add(e16);
		empleadosEntrada6.add(e10);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada6));

		ArrayList<Empleado> empleadosEntrada7 = new ArrayList<>();
		empleadosEntrada7.add(e17);
		empleadosEntrada7.add(e2);
		empleadosEntrada7.add(e19);
		empleadosEntrada7.add(e20);
		empleadosEntrada7.add(e4);
		empleadosEntrada7.add(e12);
		empleadosEntrada7.add(e15);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada7));

		ArrayList<Empleado> empleadosEntrada8 = new ArrayList<>();
		empleadosEntrada8.add(e12);
		empleadosEntrada8.add(e14);
		empleadosEntrada8.add(e18);
		empleadosEntrada8.add(e6);
		empleadosEntrada8.add(e2);
		empleadosEntrada8.add(e9);
		empleadosEntrada8.add(e10);
		empleadosEntrada8.add(e16);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada8));

		ArrayList<Empleado> empleadosEntrada9 = new ArrayList<>();
		empleadosEntrada9.add(e1);
		empleadosEntrada9.add(e2);
		empleadosEntrada9.add(e3);
		empleadosEntrada9.add(e4);
		empleadosEntrada9.add(e5);
		empleadosEntrada9.add(e6);
		empleadosEntrada9.add(e7);
		empleadosEntrada9.add(e8);
		empleadosEntrada9.add(e9);
		empleadosEntrada9.add(e10);
		empleadosEntrada9.add(e11);
		empleadosEntrada9.add(e12);
		empleadosEntrada9.add(e13);
		empleadosEntrada9.add(e14);
		empleadosEntrada9.add(e15);
		empleadosEntrada9.add(e16);
		empleadosEntrada9.add(e17);
		empleadosEntrada9.add(e18);
		empleadosEntrada9.add(e19);
		empleadosEntrada9.add(e20);
		System.out.println(greedy.Soluciongreedy(empleadosEntrada9));
	}

}
