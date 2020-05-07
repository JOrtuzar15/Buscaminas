package Buscaminas;

import java.util.*;

public class Partida extends Observable{
	private PantallaInicial p;
	private static Partida miPartida;
	private String nombre;
	private int puntuacion;
	private int tiempo;
	private Tablero tablero;
	private int marcados = 0;
	private ArrayList <Observer> listObservadores ;
	private boolean acabado;
	private int cont;
	
	private Partida(){ 
		this.cont = 1;
		this.tiempo = 0;
		this.acabado = false;
		this.listObservadores = new ArrayList<Observer>();
		
		
	}
 
	public static Partida getMiPartida(){
		if (miPartida == null){
			miPartida = new Partida();
		}
		return miPartida;
		}
 
	public PantallaInicial empezar() {
		 p = new PantallaInicial();
		 return p;
		
	}
	public void setNombre(String pnombre) {
		this.nombre = pnombre;
	}
	public void setPuntu(int ppuntu) {
		this.puntuacion = ppuntu;
	}
	
	private void terminar(boolean pB){
		
		if (pB) {
			if (cont == 1) {
			new PantallaFinal("Victoria",this.puntuacion);
			Ranking.getMiRanking().annadirOrdenado(new Usuario(this.nombre , this.puntuacion));
			cont++;
			}
		}
		else {
			new PantallaFinal("Derrota",this.puntuacion);
		}
		
	}
	
	public void reset(){
		this.cont = 1;
		this.acabado= false;
		this.tiempo = 0;
		this.tablero.reset();
		InterfazTablero i=(InterfazTablero) listObservadores.get(0);
		Iterator<Observer> itr=listObservadores.iterator();
		while(itr.hasNext()) {
			InterfazTablero o=(InterfazTablero) itr.next();
			o.setVisible(false);
		}
		listObservadores=new ArrayList<Observer>();
		listObservadores.add(new InterfazTablero(i.getDificultad()));
	}
	
	public void clicar(int pX, int pY, int pClick){
		if (acabado == false) {
		System.out.println(pClick + "TIPO CLICK");
		int res=this.tablero.clicar(pX,pY,pClick);
		if (res == 11 && marcados == this.tablero.getAlto()) {
			this.tablero.clicar(pX,pY,3);
			res = 9;
		}
		if((res != 9)) {
			Coordenadas d = new Coordenadas(res , pX ,pY);
			
			if (res==0) {
			this.expandir(pX, pY, pClick);
			}
				
			else if(res==-1) {
				this.notify(d);
				this.terminar(false);
			}
			else if(res == 11) {
				if (marcados >  this.tablero.getAlto()) {
					marcados =  this.tablero.getAlto()-1;
				}else {
				marcados++;}
				System.out.println(marcados + "marcados" + " " + this.tablero.getAlto() + "alto");
				System.out.println("BOMBAS" + this.tablero.getAlto());
			}
			else if(res == 10 ) {
				if (marcados < 0) {
					marcados = 0;
				}
				else {
				marcados--;}
				System.out.println(marcados + "marcados");
			}
			
			if(res == 11 && marcados <= this.tablero.getAlto()) {
				this.notify(d);
			}
			if (res != 11) {
				this.notify(d);
			}
			if (this.tablero.ganado()) {
				this.terminar(true);}
		}
		}
		
	}
	private void expandir(int pX, int pY, int pClick){
		
		if(pX==0 && pY==0) {
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY+1, pClick);
		}
		else if(pX==0 && pY==this.tablero.dimY()-1) {
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX+1, pY-1, pClick);
		}
		else if(pX==this.tablero.dimX()-1 && pY==0) {
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX-1, pY+1, pClick);
		}
		else if(pX==this.tablero.dimX()-1 && pY==this.tablero.dimY()-1) {
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX-1, pY-1, pClick);
		}
		else if(pX==0) {
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY-1, pClick);
			this.clicar(pX+1, pY+1, pClick);
		}
		else if(pX==this.tablero.dimX()-1) {
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX-1, pY-1, pClick);
			this.clicar(pX-1, pY+1, pClick);
		}
		else if(pY==0) {
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX+1, pY+1, pClick);
			this.clicar(pX-1, pY+1, pClick);
		}
		else if(pY==this.tablero.dimY()-1) {
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX+1, pY-1, pClick);
			this.clicar(pX-1, pY-1, pClick);
		}
		else {
			this.clicar(pX-1, pY-1, pClick);
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX-1, pY+1, pClick);
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY-1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX+1, pY+1, pClick);
		
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
	public void aņadirObserver(Observer o) {
		this.listObservadores.add(o);
	}
	public Tablero getTablero() {
		return this.tablero;
	}
	public void setAcabado() {
		this.acabado=true;
	}
}
