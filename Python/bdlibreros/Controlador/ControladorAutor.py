from Modelo.ModeloAutor import Autor, seleccionar


def accionAutor(accion):
    if accion == '1':
        autor = Autor()
        lista = seleccionar()
        for x in range(0, len(lista)):
            print(lista[x])
    if accion == '2':
        codigoautor = input("Introduce el código del autor ")
        nombre = input("Introduce el nombre ")
        apellido1 = input("Introduce el primer apellido ")
        apellido2 = input("Introduce el segundo apellido ")
        nacionalidad = input("Introduce la nacionalidad ")
        anyonacimiento = input("Introduce el año de nacimiento ")
        ciudadnacimiento = input("Introduce la ciudad de nacimiento ")
        paisnacimiento = input("Introduce el pais de nacimiento ")
        anyofallecimiento = input("Introduce el año de fallecimiento ")
        observaciones = input("Introduce observaciones ")

        autor = Autor()
        autor.codigoautor = codigoautor
        autor.nombre = nombre
        autor.apellido1 = apellido1
        autor.apellido2 = apellido2
        autor.nacionalidad = nacionalidad
        autor.anyonacimiento = anyonacimiento
        autor.ciudadnacimiento = ciudadnacimiento
        autor.paisnacimiento = paisnacimiento
        autor.anyofallecimiento = anyofallecimiento
        autor.observaciones = observaciones

        autor.insertar()

    if accion == '3':
        codigoautor = input("Introduce el código del autor ")
        anyofallecimiento = input("Introduce el año de falleciomiento ")
        autor = Autor()
        autor.codigoautor = codigoautor
        autor.anyofallecimiento = anyofallecimiento
        autor.modificar()

    if accion == '4':
        codigoautor = input("Introduce el código de autor a eliminar ")
        autor = Autor()
        autor.codigoautor = codigoautor
        autor.borrar()
