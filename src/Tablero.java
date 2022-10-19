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

    private boolean tableroLleno(){
        int i = 0; int j = 0; boolean ok = false;
        while(!ok && i < numColumnas){
            while (!ok && j < numFilas){
                if(columnas[i].getPosiciones()[j] == Colores.VACIO)
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
        for(int i = 1; i < numFilas; i++){
            for(int j = 0; j < numColumnas; j++){
                if(columnas[j].getPosiciones()[i].equals(columnas[j].getPosiciones()[i-1])){
                    cuenta++;
                } else
                    cuenta = 0;
                if(cuenta >= mejor)
                    mejor = cuenta;
            }
        }
        return mejor >= 4;

    }

    private boolean comprobar4enHorizontal(){
        int cuenta = 0;
        int mejor = 0;
        for(int i = 0; i < numFilas; i++){
            for(int j = 1; j < numColumnas; j++){
                if(columnas[i].getPosiciones()[j].equals(columnas[i].getPosiciones()[j-1])){
                    cuenta++;
                } else
                    cuenta = 0;
                if(cuenta >= mejor)
                    mejor = cuenta;
            }
        }
        return mejor >= 4;
    }

    public boolean isFinDePartida(){
        return tableroLleno();
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
