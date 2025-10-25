package cajaRegistradora;


public class Caja {
	
	private double total = 0;
	private double propinas = 0;
	

	
	public synchronized void cobrar (double cantidad, double propina) {		
		this.total = this.total + cantidad;
		this.propinas = this.propinas + propina;
	}
	
	public synchronized double getPropinas() {
		return Math.round(propinas * 100.0) / 100.0;
	}

	public synchronized double getTotal() {
		return Math.round(total * 100.0) / 100.0;
	}
}
