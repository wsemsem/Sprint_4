package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Класс 2-го шага формы для заказа самоката
public class RegistrationOrderStep2 {

    private WebDriver driver;

    //Поле для ввода "Когда привезти самокат"
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Поле "Срок аренды"
    private By rentTimeField = By.className("Dropdown-root");

    //Поле "Цвет самоката"
    private By blackColorCheckbox = By.xpath(".//input[@id='black']");
    private By greyColorCheckbox = By.xpath(".//input[@id='grey']");

    //Поле для ввода "Комментарий для курьера"
    private By commentsField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Заказать" 2-го шага
    private By orderButtonSecondStep = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");

    public RegistrationOrderStep2(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для заполнения поля "Когда привезти самокат"
    public void setDateField(String dateToGetSamokat) {
        WebElement datePicker = driver.findElement(dateField);
        datePicker.sendKeys(dateToGetSamokat);
        datePicker.sendKeys(Keys.ENTER);
    }

    //Метод для заполнения поля "Срок аренды"
    public void setRentTimeField() {
        driver.findElement(rentTimeField).click();
        driver.findElement(By.xpath(".//div[text()='пятеро суток']")).click();
    }

    //Метод для заполнения поля "Чёрный цвет самоката"
    public void setBlackColorCheckbox() {
        driver.findElement(blackColorCheckbox).click();
    }

    //Метод для заполнения поля "Серый цвет самоката"
    public void setGreyColorCheckbox() {
        driver.findElement(greyColorCheckbox).click();
    }

    //Метод для заполнения поля "Комментарий для курьера"
    public void setCommentsField(String commentsToCourier) {
        driver.findElement(commentsField).sendKeys(commentsToCourier);
    }

    //Метод нажатия на кнопку "Заказать"
    public void clickOrderButtonSecondStep() {
        driver.findElement(orderButtonSecondStep).click();
    }

}
