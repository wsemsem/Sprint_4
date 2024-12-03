import config.CommonMethods;
import config.Constants;
import pajeObject.MainPage;
import pajeObject.PopUpWithStatus;
import pajeObject.RegistrationOrderStepOne;
import pajeObject.RegistrationOrderStepTwo;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Импорт для запуска полного теста в мозиле
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class HeaderOrderButton {

    private WebDriver driver;

    private final String name;
    private final String surename;
    private final String address;
    private final String subway;
    private final String phoneNumber;

    public HeaderOrderButton(String name, String surename, String address, String subway, String phoneNumber) {
        this.name = name;
        this.surename = surename;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getCreditionals() {
        return new Object[][] {
                {"Александр", "Пархамович", "г. Москва, ул. Байкальская, д.52, кв.27", "Полянка", "+798911111111"},
                {"Анна", "Голубович", "г. Москва, ул. Кленовая, д.6, кв.205", "Авиамоторная", "+79896041730"},
        };
    }

    @Test
    public void makeOrder() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

        MainPage objMainPage = new MainPage(driver);
        RegistrationOrderStepOne objRegistrationOrderStep1 = new RegistrationOrderStepOne(driver);
        RegistrationOrderStepTwo objRegistrationOrderStep2 = new RegistrationOrderStepTwo(driver);
        PopUpWithStatus objPopUpWithStatus = new PopUpWithStatus(driver);
        Constants constants = new Constants();
        CommonMethods commonMethods = new CommonMethods();


        driver.get(constants.SITE_URL_ADDRESS);
        driver.manage().window().maximize();

        //Переход к форме для отправки заявки
        objMainPage.clickOrderButtonHeader();

        //Заполнение 1-го шага формы
        objRegistrationOrderStep1.setNameField(name);
        objRegistrationOrderStep1.setSurenameField(surename);
        objRegistrationOrderStep1.setAddressField(address);
        objRegistrationOrderStep1.setSubwayField(subway);
        objRegistrationOrderStep1.setPhoneNumberField(phoneNumber);
        objRegistrationOrderStep1.clickNextStepButton();

        //Заполнение 2-го шага формы
        objRegistrationOrderStep2.setDateField("20.12.2024");
        objRegistrationOrderStep2.setRentTimeField();
        objRegistrationOrderStep2.setBlackColorCheckbox();
        objRegistrationOrderStep2.setCommentsField("Что-то получается, но хочется бОльшего");
        objRegistrationOrderStep2.clickOrderButtonSecondStep();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[text()='Хотите оформить заказ?']"))));

        //Нажатие на кнопку "Да" в поп-апе подтверждения заказа
        objPopUpWithStatus.clickOnButtonYes();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[text()='Заказ оформлен']"))));
        //Нажатие на кнопку "Посмотреть статус" для перехода к странице заказа
        objPopUpWithStatus.clickOnButtonCheckStatus();
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
