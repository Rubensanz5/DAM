using MySqlConnector;
using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using System.Windows;

namespace Jugueteria_RSG
{
    class Conexion
    {
        private static MySqlConnectionStringBuilder builder = null;
        private static MySqlConnection conn = null;
        private static String SERVIDOR = "localhost";
        private static uint PUERTO = 3306;
        private static String BD = "jugueteria";
        private static String USUARIO = "root";
        private static String PASSWORD = "1234";

        private Conexion() { }

        private static MySqlConnectionStringBuilder GetBuilder()
        {
            if (builder == null)
            {
                try
                {
                    builder = new MySqlConnectionStringBuilder();
                }
                catch (Exception)
                {
                    builder = null;
                }
            }
            return builder;
        }

        public static MySqlConnection obtenerConexion()
        {
            if (conn == null)
            {
                if (GetBuilder() == null)
                {
                    return null;
                }
                builder.Server = SERVIDOR;
                builder.Port = PUERTO;
                builder.UserID = USUARIO;
                builder.Password = PASSWORD;
                builder.Database = BD;
                try
                {
                    conn = new MySqlConnection(builder.ToString());
                    conn.Open();
                }
                catch (MySqlException ex)
                {
                    Console.WriteLine("Error: " + ex.Message);
                }
            }

            else if (conn.State != ConnectionState.Open)
            {
                try
                {
                    conn.Close();
                    conn.Open();
                }
                catch
                {
                    return null;
                }
            }

            if (conn.State == ConnectionState.Open)
            {
                
            }
            return conn;
        }

        public static void cerrarConexion()
        {
            if (conn != null)
            {
                try
                {
                    conn.Close();

                    if (conn.State == ConnectionState.Closed)
                    {
                       
                    }
                }
                finally
                {
                }
            }
        }
    }
}
