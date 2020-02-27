package buscaminas;

public abstract class Casilla {
	
	public Tablero tablero ;
	
	public Casilla(){
		this.tablero = Partida.getMiPartida().tablero;
	}
	
	public abstract void colocar();
}
