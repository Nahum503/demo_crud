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
     public void actualizarEliminarRegistro(String tabla, String condicion, String valoresCamposNuevos){
            //cargar conexion
            ConexionCRUD conectar = new ConexionCRUD();
            Connection cone = conectar.getConnection();
            try {
                Statement stmt;
                String sqlQueryStml;
                //Verificar que valorescamposnuevos  venga vacia y asi al borrar o actualizar registro
                if (valoresCamposNuevos.isEmpty()) {
                    sqlQueryStml = "DELETE FROM "+tabla+" WHERE "+condicion+";";
                    
                }else{
                    sqlQueryStml = " UPDATE "+tabla+ " SET "+valoresCamposNuevos+ " WHERE "+condicion+";";
                }
                stmt= cone.createStatement();
           stmt.executeUpdate(sqlQueryStml);
           stmt.close();
           cone.close();
                
            } catch (Exception ex) {
                System.out.println("Ha ocurrido el siguiente error: "+ ex.getMessage());
            }
        }
        
        public void desplegarRegistros(String tablaBuscar, String camposBuscar, String condicionBuscar)throws SQLException {
              ConexionCRUD conectar = new ConexionCRUD();
            Connection cone = conectar.getConnection();
            try {
                Statement stmt;
                String sqlQueryStml;
                //Verificar que valorescamposnuevos  venga vacia y asi al borrar o actualizar registro
                if (condicionBuscar.equals("")) {
                    sqlQueryStml = "SELECT "+camposBuscar+" FROM "+tablaBuscar+";";
                    
                }else{
                    sqlQueryStml = "SELECT "+camposBuscar+ " FROM "+tablaBuscar+ " WHERE "+condicionBuscar;
                }
                stmt= cone.createStatement();
           stmt.executeQuery(sqlQueryStml);
           //le indicamos que ejecute la consulta de la tabla y le pasamos por argumento nuestra sentencia
                try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStml)){
                    if (miResultSet.next()) {//Ubica el curso de la primera fila dela tabla
                        ResultSetMetaData metaData = miResultSet.getMetaData();
                        int numColumnas = metaData.getColumnCount();//obtiene el numero de columnas de la consulta
                        System.out.println("<< REGISTRO ALMACENADO >>");
                        System.out.println();
                        
                        for (int i = 1; i <= numColumnas; i++) {
                            System.out.printf("%-20s\t", metaData.getColumnName(i));
                        }
                        System.out.println();
                        do {                            
                            for (int i = 1; i <=numColumnas; i++) {
                                System.out.printf("%-20s\t", miResultSet.getObject(i));
                            }
                            System.out.println();
                            
                        } while (miResultSet.next());
                        System.out.println();
                        
                        
                        
                    } else {
                        System.out.println("No se han encontrado registros");
                    }
                    miResultSet.close();
                    }finally{
                    stmt.close();
                    cone.close();
                }
                } catch (SQLException ex) {
                    System.out.println("Ha ocurrido al error: "+ ex.getMessage());
                }
            
            
        }
}

    
    
    

