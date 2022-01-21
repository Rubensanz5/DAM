#include <stdio.h>
#define MAXIMO 100
void main(){
	srand (getpid());
	int numeroSecreto;
	int num;
	numeroSecreto = rand() % MAXIMO + 1;
	int intentos = 5;
	
	printf("Introduce un numero del 1 al 100");
	
	while (numeroSecreto != num && intentos > 0) {
		do {
			printf("\nTienes %u intentos: ", intentos);
			scanf ("%u", &num);
			if(numeroSecreto < 0 || numeroSecreto > 100){
				printf("Pon un numero entre 0 y 100");
			}
		} while (numeroSecreto < 0 || numeroSecreto > 100);
	
	
		
	
		if (numeroSecreto > num) {
			printf("El número secreto es mayor que: %u", num);
		} else {
			printf("El número secreto es menor que: %u", num);
		}
		intentos = intentos - 1;
		printf("\nEse no es intentelo de nuevo");
	}
		
	if (numeroSecreto == num) {
		printf("\nEnhorabuena! Usted adivino el numero\n");
	} else{
		printf("\nFin de la partida, el numero era: %u\n" ,numeroSecreto);
	}
}
