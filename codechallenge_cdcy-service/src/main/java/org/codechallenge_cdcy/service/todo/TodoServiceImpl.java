package org.codechallenge_cdcy.service.todo;

import org.codechallenge_cdcy.model.Todo;
import org.codechallenge_cdcy.repo.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class TodoServiceImpl implements TodoService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public Page<Todo> findAll(PageRequest pageRequest) {
		return todoRepository.findAll(pageRequest);
	}

	@Override
	public Page<Todo> findAllCompleted(boolean completed, PageRequest pageRequest) {
		return todoRepository.findByCompleted(completed, pageRequest);
	}

	@Override
	public Page<Todo> findAll(String search, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long delete(Long id) {
		try {
			Todo todo = todoRepository.getOne(id);
			Long todo_id = todo.getId();
			todoRepository.delete(todo);
			return todo_id;
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return -1L;
	}

	@Override
	public Todo findById(Long id) {
		return todoRepository.getOne(id);
	}

	@Override
	public Todo updateTodo(Long id, String title) {
		Todo todo = todoRepository.getOne(id);

		if (todo == null) {
			return null;
		} else {
			todo.setTitle(title);
			return todoRepository.save(todo);
		}
	}

	@Override
	public Todo updateTodo(Long id, boolean completed) {
		Todo todo = todoRepository.getOne(id);

		if (todo == null) {
			return null;
		} else {
			todo.setCompleted(completed);
			return todoRepository.save(todo);
		}
	}

	@Override
	public Todo addTodo(String title, boolean completed) {
		Todo todo = new Todo(title, completed);
		return todoRepository.save(todo);
	}
}
