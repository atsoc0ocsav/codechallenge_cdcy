package com.atsoc0ocsav.codechallenge.dto;

public class TodoDto {

	private Long id;
	private String title;
	private Boolean isCompleted;

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
