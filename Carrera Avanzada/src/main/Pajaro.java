package main;

import java.util.concurrent.Semaphore;



public class Pajaro extends Animal{
		
	private int velocidad = 3;
	private Semaphore tunel;
	private int distanciaRecorrida = 0;	
	private String nombre;
	private boolean volar = false;
	private boolean volarHaciaAtras = false;
	
	
	
	public Pajaro(String nombre) {
		super(nombre);
		this.nombre = nombre;
	}


	@Override
	public void correr () {						
		if (this.distanciaRecorrida == 0) {
			volar();
		}else {	
			if (volar()) {
				if(volarHaciaAtras()) {
				System.out.println(nombre +" volo hacia atras");
				}else {
					System.out.println(nombre + " volo hacia adelante");
				}				
			}else {
				System.out.println(nombre + " camina");
			}
		}
		avanzar(this.velocidad);	
		System.out.println(nombre + " lleva " + getDistanciaRecorrida() + " metros recorridos" );	
	}
	
	
	public boolean volar() {
		int iniciarVolar = (int) (Math.random() * 10) + 1;		
		if (iniciarVolar > 4 ) {
			this.volar = true;
			this.velocidad = 10;
			return true;
		}else {
			this.velocidad = 3;
			this.volar = false;
			return false;
		}
		
	}
	
	public boolean volarHaciaAtras() {
		
		int volarAlContrario = (int) (Math.random() * 10) + 1;			
		if(volarAlContrario<4) {				
			this.velocidad = -10;
			this.volarHaciaAtras = true;
			return true;
		}else {
			this.volarHaciaAtras = false;
			return false;
		}
	}
	
	public void avanzar(int velocidad)  {
		this.distanciaRecorrida += velocidad;
		boolean viento = Animal.viento();
		if (this.volar) {
			if(viento) {
				this.distanciaRecorrida += 5;
				
				if (this.volarHaciaAtras) {
					System.out.println("Viento a favor " + nombre  + " retrocedio 5 metros menos");
				}else {
					System.out.println("Viento a favor " + nombre  + " avanzo 5 metros mas");
				}
			}else {
				this.distanciaRecorrida -=5;
				if (this.volarHaciaAtras) {
					System.out.println("Viento en contra " + nombre  + " retrocedio 5 metros mas");
				}else {
					System.out.println("Viento en contra " + nombre  + " avanzo 5 metros menos");
				}
			}
		}
	}
	
	public int getDistanciaRecorrida() {
		return distanciaRecorrida;
	}
	
	
	
}