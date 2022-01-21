using System;
using System.Collections;

namespace EjercicioOpc4
{
	class Program
	{
		static void Main(string[] args)
		{
			try
			{
				int[] numeros = new int[5];
				int numComparar;

				for (int i = 0; i < numeros.Length; i++)
				{
					Console.WriteLine("Dime un numero: ");
					numeros[i] = int.Parse(Console.ReadLine());
				}

				Console.WriteLine("Escribe el numero con el que quieres comparar");
				numComparar = int.Parse(Console.ReadLine());

				//ArrayList int[] numMayores = new int[5];
				ArrayList numMayores = new ArrayList();
				for (int i = 0; i < numeros.Length; i++)
				{
					if (numeros[i] > numComparar)
					{
						numMayores.Add(numeros[i]);
					}
				}

				if (numMayores.Count == 0)
				{
					Console.WriteLine("No hay numeros mayores al dato comaprado");
				}
				else
				{

					Console.WriteLine("El/los numeros mayores al dato comaprado es: ");
					foreach (int num in numMayores)
					{
						Console.WriteLine(num + "\n");
					}
				}
			}
			catch (Exception)
			{
				Console.WriteLine("Escribe numeros no caracteres");
			}
		}
	}
}
