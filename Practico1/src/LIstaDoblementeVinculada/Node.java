package LIstaDoblementeVinculada;


public class Node {
	private int info;
	private Node next;
	private Node after;

	public Node() {
		this.info = -1;
		this.after=null;
		this.next = null;
	}
	
	public Node(int o, Node n,Node m) {
		this.setInfo(o);
		this.setNext(n);
		this.setAfter(m);
	}
	
	public void setAfter(Node after) {
		this.after=after;
	}
	
	public Node getAfter() {
		return after;
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
		return "Node [info=" + info + ", next=" + next + ", after=" + after + "]";
	}

	
	
}

