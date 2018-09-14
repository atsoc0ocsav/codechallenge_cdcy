package com.atsoc0ocsav.codechallenge.service.todo;

import java.util.List;

import com.atsoc0ocsav.codechallenge.dto.TodoDto;
import com.atsoc0ocsav.codechallenge.exceptions.TodoException;

public interface TodoService {
	List<TodoDto> getAll();

	List<TodoDto> getAllCompleted(boolean completed);

	Long deleteTodo(Long id) throws TodoException;

	TodoDto getById(Long id) throws TodoException;

	TodoDto updateTodo(TodoDto todoDto) throws TodoException;

	TodoDto addTodo(TodoDto todoDto);
}
