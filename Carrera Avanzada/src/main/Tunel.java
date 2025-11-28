package main;

public class Tunel {
	
	private boolean tunel = false;
	
	public synchronized void entrarTunel() throws InterruptedException {
		while(tunel) {
			wait();
		}
		
		tunel =  true;
	}
	public synchronized void salirTunel() {
		tunel = false;
		notify();
	}
	
}
