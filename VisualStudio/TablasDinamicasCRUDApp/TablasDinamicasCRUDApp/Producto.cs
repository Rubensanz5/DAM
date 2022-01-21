using MySqlConnector;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace TablasDinamicasCRUDApp
{
    public class ProductoCollection : ObservableCollection<Producto>
    {
    }

    public class Producto
    {
        #region propiedades

        private int id;
        private String codigo;
        private String nombre;
        private String descripcion;
        private decimal precio;
        private int existencias;

        #endregion propiedades

        #region metodos

        public Producto()
        {
            id = 0;
            codigo = "";
            nombre = "";
            descripcion = "";
            precio = 0;
            existencias = 0;
        }
        public int Id { get => id; set => id = value; }
        public string Codigo { get => codigo; set => codigo = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public decimal Precio { get => precio; set => precio = value; }
        public int Existencias { get => existencias; set => existencias = value; }

        public Producto buscarProducto(string codigoProducto)
        {

            Producto producto = new Producto();

            if (codigoProducto != "")
            {
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
                            // comando a ejecutar en la BD
                            String consulta =
                                "SELECT idProducto, codigoProducto, " +
                                     "nombre, descripcion, precio, " +
                                     "existencias " +
                                     "FROM productos WHERE codigoProducto = " +
                                     "@codProducto LIMIT 1";

                            using var comando = new MySqlCommand(consulta, conexionBD);

                            comando.Parameters.AddWithValue("@codProducto", codigoProducto);
                            comando.Prepare();

                            // Ejecución del comando
                            using var reader = comando.ExecuteReader();

                            if (reader.HasRows)
                            {
                                // Obtención del cursor con el resultado de una consulta
                                while (reader.Read())
                                {
                                    producto.Id = reader.GetInt32(0);
                                    producto.Codigo = reader.GetString(1);
                                    producto.Nombre = reader.GetString(2);
                                    producto.Descripcion = reader.GetString(3);
                                    producto.Precio = reader.GetDecimal(4);
                                    producto.Existencias = reader.GetInt32(5);
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
            }
            else
            {
                throw new Exception("Código de producto no introducido. Introducir Código de producto");
            }

            return producto;
        }

        public bool existeProducto(string codigoProducto)
        {
            bool existe = false;

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
                        // Para modificar, verificar primero que exista el producto.
                        // comando a ejecutar en la BD
                        String consulta =
                            "SELECT idProducto " +
                                 "FROM productos WHERE codigoProducto = " +
                                 "@codigoProducto LIMIT 1";

                        using var comando = new MySqlCommand(consulta, conexionBD);

                        comando.Parameters.AddWithValue("@codigoProducto", codigoProducto);
                        comando.Prepare();

                        // Ejecución del comando
                        using var reader = comando.ExecuteReader();

                        if (reader.HasRows)
                        {
                            existe = true;
                        }
                        return existe;
                    }
                    catch (InvalidOperationException ex)
                    {
                        throw new Exception("Incidencia en busqueda de producto: " + ex.Message);
                    }
                    finally
                    {

                    }
                }
            }
            catch (MySqlException ex)
            {
                throw new Exception("Incidencia al buscar producto: " + ex.Message);
            }
            finally
            {
                // siempre se cierra la conexion
                Conexion.cerrarConexion();
            }
        }

        public bool guardarProducto(Producto producto)
        {
            bool operacion_ok = false;
            try
            {
                // No permitir guardar registros con datos vacios
                if (producto.Codigo != "" &&
                    producto.Nombre != "" &&
                    producto.Descripcion != "" &&
                    producto.Precio != 0 &&
                    producto.Existencias != 0)
                {
                    // Verificar si existe el registro. No se puede dar de alta
                    // un registro si ya existe
                    try
                    {
                        if (!existeProducto(producto.Codigo))
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
                                    string sql = "INSERT INTO productos (codigoProducto, " +
                                        "nombre, descripcion, precio, existencias) " +
                                        "VALUES (@codigoProducto, @nombre, @descripcion, " +
                                        "@precio, @existencias)";

                                    // comando a ejecutar en la BD
                                    using var comando = new MySqlCommand(sql, conexionBD);
                                    comando.Parameters.AddWithValue("@codigoProducto", producto.Codigo);
                                    comando.Parameters.AddWithValue("@nombre", producto.Nombre);
                                    comando.Parameters.AddWithValue("@descripcion", producto.Descripcion);
                                    comando.Parameters.AddWithValue("@precio", producto.Precio);
                                    comando.Parameters.AddWithValue("@existencias", producto.Existencias);
                                    comando.Prepare();

                                    // Ejecución del comando
                                    comando.ExecuteNonQuery();

                                    operacion_ok = true;
                                    return operacion_ok;

                                }
                                catch (MySqlException ex)
                                {
                                    throw new Exception("Incidencia al guardar producto: " + ex.Message);
                                }
                            }
                        }
                        else
                        {
                            throw new Exception("Imposible guardar - Producto ya existe");
                        }
                    }
                    catch (MySqlException ex)
                    {
                        throw new Exception("Incidencia: " + ex.Message);
                    }
                    finally
                    {
                        // siempre se cierra la conexion
                        Conexion.cerrarConexion();
                    }
                }
                else
                {
                    throw new Exception("Algunos datos vacios. Introducir todos los datos");
                }
            }
            catch (FormatException fex)
            {
                throw new Exception("Datos incorrectos: " + fex.Message);
            }
        }

        public bool actualizarProducto(Producto producto)
        {
            Producto productoEnBD = new Producto();

            bool operacion_ok = false;

            // No permitir modificar registros con datos vacios
            if (producto.Codigo != "" && producto.Nombre != "" &&
                producto.Descripcion != "" && producto.Precio != 0 &&
                producto.Existencias != 0)
            {
                if (existeProducto(producto.Codigo))
                {
                    // Modificar datos si no son identicos a los que existen en la BD.
                    productoEnBD = buscarProducto(producto.Codigo);

                    if (producto.Codigo != productoEnBD.Codigo ||
                        producto.Nombre != productoEnBD.Nombre ||
                        producto.Descripcion != productoEnBD.Descripcion ||
                        producto.Precio != productoEnBD.Precio ||
                        producto.Existencias != productoEnBD.Existencias)
                    {
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
                                    string sql = "UPDATE productos SET " +
                                    "codigoProducto=@codigoProducto, " +
                                    "nombre=@nombre, descripcion=@descripcion, " +
                                    "precio=@precio, " +
                                    "existencias=@existencias " +
                                    "WHERE codigoProducto=@codigoProducto;";
                                    // comando a ejecutar en la BD
                                    using var comando = new MySqlCommand(sql, conexionBD);

                                    comando.Parameters.AddWithValue("@codigoProducto", producto.Codigo);
                                    comando.Parameters.AddWithValue("@nombre", producto.Nombre);
                                    comando.Parameters.AddWithValue("@descripcion", producto.Descripcion);
                                    comando.Parameters.AddWithValue("@precio", producto.Precio);
                                    comando.Parameters.AddWithValue("@existencias", producto.Existencias);
                                    comando.Prepare();

                                    // Ejecución del comando
                                    comando.ExecuteNonQuery();

                                    operacion_ok = true;
                                    return operacion_ok;
                                }
                                catch (MySqlException ex)
                                {
                                    throw new Exception("Incidencia al modificar producto: " + ex.Message);
                                }
                            }
                        }
                        catch (MySqlException ex)
                        {
                            throw new Exception("Incidencia: " + ex.Message);
                        }
                        finally
                        {
                            // siempre se cierra la conexion
                            Conexion.cerrarConexion();
                        }
                    }
                    else
                    {
                        throw new Exception("Producto no modificado. Mismos datos en Base de Datos");
                    }
                }
                else
                {
                    throw new Exception("Imposible modificación - Producto no existe");
                }
            }
            else
            {
                throw new Exception("Datos vacios. No se puede modificar producto");
            }
        }

        public bool eliminarProducto(Producto producto)
        {
            bool operacion_ok = false;

            // No se puede eliminar producto si codigo vacio
            if (producto.Codigo != "")
            {
                if (existeProducto(producto.Codigo))
                {
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
                                string sql = "DELETE FROM productos " +
                                    "WHERE codigoProducto=@codigoProducto;";
                                // comando a ejecutar en la BD
                                using var comando = new MySqlCommand(sql, conexionBD);

                                comando.Parameters.AddWithValue("@codigoProducto", producto.Codigo);
                                comando.Prepare();

                                // Ejecución del comando
                                comando.ExecuteNonQuery();

                                operacion_ok = true;
                                return operacion_ok;
                            }
                            catch (MySqlException ex)
                            {
                                throw new Exception("Incidencia al eliminar producto: " + ex.Message);
                            }
                        }
                    }
                    catch (MySqlException ex)
                    {
                        throw new Exception("Incidencia: " + ex.Message);
                    }
                    finally
                    {
                        // siempre se cierra la conexion
                        Conexion.cerrarConexion();
                    }
                }
                else
                {
                    throw new Exception("Imposible eliminación - Producto no existe");
                }
            }
            else
            {
                throw new Exception("Datos vacios. No se puede eliminar producto");
            }
        }
        #endregion metodos
    }
}

