package examenr_sg;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConverterApp extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new ConverterApp();

	}
	
	
	public ConverterApp(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Currency Converter");
		
		JPanel panel = new JPanel();
		
		JLabel foto = new JLabel(new ImageIcon("img/usdeurbtc.jpg"));
		JLabel textoIni = new JLabel("Currency Converter");
		
		JComboBox<String> desplegable = new JComboBox<>();
		desplegable.addItem("EUR -> USD");
		desplegable.addItem("EUR -> BTC");
		desplegable.addItem("USD -> EUR");
		desplegable.addItem("USD -> BTC");
		desplegable.addItem("BTC -> EUR");
		desplegable.addItem("BTC -> USD");
		
		JTextField cantidad = new JTextField(8);
		JLabel monOrigen = new JLabel("Euros");
		JButton convertir = new JButton("Convertir");
		
		JLabel resultado = new JLabel("");
		resultado.setBackground(Color.YELLOW);
		resultado.setOpaque(true);

		
		desplegable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String monedaO = desplegable.getSelectedItem().toString();
				if(monedaO.equals("EUR -> USD") || monedaO.equals("EUR -> BTC")) {
					monOrigen.setText("Euros");
				} else if(monedaO.equals("USD -> EUR") || monedaO.equals("USD -> BTC")) {
					monOrigen.setText("Dolares");
				} else if(monedaO.equals("BTC -> EUR") || monedaO.equals("BTC -> USD")) {
					monOrigen.setText("BitCoins");
				}
				
			}
		});
		
		convertir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String monedaD = desplegable.getSelectedItem().toString();
				double cant = Integer.parseInt(cantidad.getText());
				switch(monedaD) {
					case "EUR -> USD":
						resultado.setText((cant * 1.22 ) + " Dolares estadounidanses");
						break;
					case "EUR -> BTC":
						resultado.setText((cant * 0.000036 ) + " BitCoins");
						break;
					case "USD -> EUR":
						resultado.setText((cant * 0.82 ) + " Euros");
						break;
					case "USD -> BTC":
						resultado.setText((cant * 0.000029 ) + " BitCoins");
						break;
					case "BTC -> EUR":
						resultado.setText((cant * 27900 ) + " Euros");
						break;
					case "BTC -> USD":
						resultado.setText((cant * 34000 ) + " Dolares estadounidanses");
						break;
				}
				
			}
		});
		
		
		panel.add(foto);
		panel.add(textoIni);
		panel.add(desplegable);
		panel.add(cantidad);
		panel.add(monOrigen);
		panel.add(convertir);
		panel.add(resultado);
		setContentPane(panel);
		
		
		setSize(new Dimension(325,145));
		setVisible(true);
	}

}
