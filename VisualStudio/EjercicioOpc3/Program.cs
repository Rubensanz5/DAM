using System;

namespace EjercicioOpc3
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
                    Console.WriteLine("Introduce un numero para dibujar: ");
                    num = int.Parse(Console.ReadLine());

                    if (num < 0)
                    {
                        Console.WriteLine("Tiene que ser positivo");
                    }
                } while (num < 0);

                
                String simbolo;
                do
                {
                    Console.WriteLine("Introcude un simbolo para hacer el dibujo: ");
                    simbolo = Console.ReadLine();
                } while ( simbolo.Length > 1);

                for (int i = 0; i < num; i++)
                {
                    String dibujo = "";
                    for (int j = 0; j < num; j++)
                    {
                        dibujo += simbolo;
                    }
                    Console.WriteLine(dibujo);
                }
            }
            catch (Exception)
            {
                Console.WriteLine("Escribe lo que pide correctamente");
            }
        }
    }
}
