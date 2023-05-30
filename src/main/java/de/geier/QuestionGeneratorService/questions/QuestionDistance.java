package de.geier.QuestionGeneratorService.questions;

public class QuestionDistance extends Question {

	String body2;

	public QuestionDistance(String candidate, int correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "Kilometer";
		body = "Wieviele Kilometer sind ";
		body2 = " voneinander entfernt";
	}

	@Override
	public String questionToString() {
		return body + candidate + body2 + "?";
	}
}