cadena = input("Introduce una frase ")
#contador = 0
#for letra in cadena:
#    if letra.upper() == "A":
#        contador += 1
#print("El numero de A son:", contador)

contadorAbreviado = cadena.upper().count("A")
print("El numero de A son:", contadorAbreviado)
