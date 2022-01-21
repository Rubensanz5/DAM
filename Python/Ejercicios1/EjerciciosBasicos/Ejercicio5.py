print("Introduce un numero y para acabar uno neativo")
numero = int(input("Numero: "))

while numero > 0:
    suma = 0
    for i in range(1, numero + 1):
        if numero % i == 0:
            suma = suma + i
    print("La suma de los divisores son: ", suma)
    print("Introduce un numero y para acabar uno neativo")
    numero = int(input("Numero: "))