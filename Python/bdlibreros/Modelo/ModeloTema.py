import psycopg2
from bd import conexion


def seleccionar():
    try:
        with conexion.cursor() as cursor:
            cursor.execute("select * from _tema")
            return list(cursor)
    except psycopg2.Error as e:
        print("Ocurrió un error al consultar")


class Tema:
    codigotema = ""
    nombretema = ""

    def insertar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "insert into _tema values(%s, %s);"
                cursor.execute(consulta, (self.codigotema, self.nombretema))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al insertar: ", e)

    def modificar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "update _tema set nombretema = %s where codigotema = %s"
                cursor.execute(consulta, (self.nombretema, self.codigotema))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al modificar: ", e)

    def eliminar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "delete from _tema where codigotema = %s;"
                cursor.execute(consulta, (self.codigotema,))
                conexion.commit()
        except psycopg2.Error as e:
            print("Error eliminado: ", e)