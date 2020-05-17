/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;


import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    
     Update() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Estudiante person = new Estudiante();
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ACTUALIZAR REGISTROS >>");
        
        System.out.println("Ingresar id del registro a modificar: ");
        person.setIdestudiante(leer.nextInt());
        
        //reingresando los datos para actualizar
        String tablaBuscar = "tb_estudiante";
        String campoBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = "+person.getIdestudiante();
        utilerias.desplegarRegistros(tablaBuscar, campoBuscar, condicionBuscar);
        
        System.out.println("N° de carnet: ");
        person.setCarnetestudiante(leer.next());
        
        System.out.println("Nombre: ");
        person.setNomestudiante(leer.next());
        
        System.out.println("Apellido: ");
        person.setApeestudiante(leer.next());
        
        System.out.println("Edad: ");
        person.setEdadestudiante(leer.nextInt());
        
        String tabla = "tb_estudiante";
        String camposValoresNuevos = "carnet_estudiante = '" +person.getCarnetestudiante()+ "', nom_estudiante = '"+person.getNomestudiante()+"', ape_estudiante = '"+person.getApeestudiante()+"', edad_estudiante = '"+
                person.getEdadestudiante()+"'";
        
        utilerias.actualizarEliminarRegistro(tabla, condicionBuscar, camposValoresNuevos);
        System.out.println("Modificado correctamente!");
        
        MenuPrincipal.desplegarMenu();
    }
}


