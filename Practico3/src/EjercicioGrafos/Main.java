package EjercicioGrafos;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		
		Ciudad ayacucho = new Ciudad(1,"Ayacucho");
		Ciudad tandil = new Ciudad(2,"Tandil");
		Ciudad bolivar = new Ciudad(3,"Bolivar");
		Ciudad pehuajo = new Ciudad(4,"Pehuajo");
		Ciudad olavarria = new Ciudad(5,"Olavarria");
		Ciudad rauch = new Ciudad(6,"Rauch");
		Ciudad azul= new Ciudad (7,"Azul");
		Ciudad mardelplata= new Ciudad(8,"Mar del Plata");
		
		
		pehuajo.setEstacionesDeServicio(3);
		pehuajo.setTieneBalanza(true);
		pehuajo.setTieneRadar(true);
		pehuajo.setTallerMecanicos(5);
		
		ayacucho.setEstacionesDeServicio(1);
		ayacucho.setTieneBalanza(false);
		ayacucho.setTieneRadar(false);
		ayacucho.setTallerMecanicos(2);
		
		olavarria.setEstacionesDeServicio(9);
		olavarria.setTieneBalanza(true);
		olavarria.setTieneRadar(false);
		olavarria.setTallerMecanicos(17);
		
		rauch.setEstacionesDeServicio(1);
		rauch.setTieneBalanza(false);
		rauch.setTieneRadar(true);
		rauch.setTallerMecanicos(0);
		
		bolivar.setEstacionesDeServicio(7);
		bolivar.setTieneBalanza(false);
		bolivar.setTieneRadar(false);
		bolivar.setTallerMecanicos(4);
		
		tandil.setEstacionesDeServicio(6);
		tandil.setTieneBalanza(true);
		tandil.setTieneRadar(true);
		tandil.setTallerMecanicos(5);
		
		azul.setEstacionesDeServicio(4);
		azul.setTieneBalanza(false);
		azul.setTieneRadar(true);
		azul.setTallerMecanicos(4);
		
		mardelplata.setEstacionesDeServicio(15);
		mardelplata.setTieneBalanza(true);
		mardelplata.setTieneRadar(false);
		mardelplata.setTallerMecanicos(12);
		
		Mapa mapa = new Mapa();
		
		mapa.addCiudad(ayacucho); // Agrego ayacucho
		mapa.addCiudad(tandil); // Agrego tandil
		mapa.addCiudad(bolivar); // Agrego bolivar
		mapa.addCiudad(pehuajo);
		mapa.addCiudad(olavarria);
		mapa.addCiudad(rauch);
		mapa.addCiudad(azul);
		mapa.addCiudad(mardelplata);
		
		mapa.addRuta(ayacucho, tandil, 70); // Agrego la ruta entre ayacucho-tandil de 70km
		mapa.addRuta(ayacucho, pehuajo, 540);
		mapa.addRuta(ayacucho, rauch, 50);
		mapa.addRuta(rauch, olavarria, 210);
		mapa.addRuta(rauch, tandil, 60);
		mapa.addRuta(olavarria, tandil, 130);
		mapa.addRuta(olavarria, bolivar, 140);
		mapa.addRuta(tandil, mardelplata, 200);
		mapa.addRuta(bolivar, azul, 100);
		mapa.addRuta(bolivar, pehuajo, 70);
		
		System.out.println("------------------------------------------");
		System.out.println(mapa.encontrarMejorCamino(azul, ayacucho,1)); // Busco el mejor camino entre ayacucho y bolivar
		System.out.println("------------------------------------------");
		System.out.println(mapa.encontrarMejorCamino(rauch,mardelplata,1));
		System.out.println("------------------------------------------");
		System.out.println(mapa.encontrarMejorCamino(mardelplata,pehuajo,1));
		
		mapa.borrarCiudad(ayacucho); // Borro la ciudad ayacucho
		mapa.borrarRuta(rauch, tandil); // Borro la ruta entre ayacucho-tandil
		System.out.println(mapa.encontrarMejorCamino(mardelplata,pehuajo,1));
	
	}
}
