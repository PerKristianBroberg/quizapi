package com.example.quizapi.controller;

import com.example.quizapi.model.Question;
import com.example.quizapi.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Question> getAll() {
        return service.getAllQuestions();
    }

    @GetMapping("/random")
    public Question getRandom() {
        return service.getRandomQuestion();
    }

    @PostMapping
    public Question add(@RequestBody Question q) {
        return service.addQuestion(q);
    }

    @PostMapping("/{id}/answer")
    public boolean checkAnswer(@PathVariable Long id, @RequestBody String answer) {
        return service.checkAnswer(id, answer);
    }
}
