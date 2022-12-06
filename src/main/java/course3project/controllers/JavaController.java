package course3project.controllers;

import course3project.services.JavaQuestionService;
import course3project.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    @DeleteMapping("remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question q = new Question(question, answer);
        return javaQuestionService.remove(q);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return javaQuestionService.getAll();
    }
}
