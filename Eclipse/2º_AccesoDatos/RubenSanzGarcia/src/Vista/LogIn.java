package Vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controlador.Principal;
import Modelo.DAO.ChampionDAO;
import Modelo.DAO.Conexion;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class LogIn extends JFrame{
	public static LogIn ventana = null;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField contraseña;
	
	public LogIn() {
		setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./arch/OptimusPrinceps.ttf")));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		setTitle("New Patch LoL 11.25");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/Icono.png"));
        setBounds(400, 200, 1316, 705);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLUE);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        //Creacion de cosas
        
        JLabel imagen = new JLabel("");
        imagen.setIcon(new ImageIcon("./img/league-of-legends.png"));
        contentPane.add(imagen, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 51, 51));
        contentPane.add(panel, BorderLayout.WEST);
        
        JLabel lbInicioSesion = new JLabel("LEAGUE OF");
        lbInicioSesion.setForeground(new Color(255, 215, 0));
        lbInicioSesion.setFont(new Font("OptimusPrincepsSemiBold", Font.PLAIN, 32));
        lbInicioSesion.setLabelFor(txtUser);
        
        JLabel lblLegends = new JLabel("LEGENDS");
        lblLegends.setForeground(new Color(255, 215, 0));
        lblLegends.setFont(new Font("OptimusPrincepsSemiBold", Font.PLAIN, 32));
        
        JLabel lbusuario = new JLabel("User");
        lbusuario.setForeground(new Color(255, 215, 0));
        lbusuario.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
        
        txtUser = new JTextField();
        txtUser.setColumns(10);
        
        JLabel lbcontraseña = new JLabel("Password");
        lbcontraseña.setForeground(new Color(255, 215, 0));
        lbcontraseña.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
        
        contraseña = new JPasswordField();
        lbcontraseña.setLabelFor(contraseña);
        
        JButton btnEntrar = new JButton("Log In");
        btnEntrar.setBackground(new Color(255, 215, 0));
        btnEntrar.setFont(new Font("OptimusPrinceps", Font.PLAIN, 24));
        
        JLabel lblErrorUser = new JLabel("");
        lblErrorUser.setForeground(Color.RED);
        lblErrorUser.setFont(new Font("OptimusPrinceps", Font.PLAIN, 14));
        
        JLabel lblErrorPass = new JLabel("");
        lblErrorPass.setForeground(Color.RED);
        lblErrorPass.setFont(new Font("OptimusPrinceps", Font.PLAIN, 14));
        
       
        // Layout para agrupar y poder mover las cosas a tu gusto 
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblErrorUser))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lbusuario))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(contraseña, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lbcontraseña))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblErrorPass))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addGap(40)
        					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
        						.addGap(38)
        						.addComponent(lblLegends, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
        						.addGap(27)
        						.addComponent(lbInicioSesion))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(126)
        			.addComponent(lbInicioSesion)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblLegends, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addGap(37)
        			.addComponent(lbusuario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblErrorUser)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbcontraseña)
        			.addGap(2)
        			.addComponent(lblErrorPass)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(contraseña, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(56)
        			.addComponent(btnEntrar)
        			.addGap(152))
        );
        
        //Listeners
        btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText();
				String pass = new String(contraseña.getPassword());
				if(Conexion.abrirConexion(user, pass)) {
					try {
						Principal.campeones = ChampionDAO.listaChamp();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					lblErrorPass.setText("");
					ventana.dispose();
					Opciones.ventana = new Opciones();
					Opciones.ventana.setSize(815,540);
					Opciones.ventana.repaint();
					Opciones.ventana.setVisible(true);
				} else {
					lblErrorPass.setText("Error, contraseña erronea compruebe que es correcta");
					lblErrorUser.setText("Error, usuario erroneo compruebe que es correcto");
				}	
				
			}
		});
        
        panel.setLayout(gl_panel);
        
        
		
	}
}
