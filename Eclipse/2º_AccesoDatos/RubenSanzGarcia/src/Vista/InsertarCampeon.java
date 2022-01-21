package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Modelo.Champion;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.github.lgooddatepicker.components.DatePicker;

import Controlador.Principal;

public class InsertarCampeon extends JFrame{
	private static final long serialVersionUID = 1L;
	public static InsertarCampeon ventana = null;
	private JTextField txNombre;
	private JTextField txHabilidad1;
	private JTextField txHabilidad2;
	private JTextField txHabilidad3;
	private JTextField txHabilidad4;
	private JTextField txHabilidad5;
	
	public InsertarCampeon() {
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
		
		setTitle("Añadir un Campeon");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
		
		
        //Paneles
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		//Elementos
		JLabel lblCreacion = new JLabel("Creacion de Campeon");
		lblCreacion.setForeground(new Color(255, 215, 0));
		lblCreacion.setFont(new Font("OptimusPrinceps", Font.PLAIN, 30));
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setForeground(new Color(255, 215, 0));
		lblNombre.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txNombre = new JTextField();
		txNombre.setColumns(10);
		
		JLabel lblRol = new JLabel("Rol*");
		lblRol.setForeground(new Color(255, 215, 0));
		lblRol.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JComboBox<String> comboBoxRol = new JComboBox<>();
		comboBoxRol.addItem(Champion.TOP);
		comboBoxRol.addItem(Champion.JUNGLE);
		comboBoxRol.addItem(Champion.MID);
		comboBoxRol.addItem(Champion.ADC);
		comboBoxRol.addItem(Champion.SUP);
		
		JLabel lblFecha = new JLabel("Fecha*");
		lblFecha.setForeground(new Color(255, 215, 0));
		lblFecha.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JLabel lblFecha_1 = new JLabel("Lanzamiento");
		lblFecha_1.setForeground(new Color(255, 215, 0));
		lblFecha_1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 20));
		
		JLabel lblHabilidad1 = new JLabel("Habilidad 1*");
		lblHabilidad1.setForeground(new Color(255, 215, 0));
		lblHabilidad1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txHabilidad1 = new JTextField();
		txHabilidad1.setColumns(10);
		
		JLabel lblHabilidad2 = new JLabel("Habilidad 2*");
		lblHabilidad2.setForeground(new Color(255, 215, 0));
		lblHabilidad2.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txHabilidad2 = new JTextField();
		txHabilidad2.setColumns(10);
		
		JLabel lblHabilidad3 = new JLabel("Habilidad 3*");
		lblHabilidad3.setForeground(new Color(255, 215, 0));
		lblHabilidad3.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txHabilidad3 = new JTextField();
		txHabilidad3.setColumns(10);
		
		JLabel lblHabilidad4 = new JLabel("Habilidad 4*");
		lblHabilidad4.setForeground(new Color(255, 215, 0));
		lblHabilidad4.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txHabilidad4 = new JTextField();
		txHabilidad4.setColumns(10);
		
		JLabel lblHabilidad5 = new JLabel("Habilidad 5*");
		lblHabilidad5.setForeground(new Color(255, 215, 0));
		lblHabilidad5.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		txHabilidad5 = new JTextField();
		txHabilidad5.setColumns(10);
		
		JLabel lblHabilidades = new JLabel("Habilidades");
		lblHabilidades.setForeground(new Color(255, 215, 0));
		lblHabilidades.setFont(new Font("OptimusPrinceps", Font.PLAIN, 28));
		
		JLabel lblHechizos = new JLabel("Hechizos");
		lblHechizos.setForeground(new Color(255, 215, 0));
		lblHechizos.setFont(new Font("OptimusPrinceps", Font.PLAIN, 28));
		
		JLabel lblHechizo1 = new JLabel("Hechizo 1*");
		lblHechizo1.setForeground(new Color(255, 215, 0));
		lblHechizo1.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JLabel lblHechizo2 = new JLabel("Hechizo 2*");
		lblHechizo2.setForeground(new Color(255, 215, 0));
		lblHechizo2.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
		
		JButton btnAyudaRol = new JButton("");
		btnAyudaRol.setIcon(new ImageIcon("./img/ayuda.png"));
		
		JButton btnAyudaHabilidades = new JButton("");
		btnAyudaHabilidades.setIcon(new ImageIcon("./img/ayuda.png"));
		
		JButton btnAyudaHechizos = new JButton("");
		btnAyudaHechizos.setIcon(new ImageIcon("./img/ayuda.png"));
		
		JButton btnInsertar = new JButton("Insertar Campeon");
		btnInsertar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnInsertar.setBackground(new Color(255, 215, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(255, 215, 0));
		
		ArrayList<String> hechizos = Champion.getHechizos();
		
		JComboBox<String> comboBoxHechizos1 = new JComboBox<String>();
		for (String hech : hechizos) {
			comboBoxHechizos1.addItem(hech);
		}
		
		JComboBox<String> comboBoxHechizos2 = new JComboBox<String>();
		for (String hech : hechizos) {
			comboBoxHechizos2.addItem(hech);
		}
		
		DatePicker datePicker = new DatePicker();
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon("./img/calendario1.png"));
		datePicker.getComponentToggleCalendarButton().setText("");
		datePicker.setDate(LocalDate.now());
		datePicker.getComponentToggleCalendarButton().setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		datePicker.getComponentDateTextField().setFont(new Font("OptimusPrinceps", Font.PLAIN, 12));
		
		
		
		//GroupLayout para poder mover mas sencillamente el contenido
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblFecha)
									.addComponent(lblRol)
									.addComponent(lblNombre)
									.addComponent(lblFecha_1))
								.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
									.addComponent(txNombre, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(comboBoxRol, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnAyudaRol, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(lblHabilidad1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(lblHabilidad3))
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lblHabilidad2, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addComponent(lblHabilidad4))
										.addGap(12))
									.addComponent(lblHabilidad5)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(17)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblHechizo1)
											.addComponent(lblHechizo2))
										.addGap(18)))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(comboBoxHechizos2, 0, 321, Short.MAX_VALUE)
									.addComponent(txHabilidad5, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txHabilidad4)
										.addComponent(txHabilidad1, Alignment.TRAILING)
										.addComponent(txHabilidad3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
										.addComponent(txHabilidad2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
									.addComponent(comboBoxHechizos1, 0, 321, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(166)
							.addComponent(lblHabilidades, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAyudaHabilidades, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 112, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(52)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnInsertar)
							.addPreferredGap(ComponentPlacement.RELATED, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(189)
							.addComponent(lblHechizos, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAyudaHechizos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 125, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(114, Short.MAX_VALUE)
					.addComponent(lblCreacion, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreacion, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(txNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAyudaRol, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHabilidades, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAyudaHabilidades, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFecha_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabilidad1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txHabilidad1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txHabilidad2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHabilidad2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txHabilidad3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHabilidad3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabilidad4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txHabilidad4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txHabilidad5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHabilidad5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHechizos, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAyudaHechizos, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxHechizos1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHechizo1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHechizo2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxHechizos2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInsertar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		panel.setLayout(gl_panel);
        setLocationRelativeTo(null);
        
       // Listeners
        btnAyudaRol.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Top - El Tanque suele ser un campeón característico del carril superior (Top Lane)\n"
						+ "Jungle - El Jungler pasa la mayor parte del inicio de la partida dentro de la jungla y eventualmente le permitirá comenzar a hacer emboscadas.\n"
						+ "Mid - Tendrá el control del carril central del mapa. Junto con el ADC, este campeón suele ser el que reparte la mayor cantidad de daño.\n"
						+ "Botton - El Attack-Damage Carry o ADC, es la forma principal de daño físico de tu equipo. En contraste su defensa y salud base son relativamente bajas.\n"
						+ "Support - El jugador de apoyo se combina con el ADC y se utiliza principalmente para ayudar a este a lograr un mayor número de bajas.","Ayuda de Roles", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
        
        btnAyudaHabilidades.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "La naturaleza única de las habilidades de un campeón los diferencia entre otros campeones. \n"
						+ "Las habilidades de un campeón también determinan el rol de un campeón en su equipo, cómo se debe jugar con el mismo, \n"
						+ "y que objetos, runas, y maestrías deben usarse para maximizar su efectividad. Los hechizos de invocador no son habilidades."
						,"Ayuda de Roles", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
        
        btnAyudaHechizos.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Son elegidos en la Selección de Campeones antes del comienzo del juego. \n"
						+ "Cada jugador puede elegir un máximo de 2 Hechizos par partida. Los hechizos de invocador se pueden utilizar en el juego\n"
						+ "para ayudar al campeón de un jugador de varias maneras, ya que cada hechizo tiene un efecto único. \n"
						+ "Algunos hechizos de invocador aumentan su efectividad en relación con el nivel del campeón, pero muchos ofrecen el mismo efecto en el nivel 1 del campeón que en el nivel 18 del campeón. \n"
						+ "No tienen costo pero hay que esperar a su tiempo de enfriamiento para poder usarlo nuevamente."
						,"Ayuda de Roles", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
        
        btnInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txNombre.getText();
				String rol = comboBoxRol.getSelectedItem().toString();
				Date fecha = Date.valueOf(datePicker.getDate());
				
				String h1 = txHabilidad1.getText();
				String h2 = txHabilidad2.getText();
				String h3 = txHabilidad3.getText();
				String h4 = txHabilidad4.getText();
				String h5 = txHabilidad5.getText();
				
				String he1 = comboBoxHechizos1.getSelectedItem().toString();
				String he2 = comboBoxHechizos1.getSelectedItem().toString();
				
				if(Principal.comprobarCampos(nombre, h1, h2, h3, h4, h5)) {
					Champion camp = new Champion(nombre, rol, fecha.toLocalDate(), h1, h2, h3, h4, h5, he1, he2);
					if(Principal.crearCampeones(camp)) {
						JOptionPane.showMessageDialog(ventana, "Campeon creado con exito", "Creado!",JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(ventana, "Algun dato incorrecto, campeon no creado, reviselo", "Error!",JOptionPane.ERROR_MESSAGE);
					}
				
					ventana.dispose();
					Opciones.ventana = new Opciones();
					Opciones.ventana.setSize(815,540);
					Opciones.ventana.repaint();
					Opciones.ventana.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(ventana, "Algun dato vacio, campeon no creado, reviselo", "Error!",JOptionPane.ERROR_MESSAGE);
				}
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
