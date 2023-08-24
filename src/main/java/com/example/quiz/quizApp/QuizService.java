package com.example.quiz.quizApp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {
    QuizRepo quizRepo;

    public void addQues(Quiz quiz) {
        quizRepo.save(quiz);
    }
    public ResponseEntity<String > updateQues(Quiz quiz) {
        return new ResponseEntity<>(quizRepo.save(quiz), HttpStatus.OK);
    }
    public List<Quiz> getAllQues() {
        return quizRepo.findAll();
    }
    public List<Quiz> findByID(int id) {
        return quizRepo.findById(id);
    }
    public void deleteByID(int id) {
        quizRepo.deleteById(id);
    }
}
