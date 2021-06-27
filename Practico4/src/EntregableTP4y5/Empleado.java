package EntregableTP4y5;

public class Empleado {
	private String id;
	private String nombre;
	private String apellido;
	private int edad;
	private int fuerza_trabajo;
	
	public Empleado() {
	}

	public Empleado(String id,String n,String a,int e,int fuerza) {
		this.setId(id);
		this.setNombre(n);
		this.setApellido(a);
		this.setEdad(e);
		this.setFuerza_trabajo(fuerza);
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getFuerza_trabajo() {
		return fuerza_trabajo;
	}


	public void setFuerza_trabajo(int fuerza_trabajo) {
		this.fuerza_trabajo = fuerza_trabajo;
	}

	@Override
	public String toString() {
		return id;
	}


}
