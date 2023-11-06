import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static pageobject.MainScooterQuestionsPage.*;


@RunWith(Parameterized.class)
public class ImportantQuestionsParametersForTest {

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][] {
                {QUESTION1, ANSWER1, TEXT_QUESTION1, TEXT_ANSWER1},
                {QUESTION2, ANSWER2, TEXT_QUESTION2, TEXT_ANSWER2},
                {QUESTION3, ANSWER3, TEXT_QUESTION3, TEXT_ANSWER3},
                {QUESTION4, ANSWER4, TEXT_QUESTION4, TEXT_ANSWER4},
                {QUESTION5, ANSWER5, TEXT_QUESTION5, TEXT_ANSWER5},
                {QUESTION6, ANSWER6, TEXT_QUESTION6, TEXT_ANSWER6},
                {QUESTION7, ANSWER7, TEXT_QUESTION7, TEXT_ANSWER7},
                {QUESTION8, ANSWER8, TEXT_QUESTION8, TEXT_ANSWER8},
        };
    }

}
