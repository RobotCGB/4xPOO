import java.awt.*;
import java.util.Scanner;

public class Partida {
    Jugador jugadorUno;
    Jugador jugadorDos;
    Tablero tablero;
    Colores jugadorActual;

    public Partida(Tablero tablero, Jugador jugador1, Jugador jugador2){
        this.tablero = tablero;
        this.jugadorUno = jugador1;
        this.jugadorDos = jugador2;
        this.jugadorActual = Colores.ROJO;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void dibujarTablero(){
        for(int i = tablero.getNumFilas() - 1; i >= 0; i--){
            for (int j = 0; j < tablero.getNumColumnas(); j++){
                System.out.print(" | ");
                if(!tablero.getColumnas()[j].getUnaPosicion(i).equals(Colores.VACIO))
                    System.out.print(tablero.getColumnas()[j].getUnaPosicion(i).getPinta());
                else System.out.print(" ");
                if(j == tablero.getNumColumnas()-1)
                    System.out.print(" |");
            }
            System.out.println();
        }
    }

    public void iniciarPartida(){
        boolean fin = false;
        Scanner sc = new Scanner(System.in);
        int posicionElegida = -1;
        boolean columnaEsPosible = false;

        do {
            System.out.print("Le toca al jugador: ");
            if(jugadorActual == Colores.ROJO){System.out.println("ROJO");} else {System.out.println("AZUL");}

            dibujarTablero();

            while(!columnaEsPosible) {
                System.out.print("¿En que posicion colocas ficha? [1-7]: ");
                posicionElegida = sc.nextInt();
                if (posicionElegida >= 1 && posicionElegida <= 7) {
                    columnaEsPosible = tablero.insertarFicha(jugadorActual, posicionElegida - 1);
                } else {
                    System.out.println("Columna no esta entre los valores posibles [1-7]");
                }
            }
            columnaEsPosible = false;
            cambioDeJugador();
            fin = tablero.isFinDePartida();

            System.out.println();
            System.out.println();

        } while(!fin);

        System.out.println("Se acabó la partida. GAME OVER");

    }

    private void cambioDeJugador(){
        if(jugadorActual == Colores.ROJO)
            jugadorActual = Colores.AZUL;
        else
            jugadorActual = Colores.ROJO;
    }

}
