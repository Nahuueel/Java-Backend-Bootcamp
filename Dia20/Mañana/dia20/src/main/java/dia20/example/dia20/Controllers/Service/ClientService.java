package dia20.example.dia20.Controllers.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dia20.example.dia20.Controllers.Repository.ClientRepository;
import dia20.example.dia20.Models.Client;

@Service
public class ClientService {
    @Autowired
    ClientRepository cr;

    public ArrayList<Client> getAllClients() { return (ArrayList<Client>) cr.findAll(); }

    public void saveClient(Client client) { cr.save(client); }

    public void deleteClient(long id) {
        Client client=new Client();
        client=cr.findById(id);
        cr.delete(client);
    }

    public Client getOneUser(long dni) {
        return cr.findByDni(dni);
    }
}