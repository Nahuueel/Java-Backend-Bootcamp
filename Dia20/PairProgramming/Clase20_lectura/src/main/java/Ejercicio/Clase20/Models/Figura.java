package Ejercicio.Clase20.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="figuras")
public class Figura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double precio;
    private String nombre;
    private String marca;
    private String origen;
}
