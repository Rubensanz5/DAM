using Microsoft.Win32;
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

namespace Jugueteria_RSG
{
	/// <summary>
	/// Interaction logic for MainWindow.xaml
	/// </summary>
	public partial class MainWindow : Window
	{
		Uri defecto = new Uri("E:\\Proyectos\\VisualStudio\\Jugueteria-RSG\\img\\defecto.png", UriKind.Absolute);
		private byte[] imagenActual = null;

		public MainWindow()
		{
			InitializeComponent();
		}

		private void btnseleccionar(object sender, RoutedEventArgs e)
		{
			
			OpenFileDialog opf = new OpenFileDialog();
			opf.Multiselect = false;
			opf.Filter = "Imagenes jpg|*.jpg|Imagenes png|*.png|All files (*.*)|*.*";
			opf.InitialDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
			if (opf.ShowDialog() == true)
			{
				Uri imagen = new Uri(opf.FileName, UriKind.Absolute);
				lbUrl.Content = opf.FileName;
				img.Source = new BitmapImage(imagen);
				imagenActual = Utilidades.ConvertBitmapSourceToByteArray(new BitmapImage(new Uri(opf.FileName)));
			}

		}
		
		private void btn_Insertar(object sender, RoutedEventArgs e)
		{
			if (tbCodigo.Text != "" && tbDenominacion.Text != "" && tbDescripcion.Text != "" && tbImporte.Text != "" && img.Source != null)
			{
				try
				{
					try
					{
						if (!existeProducto(tbCodigo.Text))
						{

							// Obtener una conexión abierta a la BD
							MySqlConnection conexionBD = Conexion.obtenerConexion();

							if (conexionBD == null)
							{
								Console.WriteLine("Error en Conexion a BD");
							}
							else
							{
								try
								{
									string sql = "INSERT INTO juguetes (codigoJug, " +
										"nombreJug, descripcionJug, imagenJug, importeJug)" +
										" VALUES (@codigo, @nombre, @descripcion, " +
										"@imagen, @importe)";

									using var consulta = new MySqlCommand(sql, conexionBD);

									consulta.Parameters.AddWithValue("@codigo", tbCodigo.Text);
									consulta.Parameters.AddWithValue("@nombre", tbDenominacion.Text);
									consulta.Parameters.AddWithValue("@descripcion", tbDescripcion.Text);
									consulta.Parameters.AddWithValue("@imagen", imagenActual);
									consulta.Parameters.AddWithValue("@importe", tbImporte.Text.Replace(',', '.'));

									consulta.Prepare();
									consulta.ExecuteNonQuery();

									MessageBox.Show("Producto guardado");

									limpiarDatos();

								}
								catch (MySqlException ex)
								{
									MessageBox.Show("Error al guardar producto: " + ex.Message);
								}
							}
						}
						else
						{
							MessageBox.Show("No se puede guardar\nProducto existente");
						}
					}

					catch (MySqlException ex)
					{
						MessageBox.Show("Error: " + ex.Message);
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
				MessageBox.Show("Algunos datos vacios. Introducir todos los datos");
			}
		}

		private void btn_Buscar(object sender, RoutedEventArgs e)
		{
			try
			{
				MySqlConnection conexionBD = Conexion.obtenerConexion();

				if (conexionBD == null)
				{
					Console.WriteLine("Error en Conexion a BD");
				}
				else
				{
					try
					{
						String consulta = "SELECT codigoJug, nombreJug, " +
										  "descripcionJug, imagenJug, importeJug " +
										  "FROM juguetes WHERE codigoJug = " +
										  "@codigo LIMIT 1";

						using var comando = new MySqlCommand(consulta, conexionBD);

						comando.Parameters.AddWithValue("@codigo", tbCodigo.Text);
						comando.Prepare();

						using var reader = comando.ExecuteReader();

						if (reader.HasRows)
						{
							while (reader.Read())
							{
								tbCodigo.Text = reader.GetString(0);
								tbDenominacion.Text = reader.GetString(1);
								tbDescripcion.Text = reader.GetString(2);
								img.Source = Utilidades.ConvertByteArrayToBitmapImage((byte[])reader.GetValue(3));
								imagenActual = (byte[])reader.GetValue(3);
								tbImporte.Text = reader.GetDecimal(4).ToString();
							}
						}
						else
						{
							MessageBox.Show("No se encontraron registros");
						}
					}
					catch (InvalidOperationException ex)
					{
						MessageBox.Show("Error en busqueda productos: " + ex.Message);
					}
				}
			}
			catch (MySqlException ex)
			{
				MessageBox.Show("Error al buscar productos: " + ex.Message);
			}
			finally
			{
				Conexion.cerrarConexion();
			}
		}

		private void btn_Actualizar(object sender, RoutedEventArgs e)
		{
			if (tbCodigo.Text != "" && tbDenominacion.Text != "" && tbDescripcion.Text != "" && tbImporte.Text != "" && img.Source != null)
			{
				try
				{
					try
					{
						if (existeProducto(tbCodigo.Text))
						{

							// Obtener una conexión abierta a la BD
							MySqlConnection conexionBD = Conexion.obtenerConexion();

							if (conexionBD == null)
							{
								Console.WriteLine("Error en Conexion a BD");
							}
							else
							{
								try
								{
									string sql = "UPDATE juguetes SET codigoJug=@codigo," +
									"nombreJug=@nombre, descripcionJug=@descripcion, " +
									"imagenJug=@imagen, importeJug=@importe " +
									"WHERE codigoJug=@codigo;";

									using var comando = new MySqlCommand(sql, conexionBD);

									comando.Parameters.AddWithValue("@codigo", tbCodigo.Text);
									comando.Parameters.AddWithValue("@nombre", tbDenominacion.Text);
									comando.Parameters.AddWithValue("@descripcion", tbDescripcion.Text);
									comando.Parameters.AddWithValue("@imagen", imagenActual);
									comando.Parameters.AddWithValue("@importe", tbImporte.Text.Replace(',', '.'));
									comando.Prepare();

									comando.ExecuteNonQuery();

									MessageBox.Show("Producto modificado");
									limpiarDatos();

								}
								catch (MySqlException ex)
								{
									MessageBox.Show("Error al modificar producto: " + ex.Message);
								}
							}
						}
						else
						{
							MessageBox.Show("Imposible modificación - Producto no existe");
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
				MessageBox.Show("Datos vacios. No se puede modificar producto");
			}
		}

		private void btn_Borrar(object sender, RoutedEventArgs e)
		{
			// No permitir eliminar registros si codProducto está vacío
			if (tbCodigo.Text != "")
			{
				if (existeProducto(tbCodigo.Text))
				{

					try
					{
						// Obtener una conexión abierta a la BD
						MySqlConnection conexionBD = Conexion.obtenerConexion();

						if (conexionBD == null)
						{
							Console.WriteLine("Error en Conexion a BD");
						}
						else
						{
							try
							{
								string sql = "DELETE FROM juguetes " +
									"WHERE codigoJug=@codigo;";
								// comando a ejecutar en la BD
								using var comando = new MySqlCommand(sql, conexionBD);

								comando.Parameters.AddWithValue("@codigo", tbCodigo.Text);
								comando.Prepare();

								// Ejecución del comando
								comando.ExecuteNonQuery();

								MessageBox.Show("Producto eliminado");
								limpiarDatos();

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
				else
				{
					MessageBox.Show("Imposible eliminación - Producto no existe");
				}
			}
			else
			{
				MessageBox.Show("Datos vacios. No se puede eliminar producto");
			}
		}

		public void limpiarDatos()
        {
			tbCodigo.Text = "";
			tbDenominacion.Text = "";
			tbDescripcion.Text = "";
			tbImporte.Text = "";
			img.Source = new BitmapImage(defecto);
			imagenActual = Utilidades.ConvertBitmapSourceToByteArray(new BitmapImage(defecto));
			lbUrl.Content = "";

		}

		private bool existeProducto(string codProd)
		{
			bool existe = false;

			try
			{
				// Obtener una conexión abierta a la BD
				MySqlConnection conexionBD = Conexion.obtenerConexion();

				if (conexionBD == null)
				{
					Console.WriteLine("Error en Conexion a BD");
					existe = false;
					return existe;
				}
				else
				{
					try
					{
						// Para modificar, verificar primero que exista el producto.
						// comando a ejecutar en la BD
						String consulta =
							"SELECT codigoJug " +
								 "FROM juguetes WHERE codigoJug = " +
								 "@codigo LIMIT 1";

						using var comando = new MySqlCommand(consulta, conexionBD);

						comando.Parameters.AddWithValue("@codigo", codProd);
						comando.Prepare();

						// Ejecución del comando
						using var reader = comando.ExecuteReader();

						if (reader.HasRows)
						{
							existe = true;
						}
						else
						{
							existe = false;
						}
						return existe;
					}

					catch (InvalidOperationException ex)
					{
						existe = false;
						MessageBox.Show("Error en busqueda producto: " + ex.Message);
						return existe;
					}
					finally
					{

					}
				}
			}
			catch (MySqlException ex)
			{
				MessageBox.Show("Error al buscar producto: " + ex.Message);
				existe = false;
				return existe;
			}
			finally
			{
				Conexion.cerrarConexion();
			}
		}

        private void btn_Limpiar(object sender, RoutedEventArgs e)
        {
			limpiarDatos();
        }
    }

}

