from builtins import print


def PedirNum():
    num = -1
    while num < 1:
        try:
            num = int(input("Intruduce un número positivo: "))
        except NotImplementedError:
            print("ERROR: Introduce un número positivo")
    return num


def EsMultiplo(numer1, numer2):
    return numer1 % numer2 == 0 or numer2 % numer1 == 0


num1 = PedirNum()
num2 = PedirNum()
if EsMultiplo(num1, num2):
    print("Un num es multiplo del otro")
else:
    print("No son multiplos")
