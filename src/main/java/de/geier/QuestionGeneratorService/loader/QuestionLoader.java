package de.geier.QuestionGeneratorService.loader;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.geier.QuestionGeneratorService.questions.Question;
import de.geier.QuestionGeneratorService.questions.QuestionBornWhen;
import de.geier.QuestionGeneratorService.questions.QuestionDistance;
import de.geier.QuestionGeneratorService.questions.QuestionHowHigh;
import de.geier.QuestionGeneratorService.questions.QuestionHowMany;
import de.geier.QuestionGeneratorService.questions.QuestionHowTall;
import de.geier.QuestionGeneratorService.questions.QuestionInWhichYear;
import de.geier.QuestionGeneratorService.questions.QuestionInhabitants;
import de.geier.QuestionGeneratorService.questions.QuestionType;
import de.geier.QuestionGeneratorService.questions.QuestionWhenReleased;

public class QuestionLoader {
	
	private int dataSetsTotal;

	private String pathToFiles = "data//";

	@SuppressWarnings("null")
	public ArrayList<Question> loadQuestionsForQuestionType(QuestionType questionType) {
		ArrayList<Question> questions = null;
		String[] data = null;
		String line = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(pathToFiles + questionType + ".txt"));
			line = br.readLine();
			data = line.split("::|\n");
		} catch (IOException e) {
			System.out.print(e.toString());
		}
		questions = mapDataToQuestionsList(data, questionType);
		System.out.println("Anzahl " + questionType + "-Datensätze: " + questions.size());
		dataSetsTotal+=questions.size();
		return questions;
	}
	
	public int getDataSetsTotal() {
		return dataSetsTotal;
	}
	
	public void clearDataSetsTotal(){
		this.dataSetsTotal=0;
	}
	
	private ArrayList<Question> mapDataToQuestionsList(String[] data, QuestionType questionType) {
	    ArrayList<Question> questions = new ArrayList<Question>();
	    for (int i = 0; i < data.length; i += 2) {
	        Question question = null;
	        switch (questionType) {
	            case HOW_TALL:
	                question = new QuestionHowTall(data[i], Integer.parseInt(data[i + 1]));
	                break;
	            case HOW_HIGH:
	            case HOW_HIGH_TESTDATA:
	                question = new QuestionHowHigh(data[i], Integer.parseInt(data[i + 1]));
	                break;
	            case WHEN_RELEASED:
	                question = new QuestionWhenReleased(data[i], Integer.parseInt(data[i + 1]));
	                break;
	            case DISTANCE_BETWEEN:
	                question = new QuestionDistance(data[i], Integer.parseInt(data[i + 1]));
	                break;
	            case IN_WHICH_YEAR:
	                question = new QuestionInWhichYear(data[i], Integer.parseInt(data[i + 1]));
	                break;
	            case HOW_MANY_INHABITANTS:
	                question = new QuestionInhabitants(data[i], Long.parseLong(data[i + 1]));
	                break;
	            case BORN_WHICH_YEAR:
	                question = new QuestionBornWhen(data[i], Integer.parseInt(data[i + 1]));
	                break;
	            case HOW_MANY:
	                question = new QuestionHowMany(data[i], Integer.parseInt(data[i + 1]));
	                break;
	        }
	        if (question != null) {
	            questions.add(question);
	        }
	    }
	    return questions;
	}
}