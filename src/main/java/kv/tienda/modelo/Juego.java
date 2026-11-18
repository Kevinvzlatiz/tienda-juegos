package kv.tienda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Juego { // Capa entidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idJuego;

    @NotBlank(message = "El nombre es obligatorio")
    String nombreJuego;

    @NotBlank(message = "El nombre es obligatorio")
    String categoriaJuego;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    Double precioJuego;
}
