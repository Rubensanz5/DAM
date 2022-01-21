using System;

namespace EjercicioOpc1
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Console.WriteLine("Escribe el numero 1: ");
                double num1 = double.Parse(Console.ReadLine());

                Console.WriteLine("Escribe el numero 2: ");
                double num2 = double.Parse(Console.ReadLine());

                Console.WriteLine("Escribe el numero 3: ");
                double num3 = double.Parse(Console.ReadLine());

                Console.WriteLine("Escribe el numero 4: ");
                double num4 = double.Parse(Console.ReadLine());

                Console.WriteLine("Escribe el numero 5: ");
                double num5 = double.Parse(Console.ReadLine());

                double suma = num1 + num2 + num3 + num4 + num5;
                Console.WriteLine("La suma de los numeros es: " + suma);

                double media = suma / 5;
                Console.WriteLine("La suma de los tus 5 numeros es: " + media);

            } catch (System.FormatException) {
                Console.WriteLine("ERROR: Tienes que escribir un numero");
            }
        }
    }
}
