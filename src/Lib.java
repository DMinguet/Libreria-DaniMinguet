import java.time.LocalDate;
import java.util.*;

public class Lib {
    public static final Scanner lector = new Scanner(System.in);
    private static final String ESCAPE = "\u001B[";
    private static final LocalDate FECHA_ACTUAL = LocalDate.now();
    private static final int DIA_MIN = 1;
    private static final int DIA_MAX = 31;
    private static final int MES_MIN = 1;
    private static final int MES_MAX = 12;
    private static final int ANYO_MIN = 1900;
    private static final int ANYO_MAX = FECHA_ACTUAL.getYear();
    private static final int LONGITUD_NIF = 9;

    public static int aleatorioEntero(int min, int max) {
        Random rd = new Random();
        int numeroAleatorio = rd.nextInt(max - min + 1) + min;

        return numeroAleatorio;
    }

    public static double aleatorioReal(int min, int max) {
        Random rd = new Random();

        double numeroAleatorio = min + (max - min) * rd.nextDouble();

        return numeroAleatorio;
    }

    public static boolean booleanAleatorio() {
        Random rd = new Random();

        return rd.nextBoolean();
    }

    public static String crearNifAleatorio() {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int nifInt, resto;
        String nif;
        char letra;

        nifInt = aleatorioEntero(10000000, 99999999);

        resto = nifInt % 23;
        letra = letras.charAt(resto);

        nif = String.valueOf(nifInt) + letra;

        return nif;
    }

    public static boolean validarNif(String nif) {
        char letra;

        if (nif.length() != LONGITUD_NIF || !Character.isLetter(nif.charAt(8))) {
            return false;
        }

        for (int i = 0; i < nif.length() - 1; i++) {
            if (Character.isLetter(nif.charAt(i))) {
                return false;
            }
        }

        letra = nif.toUpperCase().charAt(8);

        if (letraNif(nif) == letra) {
            return true;
        } else {
            return false;
        }
    }

    public static char letraNif(String nif) {
        int miNif = Integer.parseInt(nif.substring(0,8));
        int resto;
        char letra;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        resto = miNif % 23;

        letra = letras.charAt(resto);

        return letra;
    }

    public static GregorianCalendar obtenerFecha(int dia, int mes, int anyo) {
        Calendar fecha = GregorianCalendar.getInstance();

        switch (mes) {
            case 1:
                fecha.set(anyo, Calendar.JANUARY, dia);
                break;
            case 2:
                fecha.set(anyo, Calendar.FEBRUARY, dia);
                break;
            case 3:
                fecha.set(anyo, Calendar.MARCH, dia);
                break;
            case 4:
                fecha.set(anyo, Calendar.APRIL, dia);
                break;
            case 5:
                fecha.set(anyo, Calendar.MAY, dia);
                break;
            case 6:
                fecha.set(anyo, Calendar.JUNE, dia);
                break;
            case 7:
                fecha.set(anyo, Calendar.JULY, dia);
                break;
            case 8:
                fecha.set(anyo, Calendar.AUGUST, dia);
                break;
            case 9:
                fecha.set(anyo, Calendar.SEPTEMBER, dia);
                break;
            case 10:
                fecha.set(anyo, Calendar.OCTOBER, dia);
                break;
            case 11:
                fecha.set(anyo, Calendar.NOVEMBER, dia);
                break;
            case 12:
                fecha.set(anyo, Calendar.DECEMBER, dia);
                break;
        }

        return (GregorianCalendar) fecha;
    }

    public static void presionarIntroParaContinuar() {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pulsa Intro para continuar ...");
        try {
            seguir = teclado.nextLine();
            limpiarPantalla();
        } catch(Exception e) {

        }
    }

    public static void limpiarPantalla() {
        System.out.print(ESCAPE + "H");
        System.out.print(ESCAPE + "2J");
        System.out.flush();
    }

    public static void espera(int x){
        try{
            Thread.sleep(x);
        }catch(InterruptedException ie) {

        }
    }

    public static String leerLinea(String linea){
        boolean validado = false;
        String resultado = "";

        do {
            try {
                System.out.println(linea);
                resultado = lector.nextLine();
                validado = true;
            } catch (InputMismatchException ime) {
                System.out.println("Datos introducidos incorrectos");
            }

            if (isEmpty(resultado)) {
                validado = false;
                System.out.println("Contenido introducido vacío o no válido");
            }
        } while (!validado);

        return resultado;
    }

    public static boolean isEmpty(String linea) {
        return linea.isEmpty() || linea.startsWith(" ");
    }

    public static long leerLong(String linea) {
        boolean validado = false;
        long resultado = 0;

        do {
            try {
                System.out.println(linea);
                resultado = Long.parseLong(lector.nextLine());
                validado = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un entero");
            }
        } while (!validado);

        return resultado;
    }

    public static int leerInt(String linea){
        boolean validado = false;
        int resultado = 0;

        do {
            try {
                System.out.println(linea);
                resultado = Integer.parseInt(lector.nextLine());
                validado = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un entero");
            }
        } while (!validado);

        return resultado;
    }

    public static float leerFloat(String linea){
        boolean validado = false;
        float resultado = 0;

        do {
            try {
                System.out.println(linea);
                resultado = Float.parseFloat(lector.nextLine());
                validado = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un real");
            }
        } while (!validado);

        return resultado;
    }

    public static double leerDouble(String linea){
        boolean validado = false;
        double resultado = 0;

        do {
            try {
                System.out.println(linea);
                resultado = Double.parseDouble(lector.nextLine());
                validado = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un real");
            }
        } while (!validado);

        return resultado;
    }

    public static char leerChar(String linea){
        System.out.println(linea);
        return lector.next().charAt(0);
    }

    public static GregorianCalendar crearFechaAleatoria() {
        int anyo = aleatorioEntero(ANYO_MIN, ANYO_MAX);
        int mes = aleatorioEntero(MES_MIN, MES_MAX);
        int dia = aleatorioEntero(DIA_MIN, DIA_MAX);

        return obtenerFecha(dia, mes, anyo);
    }

    public static GregorianCalendar crearFechaAleatoriaMedianteAnyo(int anyoMin, int anyoMax) {
        int anyo = aleatorioEntero(anyoMin, anyoMax);
        int mes = aleatorioEntero(MES_MIN, MES_MAX);
        int dia = aleatorioEntero(DIA_MIN, DIA_MAX);

        return obtenerFecha(dia, mes, anyo);
    }
}
