package metodos;

public class GeneradorUsuario {

    /**
     * Metodo que genera el nombre de usuario utilizando los datos recibidos por
     * el metodo de validacion
     *
     * @return usuario generado
     */
    public static String usuario() {
        String n = SolicitudDatos.nombre;
        String name = n.substring(0, 3);
        String a1 = SolicitudDatos.apellido1;
        String ap1 = a1.substring(0, 2);
        String a2 = SolicitudDatos.apellido2;
        String ap2 = a2.substring(0, 2);
        return ap2 + ap1 + name;
    }
}
