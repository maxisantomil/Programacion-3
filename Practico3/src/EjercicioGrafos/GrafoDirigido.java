package EjercicioGrafos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class GrafoDirigido<T> implements Grafo<T> {
private HashMap<Integer, Vertice> mapeo;
	
	
	public GrafoDirigido() {
		mapeo = new HashMap<Integer, Vertice>();
	}
	
	@Override
	public void agregarVertice(int verticeId) {  //Complejidad O(1), es un tiempo constante
		
		if(!mapeo.containsKey(verticeId)) {
			mapeo.put(verticeId, new Vertice(verticeId));
		}
	}

	@Override
	public void borrarVertice(int verticeId) { //Complejidad O(2n) primero recorre buscando el vertice, una vez que lo encuentra vuelve a recorrer para
											   //eliminar de los demas vertices donde el esta como adyacente
		if(mapeo.containsKey(verticeId)) {
			borrarDeAdyacente(verticeId);
			mapeo.remove(verticeId);
			//System.out.println("se borro el vertice");
		}
	}
	

	private void borrarDeAdyacente(int verticeId) {
		for(Vertice v:mapeo.values()) {
			if(v.getVerticeId()!= verticeId) {
				v.borrarArco(verticeId);
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {// Complejidad O(2n) busca dos veces si existen los arcos, y luego lo agrega 
		Arco<T> aux= new Arco<T>(verticeId1, verticeId2, etiqueta);
		
		if((mapeo.containsKey(verticeId1))&&(mapeo.containsKey(verticeId2))) {
			if(!mapeo.get(verticeId1).existeArco(verticeId2)) {
				mapeo.get(verticeId1).agregarArco(aux);
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {// complejidad O(n + a), n son los vertices que recorre, y a los arcos que recorre del vertice
		
		if(mapeo.containsKey(verticeId1)) {
			mapeo.get(verticeId1).borrarArco(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) { // complejidad O(n) donde n es la cantidad de vertices que tiene el mapeo.
		return mapeo.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {// Complejidad O(v + a), recorre los vertices, y luego los arcos del mismo
		if(mapeo.containsKey(verticeId1)) 
		return	mapeo.get(verticeId1).existeArco(verticeId2);
		
		else
			return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {// Complejidad O(v + a), recorre los vertices, y luego los arcos del mismo
		Arco<T> aux = null;
		if(mapeo.containsKey(verticeId1)) {
			aux = mapeo.get(verticeId1).getArco(verticeId2);
		}
		return aux;
	}

	@Override
	public int cantidadVertices() { //complejidad O(1), tiempo constante
		return mapeo.size();
	}

	@Override
	public int cantidadArcos() {// O(n), n son los vertices que guarda el grafo, y por cada uno pregunta su cantidad de arcos, que es O(1),  
		int aux =0;
		for(Vertice v:mapeo.values()) {
			aux += v.cantidadArcos();
		}
		return aux;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {// Complejidad O(n) donde n es la cantidad de vertices que guarda
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		for(Vertice v:mapeo.values()) {
			c.add(v.getVerticeId());
		}
		return c.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {// Complejidad O(n + a + v) donde n es la cantidad vertices del arreglo, a su vez recorre los
															 //arcos que tiene cada vertice que es a, y tambien por cada arco los vertices adyacentes que es v
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		for(Vertice v:mapeo.values()) {
			if(v.getVerticeId()==verticeId) {
				for(Arco<T> a:v.getArcos()) {
					c.add(a.getVerticeDestino());
				}
			}
		}
		return c.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {// Complejidad O(v + a), donde v son los vertices del grafo, y a son los arcos de cada vertice
		ArrayList<Arco<T>> c= new ArrayList<Arco<T>>();
		
		for(Vertice v:mapeo.values()) {
			for(Arco<T> ar:v.getArcos()) {
				c.add(ar);
			}
		}
		return c.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) { //Complejidad O(n) donde n son la cantidad de vertices que tiene el grafo
		ArrayList<Arco<T>> c= new ArrayList<Arco<T>>();
		if(mapeo.containsKey(verticeId)) {
			c = mapeo.get(verticeId).arcos;
		}
		return c.iterator();
	}

	/*---------------------------------------------------- Arranca la clase vertice ------------------------------------------------------------- */
	public class Vertice{
		int verticeId;
		ArrayList<Arco<T>> arcos;
		
		public Vertice(int id) {
			this.verticeId = id;
			arcos = new ArrayList<Arco<T>>();
		}

		public Arco<T> getArco(int verticeId2) {
			Arco<T> aux = null;
			
			if(this.existeArco(verticeId2)) {
				for(Arco<T> ar: arcos) {
					if(ar.getVerticeDestino() == verticeId2) {
						aux = ar;
					}
				}
			}
			return aux;
		}

		public void borrarArco(int verticeId2) {
			if(this.existeArco(verticeId2)) {
				Arco<T> aux = null;
				for(Arco<T> ar: arcos) {
					if(ar.getVerticeDestino() == verticeId2) {
						aux = ar;
					}
				}
				arcos.remove(aux);
			}
		}

		public int cantidadArcos() {
			return arcos.size();
		}

		public int getVerticeId() {
			return verticeId;
		}
		
		public void agregarArco(Arco<T> a) {
			this.arcos.add(a);
		}

		public ArrayList<Arco<T>> getArcos() {
			return arcos;
		}
		public boolean existeArco(int idAdyacente) {
			boolean adyacente = false;
			for(Arco<T> ar: arcos) {
				if(ar.getVerticeDestino() == idAdyacente) {
					adyacente = true;
				}
			}
			return adyacente;
		}
		
	}

}
