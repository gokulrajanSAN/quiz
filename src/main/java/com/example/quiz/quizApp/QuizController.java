package com.example.quiz.quizApp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("quiz")
public class QuizController {
    QuizService quizService;

    @PostMapping("addQues")
    @ResponseStatus(HttpStatus.CREATED)
    public void addQues(@RequestBody Quiz quiz){
        try {
            quizService.addQues(quiz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("updateQues")
    public ResponseEntity<String> updateQues(@RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.updateQues(quiz), HttpStatus.OK);
    }

    @GetMapping("getAllQues")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Quiz> getAllQues(){
        return quizService.getAllQues();
    }
    @GetMapping("{id}")
    public List<Quiz> findByID(@PathVariable int id){
        return quizService.findByID(id);
    }
    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByID(@PathVariable int id){
        quizService.deleteByID(id);
    }
}
