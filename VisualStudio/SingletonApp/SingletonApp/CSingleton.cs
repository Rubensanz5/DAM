using System;
using System.Collections.Generic;
using System.Text;

namespace SingletonApp
{
    class CSingleton
    {
        // Guardar la única instancia que va a existir
        private static CSingleton instancia;

        // Datos propios de la clase
        private string nombre;
        private int edad;

        // Creación del constructor privado
        private CSingleton()
        {
            nombre = "Sin asignar";
            edad = 999;
        }

        public static CSingleton ObtenerInstancia()
        {
            // Verificamos si no existe la instancia
            if (instancia == null)
            {
                // Si no existe, instanciamos
                instancia = new CSingleton();
                Console.WriteLine("--- Instancia creada por primera vez ---");
            }

            // Devolvemos la instancia
            return instancia;
        }

        // Métodos propios de la clase
        public override string ToString()
        {
            return string.Format("La persona {0} tiene la edad de {1} años", nombre, edad);
        }

        public void PonerDatos(string pNombre, int pEdad)
        {
            nombre = pNombre;
            edad = pEdad;
        }

        public void AlgunProceso()
        {
            Console.WriteLine("{0} está trabajando en algo", nombre);
        }
    }
}
