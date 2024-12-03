package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Класс 1-го шага формы для заказа самоката
public class RegistrationOrderStepOne {

    private WebDriver driver;

    //Поле для ввода "Имя"
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");

    //Поле для ввода "Фамилия"
    private By surenameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле для ввода "Адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле для ввода "Станция метро"
    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле для ввода "Телефон"
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private By nextStepButton = By.xpath(".//button[text()='Далее']");

    public RegistrationOrderStepOne(WebDriver driver) {
        this.driver = driver;
    }

    //Метод заполнения поля "Имя"
    public void setNameField(String firstName) {
        driver.findElement(nameField).sendKeys(firstName);
    }

    //Метод заполнения поля "Фамилия"
    public void setSurenameField(String lastName) {
        driver.findElement(surenameField).sendKeys(lastName);
    }

    //Метод заполнения поля "Адрес"
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Метод заполнения поля "Станция метро"
    public void setSubwayField(String subwayAddress) {
        driver.findElement(subwayField).click();
        WebElement dropDown = driver.findElement(By.xpath(".//div[contains(text(), '" + subwayAddress + "')]"));
        dropDown.click();
    }

    //Метод для заполнения поля "Телефон"
    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //Метод нажатия на кнопку "Далее"
    public void clickNextStepButton() {
        driver.findElement(nextStepButton).click();
    }
}
