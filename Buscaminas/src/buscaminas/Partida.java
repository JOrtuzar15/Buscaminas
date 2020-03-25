package Buscaminas;

import java.util.*;

public class Partida extends Observable{
	
	private static Partida miPartida;
	private int puntuacion;
	private int tiempo;
	private Tablero tablero;
	//private Ranking ranking;
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
		this.tablero.reset();	
	}
	
	public void clicar(int pX, int pY, int pClick){
		System.out.println(pClick);
		int res=this.tablero.clicar(pX,pY,pClick);
		if((res != 9)) {
			Coordenadas d = new Coordenadas(res , pX ,pY);
			
			/*if (res==0) {
				this.clicar(pX-1, pY-1, pClick);
				this.clicar(pX-1, pY, pClick);
				this.clicar(pX-1, pY+1, pClick);
				this.clicar(pX, pY-1, pClick);
				this.clicar(pX, pY+1, pClick);
				this.clicar(pX+1, pY-1, pClick);
				this.clicar(pX+1, pY, pClick);
				this.clicar(pX+1, pY+1, pClick);
			}
			else */if(res==-1) {
				this.terminar();
			}
			
			this.notify(d);
		}
		
	}
	
	private void notify( Coordenadas d) {
		System.out.println(this.listObservadores.size());
		Iterator<Observer> it = this.listObservadores.iterator();
	
		
		while(it.hasNext()) {
			Observer o = it.next();
			o.update(this, d);
		}
	}
	public void setTablero(Tablero pTablero) {
		this.tablero = pTablero;
	}
	public void añadirObserver(Observer o) {
		this.listObservadores.add(o);
	}
	public Tablero getTablero() {
		return this.tablero;
	}
	
}
