anio = int(input("Ingresaun año para saber si es bisiesto: "))

if anio % 4 == 0 and (anio % 100 != 0 or anio % 400 == 0):
    print("Es bisiesto")
else:
    print("No es bisiesto")
