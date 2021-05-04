package Ejercicio1;

public class Pila {
	private MySimpleLinkedList lista;
	
	
	public Pila() {
		lista = new MySimpleLinkedList();
	}
	
	public void push(int o) {
		lista.insertAlFinal(o);
	}
	
	public void pop() {
		lista.extractUltimo();
	}
	public int top() {
		return lista.get(lista.size);
	}
	
	public void reverse() {
		MySimpleLinkedList aux = new MySimpleLinkedList();
		while (!this.lista.isEmpty()) {
			aux.insertAlFinal(lista.extractUltimo());
		}
		lista=aux;
	}
}
