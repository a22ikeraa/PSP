package parking4;

public class Barrera {
	private static boolean barreraAbierta = false;
	
	public Barrera() {}
	
	public void abrirBarrera() {
		barreraAbierta = true;
	}
	
	public void cerrarBarrera() {
		barreraAbierta = false;
	}
	
	public boolean isBarreraAbierta() {
		return barreraAbierta;
	}
}
