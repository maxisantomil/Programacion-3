package EntregableTP4y5;

import java.util.ArrayList;
import java.util.Collections;

public class Backtracking {
private int contador=-1;
	public Solucion solucionBack(ArrayList<Empleado>candidatos) {
		int totalCandidatos=candidatos.size();
		if (candidatos.isEmpty()) {
			return null;
		}else {
			Solucion solucion = new Solucion();
			Solucion mejorSolucion = new Solucion();
			GrupoEmpleado grupo1 = new GrupoEmpleado("gr1");
			GrupoEmpleado grupo2 = new GrupoEmpleado("gr2");
			solucion.setGrupo1(grupo1);
			solucion.setGrupo2(grupo2);
			ArrayList<Empleado>auxiliar= candidatos;
			return solucionBack(auxiliar,candidatos,solucion,mejorSolucion,totalCandidatos,contador);
		}
	}

	private Solucion solucionBack(ArrayList<Empleado>auxiliar,ArrayList<Empleado>candidatos,Solucion solucion,Solucion mejorSolucion,int totalCandidatos,int contador) {
		if (es_estado_final(contador,totalCandidatos)) {
			 if (es_solucion(solucion)) 
				 mejorSolucion=solucion;
		} 
		 	else {
			 while (!auxiliar.isEmpty()) { // por cada hijo
				Empleado e = seleccionar(auxiliar);
				 
				 if (solucion.getGrupo1().getFuerzaTotal()<= solucion.getGrupo2().getFuerzaTotal()) { 
					 solucion.getGrupo1().agregarEmpleado(e);
				 	}
					 else {
						 solucion.getGrupo2().agregarEmpleado(e);
					 }
					 solucionBack(auxiliar,candidatos, solucion,mejorSolucion,totalCandidatos,contador++); // Llamo recursivamente
					 //deshacerCambios(estado,siguiente,posicionOriginal); // deshago los cambios
			 		}
			
			 	}
		 System.out.println(solucion);
		 auxiliar=candidatos;
		return solucion;
		}
	
	private boolean es_solucion(Solucion solucion) {
	return true;
	}

	private boolean es_estado_final(int contador,int totalCandidatos) {
		return contador==totalCandidatos;
	}
	
	private Empleado seleccionar(ArrayList<Empleado> empleados) {
		Empleado emp = empleados.get(0);
		empleados.remove(0);
		return emp;
	}

}