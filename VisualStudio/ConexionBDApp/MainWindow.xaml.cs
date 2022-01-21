using MySqlConnector;
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

namespace ConexionBDApp
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

        private void btnConectar_Click(object sender, RoutedEventArgs e)
        {
            String servidor = txtServidor.Text;
            uint puerto = uint.Parse(txtPuerto.Text);
            String bd = txtBD.Text;
            String usuario = txtUsuario.Text;
            String password = pwdPassword.Password;

            // Creacion de la cadena de conexión
            MySqlConnectionStringBuilder builder = new MySqlConnectionStringBuilder
            {
                Server = servidor,
                Port = puerto,
                Database = bd,
                UserID = usuario,
                Password = password
            };

            // MessageBox.Show(builder.ConnectionString);

            // Creación de un objeto conexión a la BD
            MySqlConnection conexionBD = new MySqlConnection(builder.ToString());

            try
            {
                // Apertura de la la conexión a la BD
                conexionBD.Open();

                // Variable para tratar cada linea del cursor devuelto en la consulta
                String data = null;

                // comando a ejecutar en la BD
                String consulta = "SHOW DATABASES;";
                using var comando = new MySqlCommand(consulta, conexionBD);

                // Ejecución del comando
                using var reader = comando.ExecuteReader();

                // Obtención del cursor con el resultado de una consulta
                while (reader.Read())
                {
                    data += reader.GetString(0) + "\n";
                    //data += reader.GetString("database") + "\n";
                }
                MessageBox.Show("BASES DE DATOS:\n" + data);
            }
            catch (MySqlException ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                // siempre se cierra la conexion
                conexionBD.Close();
            }
        }
    }
}
