primerNum = 2
segundoNum = 1000
contador = 0
for i in range(primerNum, segundoNum + 1):
    primo = True
    j = 2
    while (i > j) and primo:
        if i % j == 0:
            primo = False
            break
        else:
            j += 1

    if primo:
        print(i, "es primo.")
        contador += 1

print(f"El numero total de primos entre {primerNum - 1} y {segundoNum} es {contador}")
