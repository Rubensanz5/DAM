num = 0
suma = 0


for i in range(5):
    try:
        num = int(input("Intruduce números para irlos sumando: "))
        suma += num
    except:
        print("Escribe números")
        exit(-1)
print("La suma de tus números es:", suma)
