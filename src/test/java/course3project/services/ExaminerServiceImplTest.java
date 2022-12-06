package course3project.services;

import course3project.exceptions.UnsupportedAmountOfQuestionsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static course3project.services.TestConstants.EXPECTED_LIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService mock;

    @InjectMocks
    ExaminerServiceImpl out;

    @BeforeEach
    void setUp() {
        when(mock.getAll()).thenReturn(EXPECTED_LIST);
    }

    @Test
    void getQuestions() {
        when(mock.getRandomQuestion()).thenReturn(
                EXPECTED_LIST.get(0),
                EXPECTED_LIST.get(1),
                EXPECTED_LIST.get(2));
        assertThat(out.getQuestions(3))
                .containsOnly(
                        EXPECTED_LIST.get(0),
                        EXPECTED_LIST.get(1),
                        EXPECTED_LIST.get(2));
    }

    @Test
    void shouldReturnAllQuestionsWhenRequestedAmountEqualsActualAmountOfQuestions() {
        assertThat(out.getQuestions(5))
                .isEqualTo(EXPECTED_LIST);
    }

    @Test
    void shouldThrowUnsupportedAmountOfQuestionsException() {
        assertThrows(UnsupportedAmountOfQuestionsException.class,
                () -> out.getQuestions(-1));

        assertThrows(UnsupportedAmountOfQuestionsException.class,
                () -> out.getQuestions(0));

        assertThrows(UnsupportedAmountOfQuestionsException.class,
                () -> out.getQuestions(10));
    }
}