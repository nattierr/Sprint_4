package praktikum;

import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FAQTest {
    private WebDriver driver;

    @Before
    public void startUp() throws Exception {
        DriverFactory factory = new DriverFactory();
        driver = factory.driver();
    }

    @Test
    public void openMainPage() throws Exception{
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.compareFAQ();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
