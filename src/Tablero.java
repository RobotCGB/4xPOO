public class Tablero {

    private int numColumnas;
    private int numFilas;
    private Columna[] columnas;

    public Tablero(){
        this.numColumnas = 7;
        this.numFilas = 6;
        columnas = new Columna[numColumnas];
    }

    public Tablero(int numFilas, int numColumnas){
        super();
        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
    }

    private boolean tableroLleno(){
        int i = 0; int j = 0; boolean ok = false;
        while(!ok && i < numColumnas){
            while (!ok && j < numFilas){
                if(columnas[i].getPosiciones()[j] == Colores.VACIO)
                    ok = true;
            }
        }
        return !ok;
    }

    private boolean enVertical(){//de este no estoy seguro, me he marcado un poco un triple
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

    private boolean enHorizontal(){
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
        return tableroLleno() || enHorizontal() || enVertical();
    }



}
