package de.geier.QuestionGeneratorService.questions;

public class QuestionHowTall extends Question {

	public QuestionHowTall(String candidate, int correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "Centimeter";
		body = "Wie groß ist ";
	}
	
	@Override
	public String questionToString() {
		return body + candidate + "?" + " (in cm)";
	}
}