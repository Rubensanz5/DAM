package Evaluacion_01.dam1;
import java.util.Scanner;

/*
 * Ejemplo de clase Java
 * 
 * La clase CajeroAutomatico simula el comportamiento de un cajero automático
 * donde el usuario puede ingresar y retirar dinero de su cuenta corriente
 * 
 * Programador: Héctor Morán
 */
public class ClaseEjemplo {

	public static void main(String[] args) {

		final double SALDO_INICIAL = 1000;	// Inicializo el saldo inicial de la cuenta corriente del usuario a 1000€
		double ingreso, retirada, saldoActual;
		String nombreUsuario;
		byte opcion = 0;	// Inicializo a 0 para que entre en el bucle del menú

		System.out.print("Introduzca su nombre de usuario: ");
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		nombreUsuario = entrada.nextLine();

		/*
		 * En un programa de cajero automático real, deberíamos comprobar que el usuario
		 * existe en la base de datos y pedirle su número de PIN o contraseña, que
		 * debería estar encriptada en dicha bbdd. En caso de que exista, deberíamos
		 * consultar en la bbdd el saldo que le queda en la cuenta corriente y
		 * asignárselo a la variable saldoActual, como no lo tenemos utilizamos la
		 * constante SALDO_INICIAL.
		 */
		saldoActual = SALDO_INICIAL;

		System.out.println("Bienvenido, " + nombreUsuario + "\n");
		while (opcion != 3) {	// El bucle finalizará cuando el usuario haya introducido 3 (opción "Salir")

			System.out.println("OPERACIONES CAJERO AUTOMÁTICO");
			System.out.println("-----------------------------");
			System.out.println("Saldo en cuenta corriente:\t" + saldoActual + "€");
			System.out.println("1. Ingresar dinero a la cuenta");
			// Si no dispone de saldo en la cuenta, no mostramos la opción de retirar dinero
			if (saldoActual != 0) { System.out.println("2. Retirar dinero de la cuenta"); }
			System.out.println("3. Salir"); 
			System.out.print("\nElija una opción: ");
			opcion = entrada.nextByte();

			switch (opcion) {
				case 1 :
					System.out.println("Introduzca la cantidad que desea ingresar en la cuenta: ");
					ingreso = entrada.nextDouble();
					saldoActual = saldoActual + ingreso;
					System.out.println("El saldo actual en su cuenta es de " + saldoActual + "€\n");
					break;
				case 2 :
					System.out.print("Introduzca la cantidad que desea retirar de la cuenta: ");
					retirada = entrada.nextDouble();
					// Compruebo que la retirada es positiva y que no se retira más dinero que el saldo actual disponible
					if ((retirada > 0) && (retirada <= saldoActual)) {	
						saldoActual = saldoActual - retirada;
						System.out.println("El saldo actual en su cuenta es de " + saldoActual + "€\n");
					} else {
						System.out.println("No cuenta con el saldo suficiente en su cuenta\n");
					}
					break;
				case 3 :
					break;
				default :	// Cualquier opción que introduzca distinta de 1, 2 o 3 es incorrecta
					System.out.println("Opción incorrecta\n");
					break;
			}
		}
		System.out.println("Gracias por utilizar nuestros servicios, " + nombreUsuario + "\n");
	}

}