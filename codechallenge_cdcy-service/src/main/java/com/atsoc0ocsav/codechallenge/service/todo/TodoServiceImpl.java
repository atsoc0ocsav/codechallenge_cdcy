package com.atsoc0ocsav.codechallenge.service.todo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsoc0ocsav.codechallenge.domain.Todo;
import com.atsoc0ocsav.codechallenge.dto.TodoDto;
import com.atsoc0ocsav.codechallenge.exceptions.TodoException;
import com.atsoc0ocsav.codechallenge.repo.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TodoDto> getAll() {
		List<Todo> result = todoRepository.findAll();
		List<TodoDto> lst = new LinkedList<>();
		for (Todo todo : result) {
			TodoDto todoDto = modelMapper.map(todo, TodoDto.class);
			lst.add(todoDto);
		}

		return lst;
	}

	@Override
	public List<TodoDto> getAllCompleted(boolean completed) {
		List<Todo> result = todoRepository.findByCompleted(completed);
		List<TodoDto> lst = new LinkedList<>();
		for (Todo todo : result) {
			TodoDto todoDto = modelMapper.map(todo, TodoDto.class);
			lst.add(todoDto);
		}

		return lst;
	}

	@Override
	public Long deleteTodo(Long id) throws TodoException {
		Todo todo = todoRepository.getOne(id);

		if (todo != null) {
			Long todo_id = todo.getId();
			todoRepository.delete(todo);
			return todo_id;
		} else {
			throw new TodoException("Unable to find todo with id=" + id);
		}
	}

	@Override
	public TodoDto getById(Long id) throws TodoException {
		Todo todo = this.todoRepository.getOne(id);

		if (todo != null) {
			try {
			TodoDto dto = modelMapper.map(todo, TodoDto.class);
			return dto;
			}catch(EntityNotFoundException e) {
				throw new TodoException(e.getMessage());
			}
		} else {
			throw new TodoException("Unable to find todo with id=" + id);
		}
	}

	@Override
	public TodoDto updateTodo(TodoDto todoDto) throws TodoException {
		Todo todo = todoRepository.getOne(todoDto.getId());

		if (todo != null) {
			if (todoDto.getTitle() != null) {
				todo.setTitle(todoDto.getTitle());
			}

			if (todoDto.isCompleted() != null) {
				todo.setCompleted(todoDto.isCompleted());
			}

			TodoDto toReturn = modelMapper.map(todoRepository.save(todo), TodoDto.class);
			return toReturn;
		} else {
			throw new TodoException("Unable to find todo with id=" + todoDto.getId());
		}
	}

	@Override
	public TodoDto addTodo(TodoDto todoDto) {
		Todo todo = new Todo(todoDto.getTitle(), todoDto.isCompleted());
		todo = todoRepository.save(todo);
		
		TodoDto toReturnDto = new TodoDto(todo.getId(),todo.getTitle(),todo.isCompleted());
		//return modelMapper.map(todo, TodoDto.class);
		return toReturnDto;
	}
}
