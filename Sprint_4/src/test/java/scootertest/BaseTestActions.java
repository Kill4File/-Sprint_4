package scootertest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import constants.Urls;
import scooter.Browsers;
import scooter.CookiesWindowPageObject;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        Browsers browser = new Browsers();
        driver = browser.webDriverFromChrome();
        driver.get(Urls.SCOOTER_SITE_URL);
        agreeWithCookies();
    }

    private void agreeWithCookies() {
        CookiesWindowPageObject objCookiesAllow = new CookiesWindowPageObject(driver);
        objCookiesAllow.AgreeWithCookies();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
