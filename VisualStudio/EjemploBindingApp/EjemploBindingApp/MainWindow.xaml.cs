using System.ComponentModel;
using System.Windows;

namespace EjemploBindingApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Clase objeto = new Clase();

        public MainWindow()
        {
            InitializeComponent();
   
            this.DataContext = objeto;
            objeto.Propiedad = "25";
        }

        private void btnMostrar_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show(objeto.Propiedad);
        }

        private void btnCambiar_Click(object sender, RoutedEventArgs e)
        {
            objeto.Propiedad = "350";
        }

        private void btnCambiar2_Click(object sender, RoutedEventArgs e)
        {
            objeto.Propiedad = "25";
        }
    }

    public class Clase : INotifyPropertyChanged
    {
        private string propiedad = "";

        public string Propiedad { 
            get { return propiedad; }
            set
            {
                propiedad = value;
                OnPropertyChanged("propiedad");
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
    }
}
