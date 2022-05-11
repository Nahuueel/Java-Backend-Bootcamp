package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Persona;

@RestController()
@RequestMapping("/personas")
public class PersonaController {
	
	Persona[] personas = {
            new Persona(1, "Charles", "Morris"),
            new Persona(2, "Tracey", "Ramos"),
            new Persona(3, "Michael", "Lawson"),
            new Persona(4, "Lindsay", "Ferguson")
    };
	
	@PostMapping("/agregar")
	public Persona agregar(@RequestBody Persona persona) {
		persona.setId(personas.length+1);
		return persona;
	}
	
	@GetMapping("/mostrar")
	public Persona[] mostrarTodos() {
		return personas;
	}
	
	@GetMapping("/mostrar/{id}")
	public Persona mostrarUno(@PathVariable (name= "id") int id) {
		if((id - 1) > (personas.length - 1) || (id - 1) < 0){
            return new Persona(0, null, null);
        }
		return personas[id-1];
	}
}