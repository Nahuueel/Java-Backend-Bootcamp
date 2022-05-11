package ExampleUsingJpa.JpaExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ExampleUsingJpa.JpaExample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	
	
}
