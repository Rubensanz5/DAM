using System;
using System.ComponentModel;
using System.Windows.Media.Imaging;
using CRUD_MVVMApp.Core;
using CRUD_MVVMApp.Models;
using Microsoft.Win32;

namespace CRUD_MVVMApp.ViewModels
{
    public class DatosProductoViewModel : INotifyPropertyChanged
    {
        private int id;
        private String codigo;
        private String nombre;
        private String descripcion;
        private BitmapImage imagen;
        private DateTime fechaAlta;
        private decimal precio;
        private int existencias;
        private int idCategoria;

        public DatosProductoViewModel()
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

        public int Id
        {
            get { return id; }
            set
            {
                id = value;
                OnPropertyChanged("Id");
            }
        }
        public string Codigo
        {
            get { return codigo; }
            set
            {
                codigo = value;
                OnPropertyChanged("Codigo");
            }
        }
        public string Nombre
        {
            get { return nombre; }
            set
            {
                nombre = value;
                OnPropertyChanged("Nombre");
            }
        }
        public string Descripcion
        {
            get { return descripcion; }
            set
            {
                descripcion = value;
                OnPropertyChanged("Descripcion");
            }
        }
        public BitmapImage Imagen
        {
            get {
                return imagen;
            }
            set
            {
                imagen = value;
                OnPropertyChanged("Imagen");
            }
        }
        public DateTime FechaAlta
        {
            get { return fechaAlta; }
            set
            {
                fechaAlta = value;
                OnPropertyChanged("FechaAlta");
            }
        }
        public decimal Precio
        {
            get { return precio; }
            set
            {
                precio = value;
                OnPropertyChanged("Precio");
            }
        }
        public int Existencias
        {
            get { return existencias; }
            set
            {
                existencias = value;
                OnPropertyChanged("Existencias");
            }
        }
        public int IdCategoria
        {
            get { return idCategoria; }
            set
            {
                idCategoria = value;
                OnPropertyChanged("idCategoria");
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string property)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(property));
            }
        }

        #region CRUD
        public void buscarProducto()
        {
            Producto producto = new Producto();

            try
            {
                producto = producto.buscarProducto(Codigo);
            
                Id = producto.Id;
                Codigo = producto.Codigo;
                Nombre = producto.Nombre;
                Descripcion = producto.Descripcion;
                if (producto.Imagen != null)
                {
                    Imagen =
                        Utils.ConvertByteArrayToBitmapImage(producto.Imagen);
                }
                else
                {
                    Imagen = null;
                }
                FechaAlta = producto.FechaAlta;
                Precio = producto.Precio;
                Existencias = producto.Existencias;
                IdCategoria = producto.IdCategoria;

            }
            catch (Exception e)
            {
                throw new Exception("Consulta Producto - "+e.Message);
            }
        }

        public void guardarProducto()
        {
            try
            {
                Producto producto = new Producto();

                producto.Id = Id;
                producto.Codigo = Codigo;
                producto.Nombre = Nombre;
                producto.Descripcion = Descripcion;

                if (Imagen != null)
                {
                    producto.Imagen =
                        Utils.ConvertBitmapImageToByteArray(Imagen);
                }
                else
                {
                    producto.Imagen = null;
                }

                producto.FechaAlta = FechaAlta;
                producto.Precio = Precio;
                producto.Existencias = Existencias;
                producto.IdCategoria = IdCategoria;
               
                if (!producto.guardarProducto(producto))
                {
                    // producto no guardado correctamente
                    throw new Exception("Fallo al Guardar Producto");
                }
            }
            catch (Exception e)
            {
                throw new Exception("Guardar Producto - " + e.Message);
            }
        }

        public void actualizarProducto()
        {
            try
            {
                Producto producto = new Producto();

                producto.Id = Id;
                producto.Codigo = Codigo;
                producto.Nombre = Nombre;
                producto.Descripcion = Descripcion;

                if (Imagen != null)
                {
                    producto.Imagen =
                        Utils.ConvertBitmapImageToByteArray(Imagen);
                }
                else
                {
                    producto.Imagen = null;
                }

                producto.FechaAlta = FechaAlta;
                producto.Precio = Precio;
                producto.Existencias = Existencias;
                producto.IdCategoria = IdCategoria;

                if (!producto.actualizarProducto(producto))
                {
                    // producto no guardado correctamente
                    throw new Exception("Fallo al Actualizar Producto");
                }
            }
            catch (Exception e)
            {
                throw new Exception("Actualizar Producto - " + e.Message);
            }
        }

        public void eliminarProducto()
        {
            try
            {
                Producto producto = new Producto();

                producto.Codigo = Codigo;
               
                if (!producto.eliminarProducto(producto))
                {
                    // producto no eliminado correctamente
                    throw new Exception("Fallo al Eliminar Producto");
                }
            }
            catch (Exception e)
            {
                throw new Exception("Eliminar Producto - " + e.Message);
            }
        }
        #endregion CRUD

        #region Inicializacion
        public void limpiar()
        {
            Id = 0;
            Codigo = "";
            Nombre = "";
            Descripcion = "";
            Imagen = null;
            FechaAlta = DateTime.Today;
            Precio = 0;
            Existencias = 0;
            IdCategoria = 0;
        }
        #endregion Inicializacion

        #region Imagenes
        public void CargarImagen()
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Title = "Seleccionar imágen";
            openFileDialog.Filter = "Imagenes| *.jpg; *.jpeg; *.png; *.gif";
            openFileDialog.InitialDirectory =
                Environment.GetFolderPath(Environment.SpecialFolder.MyPictures);

            if (openFileDialog.ShowDialog() == true)
            {
                Uri fileUri = new Uri(openFileDialog.FileName);
                Imagen = new BitmapImage(fileUri);
            }
        }
        #endregion Imagenes

        #region Categorias
        public CategoriaCollection cargarCategorias()
        {
            CategoriaCollection obsCategorias = new CategoriaCollection();

            // llamar y obtener las categorias

            obsCategorias = obsCategorias.cargarCategorias();

            return obsCategorias;
        }
        #endregion Categorias
    }
}
