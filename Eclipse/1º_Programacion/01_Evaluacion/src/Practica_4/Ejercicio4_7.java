package Practica_4;
import java.util.Scanner;
//usar la esa libreria para mostrar mensajes en la consola
//Autor: Ruben Sanz Garcia
//Fecha: 12/11/2020
public class Ejercicio4_7 {
	public static void main(String[] args) {
		float filas;
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca numero de filas: ");
        filas = sc.nextInt();
        sc.close();
		System.out.println();
		piramideInvertida(filas);		
	}
	
	public static float piramideInvertida(float num) {
        float numFilas = num;
       
        for (float numBlancos = 0, numAsteriscos = (numFilas*2)-1; numAsteriscos>0; numBlancos++, numAsteriscos -= 2) {
             
            //Espacios en blanco
            for(float i = 0; i < numBlancos; i++){
                System.out.print(" ");
            }
            //Asteriscos
            for(float j = numAsteriscos; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
		return num;
	}
	
}
