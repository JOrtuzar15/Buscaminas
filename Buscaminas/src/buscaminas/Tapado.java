
public class Tapado implements Estado{
	public Tapado() {
		
	}
	public void clickIzq(Casilla pCasilla) {
		pCasilla.cambiarEstado(new Destapado());
	}
	
	public void clickDer(Casilla pCasilla) {
		
	}
}
