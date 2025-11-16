package main;

public class Liebre extends Animal{
	private int velocidad = 5;
	private int distanciaRecorrida = 0;
	private int avanzar = 4;
	private int dormir = 0;
	
	public Liebre(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void correr() {
		if (this.distanciaRecorrida == 0) {
			avanza(velocidad);
			return;
		}	
		if(liebreDuerme()) {
			return;
		}
		if(liebreAvanza()) {
			return;
		}
		
		dormir = 10;
		avanzar=4;
	
	}
	public boolean liebreDuerme() {
		if (dormir > 0) {
			dormir--;
			this.velocidad = 0;
			System.out.println("Liebre Duerme");
			if (Animal.viento() == 1) {
				dormir = 0;
			}
			return true;
		}
		return false;
	}
	
	public boolean liebreAvanza() {
		if (avanzar > 0) {
			avanzar--;
			this.velocidad = 5;
			System.out.println("La liebre avanza " + getDistanciaRecorrida() + " metros");			
			avanza(velocidad);
			return true;
		}
		return false;
	}
	
	
	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}
	

	public int getVelocidad() {
		return velocidad;
	}


	public void avanza (int velocidad) {
		this.distanciaRecorrida += velocidad;		
	}
	
	
}