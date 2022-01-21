package Practica_19.Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Practica_19.AppPilotoKart;
import Practica_19.PilotoKart;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarPilotos extends JFrame {
	private static final long serialVersionUID = 1L;
	public static MostrarPilotos ventana = null;
	public PilotoKart[] pilotos = AppPilotoKart.competicionPilotos.toArray(new PilotoKart[0]);
	public static String imagen1;
	public int n = 0;
	
	public MostrarPilotos() {		
		setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setTitle("Ver pilotos");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);		
		//Paneles
		
		JPanel panelFoto = new JPanel();
		panelFoto.setBounds(25, 24, 192, 189);
		getContentPane().add(panelFoto);
		panelFoto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelCarac = new JPanel();
		panelCarac.setBounds(219, 10, 322, 228);
		getContentPane().add(panelCarac);
		panelCarac.setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(10, 233, 546, 42);
		getContentPane().add(panelBotones);
		
		//Labels
		
		imagen1 = pilotos[n].getImagen();
		JLabel lblFoto = new JLabel(new ImageIcon(imagen1));
		panelFoto.add(lblFoto);		
		
		JLabel lblVelocidad = new JLabel("Velocidad : " + pilotos[n].getCaracteristicas()[PilotoKart.VELOCIDAD]);
		lblVelocidad.setBounds(9, 73, 303, 22);
		lblVelocidad.setFont(new Font("Arial", Font.PLAIN, 18));
		panelCarac.add(lblVelocidad);
		
		JLabel lblAceleraccion = new JLabel("Aceleracion : " + pilotos[n].getCaracteristicas()[PilotoKart.ACELERACION]);
		lblAceleraccion.setBounds(10, 93, 302, 22);
		lblAceleraccion.setFont(new Font("Arial", Font.PLAIN, 18));
		panelCarac.add(lblAceleraccion);
		
		JLabel lblPeso = new JLabel("Peso : " + pilotos[n].getCaracteristicas()[PilotoKart.PESO]);
		lblPeso.setBounds(9, 115, 303, 22);
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 18));
		panelCarac.add(lblPeso);
		
		JLabel lblAgarre = new JLabel("Agarre : " + pilotos[n].getCaracteristicas()[PilotoKart.AGARRE]);
		lblAgarre.setBounds(9, 159, 303, 22);
		lblAgarre.setFont(new Font("Arial", Font.PLAIN, 18));
		panelCarac.add(lblAgarre);
		
		JLabel lblManejo = new JLabel("Manejo : " + pilotos[n].getCaracteristicas()[PilotoKart.MANEJO]);
		lblManejo.setBounds(9, 136, 303, 22);
		lblManejo.setFont(new Font("Arial", Font.PLAIN, 18));
		panelCarac.add(lblManejo);
		
		JLabel lblPiloto = new JLabel("Piloto: " + pilotos[n].getPiloto().toUpperCase());
		lblPiloto.setBounds(9, 10, 282, 24);
		lblPiloto.setFont(new Font("Arial", Font.BOLD, 20));
		panelCarac.add(lblPiloto);
		
		JLabel lblSelect = new JLabel(pilotos[n].isSeleccionado() ? "PILOTO SELECCIONADO" : "");
		lblSelect.setFont(new Font("Arial", Font.ITALIC, 18));
		lblSelect.setBounds(0, 206, 302, 22);
		panelCarac.add(lblSelect);
		
		//Botones
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Arial", Font.PLAIN, 16));
		panelBotones.add(btnAnterior);
		
		JButton btnSeleccionar = new JButton("Seleccionar Piloto");
		btnSeleccionar.setFont(new Font("Arial", Font.PLAIN, 16));
		panelBotones.add(btnSeleccionar);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Arial", Font.PLAIN, 16));
		panelBotones.add(btnSiguiente);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 16));
		panelBotones.add(btnVolver);
		
		//Listeners
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n >= pilotos.length - 1) {
				} else {		
					n++;
				}
				
				lblPiloto.setText("Piloto: " + pilotos[n].getPiloto().toUpperCase());
				lblVelocidad.setText("Velocidad : " + pilotos[n].getCaracteristicas()[PilotoKart.VELOCIDAD] );
				lblAceleraccion.setText("Aceleracion : " + pilotos[n].getCaracteristicas()[PilotoKart.ACELERACION] );
				lblPeso.setText("Peso : " + pilotos[n].getCaracteristicas()[PilotoKart.PESO] );
				lblManejo.setText("Manejo : " + pilotos[n].getCaracteristicas()[PilotoKart.MANEJO] );
				lblAgarre.setText("Agarre : " + pilotos[n].getCaracteristicas()[PilotoKart.AGARRE] );
				lblSelect.setText(pilotos[n].isSeleccionado() ? "PILOTO SELECCIONADO" : "");
				imagen1 = pilotos[n].getImagen();
				lblFoto.setIcon(new ImageIcon(imagen1));
				
				ventana.validate();
				ventana.repaint();
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n <= 0) {
				} else {
					n--;
				}
				
				lblPiloto.setText("Piloto: " + pilotos[n].getPiloto().toUpperCase());
				lblVelocidad.setText("Velocidad : " + pilotos[n].getCaracteristicas()[PilotoKart.VELOCIDAD] );
				lblAceleraccion.setText("Aceleracion : " + pilotos[n].getCaracteristicas()[PilotoKart.ACELERACION] );
				lblPeso.setText("Peso : " + pilotos[n].getCaracteristicas()[PilotoKart.PESO] );
				lblManejo.setText("Manejo : " + pilotos[n].getCaracteristicas()[PilotoKart.MANEJO] );
				lblAgarre.setText("Agarre : " + pilotos[n].getCaracteristicas()[PilotoKart.AGARRE] );
				lblSelect.setText(pilotos[n].isSeleccionado() ? "PILOTO SELECCIONADO" : "");
				imagen1 = pilotos[n].getImagen();
				lblFoto.setIcon(new ImageIcon(imagen1));
				
				ventana.validate();
				ventana.repaint();
			}
		});
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!pilotos[n].isSeleccionado()) {
					pilotos[n].setSeleccionado(true);
				}
				lblSelect.setText(pilotos[n].isSeleccionado() ? "PILOTO SELECCIONADO" : "");
				ventana.validate();
				ventana.repaint();
				AppPilotoKart.escribirEnLog("Se ha seleccionado el piloto " + pilotos[n].getPiloto());
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				
				MarioKartGUI.ventana = new MarioKartGUI();
				MarioKartGUI.ventana.setVisible(true);	
			}
		});
		
	}

	
}
