package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver() throws Exception {
        if ("firefox".equalsIgnoreCase(System.getProperty("browser"))) {
            return startUpFirefox();
        } else {
            return startUpChrome();
        }
    }
    private WebDriver startUpChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver startUpFirefox(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
