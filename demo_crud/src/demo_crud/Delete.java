/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;

import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    Delete () throws SQLException{
        Scanner leer = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ELIMINAR REGISTRO >>");
        
        System.out.println("Ingrese el id del registro");
        String idEstudianteEliminar = leer.next();
        //reingreso de datos para actualizar
        String tabla ="tb_estudiante ";
        String campos = "*";
        String condicion = "id_estudiante = "+idEstudianteEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
         System.out.println("Presionar <<Y>> para confirmar: ");
        String confirmarBorrar = leer.next();
        
           if ("Y".equals(confirmarBorrar)) {
            /*se le deja vacio para el metodo actualizarEliminarRegistro
            envie solamente los parametros de tabla y condicion y poder eliminar
            */
            String valoresCamposNuevos="";
            utilerias.actualizarEliminarRegistro(tabla, condicion, valoresCamposNuevos);
            System.out.println("Registro borrado satisfactoriamente!");
            
        }
        MenuPrincipal.desplegarMenu();
    }
}
