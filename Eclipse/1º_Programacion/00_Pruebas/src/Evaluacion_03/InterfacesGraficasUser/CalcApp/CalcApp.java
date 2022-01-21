package Evaluacion_03.InterfacesGraficasUser.CalcApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UnsupportedLookAndFeelException;

public class CalcApp {
	
	public static void main(String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel titulo = new JLabel("Calculadora");
		titulo.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
		
		JTextField primerNum = new JTextField(4);
		primerNum.setFont(new Font("Arial", Font.BOLD,24));
		JTextField segundoNum = new JTextField(4);
		segundoNum.setFont(new Font("Arial", Font.BOLD,24));
		
		JComboBox<String> operaciones = new JComboBox<>();
		operaciones.addItem("+");
		operaciones.addItem("-");
		operaciones.addItem("x");
		operaciones.addItem("/");
		
		JLabel resultado = new JLabel("Resultado");
		resultado.setFont(new Font("Courier New", Font.TRUETYPE_FONT, 24));
		
		JButton boton = new JButton("Calcular");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int n1 = Integer.parseInt(primerNum.getText());
					int n2 = Integer.parseInt(segundoNum.getText());
					String operacion = operaciones.getSelectedItem().toString();
					switch(operacion) {
						case "+":
							resultado.setText("Resultado : " + (n1 + n2));
							break;
						case "-":
							resultado.setText("Resultado : " + (n1 - n2));
							break;
						case "x":
							resultado.setText("Resultado : " + (n1 * n2));
							break;
						case "/":
							resultado.setText("Resultado : " + ((double) n1 / (double) n2));
							break;
					}
				} catch (NumberFormatException e1) {
					resultado.setText("Resultado NaN");
				}
				
				
				
			}
		});
		
		
		
		JPanel panel = new JPanel();
		panel.add(titulo);
		panel.add(resultado);
		panel.add(primerNum);
		panel.add(operaciones);
		panel.add(segundoNum);
		panel.add(boton);
		panel.add(resultado);
		frame.setContentPane(panel);
		
		frame.setSize(525,150);
		frame.setVisible(true);
		
	}
}
