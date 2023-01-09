package PageObject;

import org.openqa.selenium.By;

public class MainPage {
    //локаторы для кнопкок выпадающего списка в разделе Вопросы о важном
    public static final By HOW_MATCH_BUTTON = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    public static final By WANT_SEVERAL_SCOOTER_BUTTON = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    public static final By HOW_COUNT_TIME_BUTTON = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    public static final By MAY_ORDER_TODAY_BUTTON = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    public static final By MAY_RETURN_OR_EXTEND_TIME_BUTTON = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    public static final By DELIVERY_CHARGER_WITH_SCOOTER_BUTTON = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    public static final By MAY_CANSEL_ORDER_BUTTON = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    public static final By DELIVERY_ACROSS_MKAD_BUTTON = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");

    //локаторы для ответов выпадающего списка в разделе Вопросы о важном
    public static final By HOW_MATCH_ANSWER = By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    public static final By WANT_SEVERAL_SCOOTER_ANSWER = By.xpath(".//p[starts-with(text(),'Пока что у нас так: один заказ — один самокат.')]");
    public static final By HOW_COUNT_TIME_ANSWER = By.xpath(".//p[starts-with(text(),'Допустим, вы оформляете заказ на 8 мая.')]");
    public static final By MAY_ORDER_TODAY_ANSWER = By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    public static final By MAY_RETURN_OR_EXTEND_TIME_ANSWER = By.xpath(".//p[starts-with(text(),'Пока что нет! Но если что-то срочное — всегда')]");
    public static final By DELIVERY_CHARGER_WITH_SCOOTER_ANSWER = By.xpath(".//p[starts-with(text(),'Самокат приезжает к вам с полной зарядкой.')]");
    public static final By MAY_CANSEL_ORDER_ANSWER = By.xpath(".//p[starts-with(text(),'Да, пока самокат не привезли.')]");
    public static final By DELIVERY_ACROSS_MKAD_ANSWER = By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");

    //Принять куки
    public static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");

    //кнопка Заказать вверху страницы
    public static final By ORDER_TOP_BUTTON = By.className("Button_Button__ra12g");

    //кнопка Заказать внизу страницы
    public static final By ORDER_BOTTOM_BUTTON = By.xpath(".//button[text()='Заказать']");
}