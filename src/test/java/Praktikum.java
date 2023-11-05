import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import qaScooter.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Praktikum {
    private WebDriver driver;

    @Before
    public void beforeTest() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
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
        Object[][] questions = MainScooterQuestionsPage.getQuestions();
        for (Object[] question : questions) {
            objScooterPage = new MainScooterQuestionsPage(driver, (By) question[0], (By) question[1],
                    (String) question[2], (String) question[3]);

            // Проверить соответствие текстов вопроса и ответа
            objScooterPage.checkQuestionAndAnswer();
        }
    }

    //Нажимает верхнюю кнопку оформления заказа
    @Test
    public void clickUpperOrderButtonOpensOrderPage() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Нажать на верхнюю кнопку и убедиться, что есть переход на страницу заказа
        objScooterPage.clickHeaderOrderButton();
        // объект класса страницы заказа с параметрами
        OrderScooterPage objOrderForm;
        Object[][] testData = OrderScooterPage.testData();
        objOrderForm = new OrderScooterPage(driver, testData);
        // Пройти позитивный сценарий с параметрами
        objOrderForm.positiveOrderFlowTest();
    }

    //Нажимает нижнюю кнопку оформления заказа
    @Test
    public void clickLowerOrderButtonOpensOrderPage() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Нажать на нижнюю кнопку
        objScooterPage.clickFooterOrderButton();
        // объект класса страницы заказа
        OrderScooterPage objOrderForm;
        Object[][] testData = OrderScooterPage.testData();
        objOrderForm = new OrderScooterPage(driver, testData);
        objOrderForm.positiveOrderFlowTest();
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
