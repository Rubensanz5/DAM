using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace PROYECTO_EV1_RSG
{
	/// <summary>
	/// Lógica de interacción para Window1.xaml
	/// </summary>
	public partial class Window1 : Window
	{
		Random rdn = new Random();
		int puertaOk = 0;
		int puntuacion = 0;
		int vidas = 5;
		int p1 = 1;
		int p2 = 2;
		int p3 = 3;
		public Window1()
		{
			InitializeComponent();
		}

		//Falta cambiar bien las imagenes el acierto y el leon no salen
		//falta cuando falla salir del juego

		private void comprobar(object sender, RoutedEventArgs e)
		{
			puertaOk = rdn.Next(1, 4);

			Uri puerta = new Uri("img/puerta.jpg", UriKind.Relative);
			Uri acierto = new Uri("img/acierto.jpg", UriKind.Relative);
			Uri leon = new Uri("img/leon.jpg", UriKind.Relative);

			if (vidas > 0)
			{
				if (rdPuerta1.IsChecked == true)
				{
					if (puertaOk == p1)
					{
						pt1.Source = new BitmapImage(acierto);
						puntuacion++;
						lbPuntuacion.Content = "Puntuación: " + puntuacion;

						MessageBox.Show("¡Enhorabuena sumaste 1 punto!", "Sumas punto", MessageBoxButton.OK, MessageBoxImage.Asterisk);

					}
					else
					{
						vidas--;
						pt1.Source = new BitmapImage(leon);
						MessageBox.Show("¡Has perdido 1 vida! Ten cuidado", "Pierdes vida", MessageBoxButton.OK, MessageBoxImage.Error);
						lbvidasN.Content = "Vidas: " + vidas;
					}


					pt1.Source = new BitmapImage(puerta);
					rdPuerta1.IsChecked = false;

				}
				else if (rdPuerta2.IsChecked == true)
				{
					if (puertaOk == p2)
					{
						pt2.Source = new BitmapImage(acierto);
						puntuacion++;
						lbPuntuacion.Content = "Puntuación: " + puntuacion;
						MessageBox.Show("¡Enhorabuena sumaste 1 punto!", "Sumas punto", MessageBoxButton.OK, MessageBoxImage.Asterisk);
					}
					else
					{
						vidas--;
						pt2.Source = new BitmapImage(leon);
						MessageBox.Show("¡Has perdido 1 vida! Ten cuidado", "Pierdes vida", MessageBoxButton.OK, MessageBoxImage.Error);
						lbvidasN.Content = "Vidas: " + vidas;
					}
					pt2.Source = new BitmapImage(puerta);
					rdPuerta2.IsChecked = false;
				}
				else if (rdPuerta3.IsChecked == true)
				{
					if (puertaOk == p3)
					{
						pt3.Source = new BitmapImage(acierto);
						puntuacion++;
						lbPuntuacion.Content = "Puntuación: " + puntuacion;
						MessageBox.Show("¡Enhorabuena sumaste 1 punto!", "Sumas punto", MessageBoxButton.OK, MessageBoxImage.Asterisk);
					}
					else
					{
						vidas--;
						pt3.Source = new BitmapImage(leon);
						MessageBox.Show("¡Has perdido 1 vida! Ten cuidado", "Pierdes vida", MessageBoxButton.OK, MessageBoxImage.Error);
						lbvidasN.Content = "Vidas: " + vidas;

					}
					pt3.Source = new BitmapImage(puerta);
					rdPuerta3.IsChecked = false;
				}

			}
			if (vidas == 0)
			{
				if (puntuacion <= 5)
				{
					MessageBox.Show("GAME OVER...\nTe has quedado sin vidas\nLo puedes hacer mejor...", "GAME OVER", MessageBoxButton.OK, MessageBoxImage.Warning);
				}
				else if (puntuacion < 10 && puntuacion > 5)
				{
					MessageBox.Show("GAME OVER...\nTe has quedado sin vidas\nNo esta nada mal...", "GAME OVER", MessageBoxButton.OK, MessageBoxImage.Warning);
				}
				else
				{
					MessageBox.Show("GAME OVER...\nTe has quedado sin vidas\nSigue asi :)", "GAME OVER", MessageBoxButton.OK, MessageBoxImage.Warning);
				}

				volverJugar();

			}

		}

		private void volvermenu_Click(object sender, RoutedEventArgs e)
		{
			this.Close();
		}

		private void volverJugar()
		{
			MessageBoxResult opciones = MessageBox.Show("¿Quieres volver a jugar?", "Reintentar", MessageBoxButton.YesNo, MessageBoxImage.Question);

			switch (opciones)
			{
				case MessageBoxResult.Yes:
					puntuacion = 0;
					lbPuntuacion.Content = "Puntuación: " + puntuacion;
					vidas = 5;
					lbvidasN.Content = "Vidas: " + vidas;
					break;
				case MessageBoxResult.No:
					this.Close();
					break;
			}
		}
	}
}
