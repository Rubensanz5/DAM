package Practica_19.Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Practica_19.AppPilotoKart;
import Practica_19.PilotoKart;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EliminarPiloto extends JFrame {
	private static final long serialVersionUID = 1L;
	public static EliminarPiloto ventana = null;
	public static String imagen;
	
	public EliminarPiloto() {
		setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setTitle("Eliminar Piloto");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);		
		//Paneles
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panelpilotoImagen = new JPanel();
		getContentPane().add(panelpilotoImagen, BorderLayout.CENTER);
		
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		//ComboBox
		
		JComboBox<PilotoKart> comboBox = new JComboBox<>();
		for (PilotoKart p : AppPilotoKart.competicionPilotos) {
			comboBox.addItem(p);
		}
		panelpilotoImagen.add(comboBox);
		
		//Labels
		
		imagen = ((PilotoKart) comboBox.getSelectedItem()).getImagen();
		JLabel imag = new JLabel(new ImageIcon(imagen));
		panel.add(imag);

		//Botones
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		panelBotones.add(btnConfirmar);
		
		//Listeners
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagen = ((PilotoKart) comboBox.getSelectedItem()).getImagen();
				imag.setIcon(new ImageIcon(imagen));
				ventana.validate();
				ventana.repaint();
				
			}
		});
		
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PilotoKart piloto = ((PilotoKart) comboBox.getSelectedItem());
				String nombre = piloto.getPiloto();
				AppPilotoKart.competicionPilotos.remove(piloto);
				
				
				ventana.dispose();
				
				MarioKartGUI.ventana = new MarioKartGUI();
				MarioKartGUI.ventana.setVisible(true);
				AppPilotoKart.escribirEnLog("Se ha eliminado el piloto: " + nombre); 
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				
				MarioKartGUI.ventana = new MarioKartGUI();
				MarioKartGUI.ventana.setVisible(true);	
			}
		});
	}
}
