import math

num = 0

while True:
    num = int(input("Intruduce números para hacer su raiz cuadrada: "))
    if num < -1:
        print("ERROR: Introduce un número positivo")
    else:
        num = math.sqrt(num)
        break

print("La raiz cuadrada de tu número es: ", num)
