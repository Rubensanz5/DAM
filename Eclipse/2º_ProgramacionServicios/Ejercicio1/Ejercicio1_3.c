#include <stdio.h>

void main(){
	int anio;
	printf("Introduce un año para ver si es bisiesto: ");
	scanf("%u",&anio);
	
	
	if (anio % 4 == 0){
		if (anio % 100 == 0){
			if (anio % 400 != 0){
				printf("El año %u es bisiesto \n",anio);
			} else {
				printf("El año %u no es bisiesto \n",anio);			
			}
		} else {
			printf("El año %u es bisiesto \n",anio);
		}
	} else {
		printf("El año %u no es bisiesto \n",anio);	
	}
}
