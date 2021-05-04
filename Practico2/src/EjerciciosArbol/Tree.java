package EjerciciosArbol;

import java.util.ArrayList;

public class Tree {
	
	private int valor;
	private Tree izquierda;
	private Tree derecha;
	private int size=0;

	public Tree(int valor) {
		this.valor = valor;
		this.izquierda = null;
		this.derecha = null;
		this.size++;
	}
	
	//constructor para insertar un arreglo 
	public Tree(int[]arreglo) {
		int max=arreglo.length;
		this.valor = arreglo[0];
		this.izquierda = null;
		this.derecha = null;
		this.size++;
		for (int i=1; i< max;i++) {
			this.add(arreglo[i]);
		}
	}
	public Integer getValor() {
		return valor;
	}
	
	 private void setValor(Integer v) {
		 this.valor=v;
	 }
	
	
	//Insert
	public void add(int newValue) {
		if (newValue < this.valor) {
			if (this.izquierda == null) {
				this.izquierda = new Tree(newValue);
				size++;
			}
			else {
				this.izquierda.add(newValue);
				size++;
			}
		} else {
			if (this.derecha == null) {
				this.derecha = new Tree(newValue);
				size++;
			}
			else {
				this.derecha.add(newValue);
				size++;
			}
		}
	}
	
	public Tree getRoot() {
		return this;
	}
	
	public boolean hasElement(Integer e) {
		if (e==this.getValor()){
			return true;
		}
		else { if (e >this.valor && derecha!=null) {
			return this.derecha.hasElement(e);
			}
			else 
				if (e <this.valor && izquierda!=null) {
				return this.izquierda.hasElement(e);
				}
		}return false;
	}
	
	public int size() {
	return this.size;
		}
	
	
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	
	public void printPreOrder() {
		System.out.print(this);
		
		if (this.izquierda!=null) 
			this.izquierda.printPreOrder();
		else System.out.print("-");
		
		if (this.derecha!=null)
			this.derecha.printPreOrder();
		else System.out.print("-");
		
	}
	
	public void printPostorder() {
		if (this.izquierda!=null) 
			this.izquierda.printPostorder();
		if (this.derecha!=null)
			this.derecha.printPostorder();
		if (this!=null) {
			System.out.println(this.getValor() +" ");
		}
	}
	public void printInorder() {
		if (this.izquierda!=null) 
			this.izquierda.printInorder();
		if (this!=null) 
			System.out.println(this.getValor() +" ");
		if (this.derecha!=null)
			this.derecha.printInorder();
	}
	
	//devuelve la altura del arbol
	public int getHeight() {
		int sumaIzq=0;
		int sumaDer=0;
		if (this.izquierda!=null) {
			sumaIzq=izquierda.getHeight()+1;
		}
		if (this.derecha!=null) {
			sumaDer=derecha.getHeight()+1;
		}
		int max= Math.max(sumaIzq, sumaDer);
	return max;	
	}
	
	//elementos sin hijos (ultimo nivel)
	public ArrayList<Integer>  getFrontera() {
		ArrayList<Integer>ElementosHojas = new ArrayList<Integer>();
		if ((this.izquierda==null) && (this.derecha==null)) {
			ElementosHojas.add(this.getValor());
		}else
		{	
			if (this.izquierda!=null)
				ElementosHojas.addAll(this.izquierda.getFrontera());
			if (this.derecha!=null)
				ElementosHojas.addAll(this.derecha.getFrontera());
		}
		
		return ElementosHojas;
	}
	
	public Integer getMaxElement() {
		if (this.derecha!=null) {
			 return this.derecha.getMaxElement();
		}
		return  this.getValor();
		
		}
	public Integer getMinElement() {
		if (this.izquierda!=null) {
			 return this.izquierda.getMinElement();
		}
		return  this.getValor();
		
		}
	
