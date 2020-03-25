package buscaminas;

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
	private int ancho;
	private int alto;
	public  JButton [][] Botones; //Matriz de botones
	public  String [][] elArray; //Matriz de String subyacente a la matriz de botones
	private String dificultad;
	

	public InterfazTablero(String pdificultad) {
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
			this.alto=7;
		    this.ancho=10;
		    Botones = new JButton[ancho][alto];
		    
		    
		    
		}else if(dificultad.equals("Media")){
			this.alto=10;
		    this.ancho=15;
		    Botones =new JButton [ancho][alto];
		    elArray = new String [ancho][alto];
		}else{
			this.alto=12;
		    this.ancho=25;
		    Botones =new JButton [ancho][alto];
		    elArray = new String [ancho][alto];
		}
		System.out.println(ancho);
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
			lblNewLabel = new JLabel("BUSCAMINAS V1");
		}
		return lblNewLabel;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(ancho, alto, 0, 0));
		}
		System.out.println(ancho);
		for(int x =0; x<ancho; x++){
			for(int y=0 ; y<alto; y++){
			JButton but = new JButton();
			Botones[x][y]= but;
			panel_2.add(but);
			Botones[x][y].addActionListener(
		               new ActionListener(){
		      public void actionPerformed(ActionEvent ar) {
		       for (int i=0;i<ancho;i++){
		             for (int z=0;z<alto;z++){
		             if (ar.getSource()==Botones[i][z]){
		                 Partida.getMiPartida().clicar(i,z,1);
		  
		             }                }        }            }               }             );  
		}
	}
	return panel_2;
}
	public void mostrarCasilla(int i,int z){
	    Botones[i][z].setText(elArray[i][z]);
	    Botones[i][z].setEnabled(false);
	 
	    
	 
	 }
	

	@Override
	public void update(Observable o, Object arg) {
		
		Integer[] coordenadas = (Integer []) arg;
		if (coordenadas[2]==10) {
			//Mostrar casilla vacia
		}
		else if (coordenadas[2]==11) {
			//Poner banderin en coordenadas especificadas
		}
		else if (coordenadas[2]==-1) {
			//Has perdido
			
		}
		else if (coordenadas[2]==0){
			//Mostrar casilla vacia
			Botones[coordenadas[0]][coordenadas[1]].setEnabled(false);
		}
		else {
			elArray[coordenadas[0]][coordenadas[1]]=coordenadas[2].toString();
			Botones[coordenadas[0]][coordenadas[1]].setEnabled(false);
		}
	}
	
	
}
