package testInFirefox;

import PageObject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static PageObject.MainPage.*;

@RunWith(Parameterized.class) // указали, что тесты будет запускать раннер Parameterized

public class ImportantQuestionTest {// создали тестовый класс
    private WebDriver driver;

    // создали поля тестового класса
    private final By question;
    private final By answer;

    // создали конструктор тестового класса
    public ImportantQuestionTest(By question, By answer) {
        this.question = question;
        this.answer = answer;
    }

    //параметризированный метод
    @Parameterized.Parameters // добавили аннотацию
    // напиши метод для получения тестовых данных
    public static Object[][] getData() {
        return new Object[][]{
                {HOW_MATCH_BUTTON, HOW_MATCH_ANSWER},
                {WANT_SEVERAL_SCOOTER_BUTTON, WANT_SEVERAL_SCOOTER_ANSWER},
                {HOW_COUNT_TIME_BUTTON, HOW_COUNT_TIME_ANSWER},
                {MAY_ORDER_TODAY_BUTTON, MAY_ORDER_TODAY_ANSWER},
                {MAY_RETURN_OR_EXTEND_TIME_BUTTON, MAY_RETURN_OR_EXTEND_TIME_ANSWER},
                {DELIVERY_CHARGER_WITH_SCOOTER_BUTTON, DELIVERY_CHARGER_WITH_SCOOTER_ANSWER},
                {MAY_CANSEL_ORDER_BUTTON, MAY_CANSEL_ORDER_ANSWER},
                {DELIVERY_ACROSS_MKAD_BUTTON, DELIVERY_ACROSS_MKAD_ANSWER},
        };
    }

    @Test
    public void test() {
        // создали драйвер для браузера Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);

        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");

        //создай объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        //Принять куки,т.к. мешают
        driver.findElement(COOKIE_BUTTON).click();

        // открыть вопрос
        driver.findElement(question).click();
        // проверь, что ответ соответствует вопросу
        Assert.assertTrue(driver.findElement(answer).isEnabled());
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

}
