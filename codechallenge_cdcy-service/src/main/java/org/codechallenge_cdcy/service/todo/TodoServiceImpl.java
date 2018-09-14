package org.codechallenge_cdcy.service.todo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.codechallenge_cdcy.dto.TodoDto;
import org.codechallenge_cdcy.exceptions.TodoException;
import org.codechallenge_cdcy.model.Todo;
import org.codechallenge_cdcy.repo.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TodoDto> findAll() {
		List<Todo> result = todoRepository.findAll();
		List<TodoDto> lst = new LinkedList<>();
		for (Todo todo : result) {
			TodoDto todoDto = modelMapper.map(todo, TodoDto.class);
			lst.add(todoDto);
		}

		return lst;
	}

	@Override
	public List<TodoDto> findAllCompleted(boolean completed) {
		List<Todo> result = todoRepository.findAll();
		List<TodoDto> lst = new LinkedList<>();
		for (Todo todo : result) {
			TodoDto todoDto = modelMapper.map(todo, TodoDto.class);
			lst.add(todoDto);
		}

		return lst;
	}

	@Override
	public Long delete(Long id) throws TodoException {
		Optional<Todo> todo = todoRepository.findById(id);

		if (todo.isPresent()) {
			Long todo_id = todo.get().getId();
			todoRepository.delete(todo.get());
			return todo_id;
		} else {
			throw new TodoException("Unable to find todo with id=" + id);
		}
	}

	@Override
	public TodoDto findById(Long id) throws TodoException {
		Optional<Todo> todo = this.todoRepository.findById(id);

		if (todo.isPresent()) {
			TodoDto dto = modelMapper.map(todo, TodoDto.class);
			return dto;
		} else {
			throw new TodoException("Unable to find todo with id=" + id);
		}
	}

	@Override
	public TodoDto updateTodo(TodoDto todoDto) throws TodoException {
		Optional<Todo> todoOpt = todoRepository.findById(todoDto.getId());

		if (todoOpt.isPresent()) {
			Todo todo = todoOpt.get();
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
		return modelMapper.map(todoRepository.save(todo), TodoDto.class);
	}
}
