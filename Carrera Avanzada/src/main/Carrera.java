package main;


public class Carrera implements Runnable{
	
	
	
	private Animal animal;
	private Tunel tunel;
	private Viento viento;
	
	
	public Carrera(Animal animal, Tunel a, Viento viento) {
		this.tunel = a;
		this.animal = animal;
		this.viento = viento;
		
	}
	
	@Override
	public void run() {		
		boolean animalEnTunel = false;
		boolean animalSalioTunel = false;
		
		
		while (animal.getDistanciaRecorrida()<300){	
			viento.viento();
			animal.correr();
			int d = animal.getDistanciaRecorrida();
			try {					
				if (d >= 35 && d<50){
					if (!animalEnTunel) {
						tunel.entrarTunel();
						animalSalioTunel = false;
						animalEnTunel = true;				
						synchronized(System.out) {
						System.out.println(animal.getNombre() + " Entro en el tunel");													
						}
				   }
				}else if (d < 50 && animalEnTunel) {		    
				    tunel.salirTunel();
				    animalEnTunel = false;
				    synchronized(System.out) {
				        System.out.println(animal.getNombre() + " es bobo y perdio el ticket");
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
			        System.out.println(animal.getNombre() + " Salio del tunel");
			    }
			}
			
			
			
			if (d >= 300) {
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