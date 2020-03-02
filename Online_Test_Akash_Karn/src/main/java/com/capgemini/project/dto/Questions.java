package com.capgemini.project.dto;

import java.io.Serializable;
import java.util.List;

public class Questions implements Serializable {
	
	private int questionid;
	
	private String questionTitle;
	
	private List<String> questionOptions;
	
	private int questionAnswer;
	
	private int chosenAnswer;
	
	public Questions(int questionid, String questionTitle, List<String> questionOptions, int questionAnswer)
	{
		super();
		this.questionid = questionid;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public List<String> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<String> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public int getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
}
	
	
