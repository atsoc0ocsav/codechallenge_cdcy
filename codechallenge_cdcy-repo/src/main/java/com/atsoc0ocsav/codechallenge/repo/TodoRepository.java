package com.atsoc0ocsav.codechallenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atsoc0ocsav.codechallenge.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	@Query("select todo from Todo todo where todo.completed=:completed")
	List<Todo> findByCompleted(@Param("completed") boolean completed);
}
