package Evaluacion_03.InterfacesGraficasUser.CalcApp;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculadora {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculadora x mi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JTextArea num1 = new JTextArea(0, 4);
		num1.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));
		
		JTextField num2 = new JTextField(4);
		num2.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));

		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("+");
		comboBox.addItem("-");
		comboBox.addItem("x");
		comboBox.addItem("/");
		comboBox.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));

		
		JLabel resultado = new JLabel("Resultado ");
		resultado.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));

		
		JButton calcular = new JButton("Calcular");
		calcular.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));

		
		calcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(num1.getText());
				int n2 = Integer.parseInt(num2.getText());
				String operacion = comboBox.getSelectedItem().toString();
				switch (operacion) {
					case "+":
						resultado.setText("Resultado: " + (n1 + n2));
						break;
					case "-":
						resultado.setText("Resultado: " + (n1 - n2));
						break;
					case "x":
						resultado.setText("Resultado: " + (n1 * n2));
						break;
					case "/":
						resultado.setText("Resultado: " + ((double)n1 / (double)n2));
						break;
					
				}
				
				
			}
		});
		
		panel.add(num1);
		panel.add(comboBox);
		panel.add(num2);
		panel.add(calcular);
		panel.add(resultado);
		frame.setContentPane(panel);
		
		
		frame.setSize(new Dimension(525,150));
		frame.setVisible(true);
	
	}

}
