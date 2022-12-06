package course3project.controllers;

import course3project.exceptions.UnsupportedAmountOfQuestionsException;
import course3project.model.Question;
import course3project.services.ExaminerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {

    ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/{amount}")
    public Collection<Question> getExamQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }

    @ExceptionHandler(UnsupportedAmountOfQuestionsException.class)
    public ResponseEntity<String> handleUnsupportedAmountOfQuestionsException() {
        return ResponseEntity.badRequest().body("Запрошено неподдерживаемое количество вопросов");
    }
}
