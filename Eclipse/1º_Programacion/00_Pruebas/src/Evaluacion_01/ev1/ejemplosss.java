package Evaluacion_01.ev1;

import javax.swing.JOptionPane;

public class ejemplosss {

	public static void main(String[] args) {
		String a;
		int b;
		char c = 'R';
		
		b = Integer.parseInt(JOptionPane.showInputDialog('a' + 'c'));
		
		a = JOptionPane.showInputDialog("pon algo");
	
		switch (a) {
			case "codigo":
				JOptionPane.showMessageDialog(null, a);
				break;
			case "fuente":
				JOptionPane.showMessageDialog(null, a);
				break;
			case "objeto":
				JOptionPane.showMessageDialog(null, a);
				break;
			default:
				JOptionPane.showMessageDialog(null, "ninguna de las opciones que has puesto es valida");
		}

		JOptionPane.showMessageDialog(null, a + b + c);
	}
}