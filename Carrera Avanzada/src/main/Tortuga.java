package main;

public class Tortuga extends Animal{
	
	
	private int distanciaRecorrida = 0;
	private int velocidad = 2;
	private String nombre;
	private Viento viento;
	public Tortuga(String nombre, Viento viento) {
		super(nombre);
		this.nombre = nombre;
		this.viento = viento;
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