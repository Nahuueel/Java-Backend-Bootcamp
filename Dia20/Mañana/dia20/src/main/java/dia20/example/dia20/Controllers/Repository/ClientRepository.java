package dia20.example.dia20.Controllers.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dia20.example.dia20.Models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findById(long id);
    Client findByDni(long dni);
}