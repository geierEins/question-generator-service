package de.geier.QuestionGeneratorService.questions;

public class QuestionBornWhen extends Question {

	String body2;

	public QuestionBornWhen(String candidate, int correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "Centimeter";
		body = "In welchem Jahr wurde ";
		body2 = " geboren";
	}

	@Override
	public String questionToString() {
		return body + candidate + body2 + "?";
	}
}