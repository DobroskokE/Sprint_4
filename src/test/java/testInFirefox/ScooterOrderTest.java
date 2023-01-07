package testInFirefox;// импорт класса Parameterized и аннотации RunWith

import PageObject.MainPage;
import PageObject.OrderPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static PageObject.MainPage.*;

@RunWith(Parameterized.class) // указали, что тесты будет запускать раннер Parameterized


public class ScooterOrderTest {// создали тестовый класс
    private WebDriver driver;

    // создали поля тестового класса
    //переменные раздела Для кого самокат
    private final String name;
    private final String lastName;
    private final String address;
    private final String phoneNumber;

    //переменные раздела Про аренду самокат
    private final String comment;

    //переменная кнопок Заказать
    private final By orderButton;

    // создали конструктор тестового класса
    public ScooterOrderTest(By orderButton, String name, String lastName, String address, String phoneNumber, String comment) {

        this.orderButton = orderButton;

        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;

        this.comment = comment;
    }


    //параметризированный метод
    @Parameterized.Parameters // добавили аннотацию
    // напиши метод для получения тестовых данных
    public static Object[][] getData() {
        return new Object[][]{
                {ORDER_TOP_BUTTON, "Петр", "Петров", "Русаковская ул., 4с1", "11111111111", "бла-бла-бла"},
                {ORDER_BOTTOM_BUTTON, "Иванов", "Иван", "Хорошёвское ш., 5 корпус 2", "11111111122", "комментарий"},
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

        //создай объект параметризованного теста
        ScooterOrderTest scooterOrderTest = new ScooterOrderTest(orderButton, name, lastName, address, phoneNumber, comment);

        //Принять куки,т.к. мешают
        driver.findElement(COOKIE_BUTTON).click();

        // кликни на кнопку Заказать
        driver.findElement(orderButton).click();

        // создай объект класса перехода на страницу заказа
        OrderPage objOrderPage = new OrderPage(driver);

        //заполнить поля в блок Для кого данными из параметризованного объекта
        objOrderPage.dataEntryInTheBlockForWhom(name, lastName, address, phoneNumber);

        //заполнить поля в блок Про аренду данными из параметризованного объекта
        objOrderPage.dataEntryInTheBlockRent(comment);

        //Подтвердить заказ
        objOrderPage.yesOrderButtonClick();

        // проверь, что модальное окно активно
        objOrderPage.orderModalCheck();
        // проверь, что есть текст успешного заказа
        objOrderPage.orderTextCheck();

    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

}
