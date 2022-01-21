using MySqlConnector;
using System;
using System.Collections.Generic;
using System.Globalization;
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

namespace CRUDApp
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

        private void btnGuardar_Click(object sender, RoutedEventArgs e)
        {
            // No permitir guardar registros con datos vacios
            if (txtCodProducto.Text != "" && txtNombre.Text != "" &&
                txtDescripcion.Text != "" && txtPrecio.Text != "" &&
                txtExistencias.Text != "")
            {
                try
                {
                    String codigoProducto = txtCodProducto.Text;
                    String nombre = txtNombre.Text;
                    String descripcion = txtDescripcion.Text;
                    String precio = txtPrecio.Text.Replace(',', '.');
                    int existencias = int.Parse(txtExistencias.Text);


                    string sql = "INSERT INTO productos (codigoProducto," +
                        "nombre, descripcion, precio, existencias) VALUES " +
                        "('" + codigoProducto + "', '" + nombre + "', '" + descripcion +
                        "', '" + precio + "', '" + existencias + "')";

                    try
                    {
                        // Obtener una conexión abierta a la BD
                        MySqlConnection conexionBD = Conexion.obtenerConexionAbierta();

                        if (conexionBD == null)
                        {
                            Console.WriteLine("Error en Conexion a BD");
                        }
                        else
                        {
                            try
                            {
                                // comando a ejecutar en la BD
                                using var comando = new MySqlCommand(sql, conexionBD);

                                // Ejecución del comando
                                comando.ExecuteNonQuery();

                                MessageBox.Show("Producto guardado");

                                limpiar();

                            }
                            catch (MySqlException ex)
                            {
                                MessageBox.Show("Error al guardar producto: " + ex.Message);
                            }
                        }
                    }

                    catch (MySqlException ex)
                    {
                        Console.WriteLine("Error: " + ex.Message);
                    }
                    finally
                    {
                        // siempre se cierra la conexion
                        Conexion.cerrarConexion();
                    }

                }
                catch (FormatException fex)
                {
                    MessageBox.Show("Datos incorrectos: " + fex.Message);
                }
            }
            else
            {
                MessageBox.Show("Datos vacios. Introducir todos los datos");
            }
        }

        private void btnBuscar_Click(object sender, RoutedEventArgs e)
        {
            String codigo = txtCodProducto.Text;

            try
            {
                // Obtener una conexión abierta a la BD
                MySqlConnection conexionBD = Conexion.obtenerConexionAbierta();

                if (conexionBD == null)
                {
                    Console.WriteLine("Error en Conexion a BD");
                }
                else
                {
                    try
                    {
                        // Variable para tratar cada linea del cursor devuelto en la consulta
                        String data = null;

                        // comando a ejecutar en la BD
                        String consulta = 
                            "SELECT idProducto, codigoProducto, " +
                                 "nombre, descripcion, precio, existencias " +
                                 "FROM productos WHERE codigoProducto = '" +
                                 codigo + "' LIMIT 1";

                        using var comando = new MySqlCommand(consulta, conexionBD);

                        // Ejecución del comando
                        using var reader = comando.ExecuteReader();

                        if (reader.HasRows)
                        {
                            // Obtención del cursor con el resultado de una consulta
                            while (reader.Read())
                            {
                                txtIdProducto.Text = reader.GetInt32(0).ToString();
                                txtCodProducto.Text = reader.GetString(1);
                                txtNombre.Text = reader.GetString(2);
                                txtDescripcion.Text = reader.GetString(3);
                                txtPrecio.Text = reader.GetDecimal(4).ToString();
                                txtExistencias.Text = reader.GetInt32(5).ToString();

                            }
                        }
                        else
                        {
                            MessageBox.Show("No se encontraron registros");
                        }
                    }
                    catch (InvalidOperationException ex)
                    {
                        Console.WriteLine("Error en busqueda productos: " + ex.Message);
                    }
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine("Error al buscar productos: " + ex.Message);
            }
            finally
            {
                // siempre se cierra la conexion
                Conexion.cerrarConexion();
            }
        }

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            // No permitir modificar registros con datos vacios
            if (txtCodProducto.Text != "" && txtNombre.Text != "" &&
                txtDescripcion.Text != "" && txtPrecio.Text != "" &&
                txtExistencias.Text != "")
            {
                try
                {
                    int idProducto = int.Parse(txtIdProducto.Text);
                    String codigoProducto = txtCodProducto.Text;
                    String nombre = txtNombre.Text;
                    String descripcion = txtDescripcion.Text;
                    String precio = txtPrecio.Text.Replace(',', '.');
                    int existencias = int.Parse(txtExistencias.Text);

                    string sql = "UPDATE productos SET codigoProducto='" +
                        codigoProducto + "', nombre='" + nombre + "',descripcion='" +
                        descripcion + "', precio='" + precio + "',existencias='" +
                        existencias + "' WHERE idProducto='" + idProducto + "';";

                try
                {
                    // Obtener una conexión abierta a la BD
                    MySqlConnection conexionBD = Conexion.obtenerConexionAbierta();

                    if (conexionBD == null)
                    {
                        Console.WriteLine("Error en Conexion a BD");
                    }
                    else
                    {
                        try
                        {
                            // comando a ejecutar en la BD
                            using var comando = new MySqlCommand(sql, conexionBD);

                            // Ejecución del comando
                            comando.ExecuteNonQuery();

                            MessageBox.Show("Producto modificado");
                            limpiar();

                        }
                        catch (MySqlException ex)
                        {
                            MessageBox.Show("Error al modificar producto: " + ex.Message);
                        }
                    }
                }

                catch (MySqlException ex)
                {
                    Console.WriteLine("Error: " + ex.Message);
                }
                finally
                {
                    // siempre se cierra la conexion
                    Conexion.cerrarConexion();
                }
            }
            catch (FormatException fex)
            {
                MessageBox.Show("Datos incorrectos: " + fex.Message);
            }
        }
        else
            {
                MessageBox.Show("Datos vacios. Introducir todos los datos");
            }
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            int idProducto;

            idProducto = int.Parse(txtIdProducto.Text);

            string sql = "DELETE FROM productos WHERE idProducto='" + idProducto + "';";

            try
            {
                // Obtener una conexión abierta a la BD
                MySqlConnection conexionBD = Conexion.obtenerConexionAbierta();

                if (conexionBD == null)
                {
                    Console.WriteLine("Error en Conexion a BD");
                }
                else
                {
                    try
                    {
                        // comando a ejecutar en la BD
                        using var comando = new MySqlCommand(sql, conexionBD);

                        // Ejecución del comando
                        comando.ExecuteNonQuery();

                        MessageBox.Show("Producto eliminado");
                        limpiar();

                    }
                    catch (MySqlException ex)
                    {
                        MessageBox.Show("Error al eliminar producto: " + ex.Message);
                    }
                }
            }

            catch (MySqlException ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }
            finally
            {
                // siempre se cierra la conexion
                Conexion.cerrarConexion();
            }
        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            limpiar();
        }

        private void limpiar()
        {
            txtIdProducto.Text = "";
            txtCodProducto.Text = "";
            txtNombre.Text = "";
            txtDescripcion.Text = "";
            txtPrecio.Text = "";
            txtExistencias.Text = "";
        }
    }
}
