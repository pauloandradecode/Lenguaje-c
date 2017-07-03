/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package odbcmysql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Main Class - 
 *
 * @date: 
 * @author Paulo Andrade <source.compu at gmail.com>
 * @email: source.compu@gmail.com
 */
public class Main
{
    // Objeto conexion a base de datos
    static Odbc _db = new Odbc();
    
    /**
     * Método principal
     * @param args argumentos de la linea de comandos
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // agregamos un registro
        String sql = "insert into users (name,lastname,email) values ('Paulo','Andrade','source.compu@gmail.com')";
        
        if(_db.action(sql)){
            System.out.println("Se inserto correctamente");
        }
        
        // Realizamos una consulta
        ResultSet result;
        result = _db.select("select * from users");
        
        while(result.next()) {
            System.out.print(result.getInt("id")+" - ");
            System.out.print(result.getString("name")+" - ");
            System.out.print(result.getString("lastname")+" - ");
            System.out.println(result.getString("email")+" - ");
        }
    }

}
