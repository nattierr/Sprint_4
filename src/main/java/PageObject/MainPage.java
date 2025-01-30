package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;


    // список вопросов о важном
    private final By accordionItems = By.className("accordion__item");
    private final By middleOrderButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");
    private final By headerOrderButton = By.xpath(".//div[(@class = 'Header_Nav__AGCXC')]//button[@class = 'Button_Button__ra12g']");

    public void clickMiddleOrderButton() {
        WebElement element = driver.findElement(middleOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkFAQquestion(Integer index, String question, String answer) throws InterruptedException {

        String xpath = String.format(".//div[@id = 'accordion__heading-%d']", index);
        By questionItem = By.xpath(xpath);
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.textToBePresentInElementLocated(questionItem, question));


        List<WebElement> elements = driver.findElements(accordionItems);
        WebElement currentElement = elements.get(index);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", currentElement);

        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(currentElement));

        currentElement.click();


        // ожидание
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class = 'accordion__panel' and not(@hidden) ]//p"), answer));

    }

}
