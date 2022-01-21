using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace TablasDinamicasApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        List<Object> lista = new List<Object>();

        public MainWindow()
        {
            InitializeComponent();

            cargarTabla(null);
        }

        private void btnBuscar_Click(object sender, RoutedEventArgs e)
        {
            string dato = txtCampo.Text;
            cargarTabla(dato);
        }
        private void cargarTabla(string dato)
        {
            ProductoCollection lista = new ProductoCollection();
            ControladorProductos ctrlProductos = new ControladorProductos();
            DataTable dt = new DataTable();
            dt.Columns.Add("Código");
            dt.Columns.Add("Nombre");
            dt.Columns.Add("Descripción");
            dt.Columns.Add("Fecha Alta");
            dt.Columns.Add("Precio");
            dt.Columns.Add("Existencias");
            dt.Columns.Add("Categoría");

            dataGrid1.ItemsSource = null;

            try
            {
                lista = ctrlProductos.consultar(dato);
            }
            catch (Exception ex)
            {
                dataGrid1.ItemsSource = dt.DefaultView;

                if (MessageBox.Show(ex.Message) == MessageBoxResult.OK)
                {
                    txtCampo.Text = "";
                }
            } 

            foreach (Producto producto in lista)
            {
                dt.Rows.Add(producto.Codigo,
                            producto.Nombre,
                            producto.Descripcion,
                            producto.FechaAlta.ToShortDateString(),
                            producto.Precio,
                            producto.Existencias,
                            producto.NombreCategoria
                            );
            }
            dataGrid1.ItemsSource = dt.DefaultView;
        }
    }
}
