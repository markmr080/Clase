package cajaRegistradora;


public class Main {

	
	
	public static void main (String [] args) throws InterruptedException {
		Caja caja = new Caja();
		Thread empleado1 = new Thread(new Empleado("Ana", caja));
		Thread empleado2 = new Thread(new Empleado("Pedro", caja));
		Thread empleado3 = new Thread(new Empleado("Julio", caja));
		
		empleado1.start();			
		empleado2.start();	
		empleado3.start();

		empleado1.join();
		empleado2.join();
		empleado3.join();
		
		System.out.println("La caja registradora hizo un total de " + caja.getTotal()+ "€ hoy." + " Y se añadieron " + caja.getPropinas() + "€ al bote de propinas.");
		
		
		
	}
	
}
