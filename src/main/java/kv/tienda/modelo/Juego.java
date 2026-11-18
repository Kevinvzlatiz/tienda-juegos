package kv.tienda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    String nombreJuego;
    String categoriaJuego;
    Double precioJuego;
}
