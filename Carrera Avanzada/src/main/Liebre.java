package main;

public class Liebre extends Animal{
	private int velocidad = 5;
	private int distanciaRecorrida = 0;
	private int avanzar = 4;
	private int dormir = 0;
	private Viento viento;
	private int resbala = 0;
	public Liebre(String nombre, Viento viento) {
		super(nombre);
		this.viento = viento;
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
		
		if (liebreSeResbala()) {
			return;
		}
		
		if(liebreAvanza()) {
			return;
		}
		
	

		dormir = 10;
		avanzar=4;	
		
		
	}
	
	public boolean liebreDuerme() {
		int viento = this.viento.getViento();
		
		if (dormir > 0) {
			dormir--;
			this.velocidad = 0;
			System.out.println("Liebre Duerme");
			if (viento == 1) {
				dormir = 0;
				System.out.println("Liebre se desperto por el viento a favor");
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
	
	public boolean liebreSeResbala() {   
		if(resbala>0) {
			resbala--;
			this.velocidad=0;
			return true;
		}
		
		return false;
		
	}
	
	public void avanza (int velocidad) {
		this.distanciaRecorrida += velocidad;	
		
		if (this.distanciaRecorrida%10==0) {
			resbala=5;
			System.out.println("Liebre resbalo");
		}
	}
	
	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}
	

	public int getVelocidad() {
		return velocidad;
	}


	
	
	
}