package de.geier.QuestionGeneratorService.questions;

public class QuestionHowMany extends Question {

	public QuestionHowMany(String candidate, Number correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "";
		this.body = "Wie viele ";
	}

}
