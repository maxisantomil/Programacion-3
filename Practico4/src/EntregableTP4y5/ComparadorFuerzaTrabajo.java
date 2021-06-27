package EntregableTP4y5;

public class ComparadorFuerzaTrabajo extends Comparador{

	@Override
	public int compare(Empleado e1, Empleado e2) {
	return Integer.compare(e1.getFuerza_trabajo(), e2.getFuerza_trabajo());
	}
	
}
