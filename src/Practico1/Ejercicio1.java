package Practico1;


public class Ejercicio1 {
		
		protected Node first;
		
		public Ejercicio1() {
			this.first = null;
		}
		
		public void insertFront(Object o) {
			Node tmp = new Node(o,null);
			tmp.setNext(this.first);
			this.first = tmp;
		}
		
		public Object extractFront() {
			// TODO
			return null;
		}

		public boolean isEmpty() {
			// TODO
			return false;
		}

		public int size() {
			// TODO
			return 0;
		}
		
		public Object get(int index) {
			// TODO
			return null;
		}

	}


