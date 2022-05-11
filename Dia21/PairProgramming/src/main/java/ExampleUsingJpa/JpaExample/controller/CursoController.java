package ExampleUsingJpa.JpaExample.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ExampleUsingJpa.JpaExample.model.Curso;
import ExampleUsingJpa.JpaExample.repository.CursoRepository; 

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
  
  @Autowired
  CursoRepository cursoRepository;
 

  @PostMapping
  public ResponseEntity<Curso> createTutorial(@RequestBody Curso curso) {
    try {
      Curso cursito = new Curso();
      cursito.setName(curso.getName());
      cursito.setDescription(curso.getDescription());
      cursito.setPublished(curso.isPublished());
      cursito.setPrice(curso.getPrice());
      cursito.setUser(curso.getUser());
      cursoRepository.save(cursito);
      return new ResponseEntity<>(curso, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/published")
  public ResponseEntity<Integer> findByPublished() {
    try {
      int cursos = cursoRepository.countPublished(true);
      if (cursos == 0) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(cursos, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/{id}")
  public double totalPrecioCursos(@PathVariable("id") long id) {
	  return cursoRepository.countCursos(id);
  }
  
  
}