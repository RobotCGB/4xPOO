public class Tablero {

    private final int numColumnas = 7;
    private final int numFilas = 6;
    private Columna[] columnas;

    public Tablero(){
        columnas = new Columna[numColumnas];
        for(int i = 0; i < numColumnas; i++){ columnas[i] = new Columna(); }
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public Columna[] getColumnas() {
        return columnas;
    }

    public boolean tableroLleno(){
        int i = 0; int j = 0; boolean ok = false;
        while(!ok && i < numColumnas){
            while (!ok && j < numFilas){
                if(columnas[i].getUnaPosicion(j) == Colores.VACIO)
                    ok = true;
                j++;
            }
            j=0;
            i++;
        }
        return !ok;
    }

    private boolean comprobar4enVertical(){
        int cuenta = 0;
        int mejor = 0;
        for(int i = 0; i < numFilas; i++){
            for(int j = 0; j < numColumnas-1; j++){
                if(columnas[i].getUnaPosicion(j) == columnas[i].getUnaPosicion(j+1) && columnas[i].getUnaPosicion(j) != Colores.VACIO){
                    cuenta++;
                } else
                    cuenta = 0;
                if(cuenta >= mejor)
                    mejor = cuenta;
            }
            cuenta = 0;
        }
        return mejor >= 3;

    }

    private boolean comprobar4enHorizontal(){
        int cuenta = 0;
        int mejor = 0;
        for(int i = 0; i < numFilas; i++){
            for(int j = 0; j < numColumnas-1; j++){
                if(columnas[j].getUnaPosicion(i) == columnas[j+1].getUnaPosicion(i) && columnas[j].getUnaPosicion(i) != Colores.VACIO){
                    cuenta++;
                } else
                    cuenta = 0;
                if(cuenta >= mejor)
                    mejor = cuenta;
            }
            cuenta = 0;
        }
        return mejor >= 3;
    }

    public boolean isFinDePartida(){
        return tableroLleno() || comprobar4enVertical() || comprobar4enHorizontal();
    }

    public boolean insertarFicha(Colores color, int noColm){
        boolean ok = false;
        Columna colmSelec = columnas[noColm];
        int i = 0;
        while(!ok && i < numFilas){
            if(colmSelec.getUnaPosicion(i) == Colores.VACIO){
                colmSelec.setUnaPosicion(color, i);
                ok = true;
            }
            i++;
        }

        if(!ok){
            System.out.println("Columna llena");
        }

        return ok;
    }

}
