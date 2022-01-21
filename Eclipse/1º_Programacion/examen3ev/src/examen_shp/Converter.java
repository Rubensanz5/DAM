package examen_shp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Converter {

	private JComboBox<String> desplegable;
	private JFrame frame;
	private JPanel panel;
	private JLabel etiqueta;
	private JLabel etiqueta2;
	private JLabel etiqueta3;
	private JLabel etiqueta4;
	private JButton boton;
	
	public Converter() {
		
		desplegable = new JComboBox<String>();
		frame = new JFrame("Currency Converter");
		panel = new JPanel();
		etiqueta = new JLabel();
		etiqueta2 = new JLabel();
		etiqueta3 = new JLabel();
		etiqueta4 = new JLabel();
		boton = new JButton();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		etiqueta.setIcon(new ImageIcon("img/usdeurbtc.jpg"));
		etiqueta2.setName("Currency Converter");
		etiqueta3.setName("euros");
		etiqueta4.setBackground(Color.YELLOW);
		etiqueta4.setOpaque(true);
		
		boton.setName("Convertir");
	
		desplegable.addItem("EUR \u2794 USD");
		desplegable.addItem("EUR \\U2794 BTC");
		desplegable.addItem("USD \\U2794 EUR");
		desplegable.addItem("USD \\U2794 BTC");
		desplegable.addItem("BTC \\U2794 EUR");
		desplegable.addItem("BTC \\U2794 USD");
		
		panel.add(etiqueta);
		panel.add(etiqueta2);
		panel.add(desplegable);
		//panel.add();
		panel.add(etiqueta3);
		panel.add(boton);
		panel.add(etiqueta4);
		
		desplegable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(desplegable.getSelectedIndex()) {
				
					case 1:
					case 2:
						etiqueta3.setText("euros");
						break;
					case 3:
					case 4:
						etiqueta3.setText("dólares");
						break;
					case 5:
					case 6:
						etiqueta3.setText("bitcoins");
						break;
				}
			}
		});
		
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		new Converter();
	}

}
