#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void main(){
	FILE * archivo;
    char frase[40];
    char final[] = "end\n";
 
    archivo = fopen("fichTexto.txt", "wt");
 
    if (archivo == NULL){
        perror("Error en la apertura de este archivo");
    }
 
    printf("Escriba frases, para finalizar escriba 'end' :\n\n");
 
    do {
		//scanf("%s", &frase);	
      fgets(frase, 40,stdin);
      if(strcmp(frase,final) != 0) { 
          fprintf(archivo, "%s", frase);
        }
    } while (strcmp(frase, final) != 0);
 
 
    fclose(archivo);
    printf("Texto leido correctamente\n");
	
}
