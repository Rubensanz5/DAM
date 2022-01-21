package Evaluacion_03.InterfacesGraficasUser.CalcApp;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Prueba2 extends JFrame{

	public Prueba2() {
		super();
		configurarVentana("javax.swing.plaf.metal.MetalLookAndFeel");
	}

	private void configurarVentana(String look) {
			this.setTitle("Calculadora Ultra Mega Super Hiper Usless ModoDios Mastodonte");
			this.setSize(550, 250);                                
			this.setLocationRelativeTo(null);                      
			this.setLayout(null);                                  
			this.setResizable(false);                              
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{

			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Prueba2 ventana = new Prueba2();

		ventana.setContentPane(new PanelPrueba());

		ventana.setVisible(true);

		
	}

}
