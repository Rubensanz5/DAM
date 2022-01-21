from Controlador.ControladorAutor import accionAutor


def menuAutor():
    accion = '-1'
    while accion != '0':
        print("1. Seleccionar todos")
        print("2. Insertar")
        print("3. Modificar")
        print("4. Borrar")
        accion = input("Selecciona una opción. Salir: 0  ")
        accionAutor(accion)
