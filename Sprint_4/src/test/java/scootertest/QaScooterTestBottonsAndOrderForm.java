package scootertest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import scooter.*;

@RunWith(Parameterized.class)
public class QaScooterTestOrderButtonsAndForm extends BaseTest {

    private final By buttonOrder;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String numberForCall;

    public QaScooterTestOrderButtonsAndForm(By buttonOrder, String firstName, String secondName, String address, String numberForCall){
        this.buttonOrder = buttonOrder;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.numberForCall = numberForCall;
    }

    @Parameterized.Parameters
    public static Object[][] testDataSets() {
        OrderFormTextPageObject orderFormPage = new OrderFormTextPageObject(new Browsers().webDriverFromChrome());

        return new Object[][] {
                {orderFormPage.getTopButton(), "Артем", "Автоматизаторов", "Воронеж, улица Лизюкова, дом 228", "79994445588"},
                {orderFormPage.getTopButton(), "игооорЬ", "серггевиЧ", "Сартов, улица Закамская, дом 33", "89001112233"},
                {orderFormPage.getBottomButton(), "Сергей", "Игоревич", "Москва, улица Главная, дом 1", "80123456789"},
                {orderFormPage.getBottomButton(), "ТЕСТ", "ТЕСТОВ", "Тест, улица Тест, дом 1", "79991234567"},
        };
    }

    @Test
    public void checkOrderSuccess() {
        OrderFormTextPageObject formTextWindow = new OrderFormTextPageObject(driver);
        formTextWindow.inputTextIntoOrderUserDataWindow(buttonOrder, firstName, secondName, address, numberForCall);

        InputRentWindowPageObject objRentWindow = new InputRentWindowPageObject(driver);
        objRentWindow.rentWindow();

        OrderConfirmationWindowPageObject objConfirmationWindow = new OrderConfirmationWindowPageObject(driver);
        objConfirmationWindow.setConfirmWindowOrder();

        Assert.assertTrue("Заказ не получилось оформить", objConfirmationWindow.isOrderConfirmationMessagePresent());
    }
}