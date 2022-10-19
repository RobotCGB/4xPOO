import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Partida partida = new Partida(tablero);

        partida.iniciarPartida();

    }

}
