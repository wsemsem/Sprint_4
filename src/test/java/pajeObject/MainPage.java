package pajeObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


//Класс главной страницы
public class MainPage {

    private WebDriver driver;

    String accordionHeadingExpectedZero = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    String accordionHeadingExpectedOne = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    String accordionHeadingExpectedTwo = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    String accordionHeadingExpectedThree = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    String accordionHeadingExpectedFour = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    String accordionHeadingExpectedFive = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    String accordionHeadingExpectedSix = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    String accordionHeadingExpectedSeven = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Кнопка "Заказать" в Хедере
    private By orderButtonHeader = By.className("Button_Button__ra12g");

    //Кнопка "Заказать" в середине страницы
    private By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");

    //Заголовки раздела FAQ

    //Первый пункт
    private By accordionHeadingZero = By.xpath(".//div[@id='accordion__heading-0']");

    //Второй пункт
    private By accordionHeadingOne = By.xpath(".//div[@id='accordion__heading-1']");

    //Третий пункт
    private By accordionHeadingTwo = By.xpath(".//div[@id='accordion__heading-2']");

    //Четвертый пункт
    private By accordionHeadingThree = By.xpath(".//div[@id='accordion__heading-3']");

    //Пятый пункт
    private By accordionHeadingFour = By.xpath(".//div[@id='accordion__heading-4']");

    //Шестой пункт
    private By accordionHeadingFive = By.xpath(".//div[@id='accordion__heading-5']");

    //Седьмой пункт
    private By accordionHeadingSix = By.xpath(".//div[@id='accordion__heading-6']");

    //Восьмой пункт
    private By accordionHeadingSeven = By.xpath(".//div[@id='accordion__heading-7']");

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

    //Методы клика по заголовкам FAQ

    //Метод клика по первому заголовку
    public void clickAccordionHeadingZero() {
        driver.findElement(accordionHeadingZero).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-0']"))));
        String AccordionHeadingActual0 = driver.findElement(By.xpath(".//div[@id='accordion__panel-0']")).getText();
        assertEquals(accordionHeadingExpectedZero, AccordionHeadingActual0);
    }

    //Метод клика по второму заголовку
    public void clickAccordionHeadingOne() {
        driver.findElement(accordionHeadingOne).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-1']"))));
        String AccordionHeadingActual1 = driver.findElement(By.xpath(".//div[@id='accordion__panel-1']")).getText();
        assertEquals(accordionHeadingExpectedOne, AccordionHeadingActual1);
    }
    //Метод клика по третьему заголовку
    public void clickAccordionHeadingTwo() {
        driver.findElement(accordionHeadingTwo).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-2']"))));
        String AccordionHeadingActual2 = driver.findElement(By.xpath(".//div[@id='accordion__panel-2']")).getText();
        assertEquals(accordionHeadingExpectedTwo, AccordionHeadingActual2);
    }
    //Метод клика по четвертому заголовку
    public void clickAccordionHeadingThree() {
        driver.findElement(accordionHeadingThree).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-3']"))));
        String AccordionHeadingActual3 = driver.findElement(By.xpath(".//div[@id='accordion__panel-3']")).getText();
        assertEquals(accordionHeadingExpectedThree, AccordionHeadingActual3);
    }
    //Метод клика по пятому заголовку
        public void clickAccordionHeadingFour() {
            driver.findElement(accordionHeadingFour).click();
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-4']"))));
            String AccordionHeadingActual4 = driver.findElement(By.xpath(".//div[@id='accordion__panel-4']")).getText();
            assertEquals(accordionHeadingExpectedFour, AccordionHeadingActual4);
        }
    //Метод клика по шестому заголовку
    public void clickAccordionHeadingFive() {
        driver.findElement(accordionHeadingFive).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-5']"))));
        String AccordionHeadingActual5 = driver.findElement(By.xpath(".//div[@id='accordion__panel-5']")).getText();
        assertEquals(accordionHeadingExpectedFive, AccordionHeadingActual5);
    }

    //Метод клика по седьмому заголовку
    public void clickAccordionHeadingSix() {
        driver.findElement(accordionHeadingSix).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-6']"))));
        String AccordionHeadingActual6 = driver.findElement(By.xpath(".//div[@id='accordion__panel-6']")).getText();
        assertEquals(accordionHeadingExpectedSix, AccordionHeadingActual6);
    }
    //Метод клика по восьмому заголовку
    public void clickAccordionHeadingSeven() {
        driver.findElement(accordionHeadingSeven).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-7']"))));
        String AccordionHeadingActual7 = driver.findElement(By.xpath(".//div[@id='accordion__panel-7']")).getText();
        assertEquals(accordionHeadingExpectedSeven, AccordionHeadingActual7);
    }
}








