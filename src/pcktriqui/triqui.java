package pcktriqui;

import java.util.Scanner;

public class triqui {

        // Creamos contsnates para jugador O y jugador X y para llenar con espacios vacios el tablero
        static final char jugador_o = 'O';
        static final char jugador_x = 'X';
        static final char espacioVacio = ' ';
        // Fin de creación de constantes
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char T[][] = new char[3][3]; // Tablero con matriz de 3x3
        boolean hayGanador = false; // Inicia en falso ya que no hemos jugado y no hay ganador
        int f,c; // Variables que serán las filas y las columnas de la matriz
        limpiarTablero(T); // Método que limpia el tablero
        System.out.println("Juego del Triqui v1");
        while (hayGanador == false){ //Condición, mientras no haya ganador seguirá jugando
            System.out.println("Jugada de O");
            System.out.println("Fila = ");
            f = teclado.nextInt(); //Entrada por consola del número de fila
            System.out.println("Columna = ");
            c = teclado.nextInt();//Entrada por consola del número de columna
            T[f][c] = jugador_o;//Fila y columna le agregamos el "O"
            mostrarTablero(T);//Método que nos muestra el tablero
            if (esGanador(T, jugador_o)) {
                System.out.println("Gana el jugador O");
                hayGanador = true;
                break;
            }
            System.out.println("Jugada de X");
            System.out.println("Fila = ");
            f= teclado.nextInt();
            System.out.println("Columna = ");
            c = teclado.nextInt();
            T[f][c] = jugador_x;
            mostrarTablero(T);
            if (esGanador(T, jugador_x)) {
                System.out.println("Gana el jugador X");
                hayGanador = true;
                break;
            }
        }
        if(hayGanador ==false){
            System.out.println("Empate");
        }
    }

    private  static boolean esGanador(char [][] t,char MJ){
        //Opciones para que haya un ganador
        boolean SW = false;
        if(t[0][0] == MJ && t[0][1] == MJ &&t[0][2] == MJ){
            SW = true;
        } else if (t[1][0] == MJ && t[1][1] == MJ &&t[1][2] == MJ) {
            SW = true;
        } else if (t[2][0] == MJ && t[2][1] == MJ &&t[2][2] == MJ) {
            SW = true;
        }else if (t[0][0] == MJ && t[1][0] == MJ &&t[2][0] == MJ){
            SW = true;
        } else if (t[0][1] == MJ && t[1][1] == MJ &&t[2][1] == MJ) {
            SW = true;
        } else if (t[0][2] == MJ && t[1][2] == MJ &&t[2][2] == MJ) {
            SW = true;
        } else if (t[0][0] == MJ && t[1][1] == MJ &&t[2][2] == MJ) {
            SW = true;
        } else if (t[0][2] == MJ && t[1][1] == MJ &&t[2][0] == MJ) {
            SW = true;
        }
        return SW;
    }
    private static void mostrarTablero(char t[][]) {
        int f,c;
        for(f =0 ;f<3;f++){
            for (c=0 ;c<3;c++){
                System.out.print("|"+t[f][c]);
            }
            System.out.println("|");
        }
    }


    private static void limpiarTablero(char[][] t){
        int f,c;
        for(f =0 ;f<3;f++){
            for (c=0 ;c<3;c++){
                t[f][c] = espacioVacio;
            }
        }
    }
}
