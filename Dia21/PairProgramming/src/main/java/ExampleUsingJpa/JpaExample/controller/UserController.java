package ExampleUsingJpa.JpaExample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import ExampleUsingJpa.JpaExample.model.User;
import ExampleUsingJpa.JpaExample.repository.CursoRepository;
import ExampleUsingJpa.JpaExample.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	  
	  @Autowired
	  private UserRepository userRepository;
	  
	  @PostMapping
	  public ResponseEntity<User> createTutorial(@RequestBody User user) {
	    try {
	      User usersito = new User();
	      usersito.setUsername(user.getUsername());
	      usersito.setPassword(user.getPassword());
	      userRepository.save(usersito);
	      return new ResponseEntity<>(user, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  
	
	  
}
