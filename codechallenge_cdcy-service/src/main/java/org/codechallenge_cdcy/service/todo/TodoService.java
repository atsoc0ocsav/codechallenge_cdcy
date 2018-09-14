package org.codechallenge_cdcy.service.todo;

import java.util.List;

import org.codechallenge_cdcy.dto.TodoDto;
import org.codechallenge_cdcy.exceptions.TodoException;

public interface TodoService {
	List<TodoDto> findAll();

	List<TodoDto> findAllCompleted(boolean completed);

	Long delete(Long id) throws TodoException;

	TodoDto findById(Long id) throws TodoException;

	TodoDto updateTodo(TodoDto todoDto) throws TodoException;

	TodoDto addTodo(TodoDto todoDto);
}
