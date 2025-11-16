package main;

public class Tortuga extends Animal{
	
	
	private int distanciaRecorrida = 0;
	private int velocidad = 2;
	private String nombre;
	public Tortuga(String nombre) {
		super(nombre);
		this.nombre = nombre;
	}
	

	@Override
	public void correr() {
		avanza(velocidad);
		System.out.println(nombre + " lleva " + getDistanciaRecorrida() + " metros recorridos");
	}

	
	public void avanza (int velocidad) {
		this.distanciaRecorrida += velocidad;		
	}
	
	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}
	
	
	

}