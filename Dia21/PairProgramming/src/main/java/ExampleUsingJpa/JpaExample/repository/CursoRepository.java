package ExampleUsingJpa.JpaExample.repository; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ExampleUsingJpa.JpaExample.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
  
	
	@Query(value ="select count(*) from curso where curso.published = :published", nativeQuery=true)
	int countPublished(@Param("published") boolean published);

	@Query(value="select sum(curso.price) from curso where curso.user_fk = :id", nativeQuery=true)
	double countCursos(@Param("id") long id);
	
	List<Curso> findByPublished(boolean published);
	List<Curso> findByNameContaining(String name);
}