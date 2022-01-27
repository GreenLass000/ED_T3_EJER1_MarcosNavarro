/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author Marcos
 */
public class ComprobadorSeguridad {

    /**
     * Metodo que comprueba que tipo de seguridad tiene una contraseña
     * utilizando los criterios dados en el ejercicio
     *
     * @param contrasena es la contraseña a verificar
     * @return tipo de seguridad para cada contraseña
     */
    public static String seguridad(String contrasena) {
        boolean num = false;
        boolean may = false;
        boolean min = false;
        boolean esp = false;
        int longit = contrasena.length();

        /**
         * Bucle que verifica si una contraseña contiene mayusculas, minusculas,
         * numeros o caracteres especiales
         */
        for (int i = 0; i < longit; i++) {
            if (contrasena.charAt(i) >= (char) 65 && contrasena.charAt(i) <= (char) 90) {
                may = true;
            } else if (contrasena.charAt(i) >= (char) 97 && contrasena.charAt(i) <= (char) 122) {
                min = true;
            } else if (contrasena.charAt(i) >= (char) 48 && contrasena.charAt(i) <= (char) 57) {
                num = true;
            } else if (contrasena.charAt(i) >= (char) 33 && contrasena.charAt(i) <= (char) 47) {
                esp = true;
            }
        }

        /**
         * Variables de color para poner cada tipo de seguridad con un color
         * respectivo, POCO SEGURA > ROJO, SEGURA > NARANJA, MUY SEGURA > VERDE
         */
        String COLOR_RESET = "\u001B[0m";
        String COLOR_RED = "\u001B[31m";
        String COLOR_GREEN = "\u001B[32m";
        String COLOR_YELLOW = "\u001B[33m";

        if (contrasena.length() > 6 && num && may && min && esp) {
            return COLOR_GREEN + "MUY SEGURA" + COLOR_RESET;
        } else if (contrasena.length() > 6) {
            return COLOR_YELLOW + "SEGURA" + COLOR_RESET;
        } else {
            return COLOR_RED + "POCO SEGURA" + COLOR_RESET;
        }
    }
}
