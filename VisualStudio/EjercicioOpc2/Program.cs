using System;

namespace EjercicioOpc2
{
	class Program
	{
		static void Main(string[] args)
		{
			try
			{
				int num;
				do
				{
					Console.WriteLine("Introduce un numero para hacer la raiz cuadrada: ");
					num = int.Parse(Console.ReadLine());
					if (num < 0)
					{
						Console.WriteLine("Tiene que ser positivo");
					}
				} while (num < 0);

				Console.WriteLine("La raiz cuadrada de tu numero: " + num + " es: " + Math.Sqrt(num));

			}
			catch (Exception) 
			{
				Console.WriteLine("Introduce un numero");
			}
		}
	}
}
