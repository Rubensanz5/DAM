using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace EjemploInformeIncrustadoConFiltrosApp
{
    public class ProductoCollection : ObservableCollection<Producto>
    {
    }

    public class Producto
    {
        #region propiedades

        private int id;
        private String codigo;
        private String nombre;
        private String descripcion;
        private byte[] imagen;
        private DateTime fechaAlta;
        private decimal precio;
        private int existencias;
        private int idCategoria;
        private String nombreCategoria;

        #endregion propiedades

        #region metodos

        public Producto()
        {
            id = 0;
            codigo = "";
            nombre = "";
            descripcion = "";
            imagen = null;
            fechaAlta = DateTime.Today;
            precio = 0;
            existencias = 0;
            idCategoria = 0;
        }
        public int Id { get => id; set => id = value; }
        public string Codigo { get => codigo; set => codigo = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public byte[] Imagen { get => imagen; set => imagen = value; }
        public DateTime FechaAlta { get => fechaAlta; set => fechaAlta = value; }
        public decimal Precio { get => precio; set => precio = value; }
        public int Existencias { get => existencias; set => existencias = value; }
        public int IdCategoria { get => idCategoria; set => idCategoria = value; }
        public string NombreCategoria { get => nombreCategoria; set => nombreCategoria = value; }

        #endregion metodos

    }
}
