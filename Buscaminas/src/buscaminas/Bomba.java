package buscaminas;

public class Bomba extends Strategy {

	
	
	public void colocarBombas(int numeroBombas){
		   double i=0;
		   double z=0;
		   int condicion=0;
		  do  {
		     i=Math.random()*getAncho();
		        z=Math.random()*getAlto();
		           i=(int)i;
		           z=(int)z;
		           if  (z!=0 && i!=0 && z!=alto-1 && i!=ancho-1){
		             // Botones[(int) i][(int) z].setText("B");
		              elArray[(int)i][(int) z ]="B";
		              condicion++;
		           }
		  }}
}