	public ArrayList<Integer> getElementAtLevel(int level){
		ArrayList<Integer> aux= new ArrayList<Integer>();
		if (level==0) {
			aux.add(this.getValor());
		}
		if (this.izquierda!=null) {
			aux.addAll(izquierda.getElementAtLevel(level-1));
		}
		if (this.derecha!=null) {
			aux.addAll(derecha.getElementAtLevel(level-1));
		}
		return aux;
	}
	
	public ArrayList<Integer> getLongestBranch(){
		ArrayList<Integer> aux= new ArrayList<Integer>();
		ArrayList<Integer> leftList= new ArrayList<Integer>();
		ArrayList<Integer> rightList= new ArrayList<Integer>();
		if (this== null) {
			return aux;
		}
		if (this!=null && this.izquierda==null && this.derecha==null) {
			aux.add(this.getValor());
		}
		if (this.izquierda!=null) {
			leftList.add(this.getValor());
			leftList.addAll(this.izquierda.getLongestBranch());
			
		}
		if (this.derecha!=null) {
			rightList.add(this.getValor());
			rightList.addAll(this.derecha.getLongestBranch());
			
		}
	
		if (leftList.size()>rightList.size()) {
			aux.addAll(leftList);
		}else aux.addAll(rightList);
	return aux;
}
	


	private boolean tieneHijos() {
		return (this.izquierda!=null && this.derecha!=null);
	}

	private boolean esHoja() {
		return (this.izquierda==null && this.derecha==null);
	}
	
	public boolean delete(int elementoBorrar) {
		boolean seBorro=false;
		
	 if (this.hasElement(elementoBorrar)) {
		 
		 //si es menor resuelve por rama izquierda
		if (elementoBorrar< this.getValor()){
			if (this.izquierda.getValor()==elementoBorrar){
				this.izquierda=this.centroBorrado(this.izquierda);
				seBorro=true;
			}else { 
				seBorro= this.izquierda.delete(elementoBorrar);
			}
		}
		//si es mayor resuelvo por rama derecha
		else if(elementoBorrar > this.getValor()) {
			if (this.derecha.getValor()==elementoBorrar) {
				this.derecha=this.centroBorrado(this.derecha);
				seBorro=true;
			}else 
				{
				seBorro=this.derecha.delete(elementoBorrar);
				}
			}
		// si es raiz
		else {
			if (this.esHoja()){ // si es hoja , borra directamente
				this.setValor(null);
				seBorro=true;
			}
			else if (this.tieneHijos()|| this.izquierda!=null) {
				 Integer NMDSI = this.getMayordeLosMenores();//devuelve el mayor de los menores del subarbol izquierda;
				 seBorro=this.delete(NMDSI);
				 this.setValor(NMDSI);
			}else { 
				Integer NMISD= this.getMenordeLosMayores();// devuelve el menor de los mayores subarbol derecha;
				seBorro=this.delete(NMISD);
				this.setValor(NMISD);
				
			}
		}
		return seBorro;
	 }

		return seBorro;
	}

	private Integer getMenordeLosMayores() {
		Integer mayor=null;
		
		if (this.derecha!=null) {
			mayor= this.derecha.getMinElement();
		}
		return mayor;
	}

	private Integer getMayordeLosMenores() {
		Integer menor=null;
		
		if (this.izquierda!=null)	
			menor=this.izquierda.getMaxElement();
		return menor;
	}

	private Tree centroBorrado(Tree ramaActual) {
		if (ramaActual.esHoja()) {
			ramaActual=null;
		} else if (ramaActual.tieneHijos()) {
			Integer NMDSI= ramaActual.getMayordeLosMenores();
			ramaActual.delete(NMDSI);
			ramaActual.setValor(NMDSI);
		}else {
			if (ramaActual.izquierda!=null) {
				ramaActual=ramaActual.izquierda;
			}else {
				ramaActual=ramaActual.derecha;
			}
		}
		return ramaActual;
	}
	
	public String toString() {
		return "[" + this.getValor() + "]";
	}

	
}