/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package odbcmysql;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @date: 
 * @author Paulo Andrade <source.compu at gmail.com>
 * @email: source.compu@gmail.com
 */
public class Odbc {
    String _url;
    String _user;
    String _pass;
    Connection _connect;
    
    // Creamos el constructor de la clase
    Odbc()
    {
        /*
         * En windows utilice // para las direcciones, ya que es una
         * diagonal invertida.
         * En windows el nombre de la base de datos lleva extensión .db
        */
        this._url = "//localhost/test"; // Ruta de la base de datos
        this._user = "root"; // Usuario
        this._pass = "root"; // Password
    }
    
    // Método para realizar la conexion
    private void connect()
    {
        try {
            // Inicializamos y registramos el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // creamos la conexión con el driver sqlite
            _connect = DriverManager.getConnection("jdbc:mysql:"+this._url, this._user, this._pass);
            
            // verificamos el status de la conexion
            if (_connect != null){
                // Mensaje de conexión exito
                System.out.println("Conexión exitosa :)");
            }
        } catch (SQLException | ClassNotFoundException ex){
            // Mostramos el error al conectar
            System.err.println("\nError al intentar la conexión\n"+ex.getMessage());
        }
    }
    
    // Método para cerrar la conexion
    private void close()
    {
        try{
            // Cerramos la conexión
            _connect.close();
        } catch (SQLException ex){
            // Creamos un log informando el error al intentar cerra
            Logger.getLogger(Odbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método para realizar insert, delete, update
    public boolean action(String sql) throws SQLException
    {
        Statement consulta;
        
        // Abrimos la conexión
        this.connect();
        
        // Preparamos la declaracion sql
        consulta = _connect.createStatement();

        // Ejecutamos la accion
        consulta.execute(sql);

        // Cerramos
        consulta.close();
        
        // Cerramos la conexión
        this.close();
        
        // Retornamos
        return true;
    }
    
    // Método para realizar insert, delete, update
    public ResultSet select(String sql)
    {
        PreparedStatement consulta;
        ResultSet executeQuery;
        CachedRowSetImpl cache = null;
        
        // Abrimos la conexión
        this.connect();
        
        try{
            // Preparamos la declaracion sql
            consulta = _connect.prepareStatement(sql);

            // Ejecutamos la accion
            executeQuery = consulta.executeQuery();
            
            cache = new CachedRowSetImpl();
            cache.populate(executeQuery);

            // Cerramos
            consulta.close();
            executeQuery.close();
        } catch (SQLException ex){
            // Mostramos el error al conectar
            System.err.println(ex.getMessage());
        }
        
        // Cerramos la conexión
        this.close();
        
        // Retornamos
        return cache;
    }
}
