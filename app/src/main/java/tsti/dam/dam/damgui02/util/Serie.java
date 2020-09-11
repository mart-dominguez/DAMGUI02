package tsti.dam.dam.damgui02.util;

public class Serie {
    private String titulo;
    private Integer calificacion;
    private Integer reproducciones;
    private Boolean favorita;
    private String genero;

    public Serie(String titulo, Integer calificacion, Integer reproducciones, Boolean favorita, String genero) {
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.reproducciones = reproducciones;
        this.favorita = favorita;
        this.genero = genero;
    }

    public Serie() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(Integer reproducciones) {
        this.reproducciones = reproducciones;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getFavorita() {
        return favorita;
    }

    public void setFavorita(Boolean favorita) {
        this.favorita = favorita;
    }

    @Override
    public String toString() {
        return titulo.toUpperCase()+ " - " + genero;
    }
}
