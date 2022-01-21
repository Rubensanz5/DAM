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
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controlador.Principal;
import Modelo.Champion;

public class ModificarCampeon extends JFrame{
	private static final long serialVersionUID = 1L;
	public static ModificarCampeon ventana = null;
	
	public ModificarCampeon() {
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
		
		JLabel lbModificar = new JLabel("Modificar Campeon");
		lbModificar.setForeground(new Color(255, 215, 0));
		lbModificar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 30));
		
		JLabel lblSelec = new JLabel("Selecciona el Campeon");
		lblSelec.setForeground(new Color(255, 215, 0));
		lblSelec.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		
		JComboBox<String> comboBox = new JComboBox<>();
		for (Champion ch : Principal.campeones) {
			comboBox.addItem(ch.getNombre());
		}
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(255, 215, 0));
		
		JButton btnModificarCampeon = new JButton("Modificar Campeon");
		btnModificarCampeon.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnModificarCampeon.setBackground(new Color(255, 215, 0));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(236)
							.addComponent(lbModificar, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addComponent(lblSelec, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(211)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnModificarCampeon, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
					.addGap(96))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbModificar)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelec, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModificarCampeon, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);
		panel.setLayout(gl_panel);
		
		setResizable(false);
		
		btnModificarCampeon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Nchamp = (String) comboBox.getSelectedItem();
				Champion champ = null;
				for (Champion ch : Principal.campeones) {
					if(Nchamp.equals(ch.getNombre())) {
						champ = ch;
					}
				}
				
				ventana.dispose();
				CampeonMod.ventana = new CampeonMod(champ);
				CampeonMod.ventana.setSize(520,650);
				CampeonMod.ventana.repaint();
				CampeonMod.ventana.setVisible(true);
				CampeonMod.ventana.setLocationRelativeTo(null);
				
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
