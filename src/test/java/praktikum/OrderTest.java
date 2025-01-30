package praktikum;

import PageObject.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;

    Boolean useHeaderOrderButton;
    String username;
    String userSurname;
    String userAddress;
    String metroStationNumber;
    String phoneNumber;
    String comment;
    Boolean switchOnBlack;
    Boolean switchOnGrey;

public OrderTest(Boolean useHeaderOrderButton, String username, String userSurname, String userAddress, String metroStationNumber, String phoneNumber, String comment, Boolean switchOnBlack, Boolean switchOnGrey) {
    this.useHeaderOrderButton = useHeaderOrderButton;
    this.username = username;
    this.userSurname = userSurname;
    this.userAddress = userAddress;
    this.metroStationNumber = metroStationNumber;
    this.phoneNumber = phoneNumber;
    this.comment = comment;
    this.switchOnBlack = switchOnBlack;
    this.switchOnGrey = switchOnGrey;
}

    @Before
    public void initDriver() throws Exception {
        DriverFactory factory = new DriverFactory();
        driver = factory.driver();
    }


    @Parameterized.Parameters

        public static Object[][] fillForm() {
            return new Object[][]{

                    {true, "Анна", "Шерер", "Москва", "60", "79091112233", "Позвоните, когда привезете самокат", true, false},
                    {false, "Татьяна", "Ларина", "Москва", "3", "89031261000", "Хороший самокат", true, true}
            };
        }

        @Test
        public void checkOrderCreating() throws Exception {
//
            driver.get("https://qa-scooter.praktikum-services.ru");
            //Создать главную страницу
            MainPage mainPage = new MainPage(driver);

            //Нажать одну из кнопок заказать
            if (useHeaderOrderButton) {
                mainPage.clickHeaderOrderButton();
            } else {
                mainPage.clickMiddleOrderButton();
            }

            //Создать форму юзера
            UserInfoFormPage userInfoFormPage = new UserInfoFormPage(driver);

            //Дождаться форму
            userInfoFormPage.waitNameFieldClickable();

            //Заполнить форму юзера
            userInfoFormPage.fillForm(username, userSurname, userAddress, metroStationNumber, phoneNumber);

            //Нажать на кнопку далее
            userInfoFormPage.clickNextPageButton();

            //Создать форму заказа
            OrderFormPage orderFormPage = new OrderFormPage(driver);

            //Дождаться форму заказа
            orderFormPage.waitDeliveryDayFieldClickable();

            //Заполнить форму заказа
            orderFormPage.fillOrderForm(comment, switchOnBlack, switchOnGrey);

            //Нажать на кнопку Заказать
            orderFormPage.clickOrderButton();

            //Создать окно подтверждения
            ConfirmPage confirmPage = new ConfirmPage(driver);

            //Дождаться окна подтверждения
            confirmPage.waitConfirmPage();

            //Подтвердить заказ
            confirmPage.clickConfirmButton();

            //Создать страницу статуса заказа
            OrderResultPage orderResultPage = new OrderResultPage(driver);

            //Дождаться кнопки посмотреть статус
            orderResultPage.waitOrderResultPage();

            //Нажать на кнопку посмотреть статус
            orderResultPage.clickShowStatusButton();

        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }


