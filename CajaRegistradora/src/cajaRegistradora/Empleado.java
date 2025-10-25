package cajaRegistradora;


public class Empleado implements Runnable{
	
	private String nombre;
	private Caja cajaCompartida;
	private double propinasPropia = 0;

	public Empleado(String nombre, Caja c) {
		this.nombre = nombre;
		this.cajaCompartida = c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<5; i++) {
			double cobro = Math.round((Math.random() * (100 - 5 + 1) + 5) * 100.0) / 100.0;
			double propinas = Math.round(Math.random() * 5 * 100.0) / 100.0;
			this.propinasPropia += propinas;
			
			cajaCompartida.cobrar(cobro, nombre, propinas);								
			try {
				Thread.sleep((long) (Math.random() * (2300 - 800 + 1) + 800));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getPropinasPropias(nombre, propinasPropia);
	}
	
	public void getPropinasPropias(String nombre, double propina) {				
		System.out.println(nombre + " hizo " + (Math.round(propinasPropia * 100.0) / 100.0) + "€ de propina hoy.");
	}

}
