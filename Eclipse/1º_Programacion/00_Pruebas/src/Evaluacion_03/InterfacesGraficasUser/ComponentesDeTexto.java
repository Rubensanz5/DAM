package Evaluacion_03.InterfacesGraficasUser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ComponentesDeTexto {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		
		BoxLayout gestor = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
		contentPane.setLayout(gestor);
		
		JLabel et1 = new JLabel();
		JLabel et2 = new JLabel();
		JLabel et3 = new JLabel();
		JLabel et4 = new JLabel();
		JLabel et5 = new JLabel();
		
		et1.setText("Etiqueta de texto");
		
		et2.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\super-mario.png"));
		
		et3.setHorizontalTextPosition(SwingConstants.LEFT);
		et3.setText("Icono derecha");
		et3.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\super-mario.png"));

		et4.setHorizontalTextPosition(JLabel.RIGHT);
		et4.setText("Icono izquierda");
		et4.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\super-mario.png"));

		et5.setText("Icono arriba");
		et5.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\super-mario.png"));
		et5.setHorizontalTextPosition(JLabel.CENTER);
		et5.setVerticalTextPosition(JLabel.BOTTOM);
		
		contentPane.add(et1);
		contentPane.add(et2);
		contentPane.add(et3);
		contentPane.add(et4);
		contentPane.add(et5);
		
		frame.setContentPane(contentPane);
		frame.setSize(300,400);
		frame.setVisible(true);
		
		ejJButton();
		ejJToggleButton();
		ejJRadioButton();
		ejJCheckBox();
		ejJComboBox();
		ejJSlider();
		ejJSpinner();
		ejJList();
		ejJTree();
		
	}
	
	public static void ejJButton() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon leftButtonIcon = new ImageIcon("C:\\Users\\admin\\Desktop\\derecha.png");
		ImageIcon midButtonIcon = new ImageIcon("C:\\Users\\admin\\Desktop\\mid.png");
		ImageIcon rightButtonIcon = new ImageIcon("C:\\Users\\admin\\Desktop\\izda.png");
	
		JButton b1 = new JButton("Boton Habilitado ", leftButtonIcon);
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEADING);
		b1.setMnemonic(KeyEvent.VK_D);

		
		JButton b2 = new JButton("Boton del medio ", midButtonIcon);
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_M);
		
		JButton b3 = new JButton("Boton deshabilitado ", rightButtonIcon);
		b3.setMnemonic(KeyEvent.VK_E);
		b3.setEnabled(false);

		b1.setToolTipText("Msg de ayuda Boton 1");
		b2.setToolTipText("Msg de ayuda Boton 2");
		b3.setToolTipText("Msg de ayuda Boton 3");
		
		JPanel contentPane = new JPanel();
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		frame.setContentPane(contentPane);

		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void ejJToggleButton() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToggleButton b1 = new JToggleButton("Boton interruptor", true);
		
		JPanel contentPane = new JPanel();
		contentPane.add(b1);
		frame.setContentPane(contentPane);
		
		frame.setSize(300,400);
		frame.setVisible(true);
	}
	
	public static void ejJRadioButton() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setPreferredSize(new Dimension(300,100));
		
		JRadioButton btRadio1 = new JRadioButton("Opcion 1", true);
		btRadio1.setBounds(43,194,109,23);
		contentPane.add(btRadio1);
		
		JRadioButton btRadio2 = new JRadioButton("Opcion 2", true);
		btRadio2.setBounds(43,220,109,23);
		contentPane.add(btRadio2);
		
		JRadioButton btRadio3 = new JRadioButton("Opcion 3", true);
		btRadio3.setBounds(43,246,109,23);
		contentPane.add(btRadio3);
		
		ButtonGroup btGroup = new ButtonGroup();
		btGroup.add(btRadio1);
		btGroup.add(btRadio2);
		btGroup.add(btRadio3);
		
		frame.setContentPane(contentPane);

		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void ejJCheckBox() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setPreferredSize(new Dimension(300,100));
		
		JCheckBox chkbxOpcion = new JCheckBox("Opcion 1", true);
		contentPane.add(chkbxOpcion);
		
		JCheckBox chkbxOpcion1 = new JCheckBox("Opcion 2", true);
		contentPane.add(chkbxOpcion1);
		
		JCheckBox chkbxOpcion2 = new JCheckBox("Opcion 1", true);
		contentPane.add(chkbxOpcion2);
		
		frame.setContentPane(contentPane);

		frame.pack();
		frame.setVisible(true);
	}
	
	public static void ejJComboBox() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("Opcion 1");
		comboBox.addItem("Opcion 2");
		comboBox.addItem("Opcion 3");
		
		JPanel contentPane = new JPanel();
		contentPane.add(comboBox);
		frame.setContentPane(contentPane);
		
		frame.setSize(400,150);
		frame.setVisible(true);
	}
	
	public static void ejJSlider() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0 , 40, 10);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(10));
		
		JPanel contentPane = new JPanel();
		contentPane.add(slider);
		frame.setContentPane(contentPane);
		
		frame.setSize(400,150);
		frame.setVisible(true);
	}
	
	public static void ejJSpinner() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SpinnerNumberModel snm = new SpinnerNumberModel(
				Integer.valueOf(0),
				Integer.valueOf(0),
				Integer.valueOf(100),
				Integer.valueOf(5)	);
		JSpinner spnNumber = new JSpinner(snm);
		
		String[] colores = {"azul", "rojo", "verde"};
		SpinnerModel snl = new SpinnerListModel(colores);
		JSpinner spnList = new JSpinner(snl);
		spnList.setPreferredSize(new Dimension(100,30));
		
		
		JPanel contentPane = new JPanel();
		contentPane.add(spnNumber);
		contentPane.add(spnList);
		frame.setContentPane(contentPane);
		
		frame.setSize(400,150);
		frame.setVisible(true);
	}
	
	public static void ejJList() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final int MAX = 10;
		String [] listElements =new String[MAX];
		for (int i = 0; i < MAX; i++) {
			listElements[i] = "Elemento " + i;
		}
		
		JList list = new JList(listElements);
		JScrollPane scroll = new JScrollPane(list);
		
		JButton btnGet = new JButton("Seleccionar");
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(scroll, BorderLayout.CENTER);
		contentPane.add(btnGet, BorderLayout.SOUTH);
		frame.setContentPane(contentPane);
		
		frame.setSize(200,150);
		frame.setVisible(true);
	}
	
	public static void ejJTree() {
		JFrame frame = new JFrame("Programacion Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode("Abuelo");
		DefaultTreeModel modelo = new DefaultTreeModel(abuelo);
		JTree tree = new JTree(modelo);
		DefaultMutableTreeNode padre = new DefaultMutableTreeNode("Padre");
		DefaultMutableTreeNode tio = new DefaultMutableTreeNode("Tio");
		DefaultMutableTreeNode hijo = new DefaultMutableTreeNode("Hijo");
		DefaultMutableTreeNode hija = new DefaultMutableTreeNode("Hija");

		modelo.insertNodeInto(padre, abuelo, 0);
		modelo.insertNodeInto(tio, abuelo, 1);
		modelo.insertNodeInto(hijo, padre, 0);
		modelo.insertNodeInto(hija, padre, 1);
				
		frame.getContentPane().add(tree);
		
		frame.setSize(200,150);
		frame.setVisible(true);
	}

}
