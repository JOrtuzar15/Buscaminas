
public interface Estado {
	//El integer que devuelven estos metodos sigue el siguiente codigo:
	//-1: Explota
	//[0,8]: Cantidad de bombas en casillas adyacentes
	//9: No realizar cambios
	//10: Retirar un banderin
	//11: Colocar un banderin
	public int clickIzq(Casilla pCasilla);
	public int clickDer(Casilla pCasilla);
}
