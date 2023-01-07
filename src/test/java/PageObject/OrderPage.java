package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    //Страница Заказа
    private WebDriver driver;

    //Раздел Для кого самокат
    //Поле Имя
    private By nameField = By.cssSelector("input[placeholder='* Имя']");

    //Поле Фамилия
    private By lastNameField = By.cssSelector("input[placeholder='* Фамилия']");
    //Поле Адрес
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private By metroStationField = By.cssSelector("input[placeholder='* Станция метро']");
    //Станция метро из списка
    private By metroStationFromTheList = By.className("select-search__select");
    //Поле телефон
    private By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //Раздел Про аренду
    //Поле Когда привезти самокат
    private By whenDeliveryScooterField = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    //выбрать дату доставки
    private By whenDeliveryScooterDate = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--007 react-datepicker__day--keyboard-selected react-datepicker__day--today react-datepicker__day--weekend']");

    //поле Срок аренды
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    //Выбор срока аренды из списка
    private By threeDaysRentalPeriodField = By.xpath(".//div[text()='двое суток']");
    //Поле цвет самоката
    private By colorField = By.id("black");
    //Поле Комментарий для курьера
    private By commentField = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    //кнопка Заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка Да для оформления заказа
    private By yesOrderButton = By.xpath(".//button[text()='Да']");

    //Заказ оформлен
    private By orderText = By.xpath(".//div[text()='Заказ оформлен']");

    //Модальное окно Заказ оформлен
    private By orderModal = By.className("Order_Modal__YZ-d3");


    //Добавили конструктор класса page object
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //МЕТОДЫ раздела Для кого самокат
    //Заполнить поле Имя
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //Заполнить поле Фамилия
    public void setLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    //Заполнить поле Адрес
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Выбрать Станцию метро
    public void clickMetroStationField() {
        driver.findElement(metroStationField).click();
    }

    //Выбрать Станцию метро из списка
    public void clickMetroStationFromTheList() {
        driver.findElement(metroStationFromTheList).click();
    }

    //Заполнить поле телефон
    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //Нажать кнопку Далее
    public void clickFurtherButton() {
        driver.findElement(furtherButton).click();
    }


    //МЕТОДЫ Раздел Про аренду
    //Нажать на поле Когда привезти самокат
    public void clickWhenDeliveryScooterField() {
        driver.findElement(whenDeliveryScooterField).click();
    }

    //выбрать дату доставки
    public void clickWhenDeliveryScooterDate() {
        driver.findElement(whenDeliveryScooterDate).click();
    }

    //выбрать Срок аренды
    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
    }

    //Выбор срока аренды из списка
    public void clickThreeDaysRentalPeriodField() {
        driver.findElement(threeDaysRentalPeriodField).click();
    }

    //выбрать цвет самоката
    public void clickColorField() {
        driver.findElement(colorField).click();
    }

    //Поле Комментарий для курьера
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //нажать кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }


    //Метод поиска модального окна Заказ оформлен
    public void orderModalCheck() {
        Assert.assertTrue(driver.findElement(orderModal).isEnabled());
    }

    //Метод поиска текста Заказ оформлен
    public void orderTextCheck() {
        Assert.assertTrue(driver.findElement(orderText).isEnabled());
        ;
    }

    //МЕТОД заполнения раздела Для кого самокат
    public void dataEntryInTheBlockForWhom(String name, String lastName, String address, String phoneNumber) {
        setNameField(name);
        setLastNameField(lastName);
        setAddressField(address);
        clickMetroStationField();
        clickMetroStationFromTheList();
        setPhoneNumberField(phoneNumber);
        clickFurtherButton();
    }

    //МЕТОД заполнения раздела Про аренду
    public void dataEntryInTheBlockRent(String comment) {
        clickWhenDeliveryScooterField();
        clickWhenDeliveryScooterDate();
        clickRentalPeriodField();
        clickThreeDaysRentalPeriodField();
        clickColorField();
        setCommentField(comment);
        clickOrderButton();
    }

    //МЕТОД Нажатие кнопки Да
    public void yesOrderButtonClick() {
        driver.findElement(yesOrderButton).click();
    }

}