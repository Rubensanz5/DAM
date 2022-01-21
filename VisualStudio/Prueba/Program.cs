using System;

namespace Prueba
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Introduce el primer numero");
            int num1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Introduce el segundo numero");
            int num2 = int.Parse(Console.ReadLine());
            Console.WriteLine("El resultado es: " + (num1 + num2));
        }
    }
}
