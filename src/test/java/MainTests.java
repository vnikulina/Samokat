import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MainTests {
    private WebDriver driver;

    @Before
    public void beforeTest() {
        // драйвер для браузера
        ChromeOptions options = new ChromeOptions();
        //driver = new FirefoxDriver();
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

    //Нажимает верхнюю кнопку оформления заказа
    @Test
    public void clickUpperOrderButtonOpensOrderPage() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Нажать на верхнюю кнопку
        objScooterPage.clickHeaderOrderButton();
        //убедиться, что есть переход на страницу заказа
        objScooterPage.checkOrderPageOpened();
    }

    //Нажимает нижнюю кнопку оформления заказа
    @Test
    public void clickLowerOrderButtonOpensOrderPage() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Нажать на нижнюю кнопку
        objScooterPage.clickFooterOrderButton();
        //убедиться, что есть переход на страницу заказа
        objScooterPage.checkOrderPageOpened();
    }

    //Проверка оформления заказа
    @Test
    public void checkMakingOrder() {
        // объект класса страницы с параметрами заказа
        OrderScooterPage objOrderForm;
        Object[][] testData = OrderScooterParametersForTest.testOrderData();
        for (Object[] testOrderData : testData) {
            objOrderForm = new OrderScooterPage(driver, testOrderData);
            // Пройти позитивный сценарий с параметрами
            objOrderForm.positiveOrderFlow();
        }
    }


    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
