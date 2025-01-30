package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserInfoFormPage {
    private final WebDriver driver;

    private final By nameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private final By surnameField = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private final By addressField = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    private final By metroStationField = By.xpath(".//input[contains(@placeholder, 'Станция метро')]");
    private final By metroStationList = By.className("select-search__select");
    private final By phoneField = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    private final By nextPageButton = By.xpath(".//button[contains(text(),'Далее')]");

    public UserInfoFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitNameFieldClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(nameField));
    }

    public void setNameField(String username) {
        driver.findElement(nameField).sendKeys(username);
    }
    public void setSurnameField(String userSurname) {
        driver.findElement(surnameField).sendKeys(userSurname);
    }
    public void setAddressField(String userAddress) {
        driver.findElement(addressField).sendKeys(userAddress);
    }
    public void clickMetroStationField() {
        driver.findElement(metroStationField).click();
    }

    public void clickMetroStationItem(String metroStationNumber) {

        String xpath = String.format(".//button[@tabindex =-1 and @value = '%s']", metroStationNumber);
        By metroStationItem = By.xpath(xpath);

        WebElement element = driver.findElement(metroStationItem);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(metroStationItem).click();
    }
    public void setPhoneField(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }
    public void clickNextPageButton() {
        driver.findElement(nextPageButton).click();
    }

    public void waitMetroStationList() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(metroStationList)));
    }

    public void fillForm(String username, String userSurname, String userAddress, String metroStationNumber, String phoneNumber) {
        setNameField(username);
        setSurnameField(userSurname);
        setAddressField(userAddress);
        clickMetroStationField();
        waitMetroStationList();
        clickMetroStationItem(metroStationNumber);
        setPhoneField(phoneNumber);
    }


}
