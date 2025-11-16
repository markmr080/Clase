package main;

import java.util.concurrent.Semaphore;

public class Carrera implements Runnable{
	
	
	
	private Animal animal;
	private Tunel tunel;
	private Semaphore permiso;
	
	public Carrera(Animal animal, Tunel a, Semaphore permiso) {
		this.tunel = a;
		this.animal = animal;
		this.permiso = permiso;
	}
	
	@Override
	public void run() {		
		boolean animalEnTunel = false;
		boolean animalSalioTunel = false;
		
		
		while (animal.getDistanciaRecorrida()<200){	
			
			
			int pajaroVoloHaciaAtras = animal.getDistanciaRecorrida();
			animal.correr();
			int d = animal.getDistanciaRecorrida();
			try {					
				if (d >= 50 && d<60){
					if (!animalEnTunel) {
						tunel.entrarTunel();
						animalSalioTunel = false;
						animalEnTunel = true;				
						synchronized(System.out) {
						System.out.println(animal.getNombre() + " Entro en el tuenel");													
						}
				   }
				}
								
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
				
			if (d > 150  && animalSalioTunel==false) {
				tunel.salirTunel();
				animalEnTunel = false;
				animalSalioTunel = true;
				synchronized(System.out) {
			        System.out.println(animal.getNombre() + " Salio de el túnel");
			    }
			}
			
			if (d >= 200) {
				System.out.println(animal.getNombre()+ " termino la carrera");
			}
					
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}