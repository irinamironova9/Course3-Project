package course3project.services;

import course3project.exceptions.NoQuestionFoundException;
import course3project.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static course3project.services.TestConstants.EXPECTED;
import static course3project.services.TestConstants.EXPECTED_LIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService out;

    @BeforeEach
    void setUp() {
        this.out = new JavaQuestionService();
    }

    @Test
    void addFields() {
        Question actual = out.add("test question", "test answer");
        assertEquals(EXPECTED, actual);
        assertThat(out.getAll()).containsOnly(EXPECTED);
    }

    @Test
    void addQuestion() {
        assertEquals(EXPECTED, out.add(EXPECTED));
        assertThat(out.getAll()).containsOnly(EXPECTED);
    }

    @Test
    void remove() {
        out.add(EXPECTED);
        assertThat(out.getAll()).containsOnly(EXPECTED);
        assertThat(out.remove(EXPECTED)).isEqualTo(EXPECTED);
        assertThat(out.getAll()).isEmpty();
    }

    @Test
    void getAll() {
        for (int i = 1; i <= 5; i++) {
            out.add("q" + i, "a" + i);
        }
        assertThat(out.getAll())
                .hasSize(5)
                .isUnmodifiable()
                .containsExactlyInAnyOrderElementsOf(EXPECTED_LIST);
    }

    @Test
    void getRandomQuestion() {
        for (int i = 1; i <= 5; i++) {
            out.add("q" + i, "a" + i);
        }
        assertThat(out.getRandomQuestion())
                .isNotNull()
                .isIn(EXPECTED_LIST);
    }

    @Test
    void shouldThrowNoQuestionFoundExceptionWhenSetOfQuestionsIsEmpty() {
        assertThrows(NoQuestionFoundException.class, () -> out.getRandomQuestion());
    }
}