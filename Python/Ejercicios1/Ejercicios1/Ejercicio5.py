import random

numAzar = random.randint(1, 100)

intentos = 7
acertado = False

while intentos >= 0 and acertado == False:
    num = int(input("Introduce un numero entero del 1 al 100: "))
    if num < numAzar:
        print("Te has quedado corto")
    elif num > numAzar:
        print("Te has pasado")
    else:
        print("Has acertado")
        acertado = True
    intentos = intentos - 1

if acertado:
    print("Has ganado")
else:
    print("El numero era:", numAzar)
