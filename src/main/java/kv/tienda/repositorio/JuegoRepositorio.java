package kv.tienda.repositorio;

import kv.tienda.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JuegoRepositorio extends JpaRepository<Juego, Integer> {
    // Capa repositorio

    // Busca juegos cuyo nombre contenga el texto indicado, sin importar mayúsculas o minúsculas
    List<Juego> findByNombreJuegoContainingIgnoreCase(String nombre);

}
