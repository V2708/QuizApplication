package com.quiz.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.QuestionDTO;
import com.quiz.entity.AnswerRequest;
import com.quiz.entity.CheckAnswerRequest;
import com.quiz.entity.Question;
import com.quiz.exception.QuestionException;
import com.quiz.service.QuestionService;

@RestController
@RequestMapping("/quiz")

public class QuestionApi {
	
	@Autowired
	
	private QuestionService questionService;
	
	@Autowired
	private Environment environment;
	
	
	@PostMapping("/questions")
	ResponseEntity<String> addUser(@RequestBody QuestionDTO questionDTO) throws QuestionException{
		Long q=questionService.addQuestion(questionDTO);
		String message="Question has been added with the id:"+q;
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
    
	@GetMapping("/questions")
	ResponseEntity<List<QuestionDTO>> gettAllQuestion() throws QuestionException{
		List<QuestionDTO> list=questionService.getAllQuestions();
		return new ResponseEntity<List<QuestionDTO>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/questions/{id}")
	ResponseEntity<QuestionDTO>getQuestionById(@PathVariable long id) throws QuestionException{
		QuestionDTO q =questionService.getQuestionById(id);
		return new ResponseEntity<QuestionDTO>(q,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/questions/{id}")
	ResponseEntity<String> deleteQuestionById(@PathVariable long id) throws QuestionException{
		long q=questionService.deleteQuestion(id);
		String message = environment.getProperty("DELETE_QUESTION_MESSAGE", "Question deleted with id:") + q;		
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@PutMapping("/questions/{id}") 
	public ResponseEntity<String> updateQuestion(@PathVariable Long id, @RequestBody QuestionDTO questionDTO) throws QuestionException { 
		QuestionDTO updatedQuestion = questionService.updateQuestion(id, questionDTO); 
		String message = environment.getProperty("UPDATE_QUESTION_MESSAGE", "Question has been updated with the id:") + updatedQuestion.getId();
	    return new ResponseEntity<>(message, HttpStatus.OK); } 
	
	@PostMapping("/checkAnswers") 
	public ResponseEntity<String> checkAnswers(@RequestBody CheckAnswerRequest checkAnswersRequest) {
		Long quizId = checkAnswersRequest.getQuizId();
		Long userId = checkAnswersRequest.getUserId();
		List<AnswerRequest> answerRequests = checkAnswersRequest.getAnswerRequests(); 
		String result = questionService.checkAnswers(quizId, userId, answerRequests); return ResponseEntity.ok(result); }
}
