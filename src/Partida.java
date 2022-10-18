public class Partida {
    Jugador jugadorUno;
    Jugador jugadorDos;
    Tablero tablero;

    public Partida(Tablero tablero, Jugador jugador1, Jugador jugador2){
        this.tablero = tablero;
        this.jugadorUno = jugador1;
        this.jugadorDos = jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void dibujarTablero(){

        for(int i = tablero.getNumFilas(); i > 0; i--){
            for (int j = 0; j < tablero.getNumColumnas(); j++){
                System.out.print(tablero.getColumnas()[j].getUnaPosicion(i).getPinta() + "  ");
            }
            System.out.println();
        }
    }

}
