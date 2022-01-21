package Evaluacion_03.InterfacesGraficasUser;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JFormattedTextField;
import java.awt.Scrollbar;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class Ventana extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ventana() {
		setTitle("Creacion de personaje");
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelFoto = new JPanel();
		getContentPane().add(panelFoto);
		panelFoto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel imagen = new JLabel("");
		panelFoto.add(imagen);
		imagen.setIcon(new ImageIcon("E:\\eclipse\\Workspace-Pr\\Practica_19-RSG\\img\\img-defecto.png"));
		
		JPanel panelCaract = new JPanel();
		getContentPane().add(panelCaract);
		
		JLabel lblNewLabel_2 = new JLabel("1 - Muy Bajo  \r\n2- Bajo  \r\n3- Medio  \r\n4- Alto  \r\n5- Muy alto  \r\n");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		panelCaract.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Elige la VELOCIDAD");
		panel_5.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0 , 5, 3);
		panel_5.add(slider);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(10));
//		slider_4.setLabelTable(slider.createStandardLabels(10));
//		slider_1.setLabelTable(slider.createStandardLabels(10));
//		slider_2.setLabelTable(slider.createStandardLabels(10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(panel_1);
		
		JSlider slider_1 = new JSlider(JSlider.HORIZONTAL, 0 , 5, 3);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMajorTickSpacing(1);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1 = new JLabel("Elige la ACELERACCION");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1);
		panel_1.add(slider_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JSlider slider_3 = new JSlider(JSlider.HORIZONTAL, 0 , 5, 3);
		slider_3.setMinorTickSpacing(1);
		slider_3.setMajorTickSpacing(1);
		slider_3.setPaintTicks(true);
		slider_3.setPaintLabels(true);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_3 = new JLabel("Elige el PESO");
		panel_3.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_3.add(slider_3);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JSlider slider_2 = new JSlider(JSlider.HORIZONTAL, 0 , 5, 3);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMajorTickSpacing(1);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_2 = new JLabel("Elige el MANEJO");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1_2);
		panel_2.add(slider_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(panel_4);
		
		JSlider slider_4 = new JSlider(JSlider.HORIZONTAL, 0 , 5, 3);
		slider_4.setMinorTickSpacing(1);
		slider_4.setMajorTickSpacing(1);
		slider_4.setPaintTicks(true);
		slider_4.setPaintLabels(true);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_4 = new JLabel("Elige el AGARRE");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_1_4);
		panel_4.add(slider_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Cancelar");
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnConfirmar = new JButton("Confirmar");
		panel.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
