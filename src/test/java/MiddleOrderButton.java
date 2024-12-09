import pageobject.MainPage;
import pageobject.PopUpWithStatus;
import pageobject.RegistrationOrderStepOne;
import pageobject.RegistrationOrderStepTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(Parameterized.class)
public class MiddleOrderButton extends BaseTest {

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

        MainPage objMainPage = new MainPage(driver);
        RegistrationOrderStepOne objRegistrationOrderStep1 = new RegistrationOrderStepOne(driver);
        RegistrationOrderStepTwo objRegistrationOrderStep2 = new RegistrationOrderStepTwo(driver);
        PopUpWithStatus objPopUpWithStatus = new PopUpWithStatus(driver);

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

        //Отображение поп-ап'а
        objRegistrationOrderStep2.checkOpinionToOrder();
        //Нажатие на кнопку "Да" в поп-апе подтверждения заказа
        objPopUpWithStatus.clickOnButtonYes();

        //Проверка отображения поп-ап'а с заголовком "Заказ оформлен"
        objRegistrationOrderStep2.checkOrderStatus();

        //Нажатие на кнопку "Посмотреть статус" для перехода к странице заказа
        objPopUpWithStatus.getOrderNumber();
        objPopUpWithStatus.clickOnButtonCheckStatus();
    }

}
