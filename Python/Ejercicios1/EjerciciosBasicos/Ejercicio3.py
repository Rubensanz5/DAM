num = int(input("Ingresa un numero para saber si es par o no: "))

par_Impar = {
    1: 'Impar',
    2: 'Par',
    3: 'Impar',
    4: 'Par',
    5: 'Impar',
    6: 'Par',
    7: 'Impar',
    8: 'Par',
    9: 'Impar',
    10: 'Par'
}
print(par_Impar.get(num, "Numero fuera de rango"))

