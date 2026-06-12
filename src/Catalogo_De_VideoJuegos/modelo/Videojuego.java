package Catalogo_De_VideoJuegos.modelo;

public class Videojuego {

    private int    id;
    private String titulo;
    private String genero;
    private String desarrollador;
    private int    anio;
    private double precio;

    public Videojuego(String titulo, String genero, String desarrollador,
                      int anio, double precio) {
        this.titulo        = titulo;
        this.genero        = genero;
        this.desarrollador = desarrollador;
        this.anio          = anio;
        this.precio        = precio;
    }

    public Videojuego(int id, String titulo, String genero, String desarrollador,
                      int anio, double precio) {
        this.id            = id;
        this.titulo        = titulo;
        this.genero        = genero;
        this.desarrollador = desarrollador;
        this.anio          = anio;
        this.precio        = precio;
    }

    public int    getId()            { return id; }
    public String getTitulo()        { return titulo; }
    public String getGenero()        { return genero; }
    public String getDesarrollador() { return desarrollador; }
    public int    getAnio()          { return anio; }
    public double getPrecio()        { return precio; }

    public void setId(int id)                     { this.id            = id; }
    public void setTitulo(String titulo)          { this.titulo        = titulo; }
    public void setGenero(String genero)          { this.genero        = genero; }
    public void setDesarrollador(String d)        { this.desarrollador = d; }
    public void setAnio(int anio)                 { this.anio          = anio; }
    public void setPrecio(double precio)          { this.precio        = precio; }

    @Override
    public String toString() {
        return String.format(
            "ID: %-3d | %-30s | %-12s | %-20s | %d | $%.2f",
            id, titulo, genero, desarrollador, anio, precio);
    }
}
