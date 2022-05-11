package dia19.example.dia19.Controllers.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dia19.example.dia19.Models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findById(long id);
    Client findByDni(long dni);
}