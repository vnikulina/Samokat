import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.OrderScooterPage;

import java.time.Duration;

import static pageobject.MainScooterGeneralPage.LOWER_BUTTON;
import static pageobject.MainScooterGeneralPage.UPPER_BUTTON;
import static pageobject.constants.URL.ORDER_PAGE;

@RunWith(Parameterized.class)
public class OrderScooterParametrizedTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phone;
    private final String date;
    private final String term;
    private final String color;
    private final String comment;
    private final String button;

    public OrderScooterParametrizedTest(String name,String surname,String address,String subway,String phone,
                                        String date,String term,String color,String comment,String button) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.date = date;
        this.term = term;
        this.color = color;
        this.comment = comment;
        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[][] testOrderData() {
        return new Object[][] {
                {"Иван", "Петров", "Ивановская д1, к45", "Сокольники", "12345678901", "01.12.2023", "трое суток",
                        "black", "Позвоните за час до привоза!",UPPER_BUTTON},
                {"Тест", "Тестовый", "Красная Площадь д1", "Черкизовская", "12345678901", "25.11.2023", "сутки",
                        "gray", " ",LOWER_BUTTON}
        };
    }

    //Проверка оформления заказа
    @Test
    public void checkMakingOrder() {
        WebDriver driver = new ChromeDriver();;
        //WebDriver driver = new FirefoxDriver();
        driver.get(ORDER_PAGE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // объект класса страницы с параметрами заказа
        OrderScooterPage objOrderForm = new OrderScooterPage(driver);
        // Пройти позитивный сценарий с параметрами (выбор кнопки в параметре)
        objOrderForm.positiveOrderFlow(name, surname, address, subway, phone, date, term, color, comment, button);
        driver.quit();
    }
}
