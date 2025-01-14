package Salas_de_video;
import java.util.*;

public class Sala {
    public int capacidadAsientos;
    int asientosVendidos;
    public String codigoSala;
    Map<String, ArrayList<Seat>> butacasMap;
    ArrayList<Pelicula> carteleraSala;

    public Sala(String codigoSala) {
        butacasMap = new Hashtable<>();
        this.codigoSala = codigoSala;
        carteleraSala = new ArrayList<>();
    }

    public int getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public void setCapacidadAsientos(int capacidadAsientos){
        this.capacidadAsientos = capacidadAsientos;
    }

    public ArrayList<Pelicula> getCarteleraSala() {
        return carteleraSala;
    }

    public void setButacasMap(Map<String, ArrayList<Seat>> butacasMap) {
        this.butacasMap = butacasMap;
    }

    public Map<String, ArrayList<Seat>> getButacasMap () {
        return butacasMap;
    }

    public void setAsientosVendidos(int asientosVendidos) {
        this.asientosVendidos = asientosVendidos;
    }

    public int getAsientosVendidos() {
        return asientosVendidos;
    }

    public void InsertarPelicula (Pelicula pelicula){
        int cantidadPeliculas = carteleraSala.size();
        int calificacionPelicula = pelicula.getCalificacion();
        switch (capacidadAsientos) {
            case 50:
                if (cantidadPeliculas < 5 && calificacionPelicula <= 5) {
                    carteleraSala.add(pelicula);
                }
            case 80:
                if (cantidadPeliculas < 5 && calificacionPelicula > 5 && calificacionPelicula < 9) {
                    carteleraSala.add(pelicula);
                }
                break;
            case 100:
                if (cantidadPeliculas < 5 && calificacionPelicula > 8) {
                    carteleraSala.add(pelicula);
                }
                break;
            }
    }

    public void llenarCarteleraRandom(){
        int max = 16;
        while (carteleraSala.size()!=5){
            int index = (int) (Math.random() * max);
            InsertarPelicula(BaseDeDatos.listaPeliculas().get(index));
        }
    }

    public ArrayList<String> getListaPeliculas(){
        ArrayList<String> listaPelicula = new ArrayList<>();
        for (Pelicula pelicula : carteleraSala){
            listaPelicula.add(pelicula.nombre);
        }
        return listaPelicula;
    }

    public Pelicula getPelicula(String namePelicula){
        for (Pelicula pelicula:
                carteleraSala) {
            if (pelicula.nombre.equals(namePelicula)){
                return pelicula;
            }
        }
        return carteleraSala.get(1);
    }
}

