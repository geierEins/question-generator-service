package de.geier.QuestionGeneratorService.questions;

public class QuestionHowHigh extends Question {

	public QuestionHowHigh(String candidate, int correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "Meter";
		body = "Wie hoch ist ";
	}
}