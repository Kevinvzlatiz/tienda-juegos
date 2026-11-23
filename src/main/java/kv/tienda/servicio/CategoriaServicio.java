package kv.tienda.servicio;

import kv.tienda.modelo.Categoria;
import kv.tienda.repositorio.CategoriaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class CategoriaServicio implements ICategoriaServicio {

    private CategoriaRepositorio categoriaRepositorio;

    // retornamos las categorias existentes
    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.findAll();
    }

    // Guardamos la categoria en la base de datos
    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaRepositorio.save(categoria);
    }

    // Buscamos categoria por id
    @Override
    public Categoria buscarCategoriaPorId(Integer idCategoria) {
        return categoriaRepositorio.findById(idCategoria).orElse(null);
    }

    // Eliminamos la categoria por id
    @Override
    public void eliminarCategoria(Integer idCategoria) {
        categoriaRepositorio.deleteById(idCategoria);
    }
}
