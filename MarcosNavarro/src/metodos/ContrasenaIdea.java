package metodos;

public class ContrasenaIdea {

    /**
     * Metodo que verifica que un caracter no se haya convertido en espacio, y
     * en caso de que lo haya hecho cambiarlo a un 0, que es el valor que
     * deberia tener
     *
     * @param caracter a verificar si se ha convertido en espacio o no
     * @return caracter verificado
     */
    private static char espacio0(char caracter) {
        if (caracter == (int) 32) {
            return '0';
        }
        return caracter;
    }

    /**
     * Metodo que genera una contraseña basada en las especificaciones dadas en
     * el pdf, el metodo genera una contraseña completa y seguidamente la corta
     * dependiendo de la longitud requerida dada por el numero aleatorio
     * encargado de la asignacion de la longitud
     *
     * @return contrasena generada con el metodo
     */
    public static String contrasenaCompleta() {
        int rand = (int) (Math.random() * 9);
        String contrasena = "";
        /*char 1*/
        contrasena += SolicitudDatos.nombre.toUpperCase().charAt(0);
        /*char 2*/
        contrasena += SolicitudDatos.apellido1.charAt(SolicitudDatos.apellido1.length() - 1);
        /*char 3-4*/
        contrasena += SolicitudDatos.dni.substring(6, 8);
        /*char 5*/
        contrasena += SolicitudDatos.dni.charAt(8);
        /*char 6*/
        contrasena += espacio0(SolicitudDatos.fecha.toString().charAt(SolicitudDatos.fecha.toString().length() - 2));
        /*char 7*/
        contrasena += espacio0(SolicitudDatos.fecha.toString().charAt(SolicitudDatos.fecha.toString().length() - 1));
        /*char 8*/
        contrasena += ContrasenaAlgoritmo.ESP.charAt(rand);

        int r2 = (int) (Math.random() * 5) + 4;

        contrasena = contrasena.substring(0, r2);
        return contrasena;
    }
}
