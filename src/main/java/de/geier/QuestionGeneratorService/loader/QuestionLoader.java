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
		switch (questionType) {
		case HOW_TALL:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionHowTall(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		case HOW_HIGH:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionHowHigh(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		case WHEN_RELEASED:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionWhenReleased(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		case DISTANCE_BETWEEN:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionDistance(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		case IN_WHICH_YEAR:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionInWhichYear(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		case HOW_MANY_INHABITANTS:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionInhabitants(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		case BORN_WHICH_YEAR:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionBornWhen(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		case HOW_HIGH_TESTDATA:
			for (int i = 0; i < data.length; i += 2) {
				questions.add(new QuestionHowHigh(data[i], Integer.parseInt(data[i + 1])));
			}
			break;
		}
		return questions;
	}
}