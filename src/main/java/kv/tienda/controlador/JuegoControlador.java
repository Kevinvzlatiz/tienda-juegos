package kv.tienda.controlador;

import jakarta.validation.Valid;
import kv.tienda.modelo.Juego;
import kv.tienda.servicio.JuegoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JuegoControlador {

    // Informacion que se verá en consola
    private static final Logger logger = LoggerFactory.getLogger(JuegoControlador.class);

    @Autowired
    JuegoServicio juegoServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo) {
        List<Juego> juegos = juegoServicio.listarJuegos();
        juegos.forEach(juego -> logger.info(juego.toString()));
        modelo.put("juegos", juegos);
        return "index"; // index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(ModelMap modelo) {
        modelo.put("juegoForma", new  Juego());
        return "agregar"; // agregar.html
    }

    // Escucha las peticiones POST que llegan desde el formulario en la ruta "/agregar"
    @PostMapping("/agregar")
    public String agregar(@Valid @ModelAttribute("juegoForma") Juego juego,
                          BindingResult resultado) {

        if (resultado.hasErrors()) {
            logger.error("Error en el proceso de agregar del juego");
            return "agregar";
        }

        logger.info("Agregando el juego: " + juego);

        // Llama al servicio para guardar el objeto 'juego' en la base de datos
        juegoServicio.guardarJuego(juego);

        // Redirige al usuario de vuelta a la página principal ("/") para evitar reenvíos duplicados
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idJuego, ModelMap modelo) {
        Juego juego = juegoServicio.buscarJuegoPorId(idJuego);
        logger.info("Juego editado: " + juego);
        modelo.put("juego", juego);
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("juegoForma") Juego juego) {
        logger.info("Juego editado: " + juego);
        juegoServicio.guardarJuego(juego);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int idJuego) {
        juegoServicio.eliminarJuego(idJuego);
        return "redirect:/";
    }

}
