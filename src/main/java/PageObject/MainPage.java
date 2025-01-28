package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;

    // массив ответов

    private final String[] answers = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."

    };

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

public void compareFAQ() throws InterruptedException {
    List<WebElement> elements = driver.findElements(accordionItems);

    //assert ((int) elements.size(), (int) answers.length);

    for(int i = 0; i < elements.size(); i++ ) {
        WebElement currentElement = elements.get(i);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", currentElement);
        currentElement.click();

        // ожидание
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class = 'accordion__panel' and not(@hidden) ]//p"), answers[i]));


    }

}

}
