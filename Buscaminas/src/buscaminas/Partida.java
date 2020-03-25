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
		
	}
	
	public void reset(){
		this.tiempo = 0;
		this.tablero.reset;	
	}
	
	public void clicar(int pX, int pY, int pClick){
		int res=this.tablero.clicar(pX,pY,pClick);
		if((res != 9)) {
			int[] lista = new int[3];
			lista[0] = pX;
			lista[1] = pY;
			lista[2] = res;
			
			if (res==0) {
				this.clicar(pX-1, pY-1, pClick);
				this.clicar(pX-1, pY, pClick);
				this.clicar(pX-1, pY+1, pClick);
				this.clicar(pX, pY-1, pClick);
				this.clicar(pX, pY+1, pClick);
				this.clicar(pX+1, pY-1, pClick);
				this.clicar(pX+1, pY, pClick);
				this.clicar(pX+1, pY+1, pClick);
			}
			else if(res==-1) {
				this.terminar;
			}
			
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
