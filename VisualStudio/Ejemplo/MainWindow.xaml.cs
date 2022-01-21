using System.Windows;
using System.Diagnostics;

namespace Ejemplo
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

		private void Button_1(object sender, RoutedEventArgs e)
		{
			Trace.WriteLine("Has pulsado el boton 1");
		}

		 private void Button_2(object sender, RoutedEventArgs e)
		 {
			Trace.WriteLine("Has pulsado el boton 2");
	     }

		private void StackPanel_Click(object sender, RoutedEventArgs e)
		{
		   Trace.WriteLine("Has pulsado el SackPanel");
		}

        private void StackPanel_PreviewMouseLeftButtonDown(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
			Trace.WriteLine("Has pulsado el SackPanel");
		}
    }
}
