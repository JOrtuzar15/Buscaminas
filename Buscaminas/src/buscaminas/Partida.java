package buscaminas;

public class Partida {
	private static Partida miPartida  = new Partida();
	 Tablero tablero;
	int tiempo;
	int puntos;
	
 private Partida(){
	 
 }
 
 public static Partida getMiPartida(){
	 if(miPartida == null){
		 miPartida = new Partida();
	 }
		 return miPartida;
 }
 
 
 public void empezar(){
	 
 }
 public void reset(){
	 
 }
 public void finalGame (){
	   int contadorFinal=0;
	    for (int i=1;i<ancho-1;i++){
	       for (int z=1;z<alto-1;z++){
	       if (Tablero.[i][z].getText()==" " || Botones[i][z].getText()=="1" ||
	        Botones[i][z].getText()=="2" || Botones[i][z].getText()=="3" ||
	        Botones[i][z].getText()=="5" || Botones[i][z].getText()=="4" ){
	            contadorFinal++;
	                 if (contadorFinal==171){
	                  this.setTitle("Has Ganado… oooooo…..");
	                  jButton1.setText("NEW…");
	                 }        }   }  }     }

}
