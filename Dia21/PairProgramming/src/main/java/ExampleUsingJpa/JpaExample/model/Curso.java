package ExampleUsingJpa.JpaExample.model;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	
	private boolean published;
	private double price;
	
	@ManyToOne()
	@JoinColumn(name = "user_FK")
	private User user; 
	
	
	
}