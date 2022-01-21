from Modelo.ModeloLibro import Libro


def accionLibro(accion):
    if accion == '1':
        libro = Libro()
        lista = libro.seleccionar()
        for x in range(0, len(lista)):
            print(lista[x])
    if accion == '2':
        isbn = input("Introduce el isbn del libro")
        titulo = input("Introduce el titulo del libro")
        anyoedicion = input("Introduce el anyoedicion del libro")
        lugaredicion = input("Introduce el lugaredicion del libro")
        precioventa = input("Introduce el precio de venta del libro")
        numeropaginas = input("Introduce el numero de paginas del libro")
        estanteria = input("Introduce la estanteria del libro")
        numeroejemplares = input("Introduce el numero de ejemplares del libro")
        observaciones = input("Introduce la observaciones del libro")
        codigotema = input("Introduce el codigo tema del libro")
        codigoautor = input("Introduce el codigo autor del libro")
        codigoeditorial = input("Introduce el codigo editorial del libro")

        libro = Libro()
        libro.isbn = isbn
        libro.titulo = titulo
        libro.anyoedicion = anyoedicion
        libro.lugaredicion = lugaredicion
        libro.precioventa = precioventa
        libro.numeropaginas = numeropaginas
        libro.estanteria = estanteria
        libro.numeroejemplares = numeroejemplares
        libro.observaciones = observaciones
        libro.fotoportada = 0
        libro.miniaturaportada = 0
        libro.codigotema = codigotema
        libro.codigoautor = codigoautor
        libro.codigoeditorial = codigoeditorial

        libro.insertar()
    if accion == '3':
        isbn = input("Introduce el isbn del libro")
        numeroejemplares = input("Introduce el numero de ejemplares del libro")
        libro = Libro()
        libro.isbn = isbn
        libro.numeroejemplares = numeroejemplares
        libro.actualizar()


    if accion == '4':
        isbn = input("Introduce el isbn del libro")
        libro = Libro()
        libro.isbn = isbn
        libro.borrar()
