package metodos;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class SolicitudDatos {

    /**
     * Declaracion de las variables de clase
     */
    public static String nombre;
    public static String apellido1;
    public static String apellido2;
    public static String dni;
    public static Date fecha;

    public static Scanner entrada = new Scanner(System.in);

    /**
     * Metodo que valida que el nombre solo contenga letras y sea mayor a 3
     * caracteres
     */
    private static void nombre() {
        do {
            System.out.print("Por favor, escriba su nombre, en caso de nombre compuesto elija uno: ");
            nombre = entrada.nextLine().toLowerCase();
        } while (!nombre.matches("[A-Za-z]*") || nombre.length() < 3);
    }

    /**
     * Metodo que valida que el primer apellido contenga solo letras y sea mayor
     * a 2 caracteres, acepta apellidos compuestos
     */
    private static void apellido1() {
        do {
            System.out.print("Por favor, escriba su primer apellido: ");
            apellido1 = entrada.nextLine().toLowerCase();
        } while (!apellido1.matches("[A-Za-z ]*") || apellido1.length() < 2);
    }

    /**
     * Metodo que valida que el segundo apellido contenga solo letras y sea
     * mayor a 2 caracteres, acepta apellidos compuestos
     */
    private static void apellido2() {
        do {
            System.out.print("Por favor, escriba su segundo apellido: ");
            apellido2 = entrada.nextLine().toLowerCase();
        } while (!apellido2.matches("[A-Za-z ]*") || apellido2.length() < 2);
    }

    /**
     * Metodo que valida que un DNI sea correcto, genera la letra del DNI usando
     * 8 digitos
     *
     * @return DNI validado con letra correspondiente
     */
    private static String dni() {
        do {
            System.out.print("Por favor introduzca 8 numeros para generar un DNI o escriba los 8 numeros de un DNI existente sin escribir la letra: ");
            dni = entrada.nextLine();
            // Expresion regular para saber si la cadena contiene solo numeros
        } while (!dni.matches("[0-9]*") || dni.length() != 8);

        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numeroDNI = Integer.parseInt(dni);
        char letra = caracteres.charAt(numeroDNI % 23);
        dni = "" + numeroDNI + letra;
        return dni;
    }

    /**
     * Metodo que valida una fecha de nacimiento introducida por el usuario
     * teniendo en cuenta si la fecha es correcta, 31 de febrero es invalido,
     * pero si se pone 29 de febrero un año bisiesto si es admitido
     *
     * @return fecha validada y correcta
     */
    private static Date fechaNacim() {
        boolean valido;
        String fString;
        fecha = null;
        Date hoy = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        do {
            System.out.print("Introduzca su fecha de nacimiento con formato dd/MM/yyyy: ");
            fString = entrada.nextLine();
            df.setLenient(false);
            try {
                fecha = df.parse(fString);
                df.format(hoy);
                if (hoy.before(fecha)) {
                    System.out.println("No puede poner una fecha de nacimiento posterior a " + hoy);
                    valido = true;
                } else {
                    valido = false;
                }
            } catch (ParseException e) {
                System.out.println("Fecha invalida");
                valido = true;
            }
            if (!valido) {
                String[] fechaSplit = fString.split("/");
                int ano = Integer.parseInt(fechaSplit[2]);
                valido = ano - 1900 < 0;
            }
        } while (valido);
        return fecha;
    }

    /**
     * Metodo que llama todas las solicitudes de datos para una mayor comodidad
     * al usar
     */
    public static void solicitud() {
        nombre();
        apellido1();
        apellido2();
        dni();
        fechaNacim();
    }
}
