package Ejercicio.Clase20.Controllers.Repository;

import Ejercicio.Clase20.Models.Figura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FiguraRepository extends CrudRepository<Figura, Long> {
    Figura findById(long id);
}
