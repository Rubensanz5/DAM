num = 0

while True:
    num = int(input("Intruduce un numero para poner el numero de filas: "))
    if num < 0:
        print("Introduce un número positivo")
    else:
        break

simbolo = ""

while True:
    simbolo = input("Introduce un símbolo para hacer el dibujo: ")
    if len(simbolo) > 1:
        print("Intruduce solo un caracter")
    else:
        break

for i in range(num):
    dibujo = ""
    for j in range(num):
        dibujo += simbolo
    print(dibujo)
