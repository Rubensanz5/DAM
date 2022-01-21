#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	
	if(argc < 2){
		printf("Error: faltan paramentros");
	} else if (argc == 2) {
		FILE *fichero = fopen(argv[1], "rt");;

		if (fichero != NULL) {

			char *linea = NULL; 
			size_t n = 0;
			int longitud;
			int longitudMaxima = 0;
			int i = 1;
			
			do {
				for(i = 1; i < 6; i++){
					longitud = getline(&linea, &n, fichero);
					if (longitud > longitudMaxima) {
						longitudMaxima = longitud;
					}
					printf("%s", linea);
					if (i == 5) {
						getchar();
					}
				}
			} while (longitud != -1);
			
			
			printf("\nLa línea más larga leída tenía %u caracteres\n", longitudMaxima);
			
			free(linea); // Hay que liberar el buffer despues utilizarlo
			fclose(fichero);
		
		} else {
			printf("Error: El fichero no existe");
			exit(0);
		}
	} else {
		printf("Error: demasiados paramentros");
		exit(0);
	}
	return 0;
}