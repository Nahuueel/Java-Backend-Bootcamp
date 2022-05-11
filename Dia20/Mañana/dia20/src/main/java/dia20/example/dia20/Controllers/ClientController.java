package dia20.example.dia20.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dia20.example.dia20.Controllers.Service.ClientService;
import dia20.example.dia20.Models.Client;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService cs;

    @GetMapping()
    public String getClients(Model model){
        model.addAttribute("clients", cs.getAllClients());
        return "ClientsIndex";
    }

    @GetMapping("/find")
    public String getClients(Model model, @RequestParam long dni){
        model.addAttribute("clients", cs.getOneUser(dni));
        return "ClientsIndex";
    }

    @GetMapping("/create")
    public String showCreateClient(Model model){
        Client client=new Client();
        model.addAttribute("client", client);
        return "ClientCreate";
    }

    @PostMapping("/create")
    public String saveClient(@ModelAttribute("client") Client client){
        cs.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/update/{id}")
    public String showUpdateClient(Model model, @PathVariable("id") long id){
        Client client=new Client();
        client.setId(id);
        model.addAttribute("client", client);
        return "ClientUpdate";
    }

    @PostMapping("/update")
    public String updateClient(@Validated @ModelAttribute("client") Client client, BindingResult result) {
        if(result.hasErrors()) return "update_user";
        cs.saveClient(client); 
        return "redirect:/clients";
    }
    

    @GetMapping("/delete/{id}")
    public String showDeleteClient( @PathVariable("id") long id){
        Client client=new Client();
        cs.deleteClient(id);
        return "redirect:/clients";
    }
}