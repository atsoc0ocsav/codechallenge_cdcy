package com.atsoc0ocsav.codechallenge.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsoc0ocsav.codechallenge.GlobalVars;
import com.atsoc0ocsav.codechallenge.dto.TodoDto;
import com.atsoc0ocsav.codechallenge.service.todo.TodoService;

@RestController
@RequestMapping(GlobalVars.API_REST_URL)
public class TodoRestController {
	@Autowired
	private TodoService todoService;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<TodoDto> listTodos(@RequestParam(value = "q", required = false) String completed,
			HttpServletRequest request) throws Exception {
		if (completed != null) {
			if (completed.equals("completed")) {
				return todoService.getAllCompleted(true);
			} else {
				return todoService.getAllCompleted(false);
			}
		} else {
			return todoService.getAll();
		}
	}

	@RequestMapping(value = { "" }, method = RequestMethod.POST)
	public TodoDto createTodo(@RequestBody TodoDto todo, HttpServletRequest request) throws Exception {
		return todoService.addTodo(todo);
	}

	@RequestMapping(value = { "todo/:{id:[\\d]+}" }, method = RequestMethod.GET)
	public TodoDto getTodo(@PathVariable(value = "id") Long id, HttpServletRequest request) throws Exception {
		System.out.println("Entrei, id=" + id);
		return todoService.getById(id);
	}

	@RequestMapping(value = { "todo/:{id:[\\d]+}" }, method = RequestMethod.PATCH)
	public TodoDto patchTodo(@PathVariable(value = "id") Long id, @RequestBody TodoDto todo, HttpServletRequest request)
			throws Exception {
		return todoService.updateTodo(todo);
	}

	@RequestMapping(value = { "todo/:{id:[\\d]+}" }, method = RequestMethod.DELETE)
	public String deleteTodo(@PathVariable(value = "id") Long id, HttpServletRequest request) throws Exception {
		return "{\n\t\"id\" : " + todoService.deleteTodo(id) + "\n}";
	}
}
