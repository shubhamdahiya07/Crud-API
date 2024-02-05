package com.in28minutes.springboot.firstrestapi.survey;

import java.util.List;

public class Question {

	public Question(String id, String description, List<String> option, String correctAnswer) {
		super();
		this.id = id;
		this.description = description;
		this.Option = option;
		this.correctAnswer = correctAnswer;
	}

	private String id;
	private String description;
	private List<String> Option;
	private String correctAnswer;

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getOption() {
		return Option;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", Option=" + Option + ", correctAnswer="
				+ correctAnswer + "]";
	}

	public void setId(String randomId) {
		this.id = randomId;
	}

}
