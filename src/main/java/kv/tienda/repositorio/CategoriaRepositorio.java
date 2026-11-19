package kv.tienda.repositorio;

import kv.tienda.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio que se comunica con la tabla categoria
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}
