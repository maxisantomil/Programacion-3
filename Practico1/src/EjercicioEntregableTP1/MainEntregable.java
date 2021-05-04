package EjercicioEntregableTP1;


public class MainEntregable {
	
	
	public static MySimpleLinkedList ListaSubsecuencias(MySimpleLinkedList listaOriginal, int valorUmbral) { // por lo tanto es O(n) n= la cantidad de nodos que tiene la lista
		MySimpleLinkedList aux= new MySimpleLinkedList();
		MyIterator myIterator=listaOriginal.iterator();
		int suma=0;
		while (myIterator.hasNext()){  //O(n) n= la cantidad de nodos de la lista
			if ((suma+ myIterator.valor())<= valorUmbral){
				suma=suma+myIterator.next(); //O(1)
			}
			else {
				
				if ((suma> valorUmbral)||((suma==0) && (suma+myIterator.valor() > valorUmbral))){
					suma=myIterator.next();//O(1)
				}else {
					aux.insertAlFinal(suma); //O(1)
					suma=myIterator.next();
					}
				}
			//}
		}
		if (!myIterator.hasNext()) {
			if ((suma!=0) && (suma<=valorUmbral)) {
			aux.insertAlFinal(suma); //O(1)
			}
		}
		return aux;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySimpleLinkedList miLista= new MySimpleLinkedList();
		int valorUmbral=0;
		
		//Lista de entrada = [] Valor umbral: 10
		//Lista de salida = [] // No devuelve nada (una lista vacía)
		valorUmbral=10;
		System.out.println("lista de entrada:[]"+"  Valor umbral: "+valorUmbral);
		System.out.println("lista de salida : "+ListaSubsecuencias(miLista,valorUmbral));
		miLista=new MySimpleLinkedList();
		System.out.println("-----------------------------------");
		//Lista de entrada = [1, 2, 3] Valor umbral: 10
		//Lista de salida = [6] // Todos los valores de la lista
		miLista.insertAlFinal(1);
		miLista.insertAlFinal(2);
		miLista.insertAlFinal(3);
		valorUmbral=10;
		System.out.println("lista de entrada:[1,2,3]"+"  Valor umbral: "+valorUmbral);
		System.out.println("lista de salida : "+ListaSubsecuencias(miLista,valorUmbral));
		miLista=new MySimpleLinkedList();
		System.out.println("-----------------------------------");
		//Lista de entrada = [1, 2, 3] Valor umbral: 2
		//Lista de salida = [1, 2] // Dos elementos, el 3 como sub-secuencia supera el valor umbral.
		miLista.insertAlFinal(1);
		miLista.insertAlFinal(2);
		miLista.insertAlFinal(3);
		valorUmbral=2;
		System.out.println("lista de entrada:[1,2,3]"+"  Valor umbral: "+valorUmbral);
		System.out.println("lista de salida : "+ListaSubsecuencias(miLista,valorUmbral));
		miLista=new MySimpleLinkedList();
	
		System.out.println("-----------------------------------");
		//Lista de entrada = [3, 5, 2, 7, 19, 14, 28] Valor umbral: 10
		//Lista de salida = [10, 7] // Los valores surgen de las sub-secuencias [3,5,2]; [7]; 
		miLista.insertAlFinal(3);
		miLista.insertAlFinal(5);
		miLista.insertAlFinal(2);
		miLista.insertAlFinal(7);
		miLista.insertAlFinal(19);
		miLista.insertAlFinal(14);
		miLista.insertAlFinal(28);
		valorUmbral=10;
		System.out.println("lista de entrada:[3,5,2,7,19,14,28]"+"  Valor umbral: "+valorUmbral);
		System.out.println("lista de salida : "+ListaSubsecuencias(miLista,valorUmbral));
		miLista=new MySimpleLinkedList();
		
		System.out.println("-----------------------------------");
		//Lista de entrada = [3, 5, 4, 2, 7, 15, 14, 28] Valor umbral: 15
		//Lista de salida = [14,7,15,14] // Los valores surgen de las sub-secuencias [3,5,4,2]; [7]; [15];[14]
		miLista.insertAlFinal(3);
		miLista.insertAlFinal(5);
		miLista.insertAlFinal(4);
		miLista.insertAlFinal(2);
		miLista.insertAlFinal(7);
		miLista.insertAlFinal(15);
		miLista.insertAlFinal(14);
		miLista.insertAlFinal(28);
		valorUmbral=15;
		System.out.println("lista de entrada:[3,5,4,2,7,15,14,28]"+"  Valor umbral: "+valorUmbral);
		System.out.println("lista de salida : "+ListaSubsecuencias(miLista,valorUmbral));
		miLista=new MySimpleLinkedList();
	
		System.out.println("-----------------------------------");
		//otro ejemplo ;)
		//Lista de entrada = [1,1,1,1,1,1] Valor umbral: 5
		miLista.insertAlFinal(1);
		miLista.insertAlFinal(1);
		miLista.insertAlFinal(1);
		miLista.insertAlFinal(1);
		miLista.insertAlFinal(1);
		miLista.insertAlFinal(1);
		valorUmbral=5;
		System.out.println("lista de entrada:[1,1,1,1,1,1]"+"  Valor umbral: "+valorUmbral);
		System.out.println("lista de salida : "+ListaSubsecuencias(miLista,valorUmbral));
		miLista=new MySimpleLinkedList();
		System.out.println("-----------------------------------");
		//otro ejemplo 
		//Lista de entrada = [20,3,5] Valor umbral: 10
		miLista.insertAlFinal(20);
		miLista.insertAlFinal(3);
		miLista.insertAlFinal(5);
		miLista.print(3);
		valorUmbral=10;
		System.out.println("lista de entrada:[20,3,5]"+"  Valor umbral: "+valorUmbral);
		System.out.println("lista de salida : "+ListaSubsecuencias(miLista,valorUmbral));
		miLista=new MySimpleLinkedList();
	}

}
