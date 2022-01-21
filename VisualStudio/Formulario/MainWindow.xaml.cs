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

namespace Formulario
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

		private void enviar(object sender, RoutedEventArgs e)
		{
			String idiomo = "";
			if (espanol.IsChecked == true) 
			{
				idiomo = espanol.Content.ToString();
			} else if (ingles.IsChecked == true) {
				idiomo = ingles.Content.ToString();
			} else if (frances.IsChecked == true) {
				idiomo = frances.Content.ToString();
			}

			String repetidor;
			if (repetir.IsChecked == true)
			{
				repetidor = " Estas repitiendo curso ";
			}
			else 
			{
				repetidor = " no repites curso ";
			}

			MessageBox.Show(nombreTb.Text.ToString() + " " + apellidoTb.Text.ToString() + " Cursas el grado: " + gradoTb.Text.ToString()
							+ " tu fecha de nacimiento es: " + fecha.Text + " tu idiomo es: " + idiomo 
							+ repetidor + " Las asignaturas que cursas son: " + asignaturas.Content.ToString(), "info cruck equis de", MessageBoxButton.OK, MessageBoxImage.Information);
		}
	}
}
