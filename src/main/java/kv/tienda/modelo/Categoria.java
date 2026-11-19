package kv.tienda.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCategoria;

    private String nombreCategoria;

    // Una categoria puede tener muchos juegos asociados
    @OneToMany(mappedBy = "categoria")
    private List<Juego> juegos;
}
