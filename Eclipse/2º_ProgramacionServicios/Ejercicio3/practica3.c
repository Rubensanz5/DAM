#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void main(){

     int fd1[2], fd2[2];
     char buffer[30];

     pid_t pid, pidNieto;

     pipe(fd1);
     pipe(fd2);

     pid = fork();

    if (pid == -1){
      printf("Error");
    } else if(pid == 0){
      pidNieto = fork();
    } 

    switch (pid)
    {
      case -1:
        exit(1);
        break;

        case 0:
          switch (pidNieto)
          {
            case -1:
              //error
              exit(1);
              break;

            case 0: //nieto
              close(fd2[1]); //cierra escritura de la pipe 2
              read(fd2[0], buffer, 21);//Lee de la pipe 2
              printf("\t\tNIETO RECIBE mensaje de HIJO: %s \n", buffer);
              printf("\t\tNIETO ENVIA mensaje a HIJO...\n");

              close(fd1[0]); //Cerrar lectura de la pipe 1 
              write(fd1[1], "Saludos de tu hijo", 21); // Escribe en la pipe 1
              break;

            default://hijo
              close(fd1[1]); //cierra escritura de la pipe 1
              read(fd1[0], buffer, 21);//Lee de la pipe 1
              printf("\tHIJO RECIBE mensaje de ABUELO: %s \n", buffer);
              printf("\tHIJO ENVIA mensaje a NIETO...\n");
              
              close(fd2[0]); //Cerrar lectura de la pipe 2
              write(fd2[1], "Saludos de tu padre", 21); // Escribe en la pipe 2

              wait(NULL); //Espera a que acabe su hijo

              close(fd1[1]); //cierra escritura de la pipe 1
              read(fd1[0], buffer, 21); //Lee de la pipe 1
              printf("\tHIJO RECIBE mensaje de NIETO: %s \n", buffer);
              printf("\tHIJO ENVIA mensaje a ABUELO...\n");

              close(fd2[0]); //Cerrar lectura de la pipe 2
              write(fd2[1], "Saludos del hijo", 21); // Escribe en la pipe 2
              break;
          }
        break;
      
      default://abuelo
        printf("ABUELO ENVIA mensaje a HIJO...\n");
        close(fd1[0]); //Cerrar lectura de la pipe 1 
        write(fd1[1], "Saludos del abuelo", 21); // Escribe en la pipe 1

        wait(NULL); //Espera a que acabe su hijo

        close(fd2[1]); //cierra escritura de la pipe 2
        read(fd2[0], buffer, 21);//Lee de la pipe 2
        printf("ABUELO RECIBE mensaje de HIJO: %s \n", buffer);
        break;
    }

}