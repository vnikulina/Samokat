package qaScooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class OrderScooterPage {
    private WebDriver driver;
    // Поле ввода имени
    private final By inputName = By.cssSelector("div.Order_Form__17u6u > div:nth-child(1) > input");
    // Поле вводе фамилии
    private final By inputSurname = By.cssSelector("div.Order_Form__17u6u > div:nth-child(2) > input");
    // Поле ввода адреса
    private final By inputAddress = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input");
    // Выпадающий список станции метро
    private final By dropdownSubway = By.cssSelector("div.select-search");
    private final By dropdownSubwayElement = By.cssSelector("div.select-search__select > ul > li");
    // Поле ввода номера телефона
    private final By inputPhone = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input");
    // Кнопка "Далее"
    private final By buttonNext = By.cssSelector("div.Order_NextButton__1_rCA > button");
    //Date-picker
    private final By datePicker = By.cssSelector(".Order_MixedDatePicker__3qiay");
    //Дропдаун срока аренды
    private final By dropdownTerm = By.cssSelector("div.Dropdown-root.Order_FilledDate__1pb8n");
    //Боксы выбора цвета
    private final By boxBlackColor = By.cssSelector("#black");
    private final By boxGrayColor = By.cssSelector("#grey");
    //Коммент для курьера
    private final By inputComment = By.cssSelector("div.Order_Form__17u6u > div.Input_InputContainer__3NykH > input");
    //Кнопка "Заказать"
    private final By buttonOrder = By.cssSelector("div.Order_Buttons__1xGrp > button:nth-child(2)");
    //Заголовок "Хотите?" на модалке подтверждения
    private final By titleDoYouReallyWant = By.cssSelector(".Order_ModalHeader__3FDaJ");
    //Кнопка Да
    private final By buttonYes = By.cssSelector("div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");
    //Заголовок "Заказ оформлен"
    private final By titleOrderRecieved = By.cssSelector(".Order_ModalHeader__3FDaJ");
    private Object[][] testData;


    //Конструктор
    public OrderScooterPage(WebDriver driver,Object[][] testData) {
        this.driver = driver;
        this.testData = testData;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Иван", "Петров", "Ивановская д1, к45", "Сокольники", "12345678901", "2023-12-01", "трое суток",
                        "black", "Позвоните за час до привоза!"},
                {"Тест", "Тестовый", "Красная Площадь д1", "Черкизовская", "12345678901", "2023-11-11", "сутки", "gray", " "}
        };
    }

    public void enterName(String name) {
        WebElement nameInputElement = driver.findElement(inputName);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nameInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nameInputElement)).click();

        nameInputElement.clear();
        nameInputElement.sendKeys(name);

        wait.until(ExpectedConditions.attributeToBe(nameInputElement, "value", name));
    }

    public void enterSurname(String surname) {
        WebElement surnameInputElement = driver.findElement(inputSurname);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", surnameInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(surnameInputElement)).click();

        surnameInputElement.clear();
        surnameInputElement.sendKeys(surname);

        wait.until(ExpectedConditions.attributeToBe(surnameInputElement, "value", surname));
    }

    public void enterAddress(String address) {
        WebElement addressInputElement = driver.findElement(inputAddress);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", addressInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addressInputElement)).click();

        addressInputElement.clear();
        addressInputElement.sendKeys(address);

        wait.until(ExpectedConditions.attributeToBe(addressInputElement, "value", address));
    }

    public void selectSubway(String subwayName) {
        WebElement subwayDropdown = driver.findElement(dropdownSubway);
        subwayDropdown.click();

        WebDriverWait ulWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ulWait.until(ExpectedConditions.visibilityOfElementLocated(dropdownSubwayElement));

        List<WebElement> options = driver.findElements(dropdownSubwayElement);
        for (WebElement option : options) {
            if (option.getText().equals(subwayName)) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", option);
                break;
            }
        }
    }

    public void enterPhone(String phone) {
        WebElement phoneInputElement = driver.findElement(inputPhone);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", phoneInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(phoneInputElement)).click();

        phoneInputElement.clear();
        phoneInputElement.sendKeys(phone);
    }

    public void clickNextButton() {
        WebElement nextButtonElement = driver.findElement(buttonNext);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonElement)).click();
    }

    public void selectDate(String date) {
        WebElement datePickerElement = driver.findElement(datePicker);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", datePickerElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(datePickerElement)).click();

        datePickerElement.clear();
        datePickerElement.sendKeys(date);
    }

    public void selectTerm(String term) {
        WebElement termDropdown = driver.findElement(dropdownTerm);
        Select select = new Select(termDropdown);
        select.selectByVisibleText(term);
    }

    public void selectColor(String color) {
        if (color.equalsIgnoreCase("black")) {
            WebElement blackColorBox = driver.findElement(boxBlackColor);
            blackColorBox.click();
        } else if (color.equalsIgnoreCase("gray")) {
            WebElement grayColorBox = driver.findElement(boxGrayColor);
            grayColorBox.click();
        }
    }

    public void enterComment(String comment) {
        WebElement commentInputElement = driver.findElement(inputComment);
        commentInputElement.sendKeys(comment);
    }

    public void clickOrderButton() {
        WebElement orderButtonElement = driver.findElement(buttonOrder);
        orderButtonElement.click();
    }

    public String getDoYouReallyWantTitle() {
        WebElement titleElement = driver.findElement(titleDoYouReallyWant);
        return titleElement.getText();
    }

    public String getOrderReceivedTitle() {
        WebElement titleElement = driver.findElement(titleOrderRecieved);
        return titleElement.getText();
    }

    @Test
    public void positiveOrderFlowTest() {
        // Параметры для теста
        String name = testData[0][0].toString();
        String surname = testData[0][1].toString();
        String address = testData[0][2].toString();
        String subway = testData[0][3].toString();
        String phone = testData[0][4].toString();
        String date = testData[0][5].toString();
        String term = testData[0][6].toString();
        String color = testData[0][7].toString();
        String comment = testData[0][8].toString();

        // Ввод данных
        enterName(name);
        enterSurname(surname);

        selectSubway(subway);
        enterAddress(address);

        enterPhone(phone);
        clickNextButton();

        selectDate(date);
        selectTerm(term);
        selectColor(color);
        enterComment(comment);
        clickOrderButton();

        // Проверка результатов
        String confirmationTitle = getDoYouReallyWantTitle();
        Assert.assertEquals("Хотите оформить заказ?", confirmationTitle);

        clickYesButton();

        String orderReceivedTitle = getOrderReceivedTitle();
        Assert.assertEquals("Заказ оформлен", orderReceivedTitle);
    }

    public void clickYesButton() {
        WebElement yesButtonElement = driver.findElement(buttonYes);
        yesButtonElement.click();
    }

}
