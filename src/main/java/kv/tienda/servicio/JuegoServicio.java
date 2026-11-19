package kv.tienda.servicio;

import kv.tienda.modelo.Juego;
import kv.tienda.repositorio.JuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoServicio implements IJuegoServicio { // Capa Servicio

    @Autowired
    private JuegoRepositorio juegoRepositorio;

    @Override
    public List<Juego> listarJuegos() {
        return juegoRepositorio.findAll(); // Retornamos una lista de todos los juegos
    }

    @Override
    public Juego buscarJuegoPorId(Integer idJuego) {
        return juegoRepositorio.findById(idJuego).orElse(null); // sino lo encuentra regresa un null, de lo contrario regresa el objeto
    }

    @Override
    public void guardarJuego(Juego juego) {
        juegoRepositorio.save(juego);
    }

    @Override
    public void eliminarJuego(Integer idJuego) {
        juegoRepositorio.deleteById(idJuego);
    }

    // Retornamos la lista de juegos que tengan el nombre que busquemos ignorando mayusculas y minusculas
    @Override
    public List<Juego> buscarPorNombre(String nombre) {
        return juegoRepositorio.findByNombreJuegoContainingIgnoreCase(nombre);
    }


}
