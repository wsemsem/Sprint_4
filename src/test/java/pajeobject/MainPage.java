package pajeobject;

import org.openqa.selenium.*;


//Класс главной страницы
public class MainPage {

    private WebDriver driver;

    //Кнопка "Заказать" в Хедере
    private By orderButtonHeader = By.className("Button_Button__ra12g");

    //Кнопка "Заказать" в середине страницы
    private By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод клика по кнопке в хедере
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    //Метод клика по кнопке в середине страницы
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }

    //Скролл до необходимой кнопки
    public void scrollToOrderButtonMiddle() {
        WebElement element = driver.findElement(orderButtonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}









