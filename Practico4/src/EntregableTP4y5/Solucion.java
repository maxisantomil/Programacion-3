package EntregableTP4y5;

import java.util.ArrayList;

public class Solucion {
	
	private GrupoEmpleado grupo1;
	private GrupoEmpleado grupo2;
	private int contador;

	
	public Solucion () {
		contador=0;
	}
	
	public Solucion(GrupoEmpleado grupo1, GrupoEmpleado grupo2,int cont) {
		this.grupo1 = grupo1;
		this.grupo2 = grupo2;
		this.contador = cont;
	}
	
	public GrupoEmpleado getGrupo1() {
		return grupo1;
	}

	public void setGrupo1(GrupoEmpleado grupo1) {
		this.grupo1 = grupo1;
	}

	public  GrupoEmpleado getGrupo2() {
		return grupo2;
	}

	public void setGrupo2(GrupoEmpleado  grupo2) {
		this.grupo2 = grupo2;
	}

	@Override
	public String toString() {
		return "Solucion [grupo1=" + grupo1 + ", grupo2=" + grupo2 + "contador Empleados: " +contador+"]";
	}
	
	
}
