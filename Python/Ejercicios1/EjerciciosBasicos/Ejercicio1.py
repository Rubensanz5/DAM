sueldo = float(input("Introduce el sueldo: "))

if sueldo < 1000:
    sueldo += sueldo * 0.15
elif 1000 <= sueldo <= 2000:
    sueldo += sueldo * 0.05
else:
    sueldo -= sueldo * 0.05

print("Tu nuevo sueldo es ", sueldo)
