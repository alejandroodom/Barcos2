import java.util.Scanner;

public class Main {
    private static char[][] tablero;
    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;
    private static final int NUM_BARCOS = 5;
    private static final char BARCO = 'B';
    private static final char AGUA = ' ';

    public static void main(String[] args) {
        initializarTablero();
        mostrarTablero();

        int barcosRestantes = NUM_BARCOS;
        while (barcosRestantes > 0) {
            int fila = introducirEnteroEntreLimites("Introduce fila (0-9): \n", 0, 9);
            int columna = introducirEnteroEntreLimites("Introduce columna (0-9): ", 0, 9);

            if (disparar(fila, columna)) {
                System.out.println("¡Barco!");
                barcosRestantes--;
            } else {
                System.out.println("¡Agua!");
            }
        }

        System.out.println("¡Has ganado!");
    }

    private static void initializarTablero() {
        tablero = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = AGUA;
            }
        }

        int barcosColocados = 0;
        while (barcosColocados < NUM_BARCOS) {
            int fila = (int) (Math.random() * FILAS);
            int columna = (int) (Math.random() * COLUMNAS);

            if (tablero[fila][columna] != BARCO) {
                tablero[fila][columna] = BARCO;
                barcosColocados++;
            }
        }
    }

    private static void mostrarTablero() {
        System.out.print("  ");
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < FILAS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int introducirEnteroEntreLimites(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()) {
                System.out.print(mensaje);
                sc.next();
            }
            num = sc.nextInt();
        } while (num < minimo || num > maximo);

        return num;
    }

    private static boolean disparar(int fila, int columna) {
        if (tablero[fila][columna] == BARCO) {
            tablero[fila][columna] = AGUA;
            return true;
        } else {
            return false;
        }
    }
}

