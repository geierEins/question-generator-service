package de.geier.QuestionGeneratorService.jsonquestions;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonQuestion {


	@JsonProperty("question")
	private String question;
	
	@JsonProperty("answer")
	private String answer;	
	
	@Override
	public String toString() {
		return new JSONObject().put("question", question).put("answer", answer).toString();
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getQuestion() {
		return question;
	}
	
}
