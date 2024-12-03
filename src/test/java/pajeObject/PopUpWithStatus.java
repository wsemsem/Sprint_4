package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Класс pop-up подтверждения заказа
public class PopUpWithStatus {

    private WebDriver driver;

    private By buttonYes = By.xpath(".//button[text()='Да']");
    private By buttonNot = By.xpath(".//button[text()='Нет']");
    private By orderDoneWithNumber = By.xpath(".//div[@class='Order_Modal__YZ-d3']//div[class='Order_ModalHeader__3FDaJ']");
    private By buttonCheckStatus = By.xpath(".//button[text()='Посмотреть статус']");

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
    //Метод нажатия на кнопку "Посмотреть статус"
    public void clickOnButtonCheckStatus() {
        driver.findElement(buttonCheckStatus).click();
    }
}
