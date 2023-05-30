package de.geier.QuestionGeneratorService.questions;

public class QuestionWhenReleased extends Question {

	String body2;

	public QuestionWhenReleased(String candidate, int correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "(Jahr)";
		body = "Wann wurde das Album ";
		body2 = " released";
	}

	@Override
	public String questionToString() {
		return body + candidate + body2 + "?";
	}
}