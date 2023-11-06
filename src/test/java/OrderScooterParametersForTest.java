import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderScooterParametersForTest {

    @Parameterized.Parameters
    public static Object[][] testOrderData() {
        return new Object[][] {
                {"Иван", "Петров", "Ивановская д1, к45", "Сокольники", "12345678901", "01.12.2023", "трое суток",
                        "black", "Позвоните за час до привоза!","upper"},
                {"Тест", "Тестовый", "Красная Площадь д1", "Черкизовская", "12345678901", "15.11.2023", "сутки",
                        "gray", " ","lower"}
        };
    }

}
