package EntregableTP4y5;

import java.util.ArrayList;

public class GrupoEmpleado {
	private String id;
	private ArrayList<Empleado> grupo ;
	private int fuerzaTotal;
	
	
	public int getFuerzaTotal() {
		return fuerzaTotal;
	}


	public GrupoEmpleado(String g) {
		id=g;
	    grupo = new ArrayList<>();
		fuerzaTotal=0;
	}
	
	
	public void sumarFuerza(int f) {
		fuerzaTotal+=f;
	}
	
	
	public void agregarEmpleado(Empleado e ) {
		grupo.add(e);
		fuerzaTotal+=e.getFuerza_trabajo();
	}
	
	public boolean esta_vacio() {
		if (grupo.isEmpty())
			return true;
		return false;
	}


	@Override
	public String toString() {
		return grupo+", fuerzaTotal=" + fuerzaTotal + "]";
	}
	
}
