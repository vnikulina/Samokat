package qaScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainScooterGeneralPage {
    private WebDriver driver;

    // Кнопка "Заказать" вверху страницы
    private final By headerOrderButton = By.cssSelector(".Button_Button__ra12g");
    // Кнопка "Заказать" внизу страницы
    private final By footerOrderButton = By.cssSelector(".Button_Middle__1CSJM");
    //Подзаголовок вопросов
    private final By questionsTitle = By.cssSelector(".Home_FourPart__1uthg > div:nth-child(1)");
    //Ожидаемый текст названия раздела вопросов
    private static final String QUESTIONS_HEADER_TEXT = "Вопросы о важном";
    //Ожидаемый URL страницы оформления заказа
    private static final String ORDER_URL = "https://qa-scooter.praktikum-services.ru/order";

    //Конструктор
    public MainScooterGeneralPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проверить корректность текста заголовка
    public void checkQuestionsHeader() {
        WebElement questionsTitleElement = driver.findElement(questionsTitle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", questionsTitleElement);

        assertTrue("Заголовок раздела вопросов неверный: ожидался "+QUESTIONS_HEADER_TEXT+", фактический "+
                questionsTitleElement.getText(), questionsTitleElement.getText().equals(QUESTIONS_HEADER_TEXT));
    }

    public void clickHeaderOrderButton() {
        //Найти верхнюю кнопку
        WebElement upperButton = driver.findElement(headerOrderButton);
        //Подскроллить к ней и нажать
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", upperButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        upperButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Проверить, что открылась страница оформления заказа
        assertTrue("Страница оформления заказа не открылась!", driver.getCurrentUrl().equals(ORDER_URL));
    }

    public void clickFooterOrderButton() {
        //Найти верхнюю кнопку
        WebElement lowerButton = driver.findElement(footerOrderButton);
        //Подскроллить к ней и нажать
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lowerButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        lowerButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Проверить, что открылась страница оформления заказа
        assertTrue("Страница оформления заказа не открылась!", driver.getCurrentUrl().equals(ORDER_URL));
    }

}
