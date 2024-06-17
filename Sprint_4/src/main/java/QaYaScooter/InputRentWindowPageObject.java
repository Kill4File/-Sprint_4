package QaYaScooter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputRentWindowPageObject {
    private WebDriver driver;

    public InputRentWindowPageObject(WebDriver driver){
        this.driver = driver;
    }
    
    //Пути
    //окна аренды
    private final By rentWindow = By.xpath(".//div/div[@class = 'Order_Content__bmtHS']");
    //окна с выбором срока аренды
    private By listRentPeriod = By.xpath(".//div/span[@class = 'Dropdown-arrow']");
    //выбора срока аренды - элемент с текстом двое суток
    private By choiceRentPeriod = By.xpath(".//div/div[text() = 'двое суток']");
    //окна с выбором цвета
    private By colorOfScooter = By.xpath(".//div/div[@class = 'Order_Checkboxes__3lWSI']");
    //чекбокса с черным цветом
    private By checkboxColorScooter = By.xpath(".//div/div/label/input[@class = 'Checkbox_Input__14A2w']");
    //путь до кнопки заказать
    private By buttonOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Клики
    //поле даты
    private By date = By.xpath(".//div/div[@class = 'react-datepicker__input-container']/input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //выбор даты
    private By choiceDate = By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--018']");


    //ожидание открытия окна ренты
    public void waitForRentWindow() {
        new WebDriverWait(driver, 3)
                .until(driver -> (driver.findElement(rentWindow).getText() != null));
    }

    public void clickDateRentWindow(){
        driver.findElement(date).click();
    }
   
    public void clickChoiceDateRentWindow(){
        driver.findElement(choiceDate).click();
    }

    public void clickListRentPeriodWindow(){
        driver.findElement(listRentPeriod).click();
    }

    public void clickChoiceRentPeriodWindow(){
        driver.findElement(choiceRentPeriod).click();
    }

    public void clickColorOfScooterRentWindow(){
        driver.findElement(colorOfScooter).click();
    }

    public void clickCheckboxColorScooterRentWindow(){
        driver.findElement(checkboxColorScooter).click();
    }

    public void clickButtonOrderRentWindow(){
        driver.findElement(buttonOrder).click();
    }

    public void rentWindow(){
        waitForRentWindow();
        clickDateRentWindow();
        clickChoiceDateRentWindow();
        clickListRentPeriodWindow();
        clickChoiceRentPeriodWindow();
        clickColorOfScooterRentWindow();
        clickCheckboxColorScooterRentWindow();
        clickButtonOrderRentWindow();
    }
}
