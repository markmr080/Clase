package main;

public abstract class Animal {
	private String nombre;
	private int distanciaRecorrida= 0;
	private int velocidad;
	private static  int viento = 0;
	
	public static  int getViento() {
		return viento;
	}

	public void setViento(int viento) {
		Animal.viento = viento;
	}

	public Animal(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public abstract void correr ();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}
	public int getVelocidad() {		
		return velocidad;
	}
	public void salirDelTunelSiRetrocede(Tunel tunel) {
		 
	}


}