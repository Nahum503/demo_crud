/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {
    public static void desplegarMenu() throws SQLException{
        Scanner opcionSeleccionada = new Scanner(System.in);
        String opcionMenu;
        //menu a deplegar
        System.out.println("************");
        System.out.println("|     REGISTRO DE ESTUDIANTE     |");
        System.out.println("************");
        System.out.println("| Opciones:                      |");
        System.out.println("|          1. Crear registro     |");
        System.out.println("|          2. Consultar registro |");
        System.out.println("|          3. Actualizar registro|");
        System.out.println("|          4. Eliminar registro  |");
        System.out.println("|          5. Salir              |");
        System.out.println("************");
        System.out.println("Seleccionar opción: ");
        opcionMenu = opcionSeleccionada.next();
        
        //desplegaremos el menu basado en las opción seleccionada
        
        switch (opcionMenu){
            case "1":
                Create create = new Create();
                break;
            case "2":
                Read read = new Read();
                break;
            case "3":
                Update update = new Update();
                break;
             case "4":
                Delete delete = new Delete();
                break;
             case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Seleccion invalida");
                break;
                
        }
        
    }
}
