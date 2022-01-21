package Evaluacion_03.InterfacesGraficasUser.CalcApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelPrueba extends JPanel{
	
	public PanelPrueba() {
		setBackground(new Color(188, 247, 30));
		
		JTextArea area1 = new JTextArea("Pon un operador");
		JTextArea area2 = new JTextArea("Pon un operador");
		String[] opciones = {"+", "-", "*", "/", "%"};
		JComboBox<String> signos = new JComboBox<>(opciones);
		JButton boton = new JButton("Operar");
		JTextField resultado = new JTextField("Resultado");
		
		area1.setPreferredSize(new Dimension(100, 50));
		area2.setPreferredSize(new Dimension(100, 50));
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Eres mu tonto
				if(signos.getSelectedIndex() == 0) {
					resultado.setText(Double.toString((Double.parseDouble(area1.getText()) + Double.parseDouble(area2.getText()))));
				}else if(signos.getSelectedIndex() == 1) {
					resultado.setText(Double.toString((Double.parseDouble(area1.getText()) - Double.parseDouble(area2.getText()))));
				}else if(signos.getSelectedIndex() == 2) {
					resultado.setText(Double.toString((Double.parseDouble(area1.getText()) * Double.parseDouble(area2.getText()))));
				}else if(signos.getSelectedIndex() == 3) {
					resultado.setText(Double.toString((Double.parseDouble(area1.getText()) / Double.parseDouble(area2.getText()))));
				}else if(signos.getSelectedIndex() == 4) {
					resultado.setText(Double.toString((Double.parseDouble(area1.getText()) % Double.parseDouble(area2.getText()))));
				}
				
			}
			
		});
		//signos.setText("Signos--");
		resultado.setPreferredSize(new Dimension(200,30));
		resultado.setEnabled(false);
		
		setLayout(new FlowLayout());
		
		add(area1);
		add(signos);
		add(area2);
		add(boton);
		add(resultado);
		
	}
	
}
