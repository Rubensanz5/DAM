package Practica_19.Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Practica_19.AppPilotoKart;


public class MarioKartGUI extends JFrame{
	
	public static MarioKartGUI ventana = null;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public MarioKartGUI() {
		
		setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setTitle("Mario Kart");
        setBounds(400, 200, 665, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        //Mensaje de inicio foto
        
        JLabel imagenInicio = new JLabel("");
        imagenInicio.setHorizontalAlignment(SwingConstants.LEFT);
        imagenInicio.setIcon(new ImageIcon("img\\mariokart.jpg"));
        contentPane.add(imagenInicio);
                
        JLabel msgInicio = new JLabel("MARIO KART - \nSelecciona una opción:");
        msgInicio.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPane.add(msgInicio);
        
        //Botones
        
        JButton btnCrear = new JButton("Crear piloto");
        btnCrear.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(btnCrear);
        
        JButton btnEliminar = new JButton("Eliminar piloto");
        btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(btnEliminar);
        
        JButton btnCargarPilotos = new JButton("Cargar pilotos por defecto");
        btnCargarPilotos.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(btnCargarPilotos);
        
        JButton btnVerPilotos = new JButton("Ver pilotos");
        btnVerPilotos.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(btnVerPilotos);
        
        //Listeners
                
        btnCrear.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed (ActionEvent e) {
        		ventana.dispose();
    			CrearPiloto.ventana = new CrearPiloto();
    			CrearPiloto.ventana.setSize(890,550);
    			CrearPiloto.ventana.repaint();
    			CrearPiloto.ventana.setVisible(true);
        		
            }
        	
        });
        
        btnEliminar.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed (ActionEvent e) {
        		if(AppPilotoKart.competicionPilotos.size() != 0) {
        			ventana.dispose();
	    			EliminarPiloto.ventana = new EliminarPiloto();
	    			EliminarPiloto.ventana.setSize(490,200);
	    			EliminarPiloto.ventana.repaint();
	    			EliminarPiloto.ventana.setVisible(true);
        		} else {
        			JOptionPane.showMessageDialog(null, "No hay ningun piloto actualmente");
        		}
            } 
        });
        
        btnCargarPilotos.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed (ActionEvent e) {
        		AppPilotoKart.cargarPilotos();
        		AppPilotoKart.escribirEnLog("Se han cargado los pilotos por defecto ");
            }
        });
        
        btnVerPilotos.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed (ActionEvent e) {
        		if(AppPilotoKart.competicionPilotos.size() != 0) {
        			ventana.dispose();
        			MostrarPilotos.ventana = new MostrarPilotos();
        			MostrarPilotos.ventana.setSize(565,320);
        			MostrarPilotos.ventana.repaint();
        			MostrarPilotos.ventana.setVisible(true);
        		} else {
        			JOptionPane.showMessageDialog(null, "No hay ningun piloto actualmente");
        		}
        		AppPilotoKart.escribirEnLog("Se han mostrado los pilotos");
        		
            }
        });
	}
}
