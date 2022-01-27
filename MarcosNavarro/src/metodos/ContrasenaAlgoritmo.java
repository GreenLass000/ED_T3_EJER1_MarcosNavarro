package metodos;

import java.security.SecureRandom;

public class ContrasenaAlgoritmo {

    public static String MINUS = "abcdefghijklmnopqrstuvwxyz";
    public static String MAYUS = MINUS.toUpperCase();
    public static String NUMBER = "0123456789";
    public static String ESP = "!\"·$%&/()=";

    public static String contrasenaSR() {

        String cadena = MAYUS + MINUS + ESP + NUMBER;

        String contrasena = "";
        SecureRandom secRand = new SecureRandom();

        int randLong = secRand.nextInt(5) + 4;

        for (int i = 0; i < randLong; i++) {
            int nRandom = secRand.nextInt(cadena.length());
            contrasena += cadena.charAt(nRandom);
        }
        return contrasena;
    }
}
