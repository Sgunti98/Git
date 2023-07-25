package com.example.GSravanthi_Capstone.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="event")
public class event {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String title; 
	private String description;
	private LocalDateTime start; 
	private LocalDateTime finish;
	

	
	public event(Long id, String name, String title, String description, LocalDateTime start, LocalDateTime finish) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.start = start;
		this.finish = finish;
	}

	public event() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "event [id=" + id + ", name=" + name + ", title=" + title + ", description=" + description + ", start="
				+ start + ", finish=" + finish + "]";
	}

}
