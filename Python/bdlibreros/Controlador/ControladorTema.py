from Modelo.ModeloTema import Tema, seleccionar


def accionTema(accion):
    if accion == '1':
        lista = seleccionar()
        for x in range(0, len(lista)):
            print(lista[x])
    if accion == '2':
        codigotema = input("Introduce el código del tema")
        nombretema = input("Introduce el nombre del tema")
        tema = Tema()
        tema.codigotema = codigotema
        tema.nombretema = nombretema
        tema.insertar()
    if accion == '3':
        codigotema = input("Introduce el código del tema")
        nombretema = input("Introduce el nombre del tema nuevo")
        tema = Tema()
        tema.codigotema = codigotema
        tema.nombretema = nombretema
        tema.modificar()
    if accion == '4':
        codigotema = input("Introduce el código del tema")
        tema = Tema()
        tema.codigotema = codigotema
        tema.eliminar()
