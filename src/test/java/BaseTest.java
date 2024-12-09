import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;


public class BaseTest {

    public static WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

        driver.get(config.Constants.SITE_URL_ADDRESS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
