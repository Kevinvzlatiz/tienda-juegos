package kv.tienda.repositorio;

import kv.tienda.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepositorio extends JpaRepository<Juego, Integer> {
    // Capa repositorio
}
