import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pageobject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MainTests {
    private WebDriver driver;

    @Before
    public void beforeTest() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Проверяет название раздела с вопросами
    @Test
    public void checkQuestionsHeaderTitle() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Проверить соответствие текста подзаголовка
        objScooterPage.checkQuestionsHeader();
    }

    //Проверяет соответствие текстов вопросов и ответов ожидаемым
    @Test
    public void checkQuestionsAndAnswers() {
        // объект класса главной страницы
        MainScooterQuestionsPage objScooterPage;

        // Использует параметры из метода getQuestions
        Object[][] questions = ImportantQuestionsParametersForTest.getQuestions();
        for (Object[] question : questions) {
            objScooterPage = new MainScooterQuestionsPage((By) question[0], (By) question[1],
                    (String) question[2], (String) question[3], driver);

            // Проверить соответствие текстов вопроса и ответа
            objScooterPage.checkQuestionAndAnswer();
        }
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
