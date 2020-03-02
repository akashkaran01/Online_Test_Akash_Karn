package com.capgemini.project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test implements Serializable{
	
	private int testid;      
	private List<Questions> testQuestions;
	private double testTotalMarks;
	private double totalMarksScored;
	
	public Test(int testId) {
		super();
		this.testid = testid;
		List<Questions> testQuestions = new ArrayList<Questions>();
	}

	public List<Questions> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(List<Questions> testQuestions) {
		this.testQuestions = testQuestions;
	}
	
}