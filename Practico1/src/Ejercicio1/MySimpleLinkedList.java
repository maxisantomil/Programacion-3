package Ejercicio1;

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
	public void insertAlFinal(int o) {
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
	
	//Inserta al principio y guardar primer nodo y final
	public void insertAlPrincipio(int o) {
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
	
	public int extractUltimo() {
		Node aux=this.first;
		for (int i=1; i< this.size-1;i++) {
			aux=aux.getNext();
		}
		this.end=aux;
		//this.end.setNext(null);
		this.size--;
		return aux.getNext().getInfo();
	}
	
	public int extractṔrimero() {
		Node aux = this.first;
		this.first=aux.getNext();
		this.size--;
		return aux.getInfo();
	}
	

	public boolean isEmpty() {
		if (this.size == 0 ) {
			return true;
		}
		return false;
	}

	public int size() {
		return this.size;
	}
	
	public int get(int index) {
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
	
	public int getInfo() {
		return this.getInfo();
	}
	
	//ejercicio 4
	public int indexOf(int o) {
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
	
	
	
	public void ordenar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "MySimpleLinkedList [first=" + first + ", end=" + end + ", size=" + size + "]";
	}


	@Override
	public MyIterator iterator() {
		return new MyIterator(this.first);
	}


	
	
}


	
