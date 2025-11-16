package main;


public class Carrera implements Runnable{
	
	
	
	private Animal animal;
	private Tunel tunel;
	
	
	public Carrera(Animal animal, Tunel a) {
		this.tunel = a;
		this.animal = animal;
		
	}
	
	@Override
	public void run() {		
		boolean animalEnTunel = false;
		boolean animalSalioTunel = false;
		
		
		while (animal.getDistanciaRecorrida()<300){	
			
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
				}else if (d < 50 && animalEnTunel) {		    
				    tunel.salirTunel();
				    animalEnTunel = false;
				    synchronized(System.out) {
				        System.out.println(animal.getNombre() + " salió del túnel porque retrocedió demasiado");
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