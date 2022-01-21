package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controlador.Principal;
import Modelo.DAO.Conexion;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;


public class Opciones extends JFrame{
	private static final long serialVersionUID = 1L;
	public static Opciones ventana = null;
	
	public Opciones() {
		getContentPane().setBackground(new Color(51, 51, 51));
		
		setResizable(false);
		
		setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./arch/OptimusPrinceps.ttf")));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		setTitle("Opciones");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        this.setSize(815,540);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		
		JPanel panel_img = new JPanel();
		panel_img.setBackground(new Color(51, 51, 51));
		
		JButton btnVisualizar = new JButton("Visualizar Campeon");
		btnVisualizar.setBackground(new Color(255, 215, 0));
		btnVisualizar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		
		JButton btnActualizar = new JButton("Actualizar Campeon");
		btnActualizar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(255, 215, 0));
		
		JButton btnBorrar = new JButton("Borrar Campeon");
		btnBorrar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		btnBorrar.setBackground(new Color(255, 215, 0));
		
		JButton btnInsertar = new JButton("Insertar Campeon");
		btnInsertar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		btnInsertar.setBackground(new Color(255, 215, 0));
		
		JLabel lbImage = new JLabel("");
		lbImage.setIcon(new ImageIcon("./img/zeri.png"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		menuBar.setBackground(new Color(51, 51, 51));

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 215, 0));
		btnSalir.setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		menuBar.add(btnSalir);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(btnInsertar, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInsertar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		panel.setLayout(gl_panel);
		
		
		GroupLayout gl_panel_img = new GroupLayout(panel_img);
		gl_panel_img.setHorizontalGroup(
			gl_panel_img.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_img.createSequentialGroup()
					.addComponent(lbImage, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panel_img.setVerticalGroup(
			gl_panel_img.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_img.createSequentialGroup()
					.addComponent(lbImage, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel_img.setLayout(gl_panel_img);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
				.addComponent(panel_img, GroupLayout.PREFERRED_SIZE, 816, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_img, GroupLayout.PREFERRED_SIZE, 446, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setLocationRelativeTo(null);
		
		

		btnInsertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				InsertarCampeon.ventana = new InsertarCampeon();
				InsertarCampeon.ventana.setSize(520,650);
				InsertarCampeon.ventana.repaint();
				InsertarCampeon.ventana.setVisible(true);
				InsertarCampeon.ventana.setLocationRelativeTo(null);
				
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Principal.campeones.size() == 0) {
					JOptionPane.showMessageDialog(ventana, "No hay campeones para actualizar, inserte alguno para realizar esta acción","Borrar",JOptionPane.ERROR_MESSAGE);
					btnActualizar.setEnabled(false);
				} else {
					btnActualizar.setEnabled(true);
					ventana.dispose();
					ModificarCampeon.ventana = new ModificarCampeon();
					ModificarCampeon.ventana.setSize(770,330);
					ModificarCampeon.ventana.repaint();
					ModificarCampeon.ventana.setVisible(true);
					ModificarCampeon.ventana.setLocationRelativeTo(null);
				}
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Principal.campeones.size() == 0) {
					JOptionPane.showMessageDialog(ventana, "No hay campeones para borrar, inserte alguno para realizar esta acción","Borrar",JOptionPane.ERROR_MESSAGE);
					btnBorrar.setEnabled(false);
				} else {
					btnBorrar.setEnabled(true);
					ventana.dispose();
					BorrarCampeon.ventana = new BorrarCampeon();
					BorrarCampeon.ventana.setSize(690,550);
					BorrarCampeon.ventana.repaint();
					BorrarCampeon.ventana.setVisible(true);
					BorrarCampeon.ventana.setLocationRelativeTo(null);
				}
			}
		});
		
		btnVisualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Principal.campeones.size() == 0) {
					JOptionPane.showMessageDialog(ventana, "No hay campeones para visualizar, inserte alguno para realizar esta acción","Borrar",JOptionPane.ERROR_MESSAGE);
					btnVisualizar.setEnabled(false);
				} else {
					btnVisualizar.setEnabled(true);
					ventana.dispose();
					VisualizarCampeones.ventana = new VisualizarCampeones(Principal.campeones);
					VisualizarCampeones.ventana.setSize(1070,625);
					VisualizarCampeones.ventana.repaint();
					VisualizarCampeones.ventana.setVisible(true);
					VisualizarCampeones.ventana.setLocationRelativeTo(null);
				}
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				try {
					Conexion.cerrarConexion();
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				}
				LogIn.ventana = new LogIn();
				LogIn.ventana.setVisible(true);
				
			}
		});
		
	}
}
