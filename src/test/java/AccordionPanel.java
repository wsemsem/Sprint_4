import config.Constants;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pajeObject.MainPage;



public class AccordionPanel {

    private WebDriver driver;

    //Раскрытие пунктов из раздела "Вопросы" и сравнение текста
    @Test
    public void checkAccordions() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        MainPage objMainPage = new MainPage(driver);

        Constants constants = new Constants();

        driver.get(constants.SITE_URL_ADDRESS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath(".//button[@id='rcc-confirm-button']")).click();
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FourPart__1uthg']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        //Нулевой пункт
        objMainPage.clickAccordionHeadingZero();

        //Первый пункт
        objMainPage.clickAccordionHeadingTwo();

        //Второй пункт
        objMainPage.clickAccordionHeadingThree();

        //Третий пункт
        objMainPage.clickAccordionHeadingFour();

        //Четвертый пункт
        objMainPage.clickAccordionHeadingFive();

        //Пятый пункт
        objMainPage.clickAccordionHeadingSix();

        //Шестой пункт
        objMainPage.clickAccordionHeadingSeven();

        //Седьмой пункт
        objMainPage.clickAccordionHeadingZero();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
