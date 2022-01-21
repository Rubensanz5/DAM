using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace ObservableCollectionApp
{
    public class TareaCollection : ObservableCollection<Tarea>
    {

    }

    public class Tarea
    {
        private string nombre;
        private DateTime fecha = DateTime.Today;
        public string Nombre { 
            get { return nombre; }
            set { nombre = value; } 
        }

        public DateTime Fecha
        {
            get { return fecha; }
            set { fecha = value; }
        }

        public string Datos
        {
            get { return nombre + " - " + fecha.ToShortDateString(); }
        }
    }
}
