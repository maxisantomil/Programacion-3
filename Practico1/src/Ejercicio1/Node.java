package Ejercicio1;


public class Node {
	private int info;
	private Node next;

	public Node() {
		this.info = -1;
		this.next = null;
	}
	
	public Node(int o, Node n) {
		this.setInfo(o);
		this.setNext(n);
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
	
	public boolean esigual(int n) {
		return this.getInfo() == n;
	}

	@Override
	public String toString() {
		return "Node [info=" + info + ", next=" + next + "]";
	}
	
	
}
