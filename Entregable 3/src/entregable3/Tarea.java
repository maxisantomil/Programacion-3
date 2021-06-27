package entregable3;

public class Tarea {
	
	private String nombre;
	private String descripcion;
	private int horas;
	public static int tiempoCritico;
	
	public Tarea(String nombre, String descripcion, int horas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}

	public static int getTiempoCritico() {
		return tiempoCritico;
	}

	public static void setTiempoCritico(int tiempoCritico) {
		Tarea.tiempoCritico = tiempoCritico;
	}

}
