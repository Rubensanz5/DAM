#include <stdio.h>
#include <stdlib.h>

int main(){ 
    FILE *fichero;
    char* linea = NULL;
	char nombre[80];
	size_t bytes = 0;
	int longitud = 0;
	int longMax = 0;
    int i=0;
	//printf("Escribe el nombre del fichero: ");
	//scanf("%s",nombre);
	
	do{	  
		fichero = fopen("fichTexto.txt", "rt");
	
		if (fichero == NULL){
			printf("\nNo existe el fichero\n");
			exit(1);  
		} else {
		   printf("\nNombre de fichero: %s",nombre);
		}
	} while (fichero == NULL);
	
    do {
        for (i = 0; i < 5; i++) {
          	longitud = getline(&linea,&bytes,stdin);
			printf("dssdfds %d",longitud);
            if (longitud != -1) {
                printf("%s",linea);                
            }
			if (longMax < longitud) {
				longMax = longitud;

			}
		}
		getchar();       
    } while (longitud != -1);

	printf("La linea mas larga tiene %d",longMax);

	free(linea);
    fclose(fichero);
    return 0;
}
