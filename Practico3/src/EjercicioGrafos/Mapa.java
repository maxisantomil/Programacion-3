package EjercicioGrafos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Mapa {
	private Grafo<Integer> grafo;
	private HashMap<Integer,Ciudad> ciudades;
	private HashMap<Integer,String> colores;
	
	public Mapa() {
		this.grafo = new GrafoNoDirigido<Integer>();
		this.ciudades = new HashMap<>();
		this.colores = new HashMap<>();
	}
	
	public void addCiudad(Ciudad ciudad) {
		this.ciudades.put(ciudad.getId(), ciudad);
		this.grafo.agregarVertice(ciudad.getId());
		this.colores.put(ciudad.getId(), "blanco");
	}
	
	public void borrarCiudad(Ciudad ciudad) {
		this.grafo.borrarVertice(ciudad.getId());
		this.ciudades.remove(ciudad.getId());
		System.out.println("se borro la ciudad: "+ ciudad.getNombre());
	}
	
	public void addRuta(Ciudad origen, Ciudad destino, int kilometros) {
		this.grafo.agregarArco(origen.getId(), destino.getId(), kilometros);
		System.out.println("se agrego la ruta: "+ origen+" - "+destino + " con una distancia de: "+ kilometros+" km");
	}

	public void borrarRuta(Ciudad origen, Ciudad destino) {
		this.grafo.borrarArco(origen.getId(), destino.getId());
		System.out.println("Se borro la ruta: " +origen.getNombre() +"-"+ destino.getNombre());
	}
	public void imprimirArcos() {
	Iterator<Arco<Integer>> itArcos = grafo.obtenerArcos();
	while(itArcos.hasNext()) {
		System.out.println(itArcos.next());
		}
	}
	
	public Camino encontrarMejorCamino(Ciudad origen, Ciudad destino, int limiteBalanza) {
		int dist=0;
		int cantBalanzas=0;
		Camino respuesta=new Camino();
		 ArrayList<ArrayList<Camino>> caminos=encontrarTodosCaminos(origen,destino);
		 for(ArrayList<Camino> arr: caminos) {
			 for(Camino c: arr) {
				 dist=this.sumatoriaEtiquetas(c);
				 cantBalanzas=this.cantidadDeBalanzas(c);
				 c.actualizacionDistancia(dist);
				 if(((limiteBalanza==0)||(cantBalanzas<=limiteBalanza))&&((respuesta.getDistancia()>c.getDistancia())||respuesta.getDistancia()==0)) {
					 respuesta=c;
				 }
			 }
		 }
			
		 return respuesta;
	}
	
	public ArrayList<ArrayList<Camino>> encontrarTodosCaminos(Ciudad origen, Ciudad destino) {

		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}

		return encontrarCamino(origen,destino);
	}

	public ArrayList<ArrayList<Camino>> encontrarCamino(Ciudad origen, Ciudad destino) {

		colores.put(origen.getId(), "amarillo");

		ArrayList<ArrayList<Camino>> resultado = new ArrayList<ArrayList<Camino>>();
		
		if (origen.getId() == destino.getId()) {
			ArrayList<Camino> aux= new ArrayList<>();
			Camino n= new Camino();
			n.addCiudad(origen);
			aux.add(n);
			resultado.add(aux);
		} else {
		
			Iterator<Integer> iterador = this.grafo.obtenerAdyacentes(origen.getId());
			while (iterador.hasNext()) {
//				int adyacente = it.next();
				 Ciudad adyacente= ciudades.get(iterador.next());
				if (colores.get(adyacente.getId()).equals("blanco")) {
					ArrayList<ArrayList<Camino>> caminosParciales = encontrarCamino(adyacente,destino);
					
					for (ArrayList<Camino> caminoParcial: caminosParciales) {
						ArrayList<Camino> caminoCompleto = new ArrayList<>();
						for(Camino c: caminoParcial) {
							c.addCiudad(origen);
						}
						caminoCompleto.addAll(caminoParcial);
						
						resultado.add(caminoCompleto);
					}

				}
					
			}
	
		}
		
		colores.put(origen.getId(), "blanco");

		return resultado;
	}
	 

	 private int sumatoriaEtiquetas(Camino c) {
			ArrayList<Ciudad> ciudades= c.getCamino();
			int dist=0;
			for(int i=0;i<c.getCamino().size()-1;i++) {
				dist+=this.grafo.obtenerArco(ciudades.get(i).getId(), ciudades.get(i+1).getId()).getEtiqueta();
			}
			return dist;
		}
	 
	 private int cantidadDeBalanzas(Camino c) {
			ArrayList<Ciudad> ciudades= c.getCamino();
			int cant=0;
			int ii=0;
			if(ciudades.get(0).isTieneBalanza()) {
				ii++;
			}
			for(int i=ii;i<c.getCamino().size()-1;i++) {
				if(ciudades.get(i).isTieneBalanza()) {
					cant++;
				}
			}
			return cant;
		}
}
