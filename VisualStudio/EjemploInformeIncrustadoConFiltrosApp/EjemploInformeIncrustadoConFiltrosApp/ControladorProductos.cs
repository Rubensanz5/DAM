using MySqlConnector;
using System;
using System.Collections.Generic;
using System.Text;

namespace EjemploInformeIncrustadoConFiltrosApp
{
    class ControladorProductos
    {
        public ProductoCollection consultar(string dato)
        {

            //Producto producto = new Producto();
            ProductoCollection lista = new ProductoCollection();

            try
            {
                // Obtener una conexión abierta a la BD
                MySqlConnection conexionBD = Conexion.obtenerConexionAbierta();

                if (conexionBD == null)
                {
                    throw new Exception("Fallo en Conexion a BD");
                }
                else
                {
                    try
                    {
                        String consulta = "";

                        if (dato != null)
                        {
                            // comando a ejecutar en la BD
                            consulta =
                            "SELECT p.idProducto AS IdProducto, " +
                                 "p.codigoProducto AS Código, " +
                                 "p.nombre AS Nombre, p.descripcion AS Descripción, " +
                                 "p.fechaAlta AS 'Fecha Alta', " +
                                 "p.precio AS Precio, " +
                                 "p.existencias AS Existencias, " +
                                 "c.nombre AS Categoría, " +
                                 "p.imagen AS Imágen " +
                                 "FROM productos p, categorias c " +
                                 "WHERE p.idCategoria = c.id AND " +
                                 "(p.codigoProducto LIKE '%" + dato + "%' OR " +
                                 "p.nombre LIKE '%" + dato + "%' OR " +
                                 "p.descripcion LIKE '%" + dato + "%' OR " +
                                 "c.nombre LIKE '%" + dato + "%') " +
                                 "ORDER BY nombre ASC " +
                                 "LIMIT 20";
                        }
                        else
                        {
                            // comando a ejecutar en la BD
                            consulta =
                            "SELECT p.idProducto AS IdProducto, " +
                            "p.codigoProducto AS Código, " +
                            "p.nombre AS Nombre, p.descripcion AS Descripción, " +
                            "p.fechaAlta AS 'Fecha Alta', " +
                            "p.precio AS Precio, " +
                            "p.existencias AS Existencias, " +
                            "c.nombre AS Categoría, " +
                            "p.imagen AS Imágen " +
                            "FROM productos p, categorias c " +
                            "WHERE p.idCategoria = c.id " +
                            "ORDER BY nombre ASC " +
                            "LIMIT 20";
                        }

                        using var comando = new MySqlCommand(consulta, conexionBD);
                        comando.Parameters.AddWithValue("@dato", dato);
                        comando.Prepare();

                        // Ejecución del comando
                        using var reader = comando.ExecuteReader();

                        if (reader.HasRows)
                        {

                            // Obtención del cursor con el resultado de una consulta
                            while (reader.Read())
                            {
                                Producto producto = new Producto();

                                producto.Id = reader.GetInt32("IdProducto");
                                producto.Codigo = reader.GetString("Código");
                                producto.Nombre = reader.GetString("Nombre");
                                producto.Descripcion = reader.GetString("Descripción");
                                producto.FechaAlta = reader.GetDateTime("Fecha Alta");
                                producto.Precio = reader.GetDecimal("Precio");
                                producto.Existencias = reader.GetInt32("Existencias");
                                producto.NombreCategoria = reader.GetString("Categoría");

                                if (reader.GetValue(8) != DBNull.Value)
                                {
                                    producto.Imagen = (byte[])reader.GetValue(8);
                                }

                                lista.Add(producto);
                            }
                        }
                        else
                        {
                            throw new Exception("No se encontraron productos");
                        }
                    }
                    catch (InvalidOperationException ex)
                    {
                        throw new Exception("Incidencia en busqueda de productos: " + ex.Message);
                    }
                }
            }
            catch (MySqlException ex)
            {
                throw new Exception("Incidencia al buscar productos: " + ex.Message);
            }
            finally
            {
                // siempre se cierra la conexion
                Conexion.cerrarConexion();
            }
            return lista;
        }
    }
}
