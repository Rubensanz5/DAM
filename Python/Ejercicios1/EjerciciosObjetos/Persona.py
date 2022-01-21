class Persona:
    def __init__(self, nombre, edad):
        self.__nombre = nombre
        self.__edad = edad


p1 = Persona("Ruben", 23)
print(p1.nombre)
p1.nombre = "Pepe"
print(p1.nombre)
