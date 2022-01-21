package Practica_19.Interface;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Practica_19.AppPilotoKart;
import Practica_19.PilotoKart;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CrearPiloto extends JFrame{

		private static final long serialVersionUID = 1L;
		public static CrearPiloto ventana = null;
		private JTextField nombrePiloto;
		private String imagen1;

		public CrearPiloto() {
			setDefaultLookAndFeelDecorated(true);
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			
			setTitle("Creacion de personaje");
			getContentPane().setLayout(new BorderLayout(0, 0));
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);		
			//Paneles
			
			JPanel panelBotones = new JPanel();
			panelBotones.setBorder(new CompoundBorder());
			getContentPane().add(panelBotones, BorderLayout.SOUTH);
			
			JPanel panelCaract = new JPanel();
			getContentPane().add(panelCaract, BorderLayout.CENTER);
			
			JPanel panelImg = new JPanel();
			panelCaract.add(panelImg);
			panelImg.setLayout(new BorderLayout(0, 0));
			
			JPanel panelNombre = new JPanel();
			panelCaract.add(panelNombre);
			panelNombre.setLayout(new BorderLayout(0, 50));
			
			JPanel panelVelocidad = new JPanel();
			panelVelocidad.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelCaract.add(panelVelocidad);
			
			JPanel panelAceleracion = new JPanel();
			panelCaract.add(panelAceleracion);
			panelAceleracion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			
			JPanel panelPeso = new JPanel();
			panelCaract.add(panelPeso);
			panelPeso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelPeso.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JPanel panelManejo = new JPanel();
			panelCaract.add(panelManejo);
			panelManejo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			
			JPanel panelAgarre = new JPanel();
			panelCaract.add(panelAgarre);
			panelAgarre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			
			// Botones
			
			JButton btnCancelar = new JButton("Cancelar");
			panelBotones.add(btnCancelar);
			btnCancelar.setFont(new Font("Arial", Font.PLAIN, 18));
			
			JButton btnConfirmar = new JButton("Confirmar");
			panelBotones.add(btnConfirmar);
			btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));
			
			//Sliders
			
			JSlider sliVelocidad = new JSlider(JSlider.HORIZONTAL, 1 , 5, 3);
			panelVelocidad.add(sliVelocidad);
			sliVelocidad.setMinorTickSpacing(1);
			sliVelocidad.setMajorTickSpacing(1);
			sliVelocidad.setPaintTicks(true);
			sliVelocidad.setPaintLabels(true);
			
			JSlider slAceleracion = new JSlider(JSlider.HORIZONTAL, 1 , 5, 3);
			slAceleracion.setMinorTickSpacing(1);
			slAceleracion.setMajorTickSpacing(1);
			slAceleracion.setPaintTicks(true);
			slAceleracion.setPaintLabels(true);
			panelAceleracion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JSlider slPeso = new JSlider(JSlider.HORIZONTAL, 1 , 5, 3);
			slPeso.setMinorTickSpacing(1);
			slPeso.setMajorTickSpacing(1);
			slPeso.setPaintTicks(true);
			slPeso.setPaintLabels(true);
			panelPeso.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JSlider slManejo = new JSlider(JSlider.HORIZONTAL, 1 , 5, 3);
			slManejo.setMinorTickSpacing(1);
			slManejo.setMajorTickSpacing(1);
			slManejo.setPaintTicks(true);
			slManejo.setPaintLabels(true);
			panelManejo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JSlider slAgarre = new JSlider(JSlider.HORIZONTAL, 1 , 5, 3);
			slAgarre.setMinorTickSpacing(1);
			slAgarre.setMajorTickSpacing(1);
			slAgarre.setPaintTicks(true);
			slAgarre.setPaintLabels(true);
			panelAgarre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			//Etiquetas
			
			JButton btnImagen = new JButton("Poner imagen");
			btnImagen.setFont(new Font("Arial", Font.PLAIN, 14));
			panelImg.add(btnImagen);
			
			imagen1 = "img\\img-defecto.png";
			JLabel imagen = new JLabel(new ImageIcon(imagen1));
			panelImg.add(imagen, BorderLayout.NORTH);
			
			JLabel lblNombre = new JLabel("1 - Muy Bajo  \r\n2- Bajo  \r\n3- Medio  \r\n4- Alto  \r\n5- Muy alto  \r\n");
			panelNombre.add(lblNombre, BorderLayout.SOUTH);
			lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
			
			JLabel lblNewLabel = new JLabel("Escribe el nombre del piloto ");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			panelNombre.add(lblNewLabel, BorderLayout.WEST);
			
			nombrePiloto = new JTextField();
			panelNombre.add(nombrePiloto, BorderLayout.CENTER);
			nombrePiloto.setColumns(10);
			
			JLabel etVelocidad = new JLabel("Elige la VELOCIDAD");
			panelVelocidad.add(etVelocidad);
			etVelocidad.setFont(new Font("Arial", Font.PLAIN, 15));
			
			JLabel lblAceleracion = new JLabel("Elige la ACELERACCION");
			lblAceleracion.setFont(new Font("Arial", Font.PLAIN, 15));
			panelAceleracion.add(lblAceleracion);
			panelAceleracion.add(slAceleracion);

			JLabel lblPeso = new JLabel("Elige el PESO");
			panelPeso.add(lblPeso);
			lblPeso.setFont(new Font("Arial", Font.PLAIN, 15));
			panelPeso.add(slPeso);

			JLabel lblManejo = new JLabel("Elige el MANEJO");
			lblManejo.setFont(new Font("Arial", Font.PLAIN, 15));
			panelManejo.add(lblManejo);
			panelManejo.add(slManejo);
			
			JLabel lblAgarre = new JLabel("Elige el AGARRE");
			lblAgarre.setFont(new Font("Arial", Font.PLAIN, 15));
			panelAgarre.add(lblAgarre);
			panelAgarre.add(slAgarre);

			//listeners
			
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nombre = nombrePiloto.getText();
					int velocidad =sliVelocidad.getValue();
					int aceleracion = slAceleracion.getValue();
					int manejo = slManejo.getValue();
					int peso = slPeso.getValue();
					int agarre = slAgarre.getValue();
					
					PilotoKart piloto = new PilotoKart(nombre, imagen1, new int[] {velocidad, aceleracion, peso, manejo, agarre});
					AppPilotoKart.competicionPilotos.add(piloto);
					ventana.dispose();
					
					MarioKartGUI.ventana = new MarioKartGUI();
					MarioKartGUI.ventana.setVisible(true);
					AppPilotoKart.escribirEnLog("Se ha creado un piloto de nombre: " + nombre); 
				}	
			});
			
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventana.dispose();
					
					MarioKartGUI.ventana = new MarioKartGUI();
					MarioKartGUI.ventana.setVisible(true);	
				}
			});
			
			btnImagen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					int opcion;
					JFileChooser selecionarImg = new JFileChooser();
					FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg y png", "jpg", "png");
					selecionarImg.setFileFilter(filtro);
					selecionarImg.setCurrentDirectory(new File("./img"));
					opcion = selecionarImg.showOpenDialog(selecionarImg);
					if(opcion != JFileChooser.CANCEL_OPTION) {
						imagen1 = selecionarImg.getSelectedFile().getAbsolutePath();
					} 
					imagen.setIcon(new ImageIcon(imagen1));
						ventana.validate();
						ventana.repaint();	
				}
			});
			
		}
		
}
