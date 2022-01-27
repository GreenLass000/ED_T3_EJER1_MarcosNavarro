package metodos;

public class Main {

    /**
     * Metodo que escribe unos patrones para poder diferenciar correctamente
     * todas las secciones de la aplicacion
     *
     * @param tipo marca que tipo de contraseña corresponde
     * @param c se inserta un String con la contraseña para poder escribirlo
     */
    private static void decoration(String tipo, String c) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("La contraseña generada por " + tipo + " es: ");
        System.out.println(c + "\nEl nivel de seguridad es: " + ComprobadorSeguridad.seguridad(c));
    }

    public static void main(String[] args) {
        SolicitudDatos.solicitud();
        System.out.println();
        String usuario = GeneradorUsuario.usuario();
        String cMec = ContrasenaMecanica.contrasenaMecanica();
        String cAlg = ContrasenaAlgoritmo.contrasenaSR();
        String cId = ContrasenaIdea.contrasenaCompleta();

        System.out.println("Su usuario es: " + usuario);
        decoration("contraseña mecanica", cMec);
        decoration("algoritmo", cAlg);
        decoration("\"mi idea\"", cId);
    }
}
