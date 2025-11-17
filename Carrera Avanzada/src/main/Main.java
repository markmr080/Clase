package main;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tunel tunel = new Tunel();
		Viento viento = new Viento();
		Thread b = new Thread(new Carrera ( new Pajaro("Pajaro", viento), tunel, viento));
		Thread c = new Thread(new Carrera ( new Liebre("Liebre", viento), tunel, viento));
		Thread d = new Thread(new Carrera (new Tortuga("Tortuga", viento), tunel, viento));
		
		b.start();
		c.start();
		d.start();
		
		

	}

}