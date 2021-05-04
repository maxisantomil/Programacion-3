package Ejercicio1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer>{

	private Node cursor;
	
	public MyIterator (Node cursor) {
		this.cursor=cursor;
	}
	@Override
	public boolean hasNext() {  // O(1)
		// TODO Auto-generated method stub
		return this.cursor!=null;
	}

	@Override
	public Integer next() {  //O(1)
		Integer valor= this.cursor.getInfo();
		this.cursor=this.cursor.getNext();
		return valor;
	}
	
	public Integer valor() { //O(1)
		return this.cursor.getInfo();
	}

	public void avanzar() {  //O(1)
		this.cursor=this.cursor.getNext();
	}
}
