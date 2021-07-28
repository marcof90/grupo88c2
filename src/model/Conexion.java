
package model;
import java.sql.*;

/**
 * Conexion
 */
public class Conexion {

    public static void main(String[] args) {
        try {
             // 1creando la conexion
             Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","");
             //2 creando statement
             Statement miStatemen=miConexion.createStatement();
             //3 ejecutar la instruccion SQL
             ResultSet miResulset = miStatemen.executeQuery("SELECT * FROM country");
             //4 LEER EL RESULSET QUE ES UNA TABLA CREADA DE LA CONSULTA
 
             while (miResulset.next())
             System.out.println(miResulset.getString("Name"));           
        } catch (Exception e) {
            System.out.println("no conecta");
            e.printStackTrace();            
        }
    }

}