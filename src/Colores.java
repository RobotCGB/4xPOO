public enum Colores {
    ROJO("R"), AZUL("A"), VACIO("-");

    private String pinta;

    private Colores(String pinta){
        this.pinta = pinta;
    }

    public String getPinta() {
        return pinta;
    }
}
