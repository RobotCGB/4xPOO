public class Partida {
    Jugador[] jugadores;
    Tablero tablero;

    public Partida(){
        this.tablero = new Tablero(7,6);
        this.jugadores = new Jugador[2];
        this.jugadores[0] = new Jugador("Default1");
        this.jugadores[1] = new Jugador("Default2");
    }

    public Partida(Jugador jugador1, Jugador jugador2){
        super();
        this.jugadores[0] = jugador1;
        this.jugadores[1] = jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

}
