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

namespace Saludar_RSG
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private String nombre = "";
        private String apellido1 = "";
        private String apellido2 = "";

        public MainWindow()
        {
            InitializeComponent();
        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            nombre = tbNombre.Text;
            apellido1 = tbApellido1.Text;
            apellido2 = tbApellido2.Text;

            if (nombre.Equals("") && apellido1.Equals(""))
            {
                MessageBox.Show("Debes introducir al menos nombre y primer apellido");
            }
            else
            {
                if (!nombre.Equals("") && !apellido1.Equals("") && !apellido2.Equals(""))
                {
                    MessageBox.Show("Hola " + nombre + " " + apellido1 + " " + apellido2 + " ¿Que tal estas?");
                }
                else 
                {
                    MessageBox.Show("Hola " + nombre + " " + apellido1 + " ¿Que tal estas?");
                }
            }
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            Close();
        }
    }
}
