package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_5 {
	public static void main(String[] args) {
		String bach,gm,pa;
		boolean tieneBach,tieneGm,tienePa;
		
		bach = JOptionPane.showInputDialog("¿Tienes el titulo de Bachillerato? (si/no)");
		gm = JOptionPane.showInputDialog("¿Tienes el titulo de Grado Medio? (si/no)");
		pa = JOptionPane.showInputDialog("¿Tienes la prueba de acceso a grado superior? (si/no)");
		
		//inicializacion de variables que si no me da error
		tieneBach = false;
		tieneGm = false;
		tienePa = false;
		
		//si en cualquiera de las 3 preguntas responde si o alguna de sus combinaciones las variables se ponen en true
		if (bach.equalsIgnoreCase("si")) {
			tieneBach = true;
		} else if (gm.equalsIgnoreCase("si")) {
			tieneGm = true;
		} else if (pa.equalsIgnoreCase("si")) {
			tienePa = true;
		} else { //si introduce no o alguna de sus combinaciones las variables se ponen en false
			tieneBach = false;
			tieneGm = false;
			tienePa = false;
		}
		
		//en este if estoy comparando que no meta una cadena distinta a si o no y sus combinaciones
		if (!bach.equalsIgnoreCase("si") && !bach.equalsIgnoreCase("no")) {
			JOptionPane.showMessageDialog(null,"Inroduce si o no en las preguntas");
		} else if (!gm.equalsIgnoreCase("si") && !gm.equalsIgnoreCase("no")){
			JOptionPane.showMessageDialog(null,"Inroduce si o no en las preguntas");
		} else if (!pa.equalsIgnoreCase("si") && !pa.equalsIgnoreCase("no")){
			JOptionPane.showMessageDialog(null,"Inroduce si o no en las preguntas");
		} else if (tieneBach || tieneGm || tienePa){ //si ha introducido si o no y sus combinaciones te dice si puedes cursarlo
			JOptionPane.showMessageDialog(null,"Puedes cursar el ciclo de DAM");
		} else {
			JOptionPane.showMessageDialog(null,"No puedes cursar el ciclo de DAM");
		}
	}
}