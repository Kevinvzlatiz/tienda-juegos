package kv.tienda.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCategoria;

    private String nombreCategoria;

    // Una categoria puede tener muchos juegos asociados
    @OneToMany(mappedBy = "categoria")
    //@ToString.Exclude
    private List<Juego> juegos;
}
