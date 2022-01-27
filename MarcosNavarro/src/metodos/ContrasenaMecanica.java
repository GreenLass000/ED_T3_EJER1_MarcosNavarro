package metodos;

public class ContrasenaMecanica {

    // - Tabla para generar caracteres aleatorios
    // - -----------------------------
    // - |...| 1 | 2 | 3 | 4 | 5 | 6 |
    // - |---|---|---|---|---|---|---|
    // - | 1 | a | b | c | d | e | f |
    // - |---|---|---|---|---|---|---|
    // - | 2 | g | h | i | j | k | l |
    // - |---|---|---|---|---|---|---|
    // - | 3 | m | n | o | p | q | r |
    // - |---|---|---|---|---|---|---|
    // - | 4 | s | t | u | v | w | x |
    // - |---|---|---|---|---|---|---|
    // - | 5 | y | z | 0 | 1 | 2 | 3 |
    // - |---|---|---|---|---|---|---|
    // - | 6 | 4 | 5 | 6 | 7 | 8 | 9 |
    // - -----------------------------
    /**
     * Metodo que genera caracteres aleatorios usando matrices. Este método no
     * está utilizado en esta version del programa
     *
     * @return caracter aleatorio en una matriz
     */
    private static String eleccionTablaMatriz() {
        int cols = (int) (Math.random() * (6)) + 1;
        int rows = (int) (Math.random() * (6)) + 1;
        int capitalLetter = (int) (Math.random() * (2));
        String letra;

        String[][] tablaCara = {{"a", "b", "c", "d", "e", "f"}, {"g", "h", "i", "j", "k", "l"},
        {"m", "n", "o", "p", "q", "r"}, {"s", "t", "u", "v", "w", "x"}, {"y", "z", "0", "1", "2", "3"},
        {"4", "5", "6", "7", "8", "9"}};

        String[][] tablaCruz = {{"A", "B", "C", "D", "E", "F"}, {"G", "H", "I", "J", "K", "L"},
        {"M", "N", "O", "P", "Q", "R"}, {"S", "T", "U", "V", "W", "X"}, {"Y", "Z", "=", "!", "\"", "·"},
        {"$", "%", "&", "/", "(", ")"}};

        if (capitalLetter == 0) {
            letra = tablaCara[rows - 1][cols - 1];
            return letra;
        } else {
            letra = tablaCruz[rows - 1][cols - 1];
            return letra;
        }
    }

    /**
     * Metodo que devuelve un caracter aleatorio de una tabla de caracteres
     *
     * @return caracter de una tabla
     */
    private static char caracter() {

        String minus = "abcdefghijklmnopqrstuvwxyz";
        String mayus = minus.toUpperCase();
        String number = "0123456789";
        String esp = "=!\"·$%&/()";

        int cols = (int) (Math.random() * (6)) + 1;
        int rows = (int) (Math.random() * (6)) + 1;
        int capitalLetter = (int) (Math.random() * (2));
        String tabla;
        char letra;

        if (capitalLetter == 0) {
            tabla = (minus + number);
            letra = tabla.charAt(((rows - 1) * 6) + (cols - 1));
        } else {
            tabla = (mayus + esp);
            letra = tabla.charAt(((rows - 1) * 6) + (cols - 1));
        }
        return letra;
    }

    /**
     * Metodo que genera una contraseña concatenando los caracteres extraidos de
     * la tabla hasta tener la longitud marcada por el numero random de control
     *
     * @return contrasena aleatoria
     */
    public static String contrasenaMecanica() {
        int longitud = (int) (Math.random() * (5)) + 4;
        String contrasena = "";

        for (int i = 0; i < longitud; i++) {
            contrasena += caracter();
        }
        return contrasena;
    }
}
