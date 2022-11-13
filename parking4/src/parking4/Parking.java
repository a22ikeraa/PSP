package parking4;

public class Parking {
	private Barrera barrera;
	private static int plazasParking = 0;
	private static int plazasOcupadas = 0;
	private static boolean parkingLleno = false;
	
	public Parking(int plazas , Barrera barrera) {
		this.barrera = barrera;
		plazasParking = plazas;
	}
	
	 private void isParkingLleno() {
		boolean estado = false;
		if (plazasOcupadas == plazasParking) {
			estado = true;
		} else {
			estado = false;
		}
		parkingLleno = estado;
	}
	 
	 public void abrirBarrera() {
		 barrera.abrirBarrera();
	 }
	 
	 public void cerrarBarrera() {
		 barrera.cerrarBarrera();
	 }
	 
	 public boolean solicitarAbrirBarreraEntrar() {
		 boolean puedeEntrar = false;
		 
		 isParkingLleno();
		 
		 if(parkingLleno || barrera.isBarreraAbierta()) {
			 puedeEntrar = false;
		 } else {
			 puedeEntrar = true;
		 }
		 return puedeEntrar;
	 }
	 
	 public boolean solicitarAbrirBarreraSalir() {
		 boolean puedeSalir = false;
		 
		 if(barrera.isBarreraAbierta()) {
			 puedeSalir = false;
		 } else {
			 puedeSalir = true;
		 }
		 
		 return puedeSalir;
	 }
	 
	 public void entraCoche() {
		 plazasOcupadas += 1;
	 }
	 
	 public void saleCoche() {
		 plazasOcupadas -= 1;
	 }
}
