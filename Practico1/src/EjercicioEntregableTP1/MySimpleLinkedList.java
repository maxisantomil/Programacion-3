package EjercicioEntregableTP1;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Integer>{
protected Node first;
protected Node end;
	int size=0;
	public MySimpleLinkedList() {
		this.first = null;
		this.end=null;
	}
	
	
	//Insertar al final , y guardar nodo inicial y final. 
	public void insertAlFinal(int o) {  // O(1)
		Node tmp = new Node(o,null);
		if (first==null) {
			this.first=tmp;
			this.end=tmp;
			this.size++;
		}else {
			end.setNext(tmp);
			end=tmp;
			this.size ++;
		}
	}
	
	//Inserta al principio y guardar nodo inicial y final
	public void insertAlPrincipio(int o) { // O(1)
		Node tmp = new Node(o,null);
		if (first== null){
			this.first = tmp;
			this.end=tmp;
			this.size ++;
		} else {
			tmp.setNext(first);
			first=tmp;
			this.size++;
		}
			
	}
	
	public int extractUltimo() { // O(n) n= size-1;
		Node aux=this.first;
		for (int i=1; i< this.size-1;i++) {
			aux=aux.getNext();
		}
		this.end=aux;
		int valor=aux.getNext().getInfo();
		this.end.setNext(null);
		this.size--;
		return valor;
	}
	
	public int extractPrimero() { // O(1)
		Node aux = this.first;
		this.first=aux.getNext();
		this.size--;
		return aux.getInfo();
	}
	

	public boolean isEmpty() { // O(1)
		if (this.size == 0 ) {
			return true;
		}
		return false;
	}

	public int size() { // O(1)
		return this.size;
	}
	
	public int get(int index) {  // O(n)   n=index
		if ((index > size) && (index< 1)){
			return -1;
		}
		else {
			int i=1;
			Node aux= first;
			while (i< index) {
				aux= aux.getNext();
				i++;
			}
			return aux.getInfo();
		}
	}
	
	public int getInfo() { // O(1)
		return this.getInfo();
	}
	
	//ejercicio 4
	public int indexOf(int o) {  // O(n) n=la cantidad de nodos necesarios hasta encontrar el elemento o.
		int n= o;
		//int i=1;
		Node aux= this.first;
		for (int i=1; i<= size;i++) {
			if (n == aux.getInfo()) {
				return i;
			}
			aux=aux.getNext();
		}
		return -1;
	}
	
	
	@Override
	public String toString() {	
		return "["+first+"]";
	}


	@Override
	public MyIterator iterator() {
		return new MyIterator(this.first);
	}
	
	//metodo que faltaba implementar
	public void print(int n) {   // O(n) n es la cantidad de elementos que quiero mostrar de la lista
		Node aux= first;
		int i=1;
		while (aux!=null && i<=n && n<= size()) {
			System.out.println("["+aux.getInfo()+"]");
			aux=aux.getNext();
			i++;
		}
		if (n>size()&& aux!=null) {
			System.out.println("el 'n' se paso del limite, la lista tiene "+ size()+" elementos :");
			System.out.println("["+aux.toString()+"]");
		}
		if (aux==null && i==1) {
			System.out.println("[ ]");
		}
	}
	
	
	
}
