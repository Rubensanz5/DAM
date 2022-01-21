
import psycopg2
from bd import conexion


class Libro:
    isbn = ""
    titulo = ""
    anyoedicion = 0
    lugaredicion = ""
    precioventa = 0.0
    numeropaginas = 0
    estanteria = ""
    numeroejemplares = 0
    observaciones = ""
    fotoportada = ""
    miniaturaportada = ""
    codigotema = ""
    codigoautor = ""
    codigoeditorial = ""

    def seleccionar(self):
        try:
            with conexion.cursor() as cursor:
                cursor.execute("select * from _libro;")
                return list(cursor)
        except psycopg2.Error as e:
            print("Ocurrió un error al consultar: ", e)

    def insertar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "insert into _libro (isbn, titulo, anyoedicion, lugaredicion, precioventa, numeropaginas, " \
                           "estanteria, numeroejemplares, observaciones, " \
                           "codigotema, codigoautor, codigoeditorial) " \
                           "values(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s ,%s, %s)"

                cursor.execute(consulta, (self.isbn, self.titulo, int(self.anyoedicion), self.lugaredicion,
                                          float(self.precioventa), int(self.numeropaginas), self.estanteria,
                                          int(self.numeroejemplares), self.observaciones,
                                          self.codigotema, self.codigoautor,
                                          self.codigoeditorial))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al insertar: ", e)

    def borrar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "delete from _libro where isbn = %s;"
                cursor.execute(consulta, (self.isbn,))
                conexion.commit()
        except psycopg2.Error as e:
            print("Error eliminado: ", e)

    def actualizar(self):
        try:
            with conexion.cursor() as cursor:
                consulta = "update _libro set numeroejemplares = %s  where isbn = %s;"
                cursor.execute(consulta, (int(self.numeroejemplares), self.isbn))
                conexion.commit()
        except psycopg2.Error as e:
            print("Ocurrió un error al insertar: ", e)
