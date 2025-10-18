package main;

public class Perro extends Animal{
	
	
	private String raza;

	Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
		this.raza = raza;
	}
	
	
	public void ladrar() {
		
		System.out.println("Guau guau");
		
	}


	@Override
	public void mostrarDatos() {
		
		super.mostrarDatos();
		System.out.println(" y raza " + raza);
		
	}

}
