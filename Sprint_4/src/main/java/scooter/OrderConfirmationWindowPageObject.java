package scooter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationWindowPageObject {
    private WebDriver driver;

    public OrderConfirmationWindowPageObject(WebDriver driver){
        this.driver = driver;
    }

    //локатор для поиска поля подтверждения заказа
    private final By confirmWindow = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор для кнопка Да
    private final By buttonYes = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //сообщение Заказ оформлен
    private final By orderComplete = By.xpath("//*[contains(text(), 'Заказ оформлен')]");

    //проверка доступности окна подтверждения
    //клик по кнопке да
    public void setConfirmWindowOrder(){
        driver.findElement(confirmWindow).isEnabled();
        driver.findElement(buttonYes).click();
    }

    public boolean isOrderConfirmationMessagePresent() {
        
        // Проверить, существует ли элемент на странице
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(driver -> driver.findElement(orderComplete).isDisplayed());
    }
}
