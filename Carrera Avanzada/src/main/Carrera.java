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
			
			if (!animalEnTunel) {
				if (Animal.isGanoCarrera()) {
					System.out.println(animal.getNombre() + " vio que perdio y se rindio");
					break;
				}		
			}
			
			viento.viento();
			animal.correr();
			int distancia = animal.getDistanciaRecorrida();
			
			try {					
				if (distancia >= 35 && distancia<50){
					if (!animalEnTunel) {
						tunel.entrarTunel();
						animalSalioTunel = false;
						animalEnTunel = true;									
							System.out.println(animal.getNombre() + " Entro en el tunel");																		
				   }
					
				}else if (distancia < 50 && animalEnTunel) {		    
				    tunel.salirTunel();
				    animalEnTunel = false;   
				        System.out.println(animal.getNombre() + " es bobo y perdio el ticket");				  
				}
								
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (distancia > 150  && animalSalioTunel==false) {			
				tunel.salirTunel();
				animalEnTunel = false;
				animalSalioTunel = true;
				synchronized(System.out) {
			        System.out.println(animal.getNombre() + " Salio del tunel");
			    }
			}
		
			if (distancia >= 300) {			
				Animal.setGanoCarrera(true);
				System.out.println(animal.getNombre()+ " termino la carrera primero");		
			}
					
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}