package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormPage {
    private final WebDriver driver;

    private final By deliveryDayField = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    private final By datepickerDay = By.className("react-datepicker__day--028");
    private final By rentalPeriodField = By.className("Dropdown-control");
    private final By rentalPeriodItem = By.xpath(".//div[@class = 'Dropdown-option' and text() = 'двое суток']");
    private final By scooterBlackColorCheckbox = By.xpath(".//label[@for='black']");
    private final By scooterGreyColorCheckbox = By.xpath(".//label[@for='grey']");
    private final By commentField = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    private final By orderButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitDeliveryDayFieldClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(deliveryDayField));
    }

    public void clickDeliveryDayField() {
        driver.findElement(deliveryDayField).click();
    }
    public void setDatepickerDay() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(datepickerDay));
        driver.findElement(datepickerDay).click();
    }
    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
    }
    public void setRentalPeriodItem() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(rentalPeriodItem));
        driver.findElement(rentalPeriodItem).click();
    }
    public void switchScooterBlackColorCheckbox() {
        driver.findElement(scooterBlackColorCheckbox).click();
    }
    public void switchScooterGreyColorCheckbox() {
        driver.findElement(scooterGreyColorCheckbox).click();
    }
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void fillOrderForm(String comment, Boolean switchOnBlack, Boolean switchOnGrey) {
        clickDeliveryDayField();
        setDatepickerDay();
        clickRentalPeriodField();
        setRentalPeriodItem();
        if (switchOnBlack) {
            switchScooterBlackColorCheckbox();
        }
        if (switchOnGrey) {
            switchScooterGreyColorCheckbox();
        }
        setCommentField(comment);
    }
}
