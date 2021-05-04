package LIstaDoblementeVinculada;

public class MainDobleV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ListaDobleVinculada miLista= new ListaDobleVinculada();
				
				miLista.insertAlFinal(1);
				miLista.insertAlFinal(2);
				miLista.insertAlFinal(3);
				miLista.insertAlFinal(4);
				miLista.insertAlFinal(5);
				miLista.insertAlFinal(6);
				
				System.out.println(miLista.extractUltimo());
				System.out.println(miLista.extractUltimo());
				System.out.println(miLista.extractUltimo());
				System.out.println(miLista.extractUltimo());
				System.out.println(miLista.extractUltimo());
				System.out.println(miLista.extractUltimo());
				
	}

}
