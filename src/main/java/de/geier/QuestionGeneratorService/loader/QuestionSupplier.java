package de.geier.QuestionGeneratorService.loader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.springframework.context.annotation.Configuration;

import de.geier.QuestionGeneratorService.questions.Question;
import de.geier.QuestionGeneratorService.questions.QuestionType;

@Configuration
public class QuestionSupplier {

	String printLine = "------------------------------------------------------";
	QuestionLoader qLoader;
	ArrayList<Question> questions;
	Question currentQuestion;

	public QuestionSupplier() {
		qLoader = new QuestionLoader();
		questions = new ArrayList<Question>();
		loadQuestions();
	}

	public Question getCurrentQuestion() {
		loadNextQuestionIntoCurrentQuestion();
		return currentQuestion;
	}

	private void loadQuestions() {
		// load different types of questions into global question list
//		System.out.println(printLine);
//		loadQuestionTypeIntoQuestions(QuestionType.HOW_HIGH);
//		loadQuestionTypeIntoQuestions(QuestionType.HOW_TALL);
//		loadQuestionTypeIntoQuestions(QuestionType.WHEN_RELEASED);
//		loadQuestionTypeIntoQuestions(QuestionType.DISTANCE_BETWEEN);
//		loadQuestionTypeIntoQuestions(QuestionType.IN_WHICH_YEAR);
		loadQuestionTypeIntoQuestions(QuestionType.HOW_MANY_INHABITANTS);
//		loadQuestionTypeIntoQuestions(QuestionType.BORN_WHICH_YEAR);
//		loadQuestionTypeIntoQuestions(QuestionType.HOW_HIGH_TESTDATA);
		System.out.println(printLine);
		System.out.println("Anzahl Datensätze aus Files gesamt: " + this.qLoader.getDataSetsTotal());
		System.out.println("Anzahl Fragen gesamt (Duplikate bereinigt): " + questions.size());
		System.out.println(printLine);
	}
	
	// so it doesnt run out of questions
	void reloadIfNessecary() {
		if(this.questions.size()==0) {
			loadQuestions();
			qLoader.clearDataSetsTotal();
		}
	}

	private void loadQuestionTypeIntoQuestions(QuestionType questionType) {
		this.questions.addAll(sortOutDuplicates(qLoader.loadQuestionsForQuestionType(questionType)));
	}

	private ArrayList<Question> sortOutDuplicates(ArrayList<Question> questions) {
		ArrayList<Question> uniqueQuestions = new ArrayList<>();
		HashSet<String> uniqueCandidates = new HashSet<>();
		questions.forEach(question -> {
			if(!uniqueCandidates.contains(question.getCandidate())) {
				uniqueCandidates.add(question.getCandidate());
				uniqueQuestions.add(question);
			}
		});
		return uniqueQuestions;
	}

	private void loadNextQuestionIntoCurrentQuestion() {
		setRandomQuestionAsCurrentQuestionAndDeleteFromGlobal();
		reloadIfNessecary();
	}

	private void setRandomQuestionAsCurrentQuestionAndDeleteFromGlobal() {
		Random random = new Random();
		int randomNum = random.nextInt(questions.size());
		this.currentQuestion = questions.get(randomNum);
		questions.remove(randomNum);
		System.out.println("verbleibende Fragen: " + questions.size());
	}

}