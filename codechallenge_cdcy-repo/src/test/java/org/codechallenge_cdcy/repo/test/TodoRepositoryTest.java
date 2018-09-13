package org.codechallenge_cdcy.repo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.codechallenge_cdcy.RepoConfig;
import org.codechallenge_cdcy.model.Todo;
import org.codechallenge_cdcy.repo.TodoRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { TodoRepository.class, RepoConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoRepositoryTest {

	@Autowired
	private TodoRepository todoRepository;

	@Before
	public void cleanTable() {
		todoRepository.deleteAll();
	}

	@Test
	public void insert() {
		Todo todo = new Todo();
		todo.setTitle(new RandomString(40).nextString());
		todo.setCompleted(true);

		Todo insertedTodo = todoRepository.save(todo);

		// Check if the instances are similar (i.e. the contents)
		assertTrue(insertedTodo.getId() > -1L);
		assertEquals(todo.getTitle(), insertedTodo.getTitle());
		assertEquals(todo.isCompleted(), insertedTodo.isCompleted());
	}

	@Test
	public void findByComplete() {
		Todo todo;

		List<Todo> originalTrue = new ArrayList<Todo>();
		List<Todo> insertedTrue = new ArrayList<Todo>();
		for (int i = 0; i < 10; i++) {
			todo = new Todo();
			todo.setTitle(new RandomString(40).nextString());
			todo.setCompleted(true);

			originalTrue.add(todo);
			insertedTrue.add(todoRepository.save(todo));
		}

		List<Todo> originalFalse = new ArrayList<Todo>();
		List<Todo> insertedFalse = new ArrayList<Todo>();
		for (int i = 0; i < 10; i++) {
			todo = new Todo();
			todo.setTitle(new RandomString(40).nextString());
			todo.setCompleted(false);

			originalFalse.add(todo);
			insertedFalse.add(todoRepository.save(todo));
		}

		List<Todo> lstTrue = todoRepository.findByCompleted(true);
		List<Todo> lstFalse = todoRepository.findByCompleted(false);

		// Check if it is returning just what is supposed to
		assertEquals(lstTrue.size(), originalTrue.size());
		assertEquals(lstFalse.size(), originalFalse.size());

		boolean listsAreEqual = true;
		for (Todo td_true : lstTrue) {
			if (!isInList(insertedTrue, td_true)) {
				listsAreEqual = false;
			}
		}

		assertTrue(listsAreEqual);

		for (Todo td_true : lstFalse) {
			if (!isInList(insertedFalse, td_true)) {
				listsAreEqual = false;
			}
		}

		assertTrue(listsAreEqual);
	}

	@Test
	public void selectAll() {
		Todo todo;

		List<Todo> original = new ArrayList<Todo>();
		List<Todo> inserted = new ArrayList<Todo>();
		for (int i = 0; i < 10; i++) {
			todo = new Todo();
			todo.setTitle(new RandomString(40).nextString());
			todo.setCompleted(true);

			original.add(todo);
			inserted.add(todoRepository.save(todo));
		}

		for (int i = 0; i < 10; i++) {
			todo = new Todo();
			todo.setTitle(new RandomString(40).nextString());
			todo.setCompleted(false);

			original.add(todo);
			inserted.add(todoRepository.save(todo));
		}

		List<Todo> lst = todoRepository.findAll();

		// Check if it is returning just what is supposed to
		assertEquals(lst.size(), original.size());

		boolean listsAreEqual = true;
		for (Todo td_true : lst) {
			if (!isInList(inserted, td_true)) {
				listsAreEqual = false;
			}
		}

		assertTrue(listsAreEqual);
	}

	private boolean isInList(List<Todo> todos, Todo t) {
		for (Todo todo : todos) {
			if (todo.equals(t)) {
				return true;
			}
		}

		return false;
	}
}
