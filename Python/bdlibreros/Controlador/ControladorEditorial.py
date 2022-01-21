from Modelo.ModeloEditorial import Editorial

def accionEditorial(accion):
    if accion == '1':
        editorial = Editorial()
        lista = editorial.seleccionar()
        for x in range(0, len(lista)):
            print(lista[x])
    if accion == '2':
        codigoeditorial = input("Introduce el código de la editorial")
        nombreeditorial = input("Introduce el nombre")
        telefono = input("Introduce el telefono")
        personacontacto = input("Introduce la persona de contacto")
        emailcontacto = input("Introduce el email de contacto")
        direccion = input("Introduce la direccion")
        ciudad = input("Introduce la ciudad")
        provincia = input("Introduce la provincia")
        tiempomediosuministro = input("Introduce el tiempo medio de suministro")
        observaciones = input("Introduce observaciones")

        editorial = Editorial()
        editorial.codigoeditorial = codigoeditorial
        editorial.nombreeditorial = nombreeditorial
        editorial.telefono = telefono
        editorial.personacontacto = personacontacto
        editorial.emailcontacto = emailcontacto
        editorial.direccion = direccion
        editorial.ciudad = ciudad
        editorial.provincia = provincia
        editorial.tiempomediosuministro = tiempomediosuministro
        editorial.observaciones = observaciones

        editorial.insertar()

    if accion == '3':
        codigoeditorial = input("Introduce el código de editorial a madificar ")
        personacontacto = input("Introduce la persona de contacto")
        editorial = Editorial()
        editorial.codigoeditorial = codigoeditorial
        editorial.personacontacto = personacontacto
        editorial.modificar()

    if accion == '4':
        codigoeditorial = input("Introduce el código de editorial a eliminar ")
        editorial = Editorial()
        editorial.codigoeditorial = codigoeditorial
        editorial.borrar()