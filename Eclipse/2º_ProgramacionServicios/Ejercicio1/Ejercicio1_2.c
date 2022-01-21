#include <stdio.h>
#define PRECIOINICIAL 0.50
#define PRECIOHORA 1.35
#define PRECIOHORAYMEDIA 0.90
void main(){
	int tiempo;
	printf("Introduce la estancia en el parking(en min): ");
	scanf("%u",&tiempo);
	double precio;
	
	if(tiempo < 0){
		printf("Introduce Un tiempo valido");
	} else {
		precio = PRECIOINICIAL;
		precio = (PRECIOHORA * tiempo / 60) + precio;
		
		if(tiempo > 90){
			tiempo = tiempo - 90;
			precio = ((PRECIOHORAYMEDIA/60) * tiempo) + precio;
			printf("El precio de su estancia es %lf Euros\n", precio);
		} else {
			printf("El precio de su estancia es %lf Euros\n", precio);
		}
		
		
	}
	
	
}
