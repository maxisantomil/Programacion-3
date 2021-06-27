package entregable3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		HashMap<Integer, Tarea> tareas = new HashMap<Integer, Tarea>();
		GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		
		Tarea t = new Tarea("tarea 0", "algo", 0);
		agregarTarea(0,t, tareas, grafo);
		
		Tarea t1 = new Tarea("tarea 1", "algo", 4);
		agregarTarea(1,t1, tareas, grafo);
		
		Tarea t2 = new Tarea("tarea 2", "algo", 18);
		agregarTarea(2,t2, tareas, grafo);
		
		Tarea t3 = new Tarea("tarea 3", "algo", 4);
		agregarTarea(3,t3, tareas, grafo);

		Tarea t4 = new Tarea("tarea 4", "algo", 13);
		agregarTarea(4,t4, tareas, grafo);

		Tarea t5 = new Tarea("tarea 5", "algo", 22);
		agregarTarea(5,t5, tareas, grafo);

		Tarea t6 = new Tarea("tarea 6", "algo", 18);
		agregarTarea(6,t6, tareas, grafo);

		Tarea t7 = new Tarea("tarea 7", "algo", 12);
		agregarTarea(7,t7, tareas, grafo);

		Tarea t8 = new Tarea("tarea 8", "algo", 3);
		agregarTarea(8,t8, tareas, grafo);

		Tarea t9 = new Tarea("tarea 9", "algo", 2);
		agregarTarea(9,t9, tareas, grafo);

		Tarea t10 = new Tarea("tarea 10", "algo", 3);
		agregarTarea(10,t10, tareas, grafo);

		Tarea t11 = new Tarea("tarea 11", "algo", 1);
		agregarTarea(11,t11, tareas, grafo);

		Tarea t12 = new Tarea("tarea 12", "algo", 5);
		agregarTarea(12,t12, tareas, grafo);
	
		
		grafo.agregarArco(0, 1, 0);
		grafo.agregarArco(0, 2, 0);
		grafo.agregarArco(1, 3, 3);
		grafo.agregarArco(2, 5, 1);
		grafo.agregarArco(2, 7, 12);
		grafo.agregarArco(3, 4, 5);
		grafo.agregarArco(3, 6, 8);
		grafo.agregarArco(4, 11, 3);
		grafo.agregarArco(5, 6, 2);
		grafo.agregarArco(6, 10, 6);
		grafo.agregarArco(6, 12, 2);
		grafo.agregarArco(7, 8, 7);
		grafo.agregarArco(8, 9, 4);
		grafo.agregarArco(9, 10, 3);
		
		dfs(grafo, tareas);
		
		System.out.println(grafo.existeArco(5, 6));
		grafo.borrarArco(5, 6);
		grafo.borrarVertice(1);
		System.out.println(grafo.existeArco(5, 6));
	}

	public static void dfs(GrafoDirigido<Integer> grafo, HashMap<Integer, Tarea> tareas) {

		String[] visitado = new String[grafo.cantidadVertices()];
		ArrayList<Tarea> recorridoCritico = new ArrayList<>();
		ArrayList<Tarea> recorrido = new ArrayList<>();
		int tiempo = 0;
		Tarea.setTiempoCritico(tiempo); // cree un atributo de clase para que guarde el tiempo mayor en realzar las tareas, lo hice static porq me parece que corresponde mas al conjunto de las tareas, mas que a una sola en particular.
		
		for(Integer i: tareas.keySet()) {
			visitado[i] = "blanco";
		}
		
		Integer tarea0 = 0;
		
		if(tareas.containsKey(tarea0)) {
			tiempo = tareas.get(tarea0).getHoras();
			recorridoDFS(grafo,tareas,tiempo, tarea0, visitado, recorridoCritico, recorrido);
		}
		//Empiezo a recorrer desde la tarea 0-> vertice 0
		for(Tarea t: recorridoCritico) {
			System.out.print("[" + t.getNombre() + "]");
		}
		System.out.println("  conjunto de tareas con mayor tiempo de ejecucion en: " + Tarea.getTiempoCritico() + " hs");
	}
	
	private static void recorridoDFS(GrafoDirigido<Integer> grafo,HashMap<Integer, Tarea> tareas,int tiempo, Integer v, String[] visitado, ArrayList<Tarea> recorridoCritico, ArrayList<Tarea> recorrido) {
		
		visitado[v] = "amarillo";
		Iterator<Integer> it = grafo.obtenerAdyacentes(v);
		recorrido.add(tareas.get(v));
		int tmpT = tiempo;
		int ady = 0;

		
		while(it.hasNext()) {
			ady = it.next();
			tmpT += tareas.get(ady).getHoras() + grafo.obtenerArco(v, ady).getEtiqueta();
			if(visitado[ady]=="blanco") {
				recorridoDFS(grafo, tareas, tmpT,ady,visitado,recorridoCritico, recorrido);	
			}
			tmpT -=tareas.get(ady).getHoras() + grafo.obtenerArco(v, ady).getEtiqueta();
		}
		int tiempoCritico = Tarea.getTiempoCritico();
		
		if(tiempoCritico<tmpT) {
			Tarea.setTiempoCritico(tmpT);
			recorridoCritico.clear();
			recorridoCritico.addAll(recorrido);
		}
		recorrido.remove(tareas.get(v));
		visitado[v] = "blanco";
	}

	public static void agregarTarea(int i, Tarea t, HashMap<Integer, Tarea> tareas, GrafoDirigido<Integer> grafo) {
		tareas.put(i, t);
		grafo.agregarVertice(i);
	}
}
