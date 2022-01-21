#include <stdio.h>
#define PRECIOINICIAL 0.50
#define PRECIOHORA 1.35
void main(){
	int tiempo;
	printf("Introduce la estancia en el parking(en min): ");
	scanf("%u",&tiempo);
	
	double precio;
	
	if(tiempo < 0){
		printf("Introduce Un tiempo valido\n");
	} else {
		precio = PRECIOINICIAL;
    	precio = (PRECIOHORA * tiempo / 60) + precio;
		printf("El precio de su estancia es %lf Euros\n", precio);
	}
}
