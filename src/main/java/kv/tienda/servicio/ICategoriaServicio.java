package kv.tienda.servicio;

import kv.tienda.modelo.Categoria;

import java.util.List;

public interface ICategoriaServicio {
    // Retornamos las categorias
    List<Categoria> listarCategorias();

    // Guardamos una categoria nueva o actualizada
    public void guardarCategoria(Categoria categoria);

    // Buscamos categoria por Id
    public Categoria buscarCategoriaPorId(Integer idCategoria);

    // Eliminamos categoria por Id
    public void eliminarCategoria(Integer idCategoria);

}
