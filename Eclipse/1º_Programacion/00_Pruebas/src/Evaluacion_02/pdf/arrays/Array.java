package Evaluacion_02.pdf.arrays;

import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JOptionPane;

import Evaluacion_02.Persona.Persona;
import Evaluacion_02.Persona.Profesor;
import Evaluacion_02.Persona.ProfesorInterino;




public class Array {

	
	public static void main(String[] args) {
		// Crear array unidimensional
		//declaracion
		Persona [] arrayuni;
		int [][] arraydoble;
		//creacion
		arrayuni = new Persona[3];
		arrayuni = new Persona[Integer.parseInt(JOptionPane.showInputDialog("Cuantos elementos hay?(3)"))];
		arraydoble = new int [3][2];
		//inicializacion
		arrayuni[0] = new Persona("Ruben", "sanz", 23);
		arrayuni[1] = new Profesor("Pedro", "benito", 55, "pedro.beni");
		arrayuni[2] = new ProfesorInterino("Juan", "el seco", 35, Calendar.getInstance());
		
		
		arraydoble[0][0] = 00;
		arraydoble[0][1] = 01;
		arraydoble[1][0] = 10;
		arraydoble[1][1] = 11;
		arraydoble[2][0] = 20;
		arraydoble[2][1] = 21;
		
		//acceso al contenido
		System.out.println("acceso al contenido");
		System.out.println(arrayuni[0].getNombre());
		System.out.println(arraydoble[2][1]);
		
		//otra forma de inicializar 
		
		Profesor profesor1 = new Profesor("Maria", "De agueda" , 45);
		Profesor profesor2 = new Profesor("Manolo", "Garcia" , 39);
		Profesor profesor3 = new Profesor("Sara", "sanz" , 21);
		
		Profesor [] profesNuevos = {profesor1,profesor2,profesor3};
		
		double[] arrayNum = {5,50.2,54,12,34.5}; 
		
		int[][] arraybi2 = {
				{2,5,3,55},
				{65,7,5,5,9,6}
				};
		
		System.out.println(profesNuevos[0].getApellidos());
		System.out.println(arraybi2[1][0]);
		
		//uso de arrays en metodos
		System.out.println("uso de arrays en metodos");
		byte [] arEntrada = {4,6,-3};
		int [] arSalida = metodo(arEntrada, (byte) 2);
		
		System.out.println("Array entrada: " + Arrays.toString(arEntrada));
		System.out.println("Array salida: " + Arrays.toString(arSalida));
		
		
		//recorer un array
		//con un for
		System.out.println("recorrer un array con for");
		for (int i=0;i<profesNuevos.length;i++){
            System.out.println(profesNuevos[i].getNombre());
		}
		
		for (int i=0;i<arraydoble.length;i++){
            for(int j=0;j<arraydoble[0].length;j++){
                System.out.println(arraydoble[i][j]);
            }
		}
		//con foreach
		//se recorre entero siempre y no se pueden saber las posiciones
		System.out.println("recorrer un array con foreach");
		for (Profesor profe : profesNuevos) {
			System.out.println(profe.getNombre());
		}
		
		//ordenacion y busqueda
		//ordena de manera ascendente
		System.out.println("ordenar un array");
		Arrays.sort(arrayNum);
		
		for (double num : arrayNum) {
			System.out.println(num + " | ");
		}
		
		System.out.println("ordenar un array de objetos");
		String[] nombres = {"6", "pedro", "AAA","aaaa"};
		Arrays.sort(nombres);
		for (String prof : nombres) {
			System.out.println(prof + " | ");
		}
		
		//se suele buscar en un array ordenado
		System.out.println("buscar en un array");
		
		System.out.println(Arrays.binarySearch(arrayNum, 50.2));
		
		//impresion de un array entero
		System.out.println("imprimir un array");
		
		System.out.println(Arrays.toString(arrayNum));
		
		//comparar arrays
		System.out.println("comparar arrays");
		
		int[] array1 = {4,7,14,9};
		int[] array2 = new int[4];
		
		array2[0] = 4; 
		array2[1] = 7; 
		array2[2] = 14; 
		array2[3] = 9; 
		
		System.out.println(array1.equals(array2)); // dara false x q no apuntan a la misma direccion de memoria
		System.out.println(Arrays.equals(array1,array2)); // dara true xq compara los elemoentros y son iguales
		
		int[] array3 = array1;
		System.out.println(array1.equals(array3)); // dara true xq apuntan a la misma direccion de memoria
		System.out.println(Arrays.equals(array1,array3)); // dara true xq compara los elemoentros y son iguales
		
		//inicializacion masiva
		System.out.println("inicializacion masiva");
		
		int[] ar1 = new int[3];
		
		Arrays.fill(ar1, 50);
		Arrays.fill(ar1, 100);
		
		System.out.println("ar1 -->" + Arrays.toString(ar1));
		
		//COPIAR ARRAY A MANO
		System.out.println("copiar un array a mano");
		double[] arrayAMano = new double[arrayNum.length];
		for(int h = 0; h < arrayNum.length; h++) {
			arrayAMano[h] = arrayNum[h];
		}
		
		System.out.println(Arrays.toString(arrayAMano));
		
		//copiar arrays con Clone
		System.out.println("copiar un array con clone");
		
		double[] arrayClone = arrayNum.clone();
		//en elementos primitivos los elementos son independientes
		System.out.println(arrayNum == arrayClone); //dara false xq no apuntan a la misma direccion de memoria
		arrayClone[0] = 0.1;
		System.out.println(arrayNum[0]);
		System.out.println(arrayClone[0]);
		
		Persona[] arrayClone2 = profesNuevos.clone();
		
		System.out.println(profesNuevos == arrayClone2); //dara false por que no apuntan a la misma direccion en memoria pero el interior si apunta al
														 // mismo objeto
		System.out.println(profesNuevos[0].getNombre());
		
		arrayClone2[0].setNombre("Pepe"); 
		
		System.out.println(profesNuevos[0].getNombre()); 
		System.out.println(arrayClone2[0].getNombre()); 
		
		
		//copiar arrays con copyOf y copyOfRange
		System.out.println("copiar un array con copyOf y copyOfRange");
		
		double[] a = Arrays.copyOfRange(arrayNum, 0, arrayNum.length); //copia completa de arrayNum en a
		double[] b = Arrays.copyOfRange(arrayNum, arrayNum.length - 2 , arrayNum.length); //copia de los 2 ultimos elementos
		double[] c = Arrays.copyOf(arrayNum, arrayNum.length); //copia completa de arrayNum a c
		double[] d = Arrays.copyOf(arrayNum, 2); //copia de los 2 primeros elementos
		
		System.out.println("array arrayNum: " + Arrays.toString(arrayNum));
		System.out.println("array a: " + Arrays.toString(a));
		System.out.println("array b: " + Arrays.toString(b));
		System.out.println("array c: " + Arrays.toString(c));
		System.out.println("array d: " + Arrays.toString(d));
		
		// copiar arrays con arraycopy
		System.out.println("copiar un array con arrayscopy");
		
		double[] arrayCopy = new double[5];
		
		System.arraycopy(arrayNum, 2, arrayCopy, 1, 2);
		
		for (int i=0;i<arrayCopy.length;i++){
            System.out.println(arrayCopy[i]);
		}
		
		//polimorfismo en arrays 
		System.out.println("polimorfismo en arrays");
		
		Persona[] person = new Persona[10];
		
		person[0] = new Persona("Ruben", "sanz", 23);
		person[1] = new Profesor("Pedro", "benito", 55, "pedro.beni");
		person[2] = new ProfesorInterino("Juan", "el seco", 35, Calendar.getInstance());
		
		for (Persona ps : person) {
			if (ps != null) {
				System.out.println("Persona: " + ps.getNombre());
				if(ps instanceof Profesor) {
					Profesor prof = (Profesor) ps;
					prof.mostrarNombreApellidosYCarnet();
				} else if (ps instanceof ProfesorInterino) {
					System.out.println(((ProfesorInterino) ps).getFechaComienzoInterinidad());
				}
			}
		}
		
		
		
		
		
	}

	public static int[] metodo( byte[] array, byte num) {
		int[] arrayRetorno = new int[array.length];
		for (int i=0;i<array.length;i++){
               arrayRetorno[i] = array[i] + num;
         }
		return arrayRetorno;
	}
	
}
