package Evaluacion_03.InterfacesGraficasUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EjemploListeners extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JComboBox<String> comboBox;
    private JRadioButton rdbtnOpcion;
    private JRadioButton rdbtnOpcion_1;
    private JRadioButton rdbtnOpcion_2;
    private JLabel lblEstasSobreLa;


    public static void main(String[] args) {
        EjemploListeners frame = new EjemploListeners();
        frame.setVisible(true);
    }

    /*
     * Creación de la ventana de la aplicación
     */
    public EjemploListeners() {

        // Añade un titulo a la ventana
        setTitle("GUI APP - Programación 1º DAM");

        /*
         * Coordenadas x y de la aplicacion y su altura y longitud,
         * si no lo indicamos aparecera una ventana muy pequeña
         */
        setBounds(400, 200, 655, 520);

        /*
         * Indica que cuando se cierre la ventana se acaba la aplicacion,
         * si no lo indicamos cuando cerremos la ventana la aplicación seguirá funcionando
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Hace visible la ventana, si no lo hacemos no veremos la aplicación
        setVisible(true);

        // Creamos el panel
        contentPane = new JPanel();

        // Indicamos su diseño
        contentPane.setLayout(null);

        // Asigno el panel a la ventana
        setContentPane(contentPane);

        // COMPONENTES

        // Etiquetas

        JLabel lblEscribeElNombre = new JLabel("Escribe el nombre de una persona");
        lblEscribeElNombre.setBounds(369, 32, 229, 25);
        contentPane.add(lblEscribeElNombre);

        JLabel lblEligeUnaOpcion = new JLabel("Elige una opción:");
        lblEligeUnaOpcion.setBounds(176, 32, 109, 14);
        contentPane.add(lblEligeUnaOpcion);

        JLabel lblPulsaElBoton = new JLabel("Pulsa el botón");
        lblPulsaElBoton.setBounds(47, 32, 85, 14);
        contentPane.add(lblPulsaElBoton);

        lblEstasSobreLa = new JLabel("Estás sobre la ");
        lblEstasSobreLa.setBounds(158, 224, 192, 14);
        contentPane.add(lblEstasSobreLa);

        JLabel lblSoloSePuede = new JLabel("Solo se puede escribir dígitos");
        lblSoloSePuede.setBounds(371, 208, 193, 14);
        contentPane.add(lblSoloSePuede);

        JLabel lblNombreElegido = new JLabel("Nombre Elegido");
        lblNombreElegido.setBounds(175, 124, 110, 14);
        contentPane.add(lblNombreElegido);

        // Campo de texto

        textField = new JTextField();
        textField.setBounds(371, 68, 193, 26);
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setBounds(175, 150, 141, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setBounds(371, 247, 126, 20);
        contentPane.add(textField_2);

        // Botones

        JButton btnPulsame = new JButton("Púlsame");
        btnPulsame.setBounds(43, 70, 89, 23);
        contentPane.add(btnPulsame);

        JButton btnAnadir= new JButton("Añadir");
        btnAnadir.setBounds(371, 124, 89, 23);
        contentPane.add(btnAnadir);

        JButton btnPantalla2 = new JButton("PANTALLA 2 -->");
        btnPantalla2.setBounds(371, 307, 126, 20);
        contentPane.add(btnPantalla2);

        // Botones de radio

        rdbtnOpcion= new JRadioButton("Opción 1");
        rdbtnOpcion.setBounds(43, 194, 109, 23);
        contentPane.add(rdbtnOpcion);

        rdbtnOpcion_1 = new JRadioButton("Opción 2");
        rdbtnOpcion_1.setBounds(43, 220, 109, 23);
        contentPane.add(rdbtnOpcion_1);

        rdbtnOpcion_2 = new JRadioButton("Opción 3");
        rdbtnOpcion_2.setBounds(43, 246, 109, 23);
        contentPane.add(rdbtnOpcion_2);

        // Agrupamos los botones de radio
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnOpcion);
        bgroup.add(rdbtnOpcion_1);
        bgroup.add(rdbtnOpcion_2);

        // Menú de opciones
        comboBox = new JComboBox<>();
        comboBox.setBounds(175, 70, 141, 22);
        contentPane.add(comboBox);

        // Añadimos opciones
        comboBox.addItem("José Ignacio");
        comboBox.addItem("María Jesús");
        comboBox.addItem("Héctor");

        // Eventos

        btnPantalla2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed (ActionEvent e) {
                pantalla2();
            }
        });

        btnPulsame.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed (ActionEvent e) {
                JOptionPane.showMessageDialog(contentPane, "¡Me has pulsado!");
            }
        });

        // En este caso hemos debido de convertir el componente en un atributo
        comboBox.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed (ActionEvent e) {
                textField_1.setText(comboBox.getItemAt(comboBox.getSelectedIndex()));
            }
        });

        textField.addKeyListener(new KeyListener() {
        	@Override
        	public void keyTyped (KeyEvent e) {
                // Si el caracter introducido es un dígito no lo escribe
                if (Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        	@Override
        	public void keyReleased(KeyEvent e) { }
        	@Override
        	public void keyPressed(KeyEvent e) { }
        });

        btnAnadir.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed (ActionEvent e) {
                comboBox.addItem(textField.getText());
                textField.setText("");
                JOptionPane.showMessageDialog(contentPane, "Nombre Añadido");
            }
        });

        rdbtnOpcion.addMouseListener(new MouseListener() {
        	@Override
        	public void mouseClicked(MouseEvent e) { }
        	@Override
        	public void mouseEntered(MouseEvent e) {
                lblEstasSobreLa.setText(lblEstasSobreLa.getText() + rdbtnOpcion.getText());
            }
        	@Override
        	public void mouseExited(MouseEvent e) {
                lblEstasSobreLa.setText("Estás sobre la ");
            }
        	@Override
        	public void mousePressed(MouseEvent e) { }
        	@Override
        	public void mouseReleased(MouseEvent e) { }
        });

        rdbtnOpcion_1.addMouseListener(new MouseListener() {
        	@Override
        	public void mouseClicked(MouseEvent e) { }
        	@Override
        	public void mouseEntered(MouseEvent e) {
                lblEstasSobreLa.setText(lblEstasSobreLa.getText() + rdbtnOpcion_1.getText());
            }
        	@Override
        	public void mouseExited(MouseEvent e) {
                lblEstasSobreLa.setText("Estás sobre la ");
            }
        	@Override
        	public void mousePressed(MouseEvent e) { }
        	@Override
        	public void mouseReleased(MouseEvent e) { }
        });

        rdbtnOpcion_2.addMouseListener(new MouseListener() {
        	@Override
        	public void mouseClicked(MouseEvent e) { }
        	@Override
        	public void mouseEntered(MouseEvent e) {
                lblEstasSobreLa.setText(lblEstasSobreLa.getText() + rdbtnOpcion_2.getText());
            }
        	@Override
        	public void mouseExited(MouseEvent e) {
                lblEstasSobreLa.setText("Estás sobre la ");
            }
        	@Override
        	public void mousePressed(MouseEvent e) { }
        	@Override
        	public void mouseReleased(MouseEvent e) { }
        });

        textField_2.addKeyListener(new KeyListener() {
        	@Override
        	public void keyTyped (KeyEvent e) {
                // Si el caracter introducido no es un dígito no lo escribe
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        	@Override
        	public void keyReleased(KeyEvent e) { }
        	@Override
        	public void keyPressed(KeyEvent e) { }
        });
    }

    public void pantalla2() {
    	JPanel panel = new JPanel();
        setContentPane(panel);
        panel.add(new JLabel("Pantalla 2 de la aplicación"));
        JButton salir = new JButton("SALIR");
        salir.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	System.exit(0);
            }
        });
        panel.add(salir);
        validate();
    }
}