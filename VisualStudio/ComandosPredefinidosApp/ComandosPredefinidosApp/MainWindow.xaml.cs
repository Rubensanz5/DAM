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

namespace ComandosPredefinidosApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            Clipboard.Clear();
        }

        private void ComprobarNew(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = true;
        }

        private void EjecutarNew(object sender, ExecutedRoutedEventArgs e)
        {
            MessageBox.Show("Nuevo elemento");
        }

        private void ComprobarCut(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = (txtBox != null) && (txtBox.SelectionLength > 0);
        }

        private void EjecutarCut(object sender, ExecutedRoutedEventArgs e)
        {
            txtBox.Cut();
        }

        private void ComprobarPaste(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = Clipboard.ContainsText();
        }

        private void EjecutarPaste(object sender, ExecutedRoutedEventArgs e)
        {
            txtBox.Paste();
        }

    }
}
