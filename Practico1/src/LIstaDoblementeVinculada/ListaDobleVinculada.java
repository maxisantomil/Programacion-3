package LIstaDoblementeVinculada;


public class ListaDobleVinculada {
	protected Node first;
	protected Node end;
		int size=0;
		
		
		
		public ListaDobleVinculada() {
			this.first = null;
			this.end=null;
		}
		
		
		//Insertar al final , y guardar nodo inicial y final. 
		public void insertAlFinal(int o) {  // O(1)
			Node tmp = new Node(o,null,null);
			if (first==null) {
				this.first=tmp;
				this.end=tmp;
				this.size++;
			}else {
				end.setNext(tmp);
				tmp.setAfter(end);
				tmp.setNext(null);
				end=tmp;
				
				this.size ++;
			}
		}
		
		//Inserta al principio y guardar nodo inicial y final
		public void insertAlPrincipio(int o) { // O(1)
			Node tmp = new Node(o,null,null);
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
			Node aux=this.end.getAfter();
			if (aux==null){
				aux=first;
				this.first=null;
				this.end=null;
				return aux.getInfo();
			}
			this.end=aux;
			//this.end.setNext(null);
			this.size--;
			return aux.getNext().getInfo();
		}
		
		public int extractṔrimero() { // O(1)
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


		@Override
		public String toString() {
			return first + ", size=" + size + "]";
		}
		
		
		
}
