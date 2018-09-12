package org.codechallenge_cdcy.repo.test;

import java.util.List;

import org.codechallenge_cdcy.JpaHikariConfig;
import org.codechallenge_cdcy.model.Todo;
import org.codechallenge_cdcy.repo.TodoRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { TodoRepository.class, JpaHikariConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoRepositoryTest {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	public void insert() {
		Todo todo = new Todo();
		todo.setTitle("4pr1VyPOLaV5hvtqZ7vM");
		todo.setCompleted(true);
		todoRepository.save(todo);
	}

	@Test
	public void findByComplete() {
		List<Todo> lst = todoRepository.findByCompleted(true);
		System.out.println(lst.size());
	}

	@Test
	public void selectAll() {
		List<Todo> lst = todoRepository.findAll();
		System.out.println(lst.size());
	}
}
