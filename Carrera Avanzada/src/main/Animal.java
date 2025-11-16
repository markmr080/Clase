package main;

public abstract class Animal {
	private String nombre;
	private int distanciaRecorrida= 0;
	private int velocidad;
	
	
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
	
	public static int viento () {	
		int seActivaViento = (int) (Math.random() * 10) + 1;
		int direccionViento = (int) (Math.random() * 2);
		int viento = 0;
		
			if (seActivaViento>6) {	
				if (direccionViento == 1) {
					viento = 1;
					return viento;
				}else {
					viento = 2;
					return viento;
				}	
			}else {
				viento = 3;
				return viento;
			}
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