package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


//Класс главной страницы
public class MainPage {

    private WebDriver driver;

    //Кнопка "Заказать" в Хедере
    private By orderButtonHeader = By.className("Button_Button__ra12g");

    //Кнопка "Заказать" в середине страницы
    private By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");

    //Панель для принятия куки
    private By cookieAcceptPanel = By.xpath(".//button[@id='rcc-confirm-button']");

    //Панель FAQ
    private By faqPanel = By.xpath(".//div[@class='Home_FourPart__1uthg']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для принятия куки
    public void cookieAccept() {
        driver.findElement(cookieAcceptPanel).click();
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

    //Скролл до панели с FAQ
    public void scrollToFaqPanel() {
        WebElement element = driver.findElement(faqPanel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод клика на пункт из FAQ
    public void faqPanelOpenAndCompare(String question, String answer) {
        driver.findElement(By.xpath(".//div[contains(text(), '" + question + "')]")).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//p[contains(text(), '" + answer + "')]"))));
        String actualText = driver.findElement(By.xpath(".//p[contains(text(), '" + answer + "')]")).getText();
        assertEquals(actualText, answer);
    }

}









