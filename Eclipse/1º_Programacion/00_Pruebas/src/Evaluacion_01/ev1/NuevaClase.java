package Evaluacion_01.ev1;

//import javax.swing.JOptionPane;
//usar la esa libreria
public class NuevaClase {
	public static void main(String[] args) {
		{
			String caden;
			caden = "Ho\nla\t\tmundo \u00f1(ñ)";
			System.out.println(caden);
			int n1 = 5;
			n1++; 
			System.out.println("n1 vale" + n1);
			//String cadena = JOptionPane.showInputDialog("Hola");
			//muestra un dialogo con lo que pongas (Escribe y lee)
			//JOptionPane.showMessageDialog(null,"Resultado: " + suma);
			//como un escribir con una ventana(lee)
			//int n1 = Integer.parseInt(String cadena = JOptionPane.showInputDialog("Hola"));
			//convertir a int
			//Integer.parsFloat();
			{
				int a = 2;
				System.out.println("a = " + a);
			}
			//La linea siguiente provocaria error
			//System.out.println("a = " + a);
			int a = 1;
			int b = 1000;
			System.out.println("a = " + a);
			System.out.println("b = " + b);
		}
		//La linea siguiente provocaria error
		//System.out.println("b = " + b);
		int a = 0;
		System.out.println("a = " + ++a);
		{
			a = 200;
			System.out.println("a = " + ++a);
			{
				System.out.println("a = " + ++a);
			}
		}
		System.out.println("a = " + ++a);
	}
}
