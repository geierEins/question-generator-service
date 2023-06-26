package de.geier.QuestionGeneratorService.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.geier.QuestionGeneratorService.jsonquestions.JsonQuestion;
import de.geier.QuestionGeneratorService.jsonquestions.JsonQuestionType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JsonQuestionLoader {
	
	public List<JsonQuestion> getGeneralQuestionsList(JsonQuestionType questionType){		
		ObjectMapper objectMapper = new ObjectMapper();
		List<JsonQuestion> questionList = new ArrayList<JsonQuestion>();
		
		try {
			questionList = objectMapper.readValue(getJsonString(questionType), new TypeReference<List<JsonQuestion>>(){});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionList;
	}
	
    public String getJsonString(JsonQuestionType questionType) {
        String filePath = "data/json/" + questionType + ".json";
        String jsonString = "";
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return jsonString;
    }

}
