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
			 this.generarCasillas(5);
			
		 }
		 
		
		 public void generarCasillas (int numBombas) { //Introduce primero las bombas y después rellena las posiciones restantes de la matriz con casillas de los valores que correspondan
			 for(int h = 0 ; h<numBombas ; h++) {
				 this.generarBomba();
			 }
			 
			 this.rellenar();
			 this.comprobar();
		 }
		 private void generarBomba() { //Genera una sola bomba en una posicion aleatoria previamente sin ocupar
			 int i = (int) Math.floor(Math.random()*(ancho)+0);
			 int z = (int) Math.floor(Math.random()*(alto)+0);
			 
			 
			 if(z>=0 && i>=0 && z<alto && i<ancho) {
				 if(matriz[i][z]==null) {
					 matriz[i][z] = new Casilla(-1);}
				 else {
					 this.generarBomba();
				 }
			 } 
				 
		 }
		
		private void rellenar() { //Rellena cada posicion con casillas vacias
			 for (int i=0;i<ancho;i++){
			       for (int z=0;z<alto;z++){
			    	 if(matriz[i][z]==null) {
			    	   matriz[i][z] = new Casilla(0); 
			    			   }
			       	}
			       }
		}
		 private void comprobar() { //Asigna los valores que correspondan a las casillas en funcion de la disposicion de las bombas
			 
			 for (int i=0;i<ancho;i++){
			       for (int z=0;z<alto;z++){//Busca las bombas
			        
			       if (matriz[i][z].getInfoCasilla() == -1){ //Al encontrarlas incrementa el valor de sus adyacentes excepto si son bombas tambien
			        if  (z>=0 && i>=0 && z<alto && i<ancho){
			        	
			           System.out.println(i+ " "+ z +" "+ ancho +" " +alto);
			           //Los condicionales tienen en cuenta los casos especiales de esquinas y bordes de la matriz
			           		if ((z-1>=0) &&  matriz[i][z-1].getInfoCasilla() != -1){
			                  matriz[i][z-1].incrementar();
			                 }
			                 if ((z-1>=0) && (i-1>=0) && matriz[i-1][z-1].getInfoCasilla() != -1 ){
			                	 matriz[i-1][z-1].incrementar();
			                 }
			                 if ((z-1>=0) && (i+1 < ancho) && matriz[i+1][z-1].getInfoCasilla() != -1){
			                	 matriz[i+1][z-1].incrementar();
			                 }
			                 if ((z+1 < alto) && matriz[i][z+1].getInfoCasilla() != -1){
			                	 matriz[i][z+1].incrementar();
			                 }
			                 if ((z+1 < alto) && (i+1 < ancho) && matriz[i+1][z+1].getInfoCasilla() != -1){
			                	 matriz[i+1][z+1].incrementar();
			                 }
			                 if ((z+1 < alto) && (i-1 >=0) && matriz[i-1][z+1].getInfoCasilla() != -1){
			                	 matriz[i-1][z+1].incrementar();
			                 }
			                 if ((i+1 < ancho) && matriz[i+1][z].getInfoCasilla() != -1){
			                	 matriz[i+1][z].incrementar();
			                 }
			                 if ((i-1 >=0) && matriz[i-1][z].getInfoCasilla() != -1){
			                	 matriz[i-1][z].incrementar();
			                 }
			             
			  			    	   
			  			       }
			  		    }
								          
			        	}         
			        }  
			
		 }
		 public Casilla[][] getTablero(){
			 return this.matriz;
		 }
		 
		 public int clicar(int x, int y , int click) { //Diferencia entre los metodos clickIzq y clickDer de Casilla y devuelve el resultado de la operacion
			System.out.println(x);
			System.out.println(y);
			Casilla c = this.matriz[x][y];
			if(click == 1) {
				return c.clickIzq();
			}else {
				return c.clickDer();
			}
			 				 
		 }


		public void reset() {
			
			
		}
		
		public int dimX() {
			return this.ancho;
		}
		
		public int dimY() {
			return this.alto;
		}
		
		public boolean ganado() { //Comprueba que todas las casillas de bomba esten tapadas o marcadas y todas las no-bombas esten destapadas. Se ejecuta a cada click que da el usuario(desde el metodo clicar de Partida) 
			boolean ganar=true;
			for (int i= 0;i<this.matriz.length;i++) {
				for (int j =0;j<this.matriz[0].length;j++) {
					ganar=ganar&&((this.matriz[i][j].getInfoCasilla()==-1&&!this.matriz[i][j].clear())||(this.matriz[i][j].getInfoCasilla()!=-1&&this.matriz[i][j].clear()));
				}
			}
			return ganar;
		}
		
}
