import psycopg2
from bd import conexion


def seleccionar():
    try :
        with conexion.cursor() as cursor:
            cursor.execute("select * from _autor;")
            return list(cursor)
    except psycopg2.Error as e:
        print("Ocurrió un error al consultar: ", e)


class Autor:
    codigoautor = ""
    nombre = ""
    apellido1 = ""
    apellido2 = ""
    nacionalidad = ""
    anyonacimiento = 0
    ciudadnacimiento = ""
    paisnacimiento = ""
    anyofallecimiento = 0
    observaciones = ""

    def insertar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "insert into _autor values(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s);"
                cursor.execute(consulta, (self.codigoautor, self.nombre, self.apellido1, self.apellido2,
                                            self.nacionalidad, int(self.anyonacimiento), self.ciudadnacimiento,
                                            self.paisnacimiento, int(self.anyofallecimiento), self.observaciones))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al insertar: ", e)

    def modificar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "update _autor set anyofallecimiento = %s where codigoautor = %s"
                cursor.execute(consulta, (self.anyofallecimiento, self.codigoautor))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al modificar: ", e)

    def borrar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "delete from _autor where codigoautor = %s"
                cursor.execute(consulta, (self.codigoautor,))
                conexion.commit()
        except psycopg2.Error as e:
            print("Error eliminado: ", e)

