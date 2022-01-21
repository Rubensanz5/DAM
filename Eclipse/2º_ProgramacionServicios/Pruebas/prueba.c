#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main () {  
    int fd [2];
	char buffer[30];
	pid_t pid;
	
	pipe(fd);
	
	pid = fork();
	
	switch(pid){
		case -1 :
			printf("NO SE HA PODIDO CREAR EL HIJO...");
			exit(-1);
			break;
		case 0 :
			close(fd[0]);
			sleep(8);
			printf("EL HIJO escribe en pipe...\n");
			write(fd[1],"Hola padre", 11);
			break;
		default	:
			close(fd[1]);
			printf("EL padre espera a que se escriba en pipe...\n");
			read(fd[0],buffer, 11);
			printf("EL padre lee del pipe...\n");
			printf("\tMensaje leido: %s\n", buffer);
			break;
	}
	
}  