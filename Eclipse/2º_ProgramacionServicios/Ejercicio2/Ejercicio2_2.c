#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void main(){
	pid_t padre;
	
	padre = fork();

	if (padre == -1) {
		printf("\nError: No se pudo crear el proceso hijo\n");
		exit(-1);
	} else if(padre == 0){
		printf("\nSoy el hijo = 3, Mi padre es = %d, Mi PID = %d \n", getppid(),getpid());
	} else {
		wait(NULL);
		padre = fork();
		
		if (padre == -1) {
			printf("\nError: No se pudo crear el proceso hijo\n");
			exit(-1);
		} else if(padre == 0){
			printf("Soy el hijo = 2, Mi padre es = %d, Mi PID = %d \n", getppid(),getpid());
		} else {
			wait(NULL);
			padre = fork();
			
			if (padre == -1) {
				printf("\nError: No se pudo crear el proceso hijo\n");
				exit(-1);
			} else if(padre == 0){
				printf("Soy el hijo = 1, Mi padre es = %d, Mi PID = %d \n", getppid(),getpid());
			} else {
				wait(NULL);
				printf("Proceso PADRE = %d\n",getpid());
				printf("Proceso ABUELO = %d\n",getppid());
			}
		}
	}
	exit(0);
}
