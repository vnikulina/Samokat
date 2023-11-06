import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.*;

@RunWith(Parameterized.class)
public class MakeOrderTest {
    private WebDriver driver;
    @Parameterized.Parameters
    public static Object[][] testOrderData() {
        return new Object[][] {
                {"Иван", "Петров", "Ивановская д1, к45", "Сокольники", "12345678901", "2023-12-01", "трое суток",
                        "black", "Позвоните за час до привоза!"},
                {"Тест", "Тестовый", "Красная Площадь д1", "Черкизовская", "12345678901", "2023-11-11", "сутки", "gray", " "}
        };
    }

    @Before
    public void beforeTest() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    //Нажимает верхнюю кнопку оформления заказа
    @Test
    public void clickUpperOrderButtonOpensOrderPage() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Нажать на верхнюю кнопку
        objScooterPage.clickHeaderOrderButton();
        // Убедиться, что есть переход на страницу заказа
        objScooterPage.checkOrderPageOpened();

        // объект класса страницы заказа с параметрами
        OrderScooterPage objOrderForm;
        Object[][] testData = testOrderData();
        objOrderForm = new OrderScooterPage(driver, testData);
        // Пройти позитивный сценарий с параметрами
        objOrderForm.positiveOrderFlow();
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
        Object[][] testData = testOrderData();
        objOrderForm = new OrderScooterPage(driver, testData);
        objOrderForm.positiveOrderFlow();
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
