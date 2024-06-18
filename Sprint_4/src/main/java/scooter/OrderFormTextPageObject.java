package scooter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.w3c.dom.Text;

public class OrderFormTextPageObject {
    private WebDriver driver;

    public OrderFormTextPageObject(WebDriver driver){
        this.driver = driver;
    }


    //Test locators
 //локатор кнопки заказа вверху
 private final By topButton = By.xpath(".//button[@class = 'Button_Button__ra12g']");
 //локатор кнопки заказа внизу
 private final By bottomButton = By.className("Button_Middle__1CSJM");
    //
    //Локаторы
    //имени
    private final By firstName = By.xpath(".//div/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Имя']");
    //фамилии
    private final By secondName = By.xpath(".//div/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Фамилия']");
    //адреса
    private final By address = By.xpath(".//div/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Адрес: куда привезти заказ']");
    //поля выбора метро
    private final By station = By.xpath(".//div/input[@class = 'select-search__input']");
    //выбора станции в выпавшем списке с метро
    private final By inputStation = By.xpath(".//div[text() = 'Бульвар Рокоссовского']");
    //поля номера телефона
    private final By numberForCall = By.xpath(".//div/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Телефон: на него позвонит курьер']");
    //кнопки Далее
    private final By buttonNext = By.className("Button_Middle__1CSJM");
    


    public By getTopButton() {
        return topButton;
    }

    public By getBottomButton() {
        return bottomButton;
    }

    public void clickTopButton() {
        driver.findElement(topButton).click();
    }

    public void clickBottomButton() {
        driver.findElement(bottomButton).click();
    }
//метод для кнопок заказа - сверху и снизу
    public void clickButtonsOrder(By buttons){
        driver.findElement(buttons).click();
    }
    //ввод имени
    public void setUserFirstNameUserDataWindow(String userFirstName) {
        driver.findElement(firstName).sendKeys(userFirstName);
    }

    //ввод фамилии
    public void setSecondNameUserDataWindow(String userSecondName) {
        driver.findElement(secondName).sendKeys(userSecondName);
    }

    //ввод адреса
    public void setAddressUserDataWindow(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }

    //клик по полю Метро для выбора станции
    public void clickButtonStationUserDataWindow() {
        driver.findElement(station).click();
    }

    //ожидание подгрузки списка после клика
    public void waitForLoadListOfMetroUserDataWindow() {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(inputStation).getText() != null));
    }

    //выбор из выпавшего списка станции Динамо
    public void clickChoiceToStationUserDataWindow(){
        driver.findElement(inputStation).click();
    }

    //ввод номера телефона
    public void setNumberForCallUserDataWindow(String userNumberForCall) {
        driver.findElement(numberForCall).sendKeys(userNumberForCall);
    }

    //клик на кнопку Далее
    public void clickButtonNextUserDataWindow() {
        driver.findElement(buttonNext).click();
    }

    //One big method to rule them all :)
    public void inputTextIntoOrderUserDataWindow(By buttonOrder, String userFirstName, String userSecondName, String userAddress, String userNumberForCall){
        clickButtonsOrder(buttonOrder);
        setUserFirstNameUserDataWindow(userFirstName);
        setSecondNameUserDataWindow(userSecondName);
        setAddressUserDataWindow(userAddress);
        clickButtonStationUserDataWindow();
        waitForLoadListOfMetroUserDataWindow();
        clickChoiceToStationUserDataWindow();
        setNumberForCallUserDataWindow(userNumberForCall);
        clickButtonNextUserDataWindow();
    }
}
