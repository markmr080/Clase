package cajaRegistradora;


public class Caja {
	
	private double total = 0;
	private double propinas = 0;
	

	
	public synchronized void cobrar (double cantidad, String nombre, double propina) {		
		this.total = this.total + cantidad;
		this.propinas = this.propinas + propina;
		System.out.println("Empleado " + nombre + " cobro " + cantidad + "€ Y le han dado " + propina + "€ de propina." +  " Total en caja: " + getTotal() + "€");
	}
	
	public double getPropinas() {
		return Math.round(propinas * 100.0) / 100.0;
	}

	public synchronized double getTotal() {
		return Math.round(total * 100.0) / 100.0;
	}
}
