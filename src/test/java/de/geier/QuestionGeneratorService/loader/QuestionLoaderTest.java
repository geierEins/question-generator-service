package de.geier.QuestionGeneratorService.loader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import de.geier.QuestionGeneratorService.questions.Question;
import de.geier.QuestionGeneratorService.questions.QuestionType;

class QuestionLoaderTest {
	
	QuestionLoader ql = new QuestionLoader();

	@Test
	void loadQuestionsForQuestionTypeTest() {
		QuestionType questionType = QuestionType.HOW_HIGH_TESTDATA;
		ArrayList<Question> questions = ql.loadQuestionsForQuestionType(questionType);
		//assertEquals(questions.get(0).c, null);
	}

}
