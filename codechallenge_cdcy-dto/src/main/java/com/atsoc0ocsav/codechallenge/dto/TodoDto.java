package com.atsoc0ocsav.codechallenge.dto;

import java.io.Serializable;

public class TodoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3206050683749775611L;
	private Long id;
	private String title;
	private Boolean isCompleted;

	public TodoDto() {
		this.id = null;
		this.title = null;
		this.isCompleted = null;
	}

	public TodoDto(Long id) {
		this.id = id;
		this.title = null;
		this.isCompleted = null;
	}

	public TodoDto(Long id, Boolean isCompleted) {
		this.id = id;
		this.title = null;
		this.isCompleted = isCompleted;
	}

	public TodoDto(Long id, String title) {
		this.id = id;
		this.title = title;
		this.isCompleted = null;
	}

	public TodoDto(String title, Boolean isCompleted) {
		this.id = -1L;
		this.title = title;
		this.isCompleted = isCompleted;
	}

	public TodoDto(Long id, String title, Boolean isCompleted) {
		this.id = id;
		this.title = title;
		this.isCompleted = isCompleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}
