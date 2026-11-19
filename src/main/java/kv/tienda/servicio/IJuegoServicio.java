package kv.tienda.servicio;

import kv.tienda.modelo.Juego;

import java.util.List;

public interface IJuegoServicio {
    public List<Juego> listarJuegos(); // Listar juegos

    public Juego buscarJuegoPorId(Integer idJuego); // Busqueda del juego

    public void guardarJuego(Juego juego);

    public void eliminarJuego(Integer idJuego);

    List<Juego> buscarPorNombre(String nombre);
}
