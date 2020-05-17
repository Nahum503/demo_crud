/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class ConexionCRUD {
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/db_recurso_humano";
    
    private final String usuario ="root";
    
    private final String clave="";
    
    private final String driveConector ="com.mysql.jdbc.Driver";
    
    private static Connection conexion;
    
    public ConexionCRUD(){
        try {
            Class.forName(driveConector);
            
            conexion=DriverManager.getConnection(servidor, usuario, clave);
        } catch (ClassNotFoundException |SQLException e) {
            System.out.println("Conexión fallida! Error! " + e.getMessage());
        }
        
    }
}
