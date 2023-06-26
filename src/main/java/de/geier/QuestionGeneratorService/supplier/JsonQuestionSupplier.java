package de.geier.QuestionGeneratorService.supplier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.geier.QuestionGeneratorService.jsonquestions.JsonQuestion;
import de.geier.QuestionGeneratorService.jsonquestions.JsonQuestionType;
import de.geier.QuestionGeneratorService.loader.JsonQuestionLoader;
import de.geier.QuestionGeneratorService.questions.Question;

@Configuration
public class JsonQuestionSupplier {
	
	private ArrayList<JsonQuestion> questions;
	private JsonQuestionLoader loader;
	private JsonQuestion currentQuestion;
	
	public JsonQuestionSupplier() {
		loader = new JsonQuestionLoader();
		questions = new ArrayList<JsonQuestion>();
		loadQuestions();
	}
	
	private void loadQuestions() {
		loadQuestionTypeIntoQuestions(JsonQuestionType.TESTQUESTIONS);
		
	}
	
	private void loadQuestionTypeIntoQuestions(JsonQuestionType questionType)  {
		this.questions.addAll(sortOutDuplicates(loader.getGeneralQuestionsList(questionType)));
	}
	
	// works only within one type of questions, otherwise two different questions might be recognized as the same questions
	private List<JsonQuestion> sortOutDuplicates(List<JsonQuestion> questions) {
		List<JsonQuestion> uniqueQuestions = new ArrayList<>();
		HashSet<String> uniqueCandidates = new HashSet<>();
		questions.forEach(question -> {
			if(!uniqueCandidates.contains(question.getQuestion())) {
				uniqueCandidates.add(question.getQuestion());
				uniqueQuestions.add(question);
			}
		});
		return uniqueQuestions;
	}
	
	void reloadIfNessecary() {
		if(this.questions.size()==0) {
			loadQuestions();
		}
	}
	
	public JsonQuestion loadAndReturnNextQuestion() {
		setRandomQuestionAsCurrentQuestionAndDeleteFromGlobal();
		reloadIfNessecary();
		return currentQuestion;
	}
	
	private void setRandomQuestionAsCurrentQuestionAndDeleteFromGlobal() {
		Random random = new Random();
		int randomNum = random.nextInt(questions.size());
		this.currentQuestion = questions.get(randomNum);
		questions.remove(randomNum);
		System.out.println("verbleibende Fragen: " + questions.size());
	}

}
