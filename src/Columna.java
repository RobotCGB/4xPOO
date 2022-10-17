public class Columna {
    private Colores[] posiciones;
    private int numHuecos;

    public Columna(int numHuecos){
        this.numHuecos = numHuecos;
        this.posiciones = new Colores[this.numHuecos];
        for(int i = 0; i < numHuecos; i++)
            posiciones[i] = Colores.VACIO;
    }

    public void insertarFicha(boolean rojo){
        boolean ok = false;
        int i = 0;
        while(!ok && i < posiciones.length){
            if(posiciones[i] != Colores.VACIO){
                ok = true;
                posiciones[i] = Colores.ROJO;
            }
        }
    }

    public Colores[] getPosiciones() {
        return posiciones;
    }
}
