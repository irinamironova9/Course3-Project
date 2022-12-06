package course3project.services;

import course3project.exceptions.UnsupportedAmountOfQuestionsException;
import course3project.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1 || amount > javaQuestionService.getAll().size()) {
            throw new UnsupportedAmountOfQuestionsException();
        }
        if (amount == javaQuestionService.getAll().size()) {
            return javaQuestionService.getAll();
        }
        Set<Question> examQuestions = new HashSet<>();
        while (examQuestions.size() < amount) {
            examQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return examQuestions;
    }
}
