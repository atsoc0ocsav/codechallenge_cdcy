package org.codechallenge_cdcy.service.todo;

import org.codechallenge_cdcy.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface TodoService {
	Page<Todo> findAll(PageRequest pageRequest);

	Page<Todo> findAllCompleted(boolean completed, PageRequest pageRequest);

	Page<Todo> findAll(String search, PageRequest pageRequest);

	Long delete(Long id);

	Todo findById(Long id);

	Todo updateTodo(Long id, String title);

	Todo updateTodo(Long id, boolean completed);

	Todo addTodo(String title, boolean completed);
}
