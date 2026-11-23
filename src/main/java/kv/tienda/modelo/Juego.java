package kv.tienda.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Juego { // Capa entidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idJuego;

    @NotBlank(message = "El nombre es obligatorio")
    String nombreJuego;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    //@ToString.Exclude
    Categoria categoria;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    Double precioJuego;
}
