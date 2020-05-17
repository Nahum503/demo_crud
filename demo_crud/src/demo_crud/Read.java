/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;

import java.sql.SQLException;

public class Read {
     public Read() throws SQLException{
        System.out.println("<< CONSULTAR REGISTROS >>");
        mostrarResultado(); //Llamar metodo dentro de la clase
        }
   private void mostrarResultado() throws SQLException{
        try {
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "*";
            //condicion se envia vacia para indicar que todos los registros se necesitan mostrar
            
            String condicionBusqueda="";
            //Metodo que realiza la busqueda
            utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error: "+ex.getMessage());
        }finally{
            MenuPrincipal.desplegarMenu();
        }
        
    }
}
