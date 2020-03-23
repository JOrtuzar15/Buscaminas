package buscaminas;

import java.util.Observable;

public class Partida extends Observable{
	
	private static Partida miPartida;
	private int puntuacion;
	private int tiempo;
	private Tablero tablero;
	private Ranking ranking;
	
	private Partida(){  }
 
	public static Partida getMiPartida(){
		if (miPartida == null){
			miPartida = new Partida();
		}
		return miPartida;
		}
 
	public void empezar(){
		PantallaInicial pi = new PantallaInicial();
	}
	
	private void terminar(){
		PantallaFinal pf = new PantallaFinal();
	}
	
	public void reset(){
		this.tiempo = 0;
		this.tablero.reset;	
	}
	
	public void clicar(int pX, int pY, int pClick){
		this.tablero.clicar(pX,pY,pClick);
	}
}
