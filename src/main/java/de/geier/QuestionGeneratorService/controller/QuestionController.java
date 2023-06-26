package de.geier.QuestionGeneratorService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.geier.QuestionGeneratorService.supplier.JsonQuestionSupplier;
import de.geier.QuestionGeneratorService.supplier.QuestionSupplier;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class QuestionController {

	private final QuestionSupplier supplier;
	private final JsonQuestionSupplier jsonSupplier;

    @Autowired
    public QuestionController(QuestionSupplier questionSupplier, JsonQuestionSupplier jsonSupplier) {
        this.supplier = questionSupplier;
        this.jsonSupplier = jsonSupplier;
    }
    
    @GetMapping("/ping")
    public String getPing(){
    	return "QuestionGeneratorService am Start ...";
    }
    
    
	@GetMapping(path = "/getRandomQuestion", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getRandomQuestion() {
		return supplier.getCurrentQuestion().toString(); 
	}
	
	@GetMapping(path = "/getGeneralQuestion", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getGeneralQuestion() {
		return jsonSupplier.loadAndReturnNextQuestion().toString();
	}

}
