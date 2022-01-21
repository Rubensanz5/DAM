	package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controlador.Principal;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Modelo.Champion;

import javax.swing.JComboBox;


public class BorrarCampeon extends JFrame{
	private static final long serialVersionUID = 1L;
	public static BorrarCampeon ventana = null;

	
	public BorrarCampeon() {
		setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./arch/OptimusPrinceps.ttf")));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		setTitle("Borrar Campeon");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
		
		getContentPane().setBackground(new Color(51, 51, 51));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBackground(new Color(51, 51, 51));
		
		JLabel lblBorrar = new JLabel("Creacion de Campeon");
		lblBorrar.setForeground(new Color(255, 215, 0));
		lblBorrar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 30));
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setForeground(new Color(255, 215, 0));
		lblRol.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 215, 0));
		lblNombre.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(255, 215, 0));
		lblFecha.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(255, 215, 0));
		
		JButton btnBorrar = new JButton("Borrar Campeon");
		btnBorrar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnBorrar.setBackground(new Color(255, 215, 0));
		
		JLabel lblHechizo1 = new JLabel("Hechizo 1");
		lblHechizo1.setForeground(new Color(255, 215, 0));
		lblHechizo1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHechizo2 = new JLabel("Hechizo 2");
		lblHechizo2.setForeground(new Color(255, 215, 0));
		lblHechizo2.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad4 = new JLabel("Habilidad 4");
		lblHabilidad4.setForeground(new Color(255, 215, 0));
		lblHabilidad4.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad5 = new JLabel("Habilidad 5");
		lblHabilidad5.setForeground(new Color(255, 215, 0));
		lblHabilidad5.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad1 = new JLabel("Habilidad 1");
		lblHabilidad1.setForeground(new Color(255, 215, 0));
		lblHabilidad1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad2 = new JLabel("Habilidad 2");
		lblHabilidad2.setForeground(new Color(255, 215, 0));
		lblHabilidad2.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad3 = new JLabel("Habilidad 3");
		lblHabilidad3.setForeground(new Color(255, 215, 0));
		lblHabilidad3.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblSelec = new JLabel("Selecciona el Campeon");
		lblSelec.setForeground(new Color(255, 215, 0));
		lblSelec.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JComboBox<String> comboBox = new JComboBox<>();
		for (Champion ch : Principal.campeones) {
			comboBox.addItem(ch.getNombre());
		}
		
		JLabel lblNombre_1 = new JLabel("");
		lblNombre_1.setForeground(new Color(255, 215, 0));
		lblNombre_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblRol_1 = new JLabel("");
		lblRol_1.setForeground(new Color(255, 215, 0));
		lblRol_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblFecha_1 = new JLabel("");
		lblFecha_1.setForeground(new Color(255, 215, 0));
		lblFecha_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad1_1 = new JLabel("");
		lblHabilidad1_1.setForeground(new Color(255, 215, 0));
		lblHabilidad1_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad2_1 = new JLabel("");
		lblHabilidad2_1.setForeground(new Color(255, 215, 0));
		lblHabilidad2_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad5_1 = new JLabel("");
		lblHabilidad5_1.setForeground(new Color(255, 215, 0));
		lblHabilidad5_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad4_1 = new JLabel("");
		lblHabilidad4_1.setForeground(new Color(255, 215, 0));
		lblHabilidad4_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHabilidad3_1 = new JLabel("");
		lblHabilidad3_1.setForeground(new Color(255, 215, 0));
		lblHabilidad3_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHechizo2_1 = new JLabel("");
		lblHechizo2_1.setForeground(new Color(255, 215, 0));
		lblHechizo2_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JLabel lblHechizo1_1 = new JLabel("");
		lblHechizo1_1.setForeground(new Color(255, 215, 0));
		lblHechizo1_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblSelec, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(140)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRol)
						.addComponent(lblNombre)
						.addComponent(lblFecha)
						.addComponent(lblHabilidad4, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(lblHabilidad5, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(lblHechizo1)
						.addComponent(lblHechizo2)
						.addComponent(lblHabilidad3, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(lblHabilidad2, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(lblHabilidad1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
					.addGap(98)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNombre_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(lblRol_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblFecha_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblHabilidad1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHabilidad2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHabilidad3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHabilidad4_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHabilidad5_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHechizo1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHechizo2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(194))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(148)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(195, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(190)
					.addComponent(lblBorrar)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBorrar)
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelec))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRol)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFecha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHechizo1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHechizo2))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombre_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRol_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFecha_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad2_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad3_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad4_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHabilidad5_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHechizo1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHechizo2_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		panel.setLayout(gl_panel);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nchamp = (String) comboBox.getSelectedItem();
				Champion champ = null;
				for (Champion ch : Principal.campeones) {
					if(Nchamp.equals(ch.getNombre())) {
						champ = ch;
					}
						
				}
				
				lblNombre_1.setText(champ.getNombre());
				lblRol_1.setText(champ.getRol());
				lblFecha_1.setText(champ.getFecha().toString());
							
				lblHabilidad1_1.setText(champ.getH1());
				lblHabilidad2_1.setText(champ.getH2());
				lblHabilidad3_1.setText(champ.getH3());
				lblHabilidad4_1.setText(champ.getH4());
				lblHabilidad5_1.setText(champ.getH5());
					
				lblHechizo1_1.setText(champ.getHe1());
				lblHechizo2_1.setText(champ.getHe2());
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Nchamp = (String) comboBox.getSelectedItem();
				Champion champ = null;
				for (Champion ch : Principal.campeones) {
					if(Nchamp.equals(ch.getNombre())) {
						champ = ch;
					}
				}
				int opcion = JOptionPane.showConfirmDialog(ventana, "Estas seguro de que quieres borrar el campeon\n(Si borras el campeon se borraran tambien sus hechizos y habilidades)","Borrar",JOptionPane.YES_NO_OPTION);
				
				if(opcion == JOptionPane.OK_OPTION) {
					if(Principal.borrarCampeones(champ)) {
						JOptionPane.showMessageDialog(ventana, "Se ha borrado el campeon correctamente","Borrar",JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(ventana, "Ha ocurrido un problema y no se puede borrar","Borrar",JOptionPane.ERROR_MESSAGE);
					}
				}
				ventana.dispose();
				Opciones.ventana = new Opciones();
				Opciones.ventana.setSize(815,540);
				Opciones.ventana.repaint();
				Opciones.ventana.setVisible(true);
				
			}
		});
        
        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				Opciones.ventana = new Opciones();
				Opciones.ventana.setSize(815,540);
				Opciones.ventana.repaint();
				Opciones.ventana.setVisible(true);
				
			}
		});
		
	}
}
