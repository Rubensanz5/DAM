using System;

namespace SingletonApp
{
    class Program
    {
        static void Main(string[] args)
        {
            // No se puede obtener la instancia directamente
            // CSingleton single = new Csingleton();
            // Obtener la instancia. Se crea la primera vez
            CSingleton uno = CSingleton.ObtenerInstancia();

            // Hacemos algo con la instancia
            uno.PonerDatos("Pedro", 25);
            uno.AlgunProceso();
            Console.WriteLine(uno);
            Console.WriteLine("----------");
            CSingleton dos = CSingleton.ObtenerInstancia();
            dos.AlgunProceso();
            Console.WriteLine(dos);
            Console.WriteLine("----------");
        }
    }
}


