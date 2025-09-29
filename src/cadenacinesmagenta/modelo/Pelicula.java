
package cadenacinesmagenta.modelo;


public class Pelicula {
    
    private int id,anio,duracion;
    private String titulo,director,genero;

    public Pelicula() {
    }

    public Pelicula(int id, String titulo, String director, int anio, int duracion, String genero) {
       this.id = id;
       this.titulo = titulo;
       this.director = director;
       this.anio = anio;
       this.duracion = duracion;
       this.genero = genero;
   }

    public Pelicula( String titulo, String director, int anio, int duracion, String genero) {
        this.anio = anio;
        this.duracion = duracion;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString(){
        return id + " | " + titulo + " | " + director + " | " + anio + " | " + duracion + " | " + genero;
    }
    
}
