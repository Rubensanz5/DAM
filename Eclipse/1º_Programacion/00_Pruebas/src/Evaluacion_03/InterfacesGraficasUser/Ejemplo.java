package Evaluacion_03.InterfacesGraficasUser;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Ejemplo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mi primera ventana");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contenido = frame.getContentPane();
		
		JTextField testField = new JTextField("JtextField");
		JPasswordField passwordField = new JPasswordField("JPasswordField");
		JFormattedTextField FormattedTextField = new JFormattedTextField("JFormattedTextField");
		
		JTextArea textArea = new JTextArea("Existen diversos componentes de texto que podemos utilizar en nuestras aplicaciones, todos\r\n"
				+ "ellos en clases que heredan de JTextComponent:");
		
		JEditorPane editorPanel = new JEditorPane();
		JTextPane textPane = new JTextPane();
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setBorder(BorderFactory.createTitledBorder("Text Fields"));
		panel2.setBorder(BorderFactory.createTitledBorder("Plain Text"));
		panel3.setBorder(BorderFactory.createTitledBorder("Styled Text"));
		
		BoxLayout lay1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
		BoxLayout lay2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		BoxLayout lay3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
		
		panel1.setLayout(lay1);
		panel2.setLayout(lay2);
		panel3.setLayout(lay3);
		
		testField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel1.add(testField);
		
		passwordField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel1.add(passwordField);
		
		FormattedTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel1.add(FormattedTextField);
		
		testField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel2.add(textArea);
		
		panel3.add(editorPanel);
		panel3.add(textPane);
		
		contenido.add(panel1, BorderLayout.LINE_START);
		contenido.add(panel2, BorderLayout.PAGE_END);
		contenido.add(panel3, BorderLayout.LINE_END);
	
		frame.pack();
		frame.setVisible(true);
	
	
	}
}
