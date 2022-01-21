numeros = []

numComparar = 0

print("Introduce 5 números")
for i in range(5):
    num = input(f"Número {i + 1}: ")
    numeros.append(num)

for i in range(0, len(numeros)):
    numeros[i] = int(numeros[i])

numComparar = int(input("Introduce el numero con el que se compararán: "))

numMayores = []

for i in range(len(numeros)):
    if numeros[i] > int(numComparar):
        numMayores.append(numeros[i])

if len(numMayores) == 0:
    print("No hay números mayores al número introducido")
else:
    print("El/los numeros mayores al dato comaprado es: ")
    for i in range(len(numMayores)):
        print(numMayores[i])
