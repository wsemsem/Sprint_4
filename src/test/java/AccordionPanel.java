import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;


public class AccordionPanel {

    private WebDriver driver;

    String AccordionHeadingExpected0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    String AccordionHeadingExpected1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    String AccordionHeadingExpected2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    String AccordionHeadingExpected3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    String AccordionHeadingExpected4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    String AccordionHeadingExpected5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    String AccordionHeadingExpected6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    String AccordionHeadingExpected7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    //Раскрытие пунктов из раздела "Вопросы" и сравнение текста
    @Test
    public void checkAccordions() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.xpath(".//button[@id='rcc-confirm-button']")).click();
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FourPart__1uthg']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        //Первый пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-0']")).click();
        String AccordionHeadingActual0 = driver.findElement(By.xpath(".//div[@id='accordion__panel-0']")).getText();
        assertEquals(AccordionHeadingExpected0, AccordionHeadingActual0);

        //Второй пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-1']")).click();
        String AccordionHeadingActual1 = driver.findElement(By.xpath(".//div[@id='accordion__panel-1']")).getText();
        assertEquals(AccordionHeadingExpected1, AccordionHeadingActual1);

        //Третий пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-2']")).click();
        String AccordionHeadingActual2 = driver.findElement(By.xpath(".//div[@id='accordion__panel-2']")).getText();
        assertEquals(AccordionHeadingExpected2, AccordionHeadingActual2);

        //Четвертый пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-3']")).click();
        String AccordionHeadingActual3 = driver.findElement(By.xpath(".//div[@id='accordion__panel-3']")).getText();
        assertEquals(AccordionHeadingExpected3, AccordionHeadingActual3);

        //Пятый пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-4']")).click();
        String AccordionHeadingActual4 = driver.findElement(By.xpath(".//div[@id='accordion__panel-4']")).getText();
        assertEquals(AccordionHeadingExpected4, AccordionHeadingActual4);

        //Шестой пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-5']")).click();
        String AccordionHeadingActual5 = driver.findElement(By.xpath(".//div[@id='accordion__panel-5']")).getText();
        assertEquals(AccordionHeadingExpected5, AccordionHeadingActual5);

        //Седьмой пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-6']")).click();
        String AccordionHeadingActual6 = driver.findElement(By.xpath(".//div[@id='accordion__panel-6']")).getText();
        assertEquals(AccordionHeadingExpected6, AccordionHeadingActual6);

        //Восьмой пункт
        driver.findElement(By.xpath(".//div[@id='accordion__heading-7']")).click();
        String AccordionHeadingActual7 = driver.findElement(By.xpath(".//div[@id='accordion__panel-7']")).getText();
        assertEquals(AccordionHeadingExpected7, AccordionHeadingActual7);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
