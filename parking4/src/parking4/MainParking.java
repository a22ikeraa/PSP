package parking4;

import java.util.Scanner;

public class MainParking {
	
	public static Coche[] crearCoches(Parking parking, int numeroCoches , String nombre) {
		ThreadGroup grupo = new ThreadGroup("Coches");
		Coche[] coches = new Coche[numeroCoches];
		
		for(int i = 0 ; i < coches.length ; i++) {
			coches[i] = new Coche(grupo, nombre+i, parking);
		}
		return coches;
	}

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int plazasParking = 0;
		int cochesEstacionar = 0;
		
		//Solicita las plazas que tendra el parking
		System.out.print("Plazas parking: ");
		plazasParking = sn.nextInt();
		
		//Solicita cuantos coches se quieren aparcar
		System.out.print("Coches a estacionar: ");
		cochesEstacionar = sn.nextInt();
		
		sn.close();
		
		//Creacion del parking ocn su barrera
		Barrera barrera = new Barrera();
		Parking parking = new Parking(plazasParking , barrera);
		
		//Crear los coches y iniciarlos
		Coche[] coches = crearCoches(parking, cochesEstacionar, "Coche");
		
		for(Coche coche : coches) {
			coche.start();
		}

	}

}
