package buscaminas;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero {
		 Casilla[][] tablero;
		 private JPanel jPanel1 = new JPanel();
		  private int ancho;
		  private int alto;
		  public  JButton Botones[][]=new JButton [ancho][alto];
		  public  String [][] elArray =new String [ancho][alto];
		 
		  
		  
		  
		  public void setAncho(int pAncho){
			  this.ancho=pAncho;
		  }
		  public void setAlto(int pAlto){
			  this.alto=pAlto;
		  }
		
		 public void cargarTablero(){
		     for (int i=0;i<ancho;i++){
		      for (int z=0;z<alto;z++){
		      elArray[i][z]=" ";
		         Botones[i][z]= new JButton();
		             jPanel1.add(Botones[i][z]);
		             Botones[i][z].setBounds(i*25,z*25,25,25);
		             Botones[i][z].setMargin(new Insets(0, 0, 0, 0));
		             Botones[i][z].setFont(new Font("Tahoma", 0,10));
		             Botones[i][z].addActionListener(
		               new ActionListener(){
		      
		    public void actionPerformed(ActionEvent ar) {
		       for (int i=0;i<ancho;i++){
		             for (int z=0;z<alto;z++){
		             if (ar.getSource()==Botones[i][z]){
		                  showTextTop(i,z);
		  
		             }                }        }            }               }             );             
		 
		             }               }       }
		//—- Muestra el texto en todos los botones cuando hay bomba.
		 
		  public void textoBotones(){
		  for (int i=0;i<ancho;i++){
		      for (int z=0;z<alto;z++){
		       Botones[i][z].setText(elArray[i][z]);
		       Botones[i][z].setEnabled(false);
		  //codigo para mostrar el texto encima del boton.
		  }   
		      }
		  }   
		 public void showTextTop(int i,int z){
			    Botones[i][z].setText(elArray[i][z]);
			    Botones[i][z].setEnabled(false);
			 
			    if (elArray[i][z]==" "){
			    Botones[i][z].setEnabled(false);
			    metodoStackOverFlow(i,z);
			    }
			    else {
			     Botones[i][z].setEnabled(false);
			    }
			    if (Botones[i][z].getText()=="B"){
			         textoBotones();
			         }
		 }
		 
		 private void metodoStackOverFlow(int i, int z) {
			    if ( z!=0 && i!=0 && z!=alto-1 && i!=ancho-1){
			    Botones[i-1][z].setEnabled(false);
			    Botones[i-1][z-1].setEnabled(false);
			    Botones[i-1][z+1].setEnabled(false);
			    Botones[i][z-1].setEnabled(false);
			    Botones[i][z+1].setEnabled(false);
			    Botones[i+1][z].setEnabled(false);
			    Botones[i+1][z+1].setEnabled(false);
			    Botones[i+1][z-1].setEnabled(false);
			 
			    Botones[i-1][z].setText(elArray[i-1][z]);
			    Botones[i-1][z-1].setText(elArray[i-1][z-1]);
			    Botones[i-1][z+1].setText(elArray[i-1][z+1]);
			    Botones[i][z-1].setText(elArray[i][z-1]);
			    Botones[i][z+1].setText(elArray[i][z+1]);
			    Botones[i+1][z].setText(elArray[i+1][z]);
			    Botones[i+1][z+1].setText(elArray[i+1][z+1]);
			    Botones[i+1][z-1].setText(elArray[i+1][z-1]);
			    }
			}
			 
		 
}
