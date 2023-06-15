package de.geier.QuestionGeneratorService.questions;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Question {

	public QuestionType questionType;
	protected String candidate;
	protected String body;
	protected String unit;
	protected Number correctAnswer;

	public Question(String candidate, Number correctAnswer) {
		this.candidate = candidate;
		this.correctAnswer = correctAnswer;
	}

	public String questionToString() {
		return body + candidate + "?";
	}

	public String answerToString() {
		return this.correctAnswer + " " + this.unit;
	}

	public String getCandidate() {
		return candidate;
	}

	@Override
	public String toString() {
		return new JSONObject().put("question", questionToString()).put("answer", correctAnswer).put("unit", unit)
				.toString();
	}
}
