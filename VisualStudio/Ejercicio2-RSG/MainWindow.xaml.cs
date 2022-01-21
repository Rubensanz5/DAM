using System;
using System.Collections.Generic;
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

namespace Ejercicio2_RSG
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void calcular(object sender, RoutedEventArgs e)
        {
            double numero = Double.Parse(tbTemperatura.Text.ToString());
            double resultado = 0;

            if (centiaFaren.IsChecked == true)
            {
                resultado = numero * 1.8 + 32;
                resultado = Math.Round(resultado, 2);
            }
            else if (FarenaCenti.IsChecked == true)
            {
                resultado = (numero - 32) / 1.8;
                resultado = Math.Round(resultado, 2);
            }

            lbresult.Content = "Resultado: " + resultado;

        }
    }
}
