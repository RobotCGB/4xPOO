public enum Colores {
    ROJO("R", "\u001B[31m"), AZUL("A", "\u001B[36m"), VACIO("-", "\u001B[0m");

    private String pinta;
    private String pigmento;

    private Colores(String pinta, String pigmento){
        this.pinta = pinta;
        this.pigmento = pigmento;
    }

    public String getPinta() {
        return pinta;
    }

    public String getPigmento() {
        return pigmento;
    }
}
