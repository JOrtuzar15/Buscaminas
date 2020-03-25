package Buscaminas;

import java.util.*;

public class Partida extends Observable{
	
	private static Partida miPartida;
	private int puntuacion;
	private int tiempo;
	private Tablero tablero;
	private Ranking ranking;
	private ArrayList <Observer> listObservadores ;
	
	private Partida(){ 
		this.puntuacion = 0;
		this.tiempo = 0;
		this.listObservadores = new ArrayList<Observer>();
		
		
	}
 
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
		if(
		this.tablero.clicar(pX,pY,pClick) != 9) {
			int[] lista = new int[3];
			lista[0] = pX;
			lista[1] = pY;
			lista[2] = pClick;
			
			this.notify(lista);
		}
		
	}
	
	private void notify(int[] lista) {
		
		Iterator<Observer> it = this.listObservadores.iterator();
		
		while(it.hasNext()) {
			Observer o = it.next();
			o.update(this, lista);
		}
	}
	
	
}
