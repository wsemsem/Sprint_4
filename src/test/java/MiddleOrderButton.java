import PajeObject.MainPage;
import PajeObject.PopUpWithStatus;
import PajeObject.RegistrationOrderStep1;
import PajeObject.RegistrationOrderStep2;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class MiddleOrderButton {

    private WebDriver driver;

    private final String name;
    private final String surename;
    private final String address;
    private final String subway;
    private final String phoneNumber;

    public MiddleOrderButton(String name, String surename, String address, String subway, String phoneNumber) {
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

        MainPage objMainPage = new MainPage(driver);
        RegistrationOrderStep1 objRegistrationOrderStep1 = new RegistrationOrderStep1(driver);
        RegistrationOrderStep2 objRegistrationOrderStep2 = new RegistrationOrderStep2(driver);
        PopUpWithStatus objPopUpWithStatus = new PopUpWithStatus(driver);


        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();

        //Скролл до необходимой кнопки
        objMainPage.scrollToOrderButtonMiddle();

        //Переход к форме для отправки заявки
        objMainPage.clickOrderButtonMiddle();

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

        //Кнопка "Да" не работает в Chrome, поэтому в этих кейсах жмём на "Нет"
        objPopUpWithStatus.clickOnButtonNot();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
