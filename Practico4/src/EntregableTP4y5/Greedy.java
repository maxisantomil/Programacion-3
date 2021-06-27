package EntregableTP4y5;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy {
	ComparadorFuerzaTrabajo c = new ComparadorFuerzaTrabajo();

	public Greedy() {

	}

	public boolean tengaEmpleados(ArrayList<Empleado> empleados) {
		return !empleados.isEmpty();
	}

	public Solucion Soluciongreedy(ArrayList<Empleado> empleados) {
		int contador = 0;
		GrupoEmpleado grupo1 = new GrupoEmpleado("gr1");
		GrupoEmpleado grupo2 = new GrupoEmpleado("gr2");
		Collections.sort(empleados, c);
		Collections.reverse(empleados);
		int cantEmpleados = empleados.size();

		while (tengaEmpleados(empleados)) {
			Empleado e = seleccionar(empleados);
			contador++;
			if (grupo1.esta_vacio() && grupo2.esta_vacio()) {
				grupo1.agregarEmpleado(e);

				if (tengaEmpleados(empleados)) {
					Empleado e2 = seleccionar(empleados);
					grupo2.agregarEmpleado(e2);
					contador++;
				}
			} else {
				if (es_factible(grupo1, grupo2)) {
					grupo1.agregarEmpleado(e);

				} else
					grupo2.agregarEmpleado(e);
			}
		}

		if (es_solucion(contador, cantEmpleados)) {
			Solucion solucionFinal = new Solucion(grupo1, grupo2, contador);
			return solucionFinal;
		}
		return null;
	}

	private boolean es_solucion(int contador, int cantEmpleados) {
		return contador == cantEmpleados;
	}

	private boolean es_factible(GrupoEmpleado grupo1, GrupoEmpleado grupo2) {
		return (grupo1.getFuerzaTotal() <= grupo2.getFuerzaTotal());
	}

	private Empleado seleccionar(ArrayList<Empleado> empleados) {
		Empleado emp = empleados.get(0);
		empleados.remove(0);
		return emp;
	}
}
