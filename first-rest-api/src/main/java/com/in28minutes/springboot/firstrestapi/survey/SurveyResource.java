package com.in28minutes.springboot.firstrestapi.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyResource {
	private SurveyService surveyService;

	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@RequestMapping("/surveys")
	public List<Survey> retriveAllSurveys() {
		return surveyService.retriveAllSurveys();
	}

	@RequestMapping("/surveys/{surveyId}")
	public Survey retriveSurveyById(@PathVariable String surveyId) {
		Survey survey = surveyService.retriveSurveyById(surveyId);
		if (survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return survey;
	}

	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retriveAllSurveyQuestions(@PathVariable String surveyId) {
		List<Question> questions = surveyService.retriveAllSurveyQuestions(surveyId);
		if (questions == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questions;
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.GET)
	public Question retriveSpecificSurveyQuestions(@PathVariable String surveyId, @PathVariable String questionId) {
		Question question = surveyService.retriveSpecificSurveyQuestions(surveyId, questionId);
		if (question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return question;
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {
		surveyService.addNewSurveyQuestion(surveyId, question);
		return ResponseEntity.created(null).build();
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		String deletedId = surveyService.deleteSurveyQuestion(surveyId, questionId);
		if (deletedId == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId,
			@RequestBody Question question) {
		surveyService.updateSurveyQuestion(surveyId, questionId, question);
		return ResponseEntity.noContent().build();
	}
}
