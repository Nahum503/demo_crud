/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;

import java.util.Scanner;
import java.sql.SQLException;


public class Create {
    Create() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Estudiante person = new Estudiante();
        System.out.println("<< CREAR REGISTRO >>");
        
        System.out.println("N° de carnet: ");
        person.setCarnetestudiante(leer.nextLine());
        
        System.out.println("Nombre: ");
        person.setNomestudiante(leer.nextLine());
        
        System.out.println("Apellido: ");
        person.setApeestudiante(leer.nextLine());
        
        System.out.println("Edad: ");
        person.setEdadestudiante(leer.nextInt());
        
        String tabla = "tb_estudiante";
        String camposTabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String valoresCampos = "'"+person.getCarnetestudiante()+"','"+person.getNomestudiante()+"','"+
                person.getApeestudiante()+"','"+person.getEdadestudiante()+"'";
        
        ConexionCRUD utilerias = new ConexionCRUD();
        
        utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);
        
        MenuPrincipal.desplegarMenu();
        
    }
}
