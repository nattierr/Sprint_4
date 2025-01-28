package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmPage {
    private final WebDriver driver;

    private final By confirmButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Да')]");
    private final By rejectButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i') and (text()='Нет')]");

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }
    public void clickRejectButton() {
        driver.findElement(rejectButton).click();
    }

    public void waitConfirmPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(confirmButton));
    }
}
