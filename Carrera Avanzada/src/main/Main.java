package main;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tunel tunel = new Tunel();
		Thread b = new Thread(new Carrera ( new Pajaro("Pajaro"), tunel));
		Thread c = new Thread(new Carrera ( new Liebre("Liebre"), tunel));
		Thread d = new Thread(new Carrera (new Tortuga("Tortuga"), tunel));
		
		b.start();
		c.start();
		d.start();
		
		

	}

}