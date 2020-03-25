package Buscaminas;

public class Tablero {
		
		
		 private Casilla[][] matriz ;
		 private int ancho;
		 private int alto;
		 private int dificultad;
		 
		 public Tablero(int pAncho ,int pAlto) {
			 this.ancho= pAncho;
			 this.alto = pAlto;
			 this.matriz = new Casilla [pAncho][pAlto];
			
		 }
		 
		
		 public void generarCasillas (int numBombas) {
			 for(int h = 0 ; h<numBombas ; h++) {
				 this.generarBomba();
			 }
			 
			 this.rellenar();
			 this.comprobar();
		 }
		 private void generarBomba() {
			 int i = (int) Math.floor(Math.random()*(ancho)+0);
			 int z = (int) Math.floor(Math.random()*(alto)+0);
			 
			 
			 if(z>=0 && i>=0 && z<alto && i<ancho) {
				 if(matriz[i][z]==null) {
					 matriz[i][z] = new Casilla("-1");}
			 } 
				 
		 }
		
		private void rellenar() {
			 for (int i=0;i<ancho;i++){
			       for (int z=0;z<alto;z++){
			    	 if(matriz[i][z]==null) {
			    	   matriz[i][z] = new Casilla(" "); 
			    			   }
			       	}
			       }
		}
		 private void comprobar() {
			
			 for (int i=0;i<ancho;i++){
			       for (int z=0;z<alto;z++){
			       int numeroComprueba=0;  
			       if (matriz[i][z].getInfoCasilla().equals("-1") == false){
			        if  (z>=0 && i>=0 && z<alto && i<ancho){
			           System.out.println(i+ " "+ z +" "+ ancho +" " +alto);
			           
			           if ((z-1>=0) &&  matriz[i][z-1].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if ((z-1>=0) && (i-1>=0) && matriz[i-1][z-1].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if ((z-1>=0) && (i+1 < ancho) && matriz[i+1][z-1].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if ((z+1 < alto) && matriz[i][z+1].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if ((z+1 < alto) && (i+1 < ancho) && matriz[i+1][z+1].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if ((z+1 < alto) && (i-1 >=0) && matriz[i-1][z+1].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if ((i+1 < ancho) && matriz[i+1][z].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if ((i-1 >=0) && matriz[i-1][z].getInfoCasilla().equals("-1")){
			                  numeroComprueba++;
			                 }
			                 if (numeroComprueba != 0) {
								 matriz[i][z] = new Casilla(Integer.toString(numeroComprueba)) ;
								 }
								
			                      
			        }         
			        }               
			       }     
			   } 
		 }
		 public Casilla[][] getTablero(){
			 return this.matriz;
		 }
		 
		 public int clicar(int x, int y , int click) {
			Casilla c = this.matriz[x][y];
			if(click == 1) {
				return c.clickIzq();
			}else {
				return c.clickDer();
			}
			 
			 
						 
		 }

}
