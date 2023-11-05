package qaScooter;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MainScooterQuestionsPage {

    private WebDriver driver;

    // Элемент выпадающего списка - вопрос и ответ
    private final By importantQuestionLocator;
    private final By importantAnswerLocator;
    private final String questionText;
    private final String questionAnswer;

    //Конструктор
    public MainScooterQuestionsPage(WebDriver driver, By importantQuestionLocator, By importantAnswerLocator,
                                    String questionText, String questionAnswer) {
        this.driver = driver;
        this.importantQuestionLocator = importantQuestionLocator;
        this.importantAnswerLocator = importantAnswerLocator;
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][] {
                {By.id("accordion__heading-0"), By.id("accordion__panel-0"), "Сколько это стоит? И как оплатить?",
                     "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {By.id("accordion__heading-1"), By.id("accordion__panel-1"), "Хочу сразу несколько самокатов! " +
                     "Так можно?", "Пока что у нас так: один заказ — один самокат. " +
                     "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {By.id("accordion__heading-2"), By.id("accordion__panel-2"), "Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 " +
                                "мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {By.id("accordion__heading-3"), By.id("accordion__panel-3"), "Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {By.id("accordion__heading-4"), By.id("accordion__panel-4"), "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в " +
                                "поддержку по красивому номеру 1010."},
                {By.id("accordion__heading-5"), By.id("accordion__panel-5"), "Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает " +
                        "на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {By.id("accordion__heading-6"), By.id("accordion__panel-6"), "Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {By.id("accordion__heading-7"), By.id("accordion__panel-7"), "Я живу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    // Проверить соответствие текстов вопроса и ответа
    public void checkQuestionAndAnswer() {
        // Найти элемент вопроса и ответа
        WebElement questionElement = driver.findElement(importantQuestionLocator);
        WebElement answerElement = driver.findElement(importantAnswerLocator);

        //Нажать на вопрос
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", questionElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        questionElement.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", answerElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        // Получить текст вопроса и ответа
        String actualQuestion = questionElement.getText();
        String actualAnswer = answerElement.getText();

        // Проверить соответствие текста вопроса и ответа ожидаемым значениям
        assertTrue("Текст вопроса не соответствует ожидаемому: "+actualQuestion+" - "+questionText,
                actualQuestion.equals(questionText));
        assertTrue("Текст ответа не соответствует ожидаемому: "+actualAnswer+" - "+questionAnswer,
                actualAnswer.equals(questionAnswer));
    }

}
