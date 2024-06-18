package scooter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {

    //метод для Хрома
    public WebDriver webDriverFromChrome(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    //метод для Огнелиса
    public WebDriver webDriverFromMozilla(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
