package main;

public class Viento {
	
	
	public int viento = 0;

	public  int viento () {	
		int seActivaViento = (int) (Math.random() * 10) + 1;
		int direccionViento = (int) (Math.random() * 2);	
		
			if (seActivaViento>6) {	
				if (direccionViento == 1) {
					this.viento = 1;					
				}else {
					this.viento = 2;					
				}	
			}else {
				this.viento = 3;			
			}
			return this.viento;
	}

	public int getViento() {
		return viento;
	}
	
}
