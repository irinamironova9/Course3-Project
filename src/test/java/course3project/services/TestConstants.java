package course3project.services;

import course3project.model.Question;

import java.util.List;

public class TestConstants {

    public static final Question EXPECTED = new Question("test question", "test answer");
    public static final List<Question> EXPECTED_LIST = List.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4"),
            new Question("q5", "a5"));
}
