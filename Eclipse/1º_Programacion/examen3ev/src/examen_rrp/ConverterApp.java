package examen_rrp;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConverterApp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public final static String EUR_USD = "EUR \u2794 USD";
	public final static String EUR_BTC = "EUR \u2794 BTC";
	public final static String USD_EUR = "USD \u2794 EUR";
	public final static String USD_BTC = "USD \u2794 BTC";
	public final static String BTC_EUR = "BTC \u2794 EUR";
	public final static String BTC_USD = "BTC \u2794 USD";
	
	public final static double CANTIDAD_EUR_USD = 1.22;
	public final static double CANTIDAD_EUR_BTC = 0.000036;
	public final static double CANTIDAD_USD_EUR = 0.82;
	public final static double CANTIDAD_USD_BTC = 0.000029;
	public final static double CANTIDAD_BTC_EUR = 27900;
	public final static double CANTIDAD_BTC_USD = 34000;
	
	public final static String EUROS = "euros";
	public final static String DOLARES = "dólares";
	public final static String BITCOINS = "bitcoins";
	
	private JPanel panel;
	private JLabel imagen;
	private JLabel titulo;
	private JComboBox<String> combo;
	private JTextField campoTexto;
	private JLabel moneda;
	private JButton boton;
	private JLabel resultado;
	
	public ConverterApp() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Currency Converter");
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		imagen = new JLabel(new ImageIcon("img/usdeurbtc.jpg"));
		
		titulo = new JLabel("Currency Converter");
		titulo.setFont(new Font("Arial", Font.TRUETYPE_FONT, 25));
		
		combo = new JComboBox<String>();
		combo.addItem(EUR_USD);
		combo.addItem(EUR_BTC);
		combo.addItem(USD_EUR);
		combo.addItem(USD_BTC);
		combo.addItem(BTC_EUR);
		combo.addItem(BTC_USD);
		combo.setSelectedItem(EUR_USD);
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcion = (String) combo.getSelectedItem();
				
				switch (opcion) {
					case EUR_USD:
					case EUR_BTC:
						moneda.setText(EUROS);
						break;
					case USD_EUR:
					case USD_BTC:
						moneda.setText(DOLARES);
						break;
					case BTC_EUR:
					case BTC_USD:
						moneda.setText(BITCOINS);
						break;
				}
			}
		});
		
		campoTexto = new JTextField(9);
		campoTexto.setFont(new Font("Arial", Font.BOLD, 25));
		
		moneda = new JLabel(EUROS);
		moneda.setFont(new Font("Arial", Font.BOLD, 14));
		
		boton = new JButton("Convertir");
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double cantidad = Double.parseDouble(campoTexto.getText());
					String opcion = (String) combo.getSelectedItem();
					String monedaDestino = null;
					switch (opcion) {
						case USD_EUR:
						case BTC_EUR:
							monedaDestino = EUROS;
							break;
						case EUR_USD:
						case BTC_USD:
							monedaDestino = DOLARES + " estadounidenses";
							break;
						case EUR_BTC:
						case USD_BTC:
							monedaDestino = BITCOINS;
							break;
					}
					resultado.setText(convertir(cantidad, opcion) + " " + monedaDestino);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panel, "Debes introducir un número real", "Examen 3ev", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		resultado = new JLabel(" ");
		resultado.setBackground(Color.YELLOW);
		resultado.setOpaque(true);
		resultado.setPreferredSize(new Dimension(400, 25));
		resultado.setFont(new Font(Font.MONOSPACED, Font.TRUETYPE_FONT, 22));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(imagen);
		panel.add(titulo);
		panel.add(combo);
		panel.add(campoTexto);
		panel.add(moneda);
		panel.add(boton);
		panel.add(resultado);
		
		this.setContentPane(panel);
		this.setSize(500, 190);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static double convertir(double cantidad, String opcion) {
		
		double resultado = 0;
		
		switch (opcion) {
			case EUR_USD:
				resultado = cantidad * CANTIDAD_EUR_USD;
				break;
			case EUR_BTC:
				resultado = cantidad * CANTIDAD_EUR_BTC;
				break;
			case USD_EUR:
				resultado = cantidad * CANTIDAD_USD_EUR;
				break;
			case USD_BTC:
				resultado = cantidad * CANTIDAD_USD_BTC;
				break;
			case BTC_EUR:
				resultado = cantidad * CANTIDAD_BTC_EUR;
				break;
			case BTC_USD:
				resultado = cantidad * CANTIDAD_BTC_USD;
				break;
		}
		
		return resultado;
		
	}

	public static void main(String[] args) {
		new ConverterApp();
	}
	
}