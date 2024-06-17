package QaYaScooterTest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;

import QaYaScooter.*;

import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class QaScooterTestBottonsAndOrderForm {

    //выбор браузера для теста
    Browsers browser = new Browsers();
    WebDriver driver = browser.webDriverFromChrome();

    //Переменные
    //локаторов кнопок заказа наверху и внизу
    private final By buttonOrder;
    //имени в форме заказа
    private final String firstName;
    //фамилии в форме заказа
    private final String secondName;
    //адреса в форме заказа
    private final String address;
    //номера телефона в форме заказа
    private final String numberForCall;

    public QaScooterTestBottonsAndOrderForm(By buttonOrder, String firstName, String secondName, String address, String numberForCall){
        this.buttonOrder = buttonOrder;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.numberForCall = numberForCall;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] setText() {
        //переменная для локатора кнопки заказа наверху
        Object topBut = By.xpath(".//button[@class = 'Button_Button__ra12g']");
        //переменная для кнопки заказа внизу
        Object bottomBut = By.className("Button_Middle__1CSJM");
        return new Object[][] {
                {topBut, "Артем", "Автоматизаторов", "Воронеж, улица Лизюкова, дом 228", "79994445588"},
                {topBut, "игооорЬ", "серггевиЧ", "Сартов, улица Закамская, дом 33", "89001112233"},
                {bottomBut, "Сергей", "Игоревич", "Москва, улица Главная, дом 1", "80123456789"},
                {bottomBut, "ТЕСТ", "ТЕСТОВ", "Тест, улица Тест, дом 1", "79991234567"},
        };
    }

    @Test
    public void checkAllowChrome(){
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //дали разрешение на куки
        CookiesWindowPageObject objCookiesAllow = new CookiesWindowPageObject(driver);
        objCookiesAllow.allowCookies();

        //клик по кнопке заказа и после ввод данных в форму заказа
        OrderFormTextPageObject formTextWindow = new OrderFormTextPageObject(driver);
        formTextWindow.inputTextIntoOrderUserDataWindow(buttonOrder, firstName, secondName, address, numberForCall);

        //заполнили детали заказа - время/цвет/дата
        InputRentWindowPageObject objRentWindow = new InputRentWindowPageObject(driver);
        objRentWindow.rentWindow();

        //клик по кнопке подтверждения в окне подтверждения информации
        // баг(!) - кнопка некликабельна
        OrderConfirmationWindowPageObject objConfirmationWindow = new OrderConfirmationWindowPageObject(driver);
        objConfirmationWindow.setConfirmWindowOrder();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
