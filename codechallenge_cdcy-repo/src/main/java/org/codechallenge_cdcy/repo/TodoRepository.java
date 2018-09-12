package org.codechallenge_cdcy.repo;

import java.util.List;

import org.codechallenge_cdcy.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	@Query("select todo from Todo todo where todo.completed=:completed")
	List<Todo> findByCompleted(@Param("completed") boolean completed);
}
