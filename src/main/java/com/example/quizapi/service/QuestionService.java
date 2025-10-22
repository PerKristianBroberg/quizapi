package com.example.quizapi.service;

import com.example.quizapi.model.Question;
import com.example.quizapi.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class QuestionService {
    private final QuestionRepository repo;
    private final Random random = new Random();

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }

    public Question getRandomQuestion() {
        List<Question> questions = repo.findAll();
        return questions.get(random.nextInt(questions.size()));
    }

    public Question addQuestion(Question q) {
        return repo.save(q);
    }

    public boolean checkAnswer(Long id, String answer) {
        Question q = repo.findById(id).orElse(null);
        if (q == null) return false;
        return q.getCorrectAnswer().equalsIgnoreCase(answer);
    }
}
