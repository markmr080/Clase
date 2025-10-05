package main;



public class Animal {
	public String nombre;
	public int edad;


	Animal (String nombre, int edad) {
		this.nombre=nombre;
		this.edad = edad;
		
		
		
	}
	
	public void mostrarDatos() {
	
		System.out.print(nombre + " tiene " + edad + " años");	
	}
	
	


}
