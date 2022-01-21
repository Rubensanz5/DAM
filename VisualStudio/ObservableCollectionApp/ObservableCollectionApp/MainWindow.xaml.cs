using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace ObservableCollectionApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private TareaCollection tareas;
        public MainWindow()
        {
            InitializeComponent();

            tareas = new TareaCollection();

            tareas.CollectionChanged += (s, e) =>
            {
                if (e.NewItems != null)
                {
                    tbUltimo.Text = ((Tarea)e.NewItems[0]).Datos;
                }
            };

            lvTareas.ItemsSource = tareas;
            cbTareas.ItemsSource = tareas;
        }

        public void AnadirTarea(object sender, RoutedEventArgs e)
        {
            if (txtNombre.Text != string.Empty)
            {
                tareas.Add(new Tarea() { Nombre = txtNombre.Text });
                txtNombre.Text = string.Empty;
                txtNombre.Focus();
            }
        }
    }
}
