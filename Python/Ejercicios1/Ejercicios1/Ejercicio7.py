def introducirNombres():
    for i in range(filas):
        for j in range(columnas):
            print("Para la posicion ", i, j)
            nombre = input("Introduce un nombre: ")
            tabla[i][j] = nombre


def verResultados():
    for i in range(filas):
        for j in range(columnas):
            print(f"El nombre es {tabla[i][j]}"
                  + f" Su longitud es {len(tabla[i][j])}")


filas = int(input("Introduce numero de filas:"))
columnas = int(input("Introduce numero de columnas:"))

tabla = [[0 for i in range(columnas)] for j in range(filas)]

introducirNombres()
verResultados()