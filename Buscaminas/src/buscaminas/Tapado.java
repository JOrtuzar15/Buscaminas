
public class Tapado implements Estado{
	public Tapado() {
		
	}
	public int clickIzq(Casilla pCasilla) { //Devuelve la informacion de la casilla, -1 si bomba, sino n de bombas adyacentes
		pCasilla.cambiarEstado(new Destapado());
		return pCasilla.getInfoCasilla();
		}
	
	public int clickDer(Casilla pCasilla) {//Devuelve 11, colocar banderin
		pCasilla.cambiarEstado(new Marcado());
		return 11;
	}
}
