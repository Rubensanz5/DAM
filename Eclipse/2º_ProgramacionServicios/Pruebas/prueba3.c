#include <stdio.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>

#define MAX_BUF 1024

int main () {  
    char msj[MAX_BUF];
	
	int t = open("tuberia_fifo", O_RDONLY);
	read(t,msj,MAX_BUF);
	printf("Recibido: %s\n", msj);
	
	close(t);
	return 0;
}  