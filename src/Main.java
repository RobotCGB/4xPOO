import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();
        Partida partida = new Partida(tablero, jugadorUno, jugadorDos);

        partida.iniciarPartida();

    }

}
