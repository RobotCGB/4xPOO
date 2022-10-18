public class Columna {

    private Colores[] posiciones;
    private final int numHuecos = 7;

    public Columna(){
        this.posiciones = new Colores[this.numHuecos];
        for(int i = 0; i < numHuecos; i++)
            posiciones[i] = Colores.VACIO;
    }

    public boolean insertarFichaEnColumna(Colores color){
        boolean ok = false;
        int i = 0;
        while(!ok && i < posiciones.length){
            if(posiciones[i] != Colores.VACIO){
                ok = true;
                posiciones[i] = color;
            }
        }
        return ok;
    }

    public Colores[] getPosiciones() {
        return posiciones;
    }

    public Colores getUnaPosicion(int i){return posiciones[i];}

    public void setUnaPosicion(Colores color, int i){
        posiciones[i] = color;
    }

}
