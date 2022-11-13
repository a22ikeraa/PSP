package parking4;

import java.util.Random;

public class Coche extends Thread {
	private static Parking parkingEstacionar;

	public Coche(ThreadGroup group, String name, Parking parking) {
		super(group, name);
		parkingEstacionar = parking;
	}

	@Override
	public void run() {
		entrarCoche();

		int tiempoEstacionamiento = new Random().nextInt(2000) + 1;

		// Simulacion de que el coche está aparcado
		try {
			System.out.println("El " + this.getName() + " se ESTACIONA " + tiempoEstacionamiento + "s");
			Thread.sleep(tiempoEstacionamiento);
		} catch (InterruptedException e) {
		}

		saleCoche();
	}

	synchronized private void entrarCoche() {
		System.out.println("El " + this.getName() + " SOLICITA ENTRAR");

		// bucle para que mientras si el hilo puede entrar
		while (!parkingEstacionar.solicitarAbrirBarreraEntrar()) {
			System.out.println("El " + this.getName() + " ESPERA para entrar");
			esperar();
			
		}

		parkingEstacionar.abrirBarrera();
		System.out.println("El " + this.getName() + " ENTRA");
		parkingEstacionar.entraCoche();
		parkingEstacionar.cerrarBarrera();

		// Notifica al resto de hilos que a acabado con el metodo
		notificar();

	}

	synchronized private void saleCoche() {

		System.out.println("El " + this.getName() + " Solicita salir");

		// bucle para que mientras si el hilo puede salir
		while (!parkingEstacionar.solicitarAbrirBarreraSalir()) {
			System.out.println("El" + this.getName() + " ESPERA para salir");
			esperar();
		}

		parkingEstacionar.abrirBarrera();
		System.out.println("El" + this.getName() + " SALE");
		parkingEstacionar.saleCoche();
		parkingEstacionar.cerrarBarrera();

		// Notifica que sale
		notificar();

	}

	synchronized private void notificar() {
		this.notifyAll();
	}

	synchronized private void esperar() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
