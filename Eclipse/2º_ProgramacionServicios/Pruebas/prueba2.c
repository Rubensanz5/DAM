#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>



int main () {  
    mkfifo("tuberia_fifo", 0666);
	
	int t = open("tuberia_fifo", O_WRONLY);
	write(t,"Mensaje enviado entre procesos",sizeof("Mensaje enviado entre procesos"));
	
	printf("El mensaje se ha leido por otro proceso\n");
	
	close(t);
	return 0;
}  