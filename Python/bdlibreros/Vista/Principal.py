from Vista.VistaAutor import menuAutor
from Vista.VistaTema import menuTema
from Vista.VistaEditorial import menuEditorial
from Vista.VistaLibro import menuLibro


def opcionMenu(accion):
    if accion == '1':
        menuAutor()
    if accion == '2':
        menuEditorial()
    if accion == '3':
        menuLibro()
    if accion == '4':
        menuTema()


def main():
    accion = '-1'
    while accion != '0':
        print("1. Autor")
        print("2. Editorial")
        print("3. Libro")
        print("4. Tema")
        accion = input("Introduce una opción. Salir 0:  ")
        opcionMenu(accion)


if __name__ == "__main__":
    main()
