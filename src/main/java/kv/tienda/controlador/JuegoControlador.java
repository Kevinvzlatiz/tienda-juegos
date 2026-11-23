package kv.tienda.controlador;

import jakarta.validation.Valid;
import kv.tienda.modelo.Categoria;
import kv.tienda.modelo.Juego;
import kv.tienda.servicio.CategoriaServicio;
import kv.tienda.servicio.JuegoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.List;

@Controller
public class JuegoControlador {

    // Informacion que se verá en consola
    private static final Logger logger = LoggerFactory.getLogger(JuegoControlador.class);

    @Autowired
    JuegoServicio juegoServicio;

    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo) {
        List<Juego> juegos = juegoServicio.listarJuegos();
        juegos.forEach(juego -> logger.info(juego.toString()));
        modelo.put("juegos", juegos);
        return "index"; // index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(ModelMap modelo) {

        // Objeto vacío para llenar el formulario del juego
        modelo.put("juegoForma", new Juego());

        // Lista de categorías para llenar el select
        modelo.put("categorias", categoriaServicio.listarCategorias());
        return "agregar"; // agregar.html
    }

    // Escucha las peticiones POST que llegan desde el formulario en la ruta "/agregar"
    @PostMapping("/agregar")
    public String agregar(@Valid @ModelAttribute("juegoForma") Juego juego,
                          BindingResult resultado, RedirectAttributes redirect) {

        // Revisamos si la validacion encontro errores
        if (resultado.hasErrors()) {
            logger.error("Error en el proceso de agregar del juego");
            return "agregar";
        }

        // Si no hubo errores, registramos en el log un mensaje informativo con el objeto guardado
        logger.info("Agregando el juego: " + juego);

        // Llama al servicio para guardar el objeto 'juego' en la base de datos
        juegoServicio.guardarJuego(juego);

        redirect.addFlashAttribute("mensaje", "Juego agregado correctamente"); // Mensaje que se muestra una sola vez

        // Redirige al usuario de vuelta a la página principal ("/") para evitar reenvíos duplicados
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idJuego, ModelMap modelo) {
        Juego juego = juegoServicio.buscarJuegoPorId(idJuego);
        logger.info("Juego editado: " + juego);
        modelo.put("juego", juego);
        modelo.put("categorias", categoriaServicio.listarCategorias());
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("juego") Juego juego) {
        //logger.info("Juego editado: " + juego);
        juegoServicio.guardarJuego(juego);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int idJuego) {
        juegoServicio.eliminarJuego(idJuego);
        return "redirect:/";
    }

    @GetMapping("/buscar")
    public String buscarJuego(@RequestParam String nombre, ModelMap modelo) {

        // Obtenemos la lista de los juegos encontrados
        List<Juego> juegos = juegoServicio.buscarPorNombre(nombre);

        // enviamos la lista a index.html
        modelo.put("juegos", juegos);

        return "index";
    }

}
