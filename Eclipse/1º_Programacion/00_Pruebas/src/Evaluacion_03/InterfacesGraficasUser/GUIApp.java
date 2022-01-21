package Evaluacion_03.InterfacesGraficasUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.Border;

public class GUIApp {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Mi primera ventana");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create menu bar- Make it have a green background
		JMenuBar greenMenuBar = new JMenuBar();
		greenMenuBar.setOpaque(true);
		greenMenuBar.setBackground(new Color(154,165,127));
		greenMenuBar.setPreferredSize(new Dimension(200,20));
		
		//Create yellow label to output in the ontent pane
		JLabel yellowLabel = new JLabel();
		yellowLabel.setOpaque(true);
		yellowLabel.setBackground(new Color(248,213,131));
		yellowLabel.setPreferredSize(new Dimension(200,100));
		
		// create ok boton
		JButton boton = new JButton();
		ImageIcon imgBoton = new ImageIcon("C:\\Users\\admin\\Desktop\\botonrojo.png");
		boton.setIcon(imgBoton);
		boton.setBackground(new Color(254,8,2));
		boton.setFocusable(true);

		//Create panel and add components to it
		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(yellowLabel, BorderLayout.CENTER);
		contentPanel.add(boton, BorderLayout.PAGE_END);
		
		//Set the menu bar and add the label and buton to the contain pane
		frame.setJMenuBar(greenMenuBar);
		frame.setContentPane(contentPanel);
		
		//display the windows
		//frame.pack();
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);
		
		EjBorderLayout();
		
		EjFlowLayout();
		
		EjBoxLayout();
		
		ejGridLayout();
		
	}
	
	public static void EjBorderLayout() {
		JFrame frame1 = new JFrame("Border Layout");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contenido = frame1.getContentPane();
		
		JButton boton0 = new JButton("Boton 0 (PAGE_START)");
		contenido.add(boton0, BorderLayout.PAGE_START);
		
		JButton boton1 = new JButton("Boton 1 (CENTER)");
		boton1.setPreferredSize(new Dimension(200,100));
		contenido.add(boton1, BorderLayout.CENTER);
		
		JButton boton2 = new JButton("Boton 2 (LINE_START)");
		contenido.add(boton2, BorderLayout.LINE_START);
		
		JButton boton3 = new JButton("Boton 3 (LINE_END)");
		contenido.add(boton3, BorderLayout.LINE_END);
		
		JButton boton4 = new JButton("Boton 4 (PAGE_END)");
		contenido.add(boton4, BorderLayout.PAGE_END);

		frame1.pack();
		frame1.setVisible(true);
	}
	
	public static void EjFlowLayout() {
		JFrame frame1 = new JFrame("Flow Layout");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contenido = frame1.getContentPane();
		
		contenido.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
		
		contenido.add(new JButton("Boton 1"));
		contenido.add(new JButton("Boton 2"));
		contenido.add(new JButton("Boton 3"));
		contenido.add(new JButton("Boton 4 con nombre largo"));
		contenido.add(new JButton("Boton 5"));
		
		frame1.setPreferredSize(new Dimension(400,180));
		
		frame1.pack();
		frame1.setVisible(true);
	}
	
	public static void EjBoxLayout() {
		JFrame frame1 = new JFrame("Box Layout");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton boton1 = new JButton("Boton 1 -");
		JButton boton2 = new JButton("Boton 2 -----------");
		JButton boton3 = new JButton("Boton 3 -");
		JButton boton4 = new JButton("Boton 4 -----------");
		JButton boton5 = new JButton("Boton 5 -");
		JButton boton6 = new JButton("Boton 6 -----------");
	
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setBorder(BorderFactory.createTitledBorder("LEFT"));
		panel2.setBorder(BorderFactory.createTitledBorder("CENTER"));
		panel3.setBorder(BorderFactory.createTitledBorder("RIGHT"));
		
		BoxLayout lay1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
		BoxLayout lay2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		BoxLayout lay3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
		
		panel1.setLayout(lay1);
		panel2.setLayout(lay2);
		panel3.setLayout(lay3);

		boton1.setAlignmentX(Component.LEFT_ALIGNMENT);
		boton2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel1.add(boton1);
		panel1.add(boton2);
		
		boton3.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton4.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel2.add(boton3);
		panel2.add(boton4);
		
		boton5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		boton6.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel3.add(boton5);
		panel3.add(boton6);
		
		frame1.add(panel1);
		frame1.add(panel2);
		frame1.add(panel3);
		
		frame1.setLayout(new FlowLayout());
		frame1.pack();
		frame1.setVisible(true);
	}
	
	
	public static void ejGridLayout() {
		JFrame frame1 = new JFrame("Box Layout");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contenido = frame1.getContentPane();
		
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		JPanel contrloes = new JPanel();
		contrloes.setLayout(new GridLayout(2,3));
		
		panel.setPreferredSize(new Dimension(365,130));
		
		panel.add(new JButton("Boton 1"));
		panel.add(new JButton("Boton 2"));
		panel.add(new JButton("Boton 3"));
		panel.add(new JButton("Boton 4 con nom largo"));
		panel.add(new JButton("5"));
		
		
		JComboBox comboBox1 = new JComboBox(new String[] {"0","10","15","20"});
		JComboBox comboBox2 = new JComboBox(new String[] {"0","10","15","20"});
		JButton apllyButton = new JButton("Cacular");
		
		contrloes.add(new JLabel("Ataque: "));
		contrloes.add(new JLabel("Defensa: "));
		contrloes.add(new JLabel(" "));
		contrloes.add(comboBox1);
		contrloes.add(comboBox2);
		contrloes.add(apllyButton);
		
		contenido.add(panel, BorderLayout.PAGE_START);
		contenido.add(new JSeparator(), BorderLayout.CENTER);
		contenido.add(contrloes, BorderLayout.PAGE_END);
		
		frame1.pack();
		frame1.setVisible(true);
		
	}
}
