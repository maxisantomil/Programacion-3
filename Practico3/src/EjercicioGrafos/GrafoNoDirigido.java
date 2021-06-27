package EjercicioGrafos;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}

	@Override
	public String toString() {
		return "GrafoNoDirigido [cantidadVertices()=" + cantidadVertices() + ", cantidadArcos()=" + cantidadArcos()
				+ ", obtenerVertices()=" + obtenerVertices() + ", obtenerArcos()=" + obtenerArcos() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
