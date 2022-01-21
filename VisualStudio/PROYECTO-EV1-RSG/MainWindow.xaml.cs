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

namespace PROYECTO_EV1_RSG
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

		private void salirmenu_Click(object sender, RoutedEventArgs e)
		{
			this.Close();
		}

		private void jugarmenu_Click(object sender, RoutedEventArgs e)
		{
			MessageBoxResult opciones = MessageBox.Show("¿Quieres jugar en modo facil?\n(Si -> modo facil / NO -> modo dificil)", "Modo de juego", MessageBoxButton.YesNo, MessageBoxImage.Question);

			switch (opciones)
			{
				case MessageBoxResult.Yes:
					Window2 juegoF = new Window2();
					juegoF.Owner = this;
					juegoF.ShowDialog();
					break;
				case MessageBoxResult.No:
					Window1 juego = new Window1();
					juego.Owner = this;
					juego.ShowDialog();
					break;
			}

		}
	}
}
