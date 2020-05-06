package Buscaminas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ranking {
	

	
	//atributos
	private ArrayList<Usuario> lista;
	
	//constructora
	
	public Ranking() {
		this.lista=new ArrayList<Usuario>();
		this.cargarDatos();
	}
	
	
	
	//otros metodos
	public void annadirUsuario (Usuario pUsuario){
		this.lista.add(pUsuario);
	}
	
	
	
	private Iterator<Usuario> getIterador()
	{
		return this.lista.iterator();
	}

	
	public void mostrar(){
		Usuario u=null;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext()){
			u=itr.next();
			System.out.println(u.getNombre()+u.getPuntuacion());
			
		}
	}
	
	
		//Metodo anadido para visualizar los datos en ranking
		//Va enlazando todos los datos de uno en uno y los devuelve para mostrar en RankingPantalla
	public String jugadorYPuntuacion(){
		String ranking=null; 
		Usuario u=null;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext()){
			u=itr.next();
			ranking=ranking+(u.getNombre()+" "+u.getPuntuacion()+"\n");
				
		}
		return ranking;
		
	}
	//Necesitamos un metodo para cargar desde un archivo de texto los nombres y otro para escribirlos
	//Para que se queden guardados

	private void escribirDatos () {
		try (FileWriter fileWriter = new FileWriter("C:\\TEMP\\Ranking.txt" , false)) {
			Usuario u=null;
			Iterator<Usuario> itr=this.getIterador();
			while (itr.hasNext()) {
				u=itr.next();
				fileWriter.write(u.getNombre()+" "+u.getPuntuacion()+"\n");
			}
		}catch (IOException e) {
			System.out.println("Error " + e);
		}
	}
	
	private void cargarDatos() {
        try (FileReader fileReader = new FileReader("C:\\TEMP\\Ranking.txt")) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] lineaSeparada = linea.split(" ");
            String usuario = lineaSeparada[0];
            int puntuacion = Integer.parseInt(lineaSeparada[1]);
            Usuario a = new Usuario(usuario , puntuacion);
			this.lista.add(a);
				}
            scanner.close();
            }
        catch (IOException e) {
            System.out.println("Error " + e);
        }
    }
	
	//Aqui tiene que ser añadir ordenado
	//Cargar los datos al arraylist
	//mirar la posicion
	//y añadir ordenado
	public void annadirOrdenado(Usuario pUsuario){
		Usuario aux=null;
		int cont=0;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext() && pUsuario.getPuntuacion()<aux.getPuntuacion() ){
			aux=itr.next();
			cont=cont+1;
			if (pUsuario.getPuntuacion()>aux.getPuntuacion()){
				this.lista.add(cont, pUsuario);
			}
				
			}
		escribirDatos();
		}
	}
