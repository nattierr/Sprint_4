package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderResultPage {
    private final WebDriver driver;

    private final By showStatusButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Посмотреть статус')]");

    public OrderResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickShowStatusButton() {
        driver.findElement(showStatusButton).click();
    }

    public void waitOrderResultPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(showStatusButton));
    }
}
