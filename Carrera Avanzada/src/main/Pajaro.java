	package main;
	
	public class Pajaro extends Animal{
			
		private int velocidad = 3;
		private int distanciaRecorrida = 0;	
		private String nombre;
		private boolean volar = false;
		private boolean volarHaciaAtras = false;
		private Viento viento;
		private int contadorCaida = 5;
		
		
		public Pajaro(String nombre, Viento viento) {
			super(nombre);
			this.nombre = nombre;
			this.viento = viento;
		}
	
	
		@Override
		public void correr () {						
			if (this.distanciaRecorrida == 0) {
				volar();
			}else {	
				if (volar()) {
					if(volarHaciaAtras()) {
						System.out.println("Pajaro volo hacia atras");
					}
				}				
			}
			
			avanzar(this.velocidad);	
			System.out.println(nombre + " lleva " + getDistanciaRecorrida() + " metros recorridos" );	
		}
		
		
		public boolean volar() {
			int iniciarVolar = (int) (Math.random() * 10) + 1;		
			if (iniciarVolar > 4 ) {
				this.volar = true;
				this.velocidad = 10;
				return true;
			}else {
				this.velocidad = 3;
				this.volar = false;
				return false;
			}
			
		}
		
		public boolean volarHaciaAtras() {	
			int volarAlContrario = (int) (Math.random() * 10) + 1;			
			if(volarAlContrario<4) {				
				this.velocidad = -10;
				this.volarHaciaAtras = true;
				return true;
			}else {
				this.volarHaciaAtras = false;
				return false;
			}
		}
		
		public void avanzar(int velocidad)  {
			this.distanciaRecorrida += velocidad;
			int viento = this.viento.getViento();
			if (this.volar) {
				if(viento == 1) {
					this.distanciaRecorrida += 5;				
					System.out.println("Viento a favor");
				}else if (viento == 2){
					this.distanciaRecorrida -=5;
					System.out.println("Viento en contra");
				}
			}else {
				if(this.distanciaRecorrida%10 == 0) {
					this.contadorCaida--;
					System.out.println("Pajaro se cayo al suelo");
				}
			}
			this.contadorCaida=5;
		}
		
		
		public int getDistanciaRecorrida() {
			return distanciaRecorrida;
		}
		
		
		
	}