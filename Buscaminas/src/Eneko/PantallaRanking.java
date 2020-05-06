package Buscaminas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Color;

public class PantallaRanking extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public PantallaRanking() {
		setTitle("RANKING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_1);
		
		JTextPane txtpnPdatosPdatosPdatos = new JTextPane();
		txtpnPdatosPdatosPdatos.setForeground(Color.BLUE);
		txtpnPdatosPdatosPdatos.setBackground(SystemColor.activeCaptionBorder);
		txtpnPdatosPdatosPdatos.setEditable(false);
		txtpnPdatosPdatosPdatos.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(txtpnPdatosPdatosPdatos);
		txtpnPdatosPdatosPdatos.setText(Ranking.getMiRanking().jugadorYPuntuacion());
		this.setVisible(true);
	}
	
	
	
	
	

}
