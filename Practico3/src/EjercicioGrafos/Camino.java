package EjercicioGrafos;

import java.util.ArrayList;

public class Camino {
	private ArrayList<Ciudad>camino;
	private int distancia;

			public Camino() {
				camino= new ArrayList<>();
				distancia=0;
			}
		
		public void addCiudad(Ciudad c) {
			camino.add(0,c);
		}

		public ArrayList<Ciudad> getCamino() {
			return camino;
		}

		public void setCiudades(ArrayList<Ciudad> ciudades) {
			this.camino = ciudades;
		}

		public int getDistancia() {
			return distancia;
		}
		public void actualizacionDistancia(int distancia) {
			this.distancia = distancia;
		}
		
	
		public void addCiudades(Camino encontrarCamino) {
			camino.addAll(encontrarCamino.getCamino());
			
		}
		@Override
		public String toString() {
			return  "El camino mas corto es : "+camino + "con una distancia total de : " + distancia + " km";
		}

		
		
		
}
