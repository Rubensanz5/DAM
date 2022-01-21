package Evaluacion_03.InterfacesGraficasUser.CalcApp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CambioMoneda extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public CambioMoneda(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JPanel panelBoton = new JPanel();
		
		setTitle("Calcular cambio");
		
		JTextField cantidad = new JTextField(4);
		
		JComboBox<String> moneda = new JComboBox<String>();
		moneda.addItem("Euro");
		moneda.addItem("Dolar");
		moneda.addItem("Yuan");
		
		JRadioButton botonE = new JRadioButton("Euros", false);
		JRadioButton botonD = new JRadioButton("Dolares", true);
		JRadioButton botonY = new JRadioButton("Yuanes", false);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(botonE);
		grupo.add(botonD);
		grupo.add(botonY);
		
		JButton calcular = new JButton("Calcular");
		
		JLabel resultado = new JLabel("Resultado: ");
		
		panel.add(cantidad);
		panel.add(moneda);
		
		panelBoton.add(botonE);
		panelBoton.add(botonD);
		panelBoton.add(botonY);
		
		panel.add(panelBoton);
		panel.add(calcular);
		panel.add(resultado);
		
		setContentPane(panel);
		
		calcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double cantPuesta = Integer.parseInt(cantidad.getText());
				String monPuesta = (String) moneda.getSelectedItem();
				double result = 0;
				if(botonE.isSelected()) {
					result = cambioMoneda(cantPuesta, monPuesta);
				} else if (botonD.isSelected()) {
					result = cambioMoneda(cantPuesta, monPuesta);
				} else if (botonY.isSelected()) {
					result = cambioMoneda(cantPuesta, monPuesta);
				}
				
				resultado.setText("Has elegido " + monPuesta + " " + cantPuesta +"      Resultado : " + result);
				
			}
			
		});
		
		
		
		setSize(new Dimension(550,150));
		setVisible(true);
		
		
	}
	
	public static double cambioMoneda(double canti, String mon) {
		double cambio = 0;
		
		switch (mon) {
			case "Euro":
				canti = canti*0.91;
				cambio = canti;
				break;
				
			case "Dolar":
				canti = canti*1.18;
				cambio = canti;
				break;
				
			case "Yuan":
				canti = canti*7.89;
				cambio = canti;
				break;
		}
		return cambio;
	}
	
	public static void main(String[] args) {
		new CambioMoneda();
		
		
	}
	

}
