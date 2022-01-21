using MySqlConnector;
using System;

namespace SingletonBDApp
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                // Obtener una conexión abierta a la BD
                MySqlConnection conexionBD = Conexion.obtenerConexionAbierta();

                if (conexionBD == null)
                {
                    Console.WriteLine("Error en Conexion a BD");
                }
                else {
                    try
                    {
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
                        }
                        Console.WriteLine("BASES DE DATOS:\n" + data);
                    }
                    catch (InvalidOperationException ex)
                    {
                        Console.WriteLine("Error: " + ex.Message);
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
    }
}
