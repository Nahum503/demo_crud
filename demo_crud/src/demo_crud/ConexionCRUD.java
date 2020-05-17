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
    public Connection getConnection(){
        return conexion;
    }
    
    public void guardarRegistros(String tabla, String campoTabla, String valoresCampos){
        //cargar la conexion 
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try {
            //definir la setencia sql
            String sqlQueryStmt = "INSERT INTO "+tabla+" ("+campoTabla+") VALUES ("+valoresCampos + ");";
            // establecemos la comunicacion entre nuetra aplicacion java y la base de datos
            Statement stmt; //Envia sentencias sql a la base de datos}
            stmt= cone.createStatement();
           stmt.executeUpdate(sqlQueryStmt);
           //cerrar el Statement y la conexion se cieran en orden de como se ha abierto
           stmt.close();
           cone.close();
            System.out.println("Registrado guardado correctamente :)");
                            
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    }
    

