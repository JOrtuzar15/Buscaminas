package Buscaminas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
 
public class InterfazTablero extends JFrame implements Observer {
	
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private int alto;
	private int ancho;
	public  JButton [][] Botones; //Matriz de botones
	public  Integer [][] elArray; //Matriz de String subyacente a la matriz de botones
	private String dificultad;
	

	public InterfazTablero(String pdificultad) {
		this.añadirmeObserver();
		this.dificultad = pdificultad;
		this.setDimensiones();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{422, 0};
		gbl_contentPane.rowHeights = new int[]{24, 197, 35, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(getPanel(), gbc_panel);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(getPanel_2(), gbc_panel_2);
		
		this.setVisible(true);
		
	}
	
	public void setDimensiones (){
		
		if (dificultad.equals("Facil")){
			this.ancho=7;
		    this.alto=10;
		    Partida.getMiPartida().setTablero(new Tablero(alto,ancho));
		    Casilla[][] c = Partida.getMiPartida().getTablero().getTablero() ;
		    Botones = new JButton[alto][ancho];
		    elArray = new Integer [alto][ancho];
		    for (int x=0;x<alto;x++){
			       for (int z=0;z<ancho;z++){
			    	   elArray[x][z] = c[x][z].getInfoCasilla();
			       }
		    }

		}else if(dificultad.equals("Media")){
			this.ancho=10;
		    this.alto=15;
		    Partida.getMiPartida().setTablero(new Tablero(alto,ancho));
		    Casilla[][] c = Partida.getMiPartida().getTablero().getTablero() ;
		    Botones = new JButton[alto][ancho];
		    elArray = new Integer [alto][ancho];
		    for (int x=0;x<alto;x++){
			       for (int y=0;y<ancho;y++){
			    	   elArray[x][y] = c[x][y].getInfoCasilla();
			       }
		    }
		}else{
			this.ancho=12;
		    this.alto=25;
		    Partida.getMiPartida().setTablero(new Tablero(alto,ancho));
		    Casilla[][] c = Partida.getMiPartida().getTablero().getTablero() ;
		    Botones = new JButton[alto][ancho];
		    elArray = new Integer [alto][ancho];
		    for (int x=0;x<alto;x++){
			       for (int y=0;y<ancho;y++){
			    	   elArray[x][y] = c[x][y].getInfoCasilla();
			       }
		    }
		}
		System.out.println(alto);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("BUSCAMINAS V1" );
		}
		return lblNewLabel;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(alto, ancho, 0, 0));
		}
		System.out.println(alto);
		for(int x =0; x<alto; x++){
			for(int y=0 ; y<ancho; y++){
			JButton but = new JButton();
			Botones[x][y]= but;
			panel_2.add(but);
			Botones[x][y].addActionListener(
		               new ActionListener(){
		      public void actionPerformed(ActionEvent ar) {
		       for (int x=0;x<alto;x++){
		             for (int y=0;y<ancho;y++){
		             if (ar.getSource()==Botones[x][y]){
		                 if ((ar.getModifiers() & 16)!=0) {
		            	 Partida.getMiPartida().clicar(x,y,1);}
		                 else if ((ar.getModifiers() & 4)!=0) {
			            	 Partida.getMiPartida().clicar(x,y,3);}
		  
		             }        	             if (ar.getSource()==Botones[x][y]){
		                  mostrarCasilla(x,y);
		        		  
		             }                        }        }            }               }             );  
		}
	}
	return panel_2;
}
	public void mostrarCasilla(int x,int y){
	    Botones[x][y].setText(elArray[x][y].toString());
	   Botones[x][y].setEnabled(false);
	 
	    
	 
	 }

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("holaaaaaaaaaaaaa");
		Coordenadas coordenadas =  (Coordenadas) arg;
		if (coordenadas.res==10) {
			
			//Mostrar casilla vacia
		}
		else if (coordenadas.res==11) {
			
			//Poner banderin en coordenadas especificadas
		}
		else if (coordenadas.res==-1) {
			
			//Has perdido
			
		}
		else if (coordenadas.res==0){
			
			//Mostrar casilla vacia
			Botones[coordenadas.x][coordenadas.y].setEnabled(false);
			this.metodoStackOverFlow(coordenadas.x, coordenadas.y);
		}
		else {
			
			elArray[coordenadas.x][coordenadas.y]=coordenadas.res;
			Botones[coordenadas.x][coordenadas.y].setEnabled(false);
		}
	}
	private void añadirmeObserver() {
		Partida.getMiPartida().añadirObserver(this);
	}
	private void metodoStackOverFlow(int x, int y) {
		//i alto columnas
		//z ancho filas
		   if ( y!=0 && x!=0 && y!=ancho-1 && x!=alto-1){
		    Botones[x-1][y].setEnabled(false);
		    Botones[x-1][y-1].setEnabled(false);
		    Botones[x-1][y+1].setEnabled(false);
		    Botones[x][y-1].setEnabled(false);
		    Botones[x][y+1].setEnabled(false);
		    Botones[x+1][y].setEnabled(false);
		    Botones[x+1][y+1].setEnabled(false);
		    Botones[x+1][y-1].setEnabled(false);
		    Botones[x][y].setEnabled(false);
		    if(x==0 && y==0) {
		    	Botones[x+1][y].setText(elArray[x+1][y].toString());
				Botones[x][y+1].setText(elArray[x][y+1].toString());
				Botones[x][y].setText(elArray[x][y].toString());
		    }
				
			else if(x==0 && y==ancho-1) {
				 Botones[x][y-1].setText(elArray[x][y-1].toString());
				 Botones[x-1][y].setText(elArray[x-1][y].toString());
				 Botones[x][y].setText(elArray[x][y].toString());
				
			}
			else if(x==alto-1 && y==0) {
				Botones[x][y+1].setText(elArray[x][y+1].toString());
				Botones[x-1][y].setText(elArray[x-1][y].toString());
				Botones[x][y].setText(elArray[x][y].toString());
			}
			else if(x==alto-1 && y==ancho-1) {
				 Botones[x][y-1].setText(elArray[x][y-1].toString());
				 Botones[x-1][x-1].setText(elArray[x-1][y-1].toString());
				 Botones[x][y].setText(elArray[x][y].toString());
			}
			else if(x==0) {
				Botones[x+1][y].setText(elArray[x+1][y].toString());
				Botones[x][y+1].setText(elArray[x][y+1].toString());
				Botones[x][y-1].setText(elArray[x][y-1].toString());
				Botones[x][y].setText(elArray[x][y].toString());
				
			}
			else if(x==alto-1) {
				Botones[x-1][y].setText(elArray[x-1][y].toString());
				Botones[x][y+1].setText(elArray[x][y+1].toString());
				Botones[x][y-1].setText(elArray[x][y-1].toString());
				Botones[x][y].setText(elArray[x][y].toString());
			}
			else if(y==0) {
				 Botones[x][y+1].setText(elArray[x][y+1].toString());
				 Botones[x+1][y].setText(elArray[x+1][y].toString());
				 Botones[x-1][y].setText(elArray[x-1][y].toString());
				 Botones[x][y].setText(elArray[x][y].toString());
			}
			else if(y==ancho-1) {
				 Botones[x][y-1].setText(elArray[x][y-1].toString());
				 Botones[x+1][y].setText(elArray[x+1][y].toString());
				 Botones[x-1][y].setText(elArray[x-1][y].toString());
				 Botones[x][y].setText(elArray[x][y].toString());
				
			}
			else {
				Botones[x-1][y].setText(elArray[x-1][y].toString());
				Botones[x-1][y-1].setText(elArray[x-1][y-1].toString());
				Botones[x-1][y+1].setText(elArray[x-1][y+1].toString());
				Botones[x][y-1].setText(elArray[x][y-1].toString());
				Botones[x][y+1].setText(elArray[x][y+1].toString());
				Botones[x+1][y].setText(elArray[x+1][y].toString());
				Botones[x+1][y+1].setText(elArray[x+1][y+1].toString());
				Botones[x+1][y-1].setText(elArray[x+1][y-1].toString());
				Botones[x][y].setText(elArray[x][y].toString());
			}
		    
		}
		   
	}
}

