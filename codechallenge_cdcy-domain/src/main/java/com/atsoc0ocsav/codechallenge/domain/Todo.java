package com.atsoc0ocsav.codechallenge.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Todo", schema = "public")
public class Todo implements TodoMinimal, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254298156727374177L;
	private Long id;
	private String title;
	private boolean isCompleted;

	public Todo() {
	}

	public Todo(String title, boolean isCompleted) {

	}

	@Id
	@GenericGenerator(name = "todo_id_gen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "todo_id_seq"),
			@Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "todo_id_gen")
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = true, length = 250, unique = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "completed", nullable = false)
	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Todo) {
			Todo todo = (Todo) obj;
			return this.title.equals(todo.getTitle()) && this.isCompleted == todo.isCompleted()
					&& this.id == todo.getId();
		} else {
			return false;
		}
	}
}
