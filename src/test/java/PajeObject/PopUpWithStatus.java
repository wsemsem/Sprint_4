package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Класс pop-up подтверждения заказа
public class PopUpWithStatus {

    private WebDriver driver;

    private By buttonYes = By.xpath(".//button[text()='Да']");
    private By buttonNot = By.xpath(".//button[text()='Нет']");

    public PopUpWithStatus(WebDriver driver) {
        this.driver = driver;
    }

    //Метод нажатия на кнопку "Да"
    public void clickOnButtonYes(){
        driver.findElement(buttonYes).click();
    }
    //Метод нажатия на кнопку "Нет"
    public void clickOnButtonNot() {
        driver.findElement(buttonNot).click();
    }
}
