package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.github.lgooddatepicker.components.DatePicker;

import Controlador.Principal;
import Modelo.Champion;


public class CampeonMod extends JFrame{
	private static final long serialVersionUID = 1L;
	public static CampeonMod ventana = null;
	private JTextField txNombre;
	private JTextField txh4;
	private JTextField txh5;
	private JTextField txh3;
	private JTextField txh2;
	private JTextField txh1;
	
	public CampeonMod(Champion champ) {
		setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./arch/OptimusPrinceps.ttf")));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		setTitle("Modificar Campeon");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(new Color(51, 51, 51));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBackground(new Color(51, 51, 51));
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setForeground(new Color(255, 215, 0));
		lblRol.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 215, 0));
		lblNombre.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(255, 215, 0));
		lblFecha.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txNombre = new JTextField();
		txNombre.setColumns(10);
		
		JComboBox<String> comboBoxRol = new JComboBox<String>();
		comboBoxRol.addItem(Champion.TOP);
		comboBoxRol.addItem(Champion.JUNGLE);
		comboBoxRol.addItem(Champion.MID);
		comboBoxRol.addItem(Champion.ADC);
		comboBoxRol.addItem(Champion.SUP);
		
		JLabel lblHechizo1 = new JLabel("Hechizo 1");
		lblHechizo1.setForeground(new Color(255, 215, 0));
		lblHechizo1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		ArrayList<String> hechizos = Champion.getHechizos();
		
		JComboBox<String> comboBoxHechizos1 = new JComboBox<String>();
		for (String hech : hechizos) {
			comboBoxHechizos1.addItem(hech);
		}
		
		JComboBox<String> comboBoxHechizos2 = new JComboBox<String>();
		for (String hech : hechizos) {
			comboBoxHechizos2.addItem(hech);
		}
		
		JLabel lblHechizo2 = new JLabel("Hechizo 2");
		lblHechizo2.setForeground(new Color(255, 215, 0));
		lblHechizo2.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
				
		JLabel lblHabilidad4 = new JLabel("Habilidad 4");
		lblHabilidad4.setForeground(new Color(255, 215, 0));
		lblHabilidad4.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txh4 = new JTextField();
		txh4.setColumns(10);
		
		JLabel lblHabilidad5 = new JLabel("Habilidad 5");
		lblHabilidad5.setForeground(new Color(255, 215, 0));
		lblHabilidad5.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txh5 = new JTextField();
		txh5.setColumns(10);
		
		JLabel lblHechizos = new JLabel("Hechizos");
		lblHechizos.setForeground(new Color(255, 215, 0));
		lblHechizos.setFont(new Font("OptimusPrinceps", Font.PLAIN, 28));
		
		JLabel lblHabilidad1 = new JLabel("Habilidad 1");
		lblHabilidad1.setForeground(new Color(255, 215, 0));
		lblHabilidad1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JLabel lblHabilidad3 = new JLabel("Habilidad 3");
		lblHabilidad3.setForeground(new Color(255, 215, 0));
		lblHabilidad3.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JLabel lblHabilidad2 = new JLabel("Habilidad 2");
		lblHabilidad2.setForeground(new Color(255, 215, 0));
		lblHabilidad2.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txh3 = new JTextField();
		txh3.setColumns(10);
		
		txh2 = new JTextField();
		txh2.setColumns(10);
		
		txh1 = new JTextField();
		txh1.setColumns(10);
		
		JLabel lblFecha_1 = new JLabel("Lanzamiento");
		lblFecha_1.setForeground(new Color(255, 215, 0));
		lblFecha_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 20));
		
		JLabel lblHabilidades = new JLabel("Habilidades");
		lblHabilidades.setForeground(new Color(255, 215, 0));
		lblHabilidades.setFont(new Font("OptimusPrinceps", Font.PLAIN, 28));
		
		JLabel lblCreacion = new JLabel("Creacion de Campeon");
		lblCreacion.setForeground(new Color(255, 215, 0));
		lblCreacion.setFont(new Font("OptimusPrinceps", Font.PLAIN, 30));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(255, 215, 0));
		
		JButton btnModificarCampeon = new JButton("Modificar Campeon");
		btnModificarCampeon.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnModificarCampeon.setBackground(new Color(255, 215, 0));
		
		DatePicker datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		datePicker.getComponentDateTextField().setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(112)
							.addComponent(lblCreacion, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txNombre, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(73)
							.addComponent(lblRol)
							.addGap(18)
							.addComponent(comboBoxRol, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblFecha_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(166)
							.addComponent(lblHabilidades, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHabilidad1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(txh1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHabilidad2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txh2, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHabilidad3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(txh3, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHabilidad4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txh4, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHabilidad5, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(txh5, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(169)
							.addComponent(lblHechizos, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(52)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnModificarCampeon))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblHechizo2)
									.addGap(10)
									.addComponent(comboBoxHechizos2, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(8)
									.addComponent(lblHechizo1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxHechizos1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreacion, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(comboBoxRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addComponent(lblFecha_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblHabilidades, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabilidad1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txh1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabilidad2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txh2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabilidad3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txh3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabilidad4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txh4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabilidad5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txh5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(lblHechizos, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxHechizos1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHechizo1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxHechizos2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHechizo2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModificarCampeon, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		
		//rellenar campos
		txNombre.setText(champ.getNombre());
		comboBoxRol.setSelectedItem(champ.getRol());
		datePicker.setDate(champ.getFecha());
		
		txh1.setText(champ.getH1());
		txh2.setText(champ.getH2());
		txh3.setText(champ.getH3());
		txh4.setText(champ.getH4());
		txh5.setText(champ.getH5());
		
		comboBoxHechizos1.setSelectedItem(champ.getHe1());
		comboBoxHechizos2.setSelectedItem(champ.getHe2());
		panel.setLayout(gl_panel);
		
		btnModificarCampeon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txNombre.getText();
				String rol = comboBoxRol.getSelectedItem().toString();
				Date fecha = Date.valueOf(datePicker.getDate());
				
				String h1 = txh1.getText();
				String h2 = txh2.getText();
				String h3 = txh3.getText();
				String h4 = txh4.getText();
				String h5 = txh5.getText();
				
				String he1 = comboBoxHechizos1.getSelectedItem().toString();
				String he2 = comboBoxHechizos2.getSelectedItem().toString();
				
				
				Champion camp = new Champion(nombre, rol, fecha.toLocalDate(), h1, h2, h3, h4, h5, he1, he2);
				camp.setIdChamp(champ.getIdChamp());
				Principal.campeones.remove(champ);
				
				if(Principal.actualizarCampeones(camp)) {
					JOptionPane.showMessageDialog(ventana, "Campeon actualizado con éxito","campeon Actualizado",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventana, "Campeon no actualizado ","campeon Actualizado",JOptionPane.ERROR_MESSAGE);
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
				ModificarCampeon.ventana = new ModificarCampeon();
				ModificarCampeon.ventana.setSize(770,330);
				ModificarCampeon.ventana.repaint();
				ModificarCampeon.ventana.setVisible(true);
				ModificarCampeon.ventana.setLocationRelativeTo(null);
			}
		});
	}
}
