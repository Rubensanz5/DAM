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

namespace Ejercicio3_RSG
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

		private void verificar(object sender, RoutedEventArgs e)
		{
			bool error = false;
			String msgError = "";
			if (cbTratamiento.Text.Equals(""))
			{
				msgError = "Debes selecicionar el tratamiento del alumno/a";
				error = true;
			}
			else if (tbNombre.Text.Equals("") || tb1Apellido.Text.Equals(""))
			{
				msgError = "Introduce al menos el nombre y el primer apellido";
				error = true;
			}
			else if (chAD.IsChecked == false && chSGE.IsChecked == false && chPSP.IsChecked == false 
				&& chDI.IsChecked == false && chEIE.IsChecked == false && chPMDM.IsChecked == false)
			{
				msgError = "Selecciona al menos un módulo";
				error = true;
			}

			if (error)
			{
				MessageBox.Show(msgError, "Error de Entrada", MessageBoxButton.OK, MessageBoxImage.Error);
			}
			else 
			{
				String apellido2 = "";
				if (!tb2Apellido.Text.Equals(""))
				{
					apellido2 = tb2Apellido.Text.ToString();
				}

				String tratamiento = "";
				if (cbTratamiento.Text.ToString().Equals("Alumno"))
				{
					tratamiento = "El alumno ";
				}
				else 
				{
					tratamiento = "La alumna ";
				}

				String modulos = "";
				if (chAD.IsChecked == true)
				{
					modulos = modulos + "*" + chAD.Content.ToString() + "\n";
				}
				if (chDI.IsChecked == true)
				{
					modulos = modulos + "*" + chDI.Content.ToString() + "\n";
				}
				if (chSGE.IsChecked == true)
				{
					modulos = modulos + "*" + chSGE.Content.ToString() + "\n";
				}
				if (chEIE.IsChecked == true)
				{
					modulos = modulos + "*" + chEIE.Content.ToString() + "\n";
				}
				if (chPSP.IsChecked == true)
				{
					modulos = modulos + "*" + chPSP.Content.ToString() + "\n";
				}
				if (chPMDM.IsChecked == true)
				{
					modulos = modulos + "*" + chPMDM.Content.ToString() + "\n";
				}

				MessageBox.Show(tratamiento + tbNombre.Text.ToString() + " " + tb1Apellido.Text.ToString() + " " + apellido2 + " se ha matriculado de\nlos módulos siguientes:\n" + modulos,
					"Módulos Matriculados" , MessageBoxButton.OK, MessageBoxImage.Information);
			}

		}

		private void salir(object sender, RoutedEventArgs e)
		{
			Close();
		}
	}
}
