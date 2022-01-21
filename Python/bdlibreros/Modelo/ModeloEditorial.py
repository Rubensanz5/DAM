import psycopg2
from bd import conexion

class Editorial:
    codigoeditorial = 0
    nombreeditorial = ""
    telefono = ""
    personacontacto = ""
    emailcontacto = ""
    direccion = 0
    ciudad = ""
    provincia = ""
    tiempomediosuministro =""
    observaciones = ""

    def seleccionar(self):
        try:
            with conexion.cursor() as cursor:
                cursor.execute("select * from _editorial;")
                return list(cursor)
        except psycopg2.Error as e:
            print("Ocurrió un error al consultar: ", e)

    def insertar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "insert into _editorial values(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s);"
                cursor.execute(consulta, (self.codigoeditorial, self.nombreeditorial, self.telefono, self.personacontacto,
                                            self.emailcontacto, self.direccion, self.ciudad,
                                            self.provincia, int(self.tiempomediosuministro), self.observaciones))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al insertar: ", e)

    def modificar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "update _editorial set personacontacto = %s where codigoeditorial = %s;"
                cursor.execute(consulta, (self.personacontacto, self.codigoeditorial))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al actualizar: ", e)

    def borrar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "delete from _editorial where codigoeditorial = %s;"
                cursor.execute(consulta, (self.codigoeditorial,))
                conexion.commit()
        except psycopg2.Error as e:
            print("Error eliminado: ", e)