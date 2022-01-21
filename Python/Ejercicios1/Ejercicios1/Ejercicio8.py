num = -1
lista = []

while num < 1:
    try:
        num = int(input("Intruduce un número positivo: "))
    except NotImplementedError:
        print("ERROR: Introduce un número positivo")

for i in range(1, num + 1):
    if num % i == 0:
        lista.append(i)

print(f"Los divisores de {num} son: {lista}")
print(f"La cantidad de divisores son {len(lista)}")
