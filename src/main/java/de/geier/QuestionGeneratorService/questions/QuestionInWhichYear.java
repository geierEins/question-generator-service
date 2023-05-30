package de.geier.QuestionGeneratorService.questions;

public class QuestionInWhichYear extends Question {

	public QuestionInWhichYear(String candidate, int correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "Jahr";
		body = "In welchem Jahr ";
	}
}