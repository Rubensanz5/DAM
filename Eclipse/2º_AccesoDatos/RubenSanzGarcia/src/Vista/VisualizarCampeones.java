package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Champion;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizarCampeones extends JFrame{
	private static final long serialVersionUID = 1L;
	public static VisualizarCampeones ventana = null;
	private JTable table;

	
	public VisualizarCampeones(ArrayList<Champion> campeones) {
		setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./arch/OptimusPrinceps.ttf")));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		setTitle("Visualizar Campeones");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(new Color(51, 51, 51));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBackground(new Color(51, 51, 51));
		
		JLabel lblVisualizar = new JLabel("Visualizar Campeones");
		lblVisualizar.setForeground(new Color(255, 215, 0));
		lblVisualizar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 30));
		
		ButtonGroup grupobtn = new ButtonGroup();
		
		JRadioButton rdbtnVer = new JRadioButton("Ver Por fecha");
		
		rdbtnVer.setForeground(new Color(255, 215, 0));
		rdbtnVer.setBackground(new Color(51, 51, 51));
		rdbtnVer.setFont(new Font("OptimusPrinceps", Font.PLAIN, 25));
		grupobtn.add(rdbtnVer);
		
		JRadioButton rdbtnVerAlf = new JRadioButton("Ver Alfabeticamente");
		rdbtnVerAlf.setForeground(new Color(255, 215, 0));
		rdbtnVerAlf.setBackground(new Color(51, 51, 51));
		rdbtnVerAlf.setFont(new Font("OptimusPrinceps", Font.PLAIN, 25));
		grupobtn.add(rdbtnVerAlf);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("OptimusPrinceps", Font.PLAIN, 18));
		btnVolver.setBackground(new Color(255, 215, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(160)
					.addComponent(rdbtnVer)
					.addPreferredGap(ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
					.addComponent(rdbtnVerAlf)
					.addGap(151))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(345)
					.addComponent(lblVisualizar)
					.addContainerGap(412, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(406)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(467, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblVisualizar)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnVer)
						.addComponent(rdbtnVerAlf))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addGap(102)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(table);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.ORANGE);
		table.setFont(new Font("OptimusPrinceps", Font.PLAIN, 14));
		table.setBorder(new LineBorder(Color.BLACK, 1, true));
		
		
		Object[][] valores = new Object[campeones.size()][10];
		int i = 0;
		
		for (Champion champion : campeones) {
			valores[i][0] = champion.getNombre();
			valores[i][1] = champion.getRol();
			valores[i][2] = champion.getFecha();
			valores[i][3] = champion.getH1();
			valores[i][4] = champion.getH2();
			valores[i][5] = champion.getH3();
			valores[i][6] = champion.getH4();
			valores[i][7] = champion.getH5();
			valores[i][8] = champion.getHe1();
			valores[i][9] = champion.getHe2();
			
			i++;
		}
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Rol", "Fecha", "Hablildad 1", "Hablildad 2", "Hablildad 3", "Hablildad 4", "Hablildad 5", "Hechizo 1", "Hechizo 2"
			}
		));
		panel.setLayout(gl_panel);
		
		
		rdbtnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreeSet<Champion> champi0ns = new TreeSet<>(campeones);
				Object[][] valores = new Object[campeones.size()][10];
				
				int i = 0;
				
				for (Champion champion : champi0ns) {
					valores[i][0] = champion.getNombre();
					valores[i][1] = champion.getRol();
					valores[i][2] = champion.getFecha();
					valores[i][3] = champion.getH1();
					valores[i][4] = champion.getH2();
					valores[i][5] = champion.getH3();
					valores[i][6] = champion.getH4();
					valores[i][7] = champion.getH5();
					valores[i][8] = champion.getHe1();
					valores[i][9] = champion.getHe2();

					i++;
				}
				
				table.setModel(new DefaultTableModel(
					valores,
					new String[] {
						"Nombre", "Rol", "Fecha", "Hablildad 1", "Hablildad 2", "Hablildad 3", "Hablildad 4", "Hablildad 5", "Hechizo 1", "Hechizo 2"
					}
				));
				ventana.revalidate();
				ventana.repaint();
			}
		});
		
		rdbtnVerAlf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreeSet<Champion> champi0ns = new TreeSet<>(Champion.ordenarNombre());
				champi0ns.addAll(campeones);
				
				Object[][] valores = new Object[campeones.size()][10];
				
				int i = 0;
				
				for (Champion champion : champi0ns) {
					valores[i][0] = champion.getNombre();
					valores[i][1] = champion.getRol();
					valores[i][2] = champion.getFecha();
					valores[i][3] = champion.getH1();
					valores[i][4] = champion.getH2();
					valores[i][5] = champion.getH3();
					valores[i][6] = champion.getH4();
					valores[i][7] = champion.getH5();
					valores[i][8] = champion.getHe1();
					valores[i][9] = champion.getHe2();

					i++;
				}
				
				table.setModel(new DefaultTableModel(
					valores,
					new String[] {
						"Nombre", "Rol", "Fecha", "Hablildad 1", "Hablildad 2", "Hablildad 3", "Hablildad 4", "Hablildad 5", "Hechizo 1", "Hechizo 2"
					}
				));
				ventana.revalidate();
				ventana.repaint();
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			
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
