using System;

namespace EjercicioOpc5
{
	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Escribe una frase para saber cuantas letras A hay: ");
			String cadena = Console.ReadLine();
			char [] letras = cadena.ToCharArray();
			int letraA = 0;
			for (int i = 0; i< cadena.Length; i++) 
			{
				if (letras[i].Equals('a') || letras[i].Equals('A')) {
					letraA ++;
				}
			}
			Console.WriteLine("La cadena tiene " + letraA + " letras A");
		}
	}
}
