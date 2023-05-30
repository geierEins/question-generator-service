package de.geier.QuestionGeneratorService.questions;

public class QuestionInhabitants extends Question {

	String body2;

	public QuestionInhabitants(String candidate, int correctAnswer) {
		super(candidate, correctAnswer);
		this.unit = "";
		body = "Wieviele Einwohner hat ";
		body2 = " (Stand: 2021)";
	}

	@Override
	public String questionToString() {
		return body + candidate + "?" + body2;
	}
}