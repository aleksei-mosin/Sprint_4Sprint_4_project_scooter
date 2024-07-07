package scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.praktikum.constant.MainPageURLConstant;
public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUpDriver(){
        driver = getDriver("edge");
        driver.get(MainPageURLConstant.URL);
        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
        driver.navigate().refresh();

    }

    private void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    @After
        public void closePage(){
        driver.quit();
    }


    private WebDriver getDriver(String driverType){
        switch (driverType){
           case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return  new EdgeDriver();
            default:
                throw new IllegalArgumentException("Driver type not supported");
        }
    }
}
