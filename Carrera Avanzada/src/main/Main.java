package main;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tunel tunel = new Tunel();
		Semaphore a = new Semaphore(1);
		Thread b = new Thread(new Carrera ( new Pajaro("Pajaro"), tunel, a));
		Thread c = new Thread(new Carrera ( new Liebre("Liebre"), tunel, a));
		Thread d = new Thread(new Carrera (new Tortuga("Tortuga"), tunel, a));
		
		b.start();
		c.start();
		d.start();
		
		

	}

}