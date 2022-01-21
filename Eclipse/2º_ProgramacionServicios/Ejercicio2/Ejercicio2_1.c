#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void main(){
	pid_t padre;
	int var = 6;

	printf("\nValor inicial de la variable: %u \n", var);
	
	padre = fork();

	if(padre == -1){
		printf("\nError: No se pudo crear el proceso hijo\n");
		exit(-1);
	} else if (padre == 0){
		var = var - 5;
		printf("Variable en el proceso hijo: %u \n", var);
	} else {
		wait(NULL);
		var = var + 5;
		printf("Variable en el proceso padre: %u \n", var);
	}

	exit(0);


}
